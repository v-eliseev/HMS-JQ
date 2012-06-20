import org.slf4j.Logger;
import org.slf4j.LoggerFactory

import grails.util.GrailsUtil
import hms.AdminService
import hms.DemoDataScript
import hms.License
import hms.LicenseService
import hms.auth.User
import hms.auth.UserRole

class BootStrap {

	protected final Logger log = LoggerFactory.getLogger(getClass())
	
	def init = {  servletContext ->

		switch (GrailsUtil.environment) {

			case "development":
				LicenseService licenseService = new LicenseService()
				License license = licenseService.createDemoLicense()
				println "License key: " + license.key + "\n"
				
				AdminService adminService = new AdminService()

				def adminRole = adminService.getAdminRole()
				def userRole = adminService.getUserRole()
				def superuserRole = adminService.getRole('ROLE_SUPERUSER')
				
				User adminUser = adminService.createUser("admin", "admin", license)
				UserRole.create(adminUser, adminRole)

				User userUser = adminService.createUser("user", "test", license)
				UserRole.create(userUser, userRole)

				User superUser = adminService.createUser("super", "user", license)
				UserRole.create(superUser, superuserRole)

				DemoDataScript.createDemoData(license)
				break
		}
		
		log.info("Application started...")
	}

	def destroy = {
	}
}
