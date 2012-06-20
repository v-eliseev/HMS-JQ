package hms

import hms.Reservation

class ReservationService extends CRUDService {

	def getDomainClass() {
		Reservation.class
	}
}
