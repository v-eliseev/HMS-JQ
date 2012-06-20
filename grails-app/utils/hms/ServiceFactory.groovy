package hms

import org.codehaus.groovy.grails.commons.ApplicationHolder

/**
 * 
 * @author evv
 *
 */
class ServiceFactory {
	
	static private serviceFactory = null
	
	private ServiceFactory() {
	}
	
	static ServiceFactory getServiceFactory() {
		if (serviceFactory== null) {
			serviceFactory = new ServiceFactory() 
		}
		serviceFactory
	}

	/**
	 * Gets service bean by service name
	 * @param serviceName
	 * @return
	 */
	def getServiceByName(serviceName) {
		//def grailsApplication
		//grailsApplication.getMainContext().getBean(serviceName)
		ApplicationHolder.getApplication().getMainContext().getBean(serviceName)
	}

	/**
	 * Gets service bean by given DomainClassName
	 * @param domainObjectClassName
	 * @return
	 */
	def getServiceByDomainClass(Class domainObjectClass) {
		String qualifiedName = domainObjectClass.getName()
		String basicName = qualifiedName.substring(qualifiedName.lastIndexOf('.') + 1)
		def serviceName = down1( basicName + "Service")
		getServiceByName(serviceName)
	}

	/**
	 * Changes the first letter to lowercase
	 * @param s
	 * @return
	 */
	private static String down1(String s) {
		return (s.length() > 0) ? s.substring(0,1).toLowerCase() + s.substring(1) : s
	}
}
