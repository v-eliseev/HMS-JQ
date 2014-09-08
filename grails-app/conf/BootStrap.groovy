import grails.util.GrailsUtil
import hms.AdminService
import hms.License
import hms.LicenseService
import hms.auth.SecUser
import hms.auth.SecUserRole
import hms.auth.SecRequestMap
import hms.Setting

class BootStrap {

	def grailsApplication

	def init = {  servletContext ->

		def startTimeInstance = Setting.findOrCreateByKey('startTime')
		startTimeInstance.value = System.currentTimeMillis()
		startTimeInstance.save()

		LicenseService licenseService = new LicenseService()
		AdminService adminService = new AdminService()

        /**
		*	Environment dependent config
        */
		switch (GrailsUtil.environment) {

			case ["development", "jenkins"]:
			try {

				log.info("Adding Spring Security RequestMaps...")
				for (String url in [
				      '/', '/index', '/index.gsp', '/**/favicon.ico', 
				      '/**/assets/**', '/**/js/**', '/**/fonts/**',
				      '/login', '/login.*', '/login/*',
				      '/logout', '/logout.*', '/logout/*',
				      '/dbconsole', '/dbconsole.*', '/dbconsole/*',
				      '/monitoring', '/monitoring.*', '/monitoring/*',
				      ]) {
				   new SecRequestMap(url: url, configAttribute: 'permitAll').save()
				}
				new SecRequestMap(url: '/superuser/**', configAttribute: 'permitAll').save()
				new SecRequestMap(url: '/admin/**', configAttribute: 'ROLE_ADMIN').save()
				new SecRequestMap(url: '/user/**', configAttribute: 'ROLE_USER').save()
				// new Requestmap(url: '/admin/role/**', configAttribute: 'ROLE_SUPERVISOR').save()
				// new Requestmap(url: '/admin/user/**', configAttribute: 'ROLE_ADMIN,ROLE_SUPERVISOR').save()
				// new Requestmap(url: '/j_spring_security_switch_user',
				//                configAttribute: 'ROLE_SWITCH_USER,isFullyAuthenticated()').save()
				new SecRequestMap(url: '/roomCategory/**', configAttribute: 'permitAll').save()
				log.info("...done")

				def adminRole = adminService.getAdminRole()
				def userRole = adminService.getUserRole()
				log.info("Roles created")


				adminService.createSystemUser(
					"superuser",
					"password"
				)

				License license = licenseService.createDemoLicense("Vladislav Eliseev", "v-eliseev@yandex.ru", "WR9WX-Q9CTF-2QFCY-YRY9V-PPHK6A")
				log.info("Demo license created: " + license.key)
				
				SecUser adminUser = adminService.createUser("admin", "admin", "v-eliseev@yandex.ru", license, [adminRole])
				log.info("Admin user for license " + license.key + " created")

				SecUser userUser = adminService.createUser("user", "test", "v-eliseev@yandex.ru", license, [userRole])
				log.info("Normal user for license " + license.key + " created")

				break
			} catch (Exception e) {
				log.error("Error executing BootStrap", e)
			}
		}

		// PricelistService pricelistService = new PricelistService()
		// pricelistService.getPricelist(license)
		
		log.info("Application started...")
	}

	def destroy = {
	}
}
