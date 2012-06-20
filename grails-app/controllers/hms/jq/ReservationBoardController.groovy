package hms.jq

import grails.converters.JSON
import hms.Reservation
import hms.ReservationService;
import hms.Room
import hms.RoomService
import hms.ServiceFactory

class ReservationBoardController {

    def index = {
		def model = prepareReservationBoard(new Date())
		[model:model] 
	}
	
	def prepareReservationBoard = { fromDate ->
		Date toDate = fromDate + 7

		def dates = []
		(fromDate..<toDate).each { date ->
			dates << date
		}
		
		RoomService service = ServiceFactory.getServiceFactory().getServiceByDomainClass(Room.class)
		def rooms = service?.list()
		
		[fromDate:fromDate, dates:dates, rooms:rooms]
    }
	
	def listReservationsJSON = {
		def fromDate = params.fromDate
		ReservationService service = ServiceFactory.getServiceFactory().getServiceByDomainClass(Reservation.class)
		render service?.list() as JSON
	}
}
