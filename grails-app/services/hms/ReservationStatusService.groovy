package hms

class ReservationStatusService {

	private def getStatus(ReservationStatus.StatusCode statusCode) {
		ReservationStatus.findByCode(statusCode) ?: new ReservationStatus(code: statusCode).save(flush:true)
	}

	def getStatusNew() {
		getStatus(ReservationStatus.StatusCode.NEW)
	}

	def getStatusCancelled() {
		getStatus(ReservationStatus.StatusCode.CANCELLED)
	}

	def getStatusPlanned() {
		getStatus(ReservationStatus.StatusCode.PLANNED)
	}

	def getStatusCheckedIn() {
		getStatus(ReservationStatus.StatusCode.CHECKED_IN)
	}

	def getStatusCheckedOut() {
		getStatus(ReservationStatus.StatusCode.CHECKED_OUT)
	}

	def getStatusNoShow() {
		getStatus(ReservationStatus.StatusCode.NO_SHOW)
	}
	
	def listReservationStatus() {
		ReservationStatus.findAll()
	}
}
