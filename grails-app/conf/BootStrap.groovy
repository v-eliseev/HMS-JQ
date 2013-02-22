import org.slf4j.Logger;
import org.slf4j.LoggerFactory

import grails.util.GrailsUtil
import hms.AdminService
import hms.DemoDataScript
import hms.License
import hms.LicenseService
import hms.auth.SecUser
import hms.auth.SecUserRole

class BootStrap {

	//protected final Logger log = LoggerFactory.getLogger(getClass())
	
	def init = {  servletContext ->

		switch (GrailsUtil.environment) {

			case "development":
			try {
				LicenseService licenseService = new LicenseService()
				License license = licenseService.createDemoLicense("WR9WX-Q9CTF-2QFCY-YRY9V-PPHK6")
				log.info("Demo license created: " + license.key)
				
				AdminService adminService = new AdminService()

				def adminRole = adminService.getAdminRole()
				def userRole = adminService.getUserRole()
				//def superuserRole = adminService.getRole('ROLE_SUPERUSER')
				log.info("Roles created")
				
				SecUser adminUser = adminService.createUser("admin", "admin", "v-eliseev@yandex.ru", license)
				SecUserRole.create(adminUser, adminRole)
				// adminUser.addToAuthorities(adminRole)
				// adminUser.save()
				log.info("Admin user for license " + license.key + " created")

				SecUser userUser = adminService.createUser("user", "test", "v-eliseev@yandex.ru", license)
				SecUserRole.create(userUser, userRole)
				// userUser.addToAuthorities(userRole)
				// userUser.save()
				log.info("Normal user for license " + license.key + " created")

				// DemoDataScript.generateRandomData(license)
				
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
