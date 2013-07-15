package hms

import grails.test.mixin.*
import hms.auth.SecUser
import spock.lang.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
//@TestFor(License)
//@Mock([License, SecUser, Hotel, Room, RoomCategory, Reservation])
class LicenseSpec extends Specification {

	def licenseService
	def adminService

	def  setup() {
		licenseService = new LicenseService()
		adminService = new AdminService()

		assert licenseService != null
		assert adminService != null
	}

	def 'License must delete related Hotel and SecUsers'() {
		given:
			def license = licenseService.createDemoLicense()
			def user = adminService.createUser("admin", "admin", "admin@email.com", license)

			assert license != null
			assert user != null

			assert License.list().size() == 1
			assert Hotel.list().size() == 1
			assert RoomCategory.list().size() > 0
			assert Room.list().size() > 0
			assert Reservation.list().size() > 0
			assert SecUser.list().size() == 1

		when:
			license.delete(flush:true)

		then:

			License.list().size() == 0
			Hotel.list().size() == 0
			RoomCategory.list().size() == 0
			Room.list().size() == 0
			Reservation.list().size() == 0
			SecUser.list().size() == 0

			
	}
}
