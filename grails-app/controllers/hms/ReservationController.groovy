package hms

import grails.converters.JSON

import hms.dto.ReservationRequest

class ReservationController extends BaseController {

	static defaultAction = "index"

	def hotelService
	def reservationService
	def roomPlanerService
	def roomService

	/**
	 * Handling mobile views	
	 */
	def afterInterceptor = [action: this.&handleMobile]

	def index() {
		License license = getLicense(request)

		def reservationInstanceList = hotelService.listReservations(license)
		[
			reservationInstanceList: reservationInstanceList
		]
	}

	def add() {
		License license = getLicense(request)

	}

	def create() {
		License license = getLicense(request)

		log.debug("Create reservation for $license from parameters: $params")

		def dates = params.daterange.split(" - ")
		def fromDate = Date.parse("MM/dd/yyyy", dates[0])
		def toDate = Date.parse("MM/dd/yyyy", dates[1])
		def adults = params.int('adults')
		def roomCategory = RoomCategory.findById(params.long('roomCategory'))

		reservationService.createReservation(license, 
			[
				fromDate: fromDate, 
				toDate: toDate, 
				roomCategory: roomCategory, 
				adults: adults
			])

		roomPlannerService.createNewPlan(license)

		redirect action: 'index'
	}

	def edit() {
		License license = getLicense(request)

		Reservation reservationInstance = reservationService.getReservation(params.id)
		[
			reservationInstance: reservationInstance
		]
	}

	def update() {
		License license = getLicense(request)

		redirect action: 'index'
	}

	def delete() {

	}

	def check() {
		License license = getLicense(request)

		log.trace("Check reservation with params: $params")

		def dates = params.daterange.split(" - ")
		def fromDate = Date.parse("MM/dd/yyyy", dates[0])
		def toDate = Date.parse("MM/dd/yyyy", dates[1])
		def adults = params.int('adults')
		def roomCategory = RoomCategory.findById(params.long('roomCategory'))

		def reservation = new ReservationRequest(
			fromDate: fromDate,
			toDate: toDate,
			adults: adults,
			roomCategory: roomCategory,
		)

		def roomAssignment = roomPlannerService.checkReservation(license, reservation)
		
		def result = (roomAssignment != null) ? 'OK' : 'Not OK'
		def jsonData = [status: result]
		
		render jsonData as JSON
	}

	
	def listAvailableRoomTypes() {
		def parameters = params
		def roomList = roomService?.list()
		def reservationsList = reservationService?.list()
		[dataList: roomList]
	}
	
	def listAvailableRooms() {
		def parameters = params
		
		def roomList
		if (parameters.roomType == null) {
			roomList = roomService?.list()
		}
		else {
			roomList = roomService?.list()
		}
		[dataList: roomList]
	}
}
