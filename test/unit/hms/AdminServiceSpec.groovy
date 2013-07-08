package hms


import grails.test.mixin.*
import hms.auth.SecUser

import spock.lang.*

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(AdminService)
@Mock([SecUser, License, Hotel, RoomCategory, Room, Reservation])
class AdminServiceSpec extends Specification {

	def licenseService
	def adminService

	def  setup() {
		licenseService = new LicenseService()
		adminService = new AdminService()

		assert licenseService != null
		assert adminService != null
	}

	def 'Create users' () {
		given:
			def license1 = licenseService.createStandardLicense()
			def license2 = licenseService.createStandardLicense()

		when:
			adminService.createUser("admin", "admin", "", license1)
			adminService.createUser("manager", "manager", "", license1)
			adminService.createUser("admin", "admin", "", license2)

		then:
			SecUser.list().size() == 3
			license1.users.size() == 2
			license2.users.size() == 1
	}

	def 'Check users' () {
		given:
			def license1 = licenseService.createStandardLicense()
			def license2 = licenseService.createStandardLicense()

		when:
			adminService.createUser("admin", "admin", "", license1)
			adminService.createUser("manager", "manager", "", license1)
			adminService.createUser("admin", "admin", "", license2)

		then:
			adminService.checkUser("admin", "admin", license1) == true
			adminService.checkUser("admin", "manager", license1) == false
			adminService.checkUser("supervisor", "manager", license1) == false
			adminService.checkUser("admin", "admin", license2) == true

	}

	def 'Demo license creation check' () {
		when:
			def demoLicense = licenseService.createDemoLicense()
			def adminUser = adminService.createDemoUser(demoLicense)

		then:
			demoLicense != null
			adminService.checkUser("admin", "admin", demoLicense) == true
	}
}
