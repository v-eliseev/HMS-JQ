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
		
		def startDate = new DateTime()
		def endDate = startDate.plusDays(7)
		
		def planningWindow = []
		for (DateTime date : new DateTimeRange(startDate.minusDays(7), endDate.plusDays(2))) {
			planningWindow << date
		}
		
		render(view: 'index', model: [planningWindow: planningWindow, rooms: Room.getAllFor(license), plan: plan])
			
	}
	
	def newConfiguration() {
		License license = getLicense(request)

		Plan plan = roomPlannerService.deleteSavedPlan(license)

		def startDate = new DateTime()
		def endDate = startDate.plusDays(7)
		
		def planningWindow = []
		for (DateTime date : new DateTimeRange(startDate.minusDays(7), endDate.plusDays(2))) {
			planningWindow << date
		}

		render(view: 'index', model: [planningWindow: planningWindow, rooms: Room.getAllFor(license), plan: plan])
	}
}
