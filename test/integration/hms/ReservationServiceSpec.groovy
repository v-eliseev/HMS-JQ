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
			def license = licenseService.createDemoLicense("aa@bb.cc")
			def roomCategory = license.hotel.roomCategories.asType(List)[0]
			def count = Reservation.list().size()

			assert license != null
			assert roomCategory != null

		when:
			def r = reservationService.createReservation(
					license, 
					[
					fromDate: new Date()-1, 
					toDate: new Date()+3, 
					roomCategory: roomCategory, 
					adults: 2
					]) 

		then:
			Reservation.list().size() == (count + 1)

		cleanup:
			license.delete()
	}

	def 'Get checkins for the date' () {
		given:
			def license = licenseService.createDemoLicense("aa@bb.cc")

			assert license != null

		when:
			def checkinList = reservationService.getCheckins(license, new Date(), 5)

		then:
			checkinList.size() != 0

		cleanup:
			license.delete()
	}

	def 'Get checkouts for the date' () {
		given:
			def license = licenseService.createDemoLicense("aa@bb.cc")

			assert license != null

		when:
			def checkoutList = reservationService.getCheckouts(license, new Date(), 5)

		then:
			checkoutList.size() != 0

		cleanup:
			license.delete()
	}

}
