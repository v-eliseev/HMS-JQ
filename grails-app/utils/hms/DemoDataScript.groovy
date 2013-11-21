package hms

import org.joda.time.DateTime
import org.joda.time.Duration
import org.joda.time.Interval
import org.apache.commons.logging.LogFactory

class DemoDataScript {

	private static final log = LogFactory.getLog(this.getClass())

	static def generateRandomData(License license) {
		int NUMBER_OF_ROOMS = 15
		int NUMBER_OF_RESERVATIONS = 12
		
		def today = new DateTime()

		def years = today.year..today.year
		def months = today.monthOfYear..today.monthOfYear
		def days = 15..30
		int ADULTS_MAX = 3
		def roomCategoriesIndex = 1..5
		int MAX_DURATION_DAYS = 7
		
		def seed = new Random()
		
		Hotel h = new Hotel(
				name: randomString(8),
				phone: randomString(8),
				fax: randomString(8),
				eMail: randomString(20),
				webSite: randomString(20),
				registrationNr: randomString(20),
				taxNr: randomString(20),
				bankName: randomString(20),
				bankCode: randomString(10),
				accountNr: randomString(20),
				bicCode: randomString(10),
				iban: randomString(10),
				countryCode: randomString(2),
				invoicePrefix: randomString(3),
				invoiceStartId: randomString(2),
				invoiceSuffix: randomString(2),
			)
		
		// generate room categories
		roomCategoriesIndex.each {
			def rc = new RoomCategory(
				name: randomString(8),
				description: randomString(120),
				shortDescription: randomString(30),
				isBookableOnline: true
			)
			h.addToRoomCategories(rc)
		}
		
		def rcList = h.roomCategories.asList()

		// generate rooms
		for (i in 1..NUMBER_OF_ROOMS) {
			def rc = rcList[seed.nextInt(rcList.size())]
			Room r = new Room(
				name: randomString(8),
				//roomCategory: rc,
				adults: seed.nextInt(ADULTS_MAX)+1
			)
			rc.addToRooms(r)
		}

		// save hotel configuration
		h.save(flush:true)

		
		// generate reservations
		for (i in 1..NUMBER_OF_RESERVATIONS) {
			DateTime nowDate = DateTime.now()
			DateTime fromDate = nowDate.minusDays(MAX_DURATION_DAYS).plusDays(seed.nextInt(MAX_DURATION_DAYS)+3).withTime(12,0,0,0)
			DateTime toDate = fromDate.plusDays(seed.nextInt(MAX_DURATION_DAYS)+1).withTime(12,0,0,0)
			def code = ReservationStatus.StatusCode.PLANNED 
			if (toDate < nowDate) {
				code = ReservationStatus.StatusCode.CHECKED_OUT
			} else if (fromDate < nowDate) {
				code = ReservationStatus.StatusCode.CHECKED_IN
			} 
			def reservationStatus = ReservationStatus.findByCode(code) ?: new ReservationStatus(code: code).save(flush:true)
			if (reservationStatus == null) {
				throw new Exception("Reserevation status is null")
			}
			Reservation r = new Reservation(
				fromDate: fromDate.toDate(),
				toDate: toDate.toDate(),
				roomCategory: rcList[seed.nextInt(rcList.size())],
				adults: seed.nextInt(ADULTS_MAX)+1,
				status: reservationStatus
			)
			h.addToReservations(r)
		}
		
		h.save(flush:true)

		h
	}

private static String randomString(long max_length) {
	def seed = new Random()
	def alphabet = 'A'..'z'
	def result = ""
	(1..max_length).each {
		result = result + alphabet[seed.nextInt(alphabet.size())]
	}	
	result
}
}
