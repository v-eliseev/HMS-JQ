package hms

class ReservationService {
		
	def reservationStatusService

	def getReservation = { id ->
		Reservation.get(id)
	}

	def getReservations(License license, Date fromDate, Date toDate) {
		Reservation.getAllFor(license)
	}

	def getCheckins(License license, Date forDate, Integer max_count = null) {
		Reservation.findAllByLicenseAndStatusAndFromDateGreaterThanEquals(
			license, reservationStatusService.getStatusPlanned(), forDate)
	}

	def getCheckouts(License license, Date toDate, Integer max_count = null) {
		Reservation.getAllByLicenseAndStatusAndToDateGreaterThanEquals(
			license, reservationStatusService.getStatusCheckedIn(), toDate)
	}

	def createReservation(License license, Date fromDate, Date toDate, int adults, RoomCategory roomCategory) {
		def hotel = license.getHotel()
		def status = reservationStatusService.getStatusPlanned()
		def reservation = new Reservation(
				fromDate: fromDate,
				toDate: toDate,
				adults: adults,
				roomCategory: roomCategory,
				status: status
			).save()
		hotel.addToReservations(reservation)
		hotel.save()

		reservation
	}
}
