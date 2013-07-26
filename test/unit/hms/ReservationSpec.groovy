package hms

import grails.test.mixin.*
import spock.lang.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
 @Mock([Reservation, ReservationStatus, License, Hotel, RoomCategory, Room])
class ReservationSpec extends Specification {

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
			def hotel = new Hotel()
			def license = new License(
					key: licenseService.generateLicenseKey(),
					issued: new Date(),
					expires: new Date() + 30,
					demoMode: true,
					hotel: hotel,
					).save()

			def roomCategory = new RoomCategory(name: "RoomCategory")

			assert license != null
			assert roomCategory != null

		when:
			def r = reservationService.createReservation(
				license, new Date()-1, new Date()+3, 2, roomCategory) 

		then:
			Reservation.list().size() == 1

		cleanup:
		 	r.delete()
	}
}