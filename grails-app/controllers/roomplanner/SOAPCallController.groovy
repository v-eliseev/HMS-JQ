package roomplanner

import hms.BaseController;
import hms.DemoDataScript
import hms.Hotel
import hms.License
import hms.Room
import hms.RoomPlannerService

import org.joda.time.DateTime

class SOAPCallController extends BaseController {

    def index() { 
		
		RoomPlannerService roomPlannerService = getServiceFactory().getServiceByName("roomPlannerService")
		License license = getLicense(request)
		
		Plan plan = roomPlannerService.getCurrentPlan(license)
		
		def startDate = new DateTime(2012, 11, 15, 12, 0, 0, 0)
		def endDate = new DateTime(2012, 11, 30, 12, 0, 0, 0)
		
		def planningWindow = []
		for (DateTime date : new DateTimeRange(startDate.minusDays(2), endDate.plusDays(7))) {
			planningWindow << date
		}
		
		render(view: 'index', model: [planningWindow: planningWindow, rooms: Room.getAllFor(license), plan: plan])
			
	}
	
	def newConfiguration() {
		RoomPlannerService roomPlannerService = getServiceFactory().getServiceByName("roomPlannerService")
		License license = getLicense(request)

		Plan plan = roomPlannerService.deleteSavedPlan(license)

		def startDate = new DateTime(2012, 11, 15, 12, 0, 0, 0)
		def endDate = new DateTime(2012, 11, 30, 12, 0, 0, 0)
		
		def planningWindow = []
		for (DateTime date : new DateTimeRange(startDate.minusDays(2), endDate.plusDays(7))) {
			planningWindow << date
		}
		render(view: 'index', model: [planningWindow: planningWindow, rooms: Room.getAllFor(license), plan: plan])
	}
}
