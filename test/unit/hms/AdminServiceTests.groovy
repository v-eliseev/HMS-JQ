package hms



import grails.test.mixin.*
import hms.auth.SecUser

import org.junit.*

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(AdminService)
@Mock([SecUser, License])
class AdminServiceTests {

    void testCreatingUser() {
        AdminService adminService = new AdminService()
		LicenseService licenseService = new LicenseService()
		
		License license1 = new License(key: licenseService.generateLicenseKey()).save()
		License license2 = new License(key: licenseService.generateLicenseKey()).save()
		
		SecUser userOK = adminService.createUser("admin", "admin", license1)
		SecUser userOK2 = adminService.createUser("manager", "manager", license1)
		SecUser userOK3 = adminService.createUser("admin", "admin", license2)
		
		def users = SecUser.findAll()

		assert users.size == 3		
    }
	
	void testLoginUser() {
		AdminService adminService = new AdminService()
		LicenseService licenseService = new LicenseService()
		
		License license1 = new License(key: licenseService.generateLicenseKey()).save()
		License license2 = new License(key: licenseService.generateLicenseKey()).save()
		
		SecUser userOK = adminService.createUser("admin", "admin", license1)
		SecUser userOK2 = adminService.createUser("manager", "manager", license1)
		SecUser userOK3 = adminService.createUser("admin", "admin", license2)
		
		assert adminService.checkUser("admin", "admin", license1) == true
		assert adminService.checkUser("admin", "manager", license1) == false
		assert adminService.checkUser("supervisor", "manager", license1) == false
		assert adminService.checkUser("admin", "admin", license2) == true
	}
	
	void testDemoLicense() {
		
		AdminService adminService = new AdminService()
		LicenseService licenseService = new LicenseService()

		License demoLicense = licenseService.createDemoLicense()
		SecUser adminUser = adminService.createDemoUser(demoLicense)
//		DemoDataScript.createDemoData(demoLicense)
		
		assert demoLicense != null
		assert adminService.checkUser("admin", "admin", demoLicense) == true
	}
}
