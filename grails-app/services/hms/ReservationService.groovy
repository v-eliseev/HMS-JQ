package hms

class ReservationService {

	def getReservation = { id ->
		Reservation.get(id)
	}

	def getReservations(License license, Date fromDate, Date toDate) {
		Reservation.getAllFor(license)
	}

	def createReservation(License license, Date fromDate, Date toDate, int adults, Long roomCategoryId) {
		def hotel = license.getHotel()
		def roomCategory = RoomCategory.get(roomCategoryId)
		def reservation = new Reservation(
				fromDate: fromDate,
				toDate: toDate,
				adults: adults,
				roomCategory: roomCategory
			).save()
		hotel.reservations.add(reservation)
		// hotel.save()
	}
}
