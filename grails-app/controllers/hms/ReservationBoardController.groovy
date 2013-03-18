package hms

import grails.converters.JSON

class ReservationBoardController extends BaseController {

	def roomService
	def reservationService

    def index() {
		License license = getLicense(request)

    	def today = new Date()

		def dates = []
		def fromDate = today-1
		def toDate = today+7
		(fromDate..<toDate).each { date ->
			dates << date
		}

		def roomInstanceList = roomService.listAll(license)
		def reservationInstanceList = reservationService.getReservations(license, fromDate, toDate)

		log.debug("Rooms: ${roomInstanceList.size()} Reservations: ${reservationInstanceList.size()}")

		[
			fromDate: fromDate, 
			dates: dates, 
			roomInstanceList: roomInstanceList, 
			reservationInstanceList: reservationInstanceList
		]
	}

	def indexJSON() {
		License license = getLicense(request)

		def fromDateParam = params.fromDate
		def toDateParam = params.toDate

		def today = new Date()

		def fromDate = (fromDateParam) ? new Date(Long.parseLong(fromDateParam)) : today-1
		def toDate = (toDateParam) ? new Date(Long.parseLong(toDateParam)) : today+7

		log.debug("From: ${fromDate} To: ${toDate}")

		def dates = []
		(fromDate..<toDate).each { date ->
			dates << date
		}

		def roomInstanceList = roomService.listAll(license)
		def reservationInstanceList = reservationService.getReservations(license, fromDate, toDate)

		log.debug("Rooms: ${roomInstanceList.size()} Reservations: ${reservationInstanceList.size()}")

		def result = [
			fromDate: fromDate, 
			dates: dates, 
			roomInstanceList: roomInstanceList, 
			reservationInstanceList: reservationInstanceList
		] 

		render result as JSON
	}
	
}
