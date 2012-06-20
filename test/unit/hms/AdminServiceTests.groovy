package hms



import grails.test.mixin.*
import hms.auth.User

import org.junit.*

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(AdminService)
@Mock([User, License])
class AdminServiceTests {

    void testCreatingUser() {
        AdminService adminService = new AdminService()
		LicenseService licenseService = new LicenseService()
		
		License license1 = new License(key: licenseService.generateLicenseKey()).save()
		License license2 = new License(key: licenseService.generateLicenseKey()).save()
		
		User userOK = adminService.createUser("admin", "admin", license1)
		User userOK2 = adminService.createUser("manager", "manager", license1)
		User userOK3 = adminService.createUser("admin", "admin", license2)
		
		def users = User.findAll()

		assert users.size == 3		
    }
	
	void testLoginUser() {
		AdminService adminService = new AdminService()
		LicenseService licenseService = new LicenseService()
		
		License license1 = new License(key: licenseService.generateLicenseKey()).save()
		License license2 = new License(key: licenseService.generateLicenseKey()).save()
		
		User userOK = adminService.createUser("admin", "admin", license1)
		User userOK2 = adminService.createUser("manager", "manager", license1)
		User userOK3 = adminService.createUser("admin", "admin", license2)
		
		assert adminService.checkUser("admin", "admin", license1) == true
		assert adminService.checkUser("admin", "manager", license1) == false
		assert adminService.checkUser("supervisor", "manager", license1) == false
		assert adminService.checkUser("admin", "admin", license2) == true
	}
	
	void testDemoLicense() {
		
		AdminService adminService = new AdminService()
		LicenseService licenseService = new LicenseService()

		License demoLicense = licenseService.createDemoLicense()
		User adminUser = adminService.createDemoUser(demoLicense)
//		DemoDataScript.createDemoData(demoLicense)
		
		assert demoLicense != null
		assert adminService.checkUser("admin", "admin", demoLicense) == true
	}
}
