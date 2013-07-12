package hms

class ReservationStatusService {

	private def getStatus(ReservationStatus.StatusCode statusCode) {
		ReservationStatus.findByCode(statusCode.value) ?: new ReservationStatus(code: statusCode).save()
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
	
}
