
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

		LicenseService licenseService = new LicenseService()
		AdminService adminService = new AdminService()

        /**
		*	Environment dependent config
        */
		switch (GrailsUtil.environment) {

			case "development":
			try {
				def adminRole = adminService.getAdminRole()
				def userRole = adminService.getUserRole()
				log.info("Roles created")


				adminService.createSystemUser(
					"superuser",
					"password"
				)

				License license = licenseService.createDemoLicense("v-eliseev@yandex.ru", "WR9WX-Q9CTF-2QFCY-YRY9V-PPHK6")
				log.info("Demo license created: " + license.key)
				
				SecUser adminUser = adminService.createUser("admin", "admin", "v-eliseev@yandex.ru", license, [adminRole])
				log.info("Admin user for license " + license.key + " created")

				SecUser userUser = adminService.createUser("user", "test", "v-eliseev@yandex.ru", license, [userRole])
				log.info("Normal user for license " + license.key + " created")

				break
			} catch (Exception e) {
				log.error("Error executing BootStrap", e)
			}

			case "jenkins":
			try {

				def adminRole = adminService.getAdminRole()
				def userRole = adminService.getUserRole()
				log.info("Roles created")


				adminService.createSystemUser(
					"superuser",
					"password"
				)

				License license = licenseService.createDemoLicense("v-eliseev@yandex.ru", "XXXXX-XXXXX-XXXXX-XXXXX-XXXXX")
				log.info("Demo license created: " + license.key)

				SecUser adminUser = adminService.createUser("admin", "admin", "v-eliseev@yandex.ru", license, [adminRole])
				log.info("Admin user for license " + license.key + " created")

				SecUser userUser = adminService.createUser("user", "test", "v-eliseev@yandex.ru", license, [userRole])
				log.info("Normal user for license " + license.key + " created")


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
