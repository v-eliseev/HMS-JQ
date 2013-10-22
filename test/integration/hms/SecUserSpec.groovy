package hms

import grails.test.mixin.*
import spock.lang.*

import hms.auth.SecUser
import hms.auth.SecRole
import hms.auth.SecUserRole

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
//@TestFor(SecUser)
//@Mock([SecUser, SecRole, SecUserRole, License, Hotel, Room, RoomCategory, Reservation])
class SecUserSpec extends Specification {

	def licenseService
	def adminService

	def  setup() {
		licenseService = new LicenseService()
		adminService = new AdminService()

		assert licenseService != null
		assert adminService != null
	}

	def 'Cascade deletion of SecUserRole'() {
		given:
			def license = licenseService.createDemoLicense("aa@bb.cc")
			def adminUser = adminService.createDemoUser(license)

			assert license != null
			assert adminUser != null

			//assert License.list().size() == 1
			assert Hotel.list().size() == 1
			assert SecUser.list().size() == 1
			assert SecRole.list().size() == 1
			assert SecUserRole.list().size() == 1

		when:
			license.removeFromUsers(adminUser)
			adminUser.delete(flush:true)

		then:

			//License.list().size() == 1
			Hotel.list().size() == 1
			SecUser.list().size() == 0
			SecRole.list().size() == 1
			SecUserRole.list().size() == 0

		cleanup:
			license.delete(flush:true)
	}
}
