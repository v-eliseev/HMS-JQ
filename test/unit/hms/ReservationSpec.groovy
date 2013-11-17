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
			def roomCategory = new RoomCategory(name: "RoomCategory")
			hotel.addToRoomCategories(roomCategory)
			hotel.save()

			def license = new License(
					key: licenseService.generateLicenseKey(),
					issued: new Date(),
					expires: new Date() + 30,
					mode: License.LicenseMode.DEMO,
					hotel: hotel,
					).save()

			def reservationStatus = ReservationStatus.findByCode(ReservationStatus.StatusCode.PLANNED) ?: new ReservationStatus(code: ReservationStatus.StatusCode.PLANNED).save()

			assert license != null
			assert roomCategory != null
			assert reservationStatus != null

		when:
			def r = reservationService.createReservation(
					license, 
					[
					fromDate: new Date()-1, 
					toDate: new Date()+3, 
					roomCategory: roomCategory, 
					adults: 2,
					status: reservationStatus
					])

		then:
			Reservation.list().size() == 1

		cleanup:
		 	r.delete()
	}
}
