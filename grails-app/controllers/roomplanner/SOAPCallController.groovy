package roomplanner

import hms.BaseController;
import hms.DemoDataScript
import hms.Hotel
import hms.License
import hms.Room


import org.joda.time.DateTime

class SOAPCallController extends BaseController {

	def roomPlannerService

    def index() { 
		License license = getLicense(request)
		
		Plan plan = roomPlannerService.getCurrentPlan(license)
		
		def startDate = new DateTime(2013, 03, 15, 12, 0, 0, 0)
		def endDate = new DateTime(2013, 03, 30, 12, 0, 0, 0)
		
		def planningWindow = []
		for (DateTime date : new DateTimeRange(startDate.minusDays(2), endDate.plusDays(7))) {
			planningWindow << date
		}
		
		render(view: 'index', model: [planningWindow: planningWindow, rooms: Room.getAllFor(license), plan: plan])
			
	}
	
	def newConfiguration() {
		License license = getLicense(request)

		Plan plan = roomPlannerService.deleteSavedPlan(license)

		def startDate = new DateTime(2013, 03, 15, 12, 0, 0, 0)
		def endDate = new DateTime(2013, 03, 30, 12, 0, 0, 0)
		
		def planningWindow = []
		for (DateTime date : new DateTimeRange(startDate.minusDays(2), endDate.plusDays(7))) {
			planningWindow << date
		}
		render(view: 'index', model: [planningWindow: planningWindow, rooms: Room.getAllFor(license), plan: plan])
	}
}
