package hms


import grails.test.mixin.*
import hms.auth.SecUser

import spock.lang.*

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
//@TestFor(AdminService)
//@Mock([SecUser, License, Hotel, RoomCategory, Room, Reservation])
class AdminServiceSpec extends Specification {

	def licenseService
	def adminService
	def adminRole

	def  setup() {
		licenseService = new LicenseService()
		adminService = new AdminService()
		adminRole = adminService.getAdminRole()

		assert licenseService != null
		assert adminService != null
		assert adminRole != null
	}

	def 'Create users' () {
		given:
			def license1 = licenseService.createStandardLicense("John Doe", "aa@bb.cc")
			def license2 = licenseService.createStandardLicense("John Doe", "aa@bb.cc")
			def secUserCountBefore = SecUser.list().size()
		when:
			adminService.createUser("admin", "admin", "aa@bb.cc", license1, [adminRole])
			adminService.createUser("manager", "manager", "aa@bb.cc", license1, [adminRole])
			adminService.createUser("admin", "admin", "aa@bb.cc", license2, [adminRole])

		then:
			SecUser.list().size() == secUserCountBefore + 3
			license1.users.size() == 2
			license2.users.size() == 1

		cleanup:
			license1.delete(flush:true)
			license2.delete(flush:true)	
	}

	def 'Create user with no role exception' () {
		given:
			def license1 = licenseService.createStandardLicense("John Doe", "aa@bb.cc")

		when:
			adminService.createUser("admin", "admin", "aa@bb.cc", license1, null)

		then:
			thrown IllegalArgumentException

		when:
			adminService.createUser("admin", "admin", "aa@bb.cc", license1, [])

		then:
			thrown IllegalArgumentException

		cleanup:
			license1.delete(flush:true)
	}

	def 'Check users' () {
		given:
			def license1 = licenseService.createStandardLicense("John Doe", "aa@bb.cc")
			def license2 = licenseService.createStandardLicense("John Doe", "aa@bb.cc")

		when:
			adminService.createUser("admin", "admin", "aa@bb.cc", license1, [adminRole])
			adminService.createUser("manager", "manager", "aa@bb.cc", license1, [adminRole])
			adminService.createUser("admin", "admin", "aa@bb.cc", license2, [adminRole])

		then:
			adminService.checkUser("admin", "admin", license1) == true
			adminService.checkUser("admin", "manager", license1) == false
			adminService.checkUser("manager", "supervisor", license1) == false
			adminService.checkUser("admin", "admin", license2) == true

		cleanup:
			license1.delete(flush:true)
			license2.delete(flush:true)	

	}

	def 'Demo license creation check' () {
		given:
			def demoLicense = licenseService.createDemoLicense("John Doe", "aa@bb.cc")
			assert demoLicense != null

		when:
			def adminUser = adminService.createDemoUser(demoLicense)

		then:
			adminUser != null
			adminService.checkUser("admin", "admin", demoLicense) == true
			adminUser.getAuthorities().size() == 1

		cleanup:
			demoLicense.delete(flush:true)
	}

	def "Create demo user with non-demo license exception" () {
		given:
			def license = licenseService.createStandardLicense("John Doe", "aa@bb.cc")
			assert license != null

		when:
			def adminUser = adminService.createDemoUser(license)

		then:
			thrown IllegalArgumentException

		cleanup:
			license.delete(flush:true)
	}
}
