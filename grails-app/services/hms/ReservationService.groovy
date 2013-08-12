package hms

class ReservationService {
		
	def reservationStatusService

	def getReservation = { id ->
		Reservation.get(id)
	}

	def getReservations(License license, Date fromDate, Date toDate) {
		Reservation.getAllFor(license, fromDate, toDate)
	}

	def getCheckins(License license, Date forDate, Integer maxCount = null) {
		def hotel = license.getHotel()
		def result = Reservation.withCriteria {
			
			eq('hotel', hotel)
			eq('status', reservationStatusService.getStatusPlanned())
			ge('fromDate', forDate)

			order('fromDate')

			if (maxCount != null) {
				maxResults(maxCount)
			}
		}
		log.debug("Checkins: $result")
		result
	}

	def getCheckouts(License license, Date forDate, Integer maxCount = null) {
		def hotel = license.getHotel()
		def result = Reservation.withCriteria {

			eq('hotel', hotel)
			eq('status', reservationStatusService.getStatusCheckedIn())
			ge('toDate',forDate)

			order('toDate')

			if (maxCount != null) {
				maxResults(maxCount)
			}
		}
		log.debug("Checkouts: $result")
		result
	}

	def createReservation(License license, def params) {

		log.debug("Create reservation for $license from parameters: $params")

		def hotel = license.getHotel()
		def status = reservationStatusService.getStatusPlanned()
		def reservation = new Reservation(
				fromDate: params.fromDate,
				toDate: params.toDate,
				adults: params.adults,
				roomCategory: params.roomCategory,
				status: status
			)
		hotel.addToReservations(reservation)
		hotel.save()

		reservation
	}
}
