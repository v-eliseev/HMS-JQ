
import grails.util.GrailsUtil
import hms.AdminService
import hms.License
import hms.LicenseService
import hms.auth.SecUser
import hms.auth.SecUserRole

class BootStrap {

	def grailsApplication

	def init = {  servletContext ->

		grailsApplication.config.startNanoTime = System.nanoTime()	

        /**
		*	Environment dependent config
        */
		switch (GrailsUtil.environment) {

			case "development":
			try {
				LicenseService licenseService = new LicenseService()
				License license = licenseService.createDemoLicense("WR9WX-Q9CTF-2QFCY-YRY9V-PPHK6")
				log.info("Demo license created: " + license.key)
				
				AdminService adminService = new AdminService()

				def adminRole = adminService.getAdminRole()
				def userRole = adminService.getUserRole()
				log.info("Roles created")
				
				SecUser adminUser = adminService.createUser("admin", "admin", "v-eliseev@yandex.ru", license)
				SecUserRole.create(adminUser, adminRole)
				log.info("Admin user for license " + license.key + " created")

				SecUser userUser = adminService.createUser("user", "test", "v-eliseev@yandex.ru", license)
				SecUserRole.create(userUser, userRole)
				log.info("Normal user for license " + license.key + " created")

				adminService.createSystemUser(
					"superuser",
					"password"
				)

				break
			} catch (Exception e) {
				log.error("Error executing BootStrap", e)
			}
				
		}
		
		log.info("Application started...")
	}

	def destroy = {
	}
}
