package hms

class ReservationService {
		
	def reservationStatusService

	def getReservation = { id ->
		Reservation.get(id)
	}

	def getReservations(License license, Date fromDate, Date toDate) {
		def hotel = license.getHotel()
		def c = Reservation.createCriteria()
		def result = c {
			eq('hotel', hotel)
			or {
				between('fromDate', fromDate, toDate)
				between('toDate', fromDate, toDate)
				and {
					lt('fromDate', fromDate)
					gt('toDate', toDate)
				}
			}
		}
		log.trace("Found $result.size reservations: $result")
		result
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
		log.trace("Checkins: $result")
		result
	}

	def getCheckouts(License license, Date forDate, Integer maxCount = null) {
		def hotel = license.getHotel()
		def result = Reservation.withCriteria {

			eq('hotel', hotel)
			//eq('status', reservationStatusService.getStatusCheckedIn())
			eq('status', reservationStatusService.getStatusPlanned())  // TODO change
			ge('toDate',forDate)

			order('toDate')

			if (maxCount != null) {
				maxResults(maxCount)
			}
		}
		log.trace("Checkouts: $result")
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
		if(!hotel.save(flush: true)) {
			log.debug("Saving hotel reservations failed")
 			hotel.errors.each {
        		log.error(it)
    		}			
		 	throw new Exception('Reservation was not created')
		 }

		log.debug("... Successful")

		reservation
	}
}
