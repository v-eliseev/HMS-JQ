package hms

class ReservationService {

	def getReservation = { id ->
		Reservation.get(id)
	}

	def getReservations(License license, Date fromDate, Date toDate) {
		Reservation.getAllFor(license)
	}
}
