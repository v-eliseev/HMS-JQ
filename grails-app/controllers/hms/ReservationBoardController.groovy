package hms

import grails.converters.JSON

class ReservationBoardController extends BaseController {

	def roomService
	def reservationService

    def index = {
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

		log.debug("Rooms: " + roomInstanceList.size())
		log.debug("Reservations: " + reservationInstanceList.size())

		[
			fromDate: fromDate, 
			dates: dates, 
			roomInstanceList: roomInstanceList, 
			reservationInstanceList: reservationInstanceList
		]
	}
	
}
