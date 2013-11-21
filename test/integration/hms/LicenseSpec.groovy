package hms

import grails.test.mixin.*
import hms.auth.SecUser
import spock.lang.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
class LicenseSpec extends Specification {

	def licenseService
	def adminService

	def  setup() {
		licenseService = new LicenseService()
		adminService = new AdminService()

		assert licenseService != null
		assert adminService != null
	}

	def 'Check demo license creation' () {
		given:
			def hotelCountBefore = Hotel.list().size()

		when:
			def license = licenseService.createDemoLicense("aa@bb.cc")

		then:
			license != null
			Hotel.list().size() == hotelCountBefore + 1

		cleanup:
			license.delete(flush:true)
	}

	def 'License must delete related Hotel and SecUsers'() {
		given:
			def hotelCountBefore = Hotel.list().size()
			def secUserCountBefore = SecUser.list().size()
			def roomCategoryCountBefore = RoomCategory.list().size()
			def roomCountBefore = Room.list().size()
			def reservationCountBefore = Reservation.list().size()

			def license = licenseService.createDemoLicense("aa@bb.cc")
			def user = adminService.createDemoUser(license)

			assert license != null
			assert user != null

			//assert License.list().size() == 1
			assert Hotel.list().size() == hotelCountBefore + 1
			assert RoomCategory.list().size() > roomCategoryCountBefore
			assert Room.list().size() > roomCountBefore
			assert Reservation.list().size() > reservationCountBefore
			assert SecUser.list().size() == secUserCountBefore + 1

		when:
			license.delete(flush:true)

		then:

			//License.list().size() == 0
			Hotel.list().size() == hotelCountBefore
			RoomCategory.list().size() == roomCategoryCountBefore
			Room.list().size() == roomCountBefore
			Reservation.list().size() == reservationCountBefore
			SecUser.list().size() == secUserCountBefore

			
	}
}
