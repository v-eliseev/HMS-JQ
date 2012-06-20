package hms

import hms.ReservationStatus

class ReservationStatusService extends CRUDService {

	def getDomainClass() {
		ReservationStatus.class
	}
	
	def getStatusNew() {
		getDomainClass().findByName("New")
	}
	
}
