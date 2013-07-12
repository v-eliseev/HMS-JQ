package hms

import grails.test.mixin.*
import hms.auth.SecUser
import spock.lang.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
class ReservationServiceSpec extends Specification {

	def licenseService
	def reservationService
	def reservationStatusService

	def  setup() {
		licenseService = new LicenseService()
		reservationStatusService = new ReservationStatusService()
		reservationService = new ReservationService(reservationStatusService: reservationStatusService)

		assert licenseService != null
		assert reservationService != null
		assert reservationStatusService != null
	}

	def 'Check object creation'() {
		given:
			def license = licenseService.createDemoLicense()
			def roomCategory = license.hotel.roomCategories.asType(List)[0]
			def count = Reservation.list().size()

			assert license != null
			assert roomCategory != null

		when:
			def r = reservationService.createReservation(
				license, new Date()-1, new Date()+3, 2, roomCategory) 

		then:
			Reservation.list().size() == count + 1

		// cleanup:
		// 	r.delete()
	}
}
