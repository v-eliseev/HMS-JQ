package hms

class ReservationService {
		
	def reservationStatusService

	def getReservation = { id ->
		Reservation.get(id)
	}

	def getReservations(License license, Date fromDate, Date toDate) {
		Reservation.getAllFor(license)
	}

	def getCheckins(License license, Date forDate, Integer maxCount = null) {

		def result = Reservation.createCriteria().list {

			'in'('id', license.hotel.reservations.collect{ it.id })
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

	def getCheckouts(License license, Date toDate, Integer maxCount = null) {
		def result = Reservation.createCriteria().list {

			'in'('id', license.hotel.reservations.collect{ it.id })
			eq('status', reservationStatusService.getStatusCheckedIn())
			ge('toDate', toDate)

			order('fromDate')

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
			).save()
		hotel.addToReservations(reservation)
		hotel.save()

		reservation
	}
}
