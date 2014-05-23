package hms

import grails.test.mixin.*
import spock.lang.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
class ReservationServiceSpec extends Specification {

	def licenseService
	def reservationService
	def reservationStatusService

	def setup() {
		licenseService = new LicenseService()
		reservationStatusService = new ReservationStatusService()
		reservationService = new ReservationService(reservationStatusService: reservationStatusService)

		assert licenseService != null
		assert reservationService != null
		assert reservationStatusService != null
	}

	def 'Check object creation'() {
		given:
			def license = licenseService.createDemoLicense("John Doe", "aa@bb.cc")
			def roomCategory = license.hotel.roomCategories.asType(List)[0]
			def count = Reservation.list().size()

			assert license != null
			assert roomCategory != null

		when:
			reservationService.createReservation(
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
			license.delete(flush:true)
	}

	def 'Get checkins for the date' () {
		given:
			def license = licenseService.createDemoLicense("John Doe", "aa@bb.cc")
			assert license != null

		when:
			def checkinList = reservationService.getCheckins(license, new Date(), 5)

		then:
			checkinList != null

		cleanup:
			license.delete(flush:true)
	}

	def 'Get checkouts for the date' () {
		given:
			def license = licenseService.createDemoLicense("John Doe", "aa@bb.cc")
			assert license != null

		when:
			def checkoutList = reservationService.getCheckouts(license, new Date(), 5)

		then:
			checkoutList != null

		cleanup:
			license.delete(flush:true)
	}

	def "Get reservations for period" () {
		given:
			def license = licenseService.createDemoLicense("John Doe", "aa@bb.cc")
			assert license != null

		when:
			def reservationList = reservationService.getReservations(license, new Date()-2, new Date()+2)

		then:
			reservationList.size() != 0

		cleanup:
			license.delete(flush:true)
	}

	def "Get first reservation" () {
		given:
			def license = licenseService.createDemoLicense("John Doe", "aa@bb.cc")
			assert license != null

		when:
			def reservation = reservationService.getFirstReservation(license)

		then:
			reservation

		cleanup:
			license.delete(flush:true)
	}

	def "Get last reservation" () {
		given:
			def license = licenseService.createDemoLicense("John Doe", "aa@bb.cc")
			assert license != null

		when:
			def reservation = reservationService.getLastReservation(license)

		then:
			reservation

		cleanup:
			license.delete(flush:true)
	}

}
