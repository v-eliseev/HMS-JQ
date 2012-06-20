package hms.jq

import grails.converters.JSON
import hms.CRUDService
import hms.DomainBaseClass
import hms.ServiceFactory

abstract class DomainObjectController extends BaseController {

	def domainObjectClazz
	def service
	
	public DomainObjectController(Class domainObjectClazz) {
		this.domainObjectClazz = domainObjectClazz
		service = ServiceFactory.getServiceFactory().getServiceByDomainClass(domainObjectClazz)
	}
	
    def index = {
	}
	
	def listJSON = {
		def jsonData = [rows: service?.list(), page: "1", records: "3", total: "1"]
		render jsonData as JSON
	}
	
}
