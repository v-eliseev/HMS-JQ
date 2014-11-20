package hms

import roomplanner.Plan
import roomplanner.DateTimeRange

import org.joda.time.DateTime

import grails.converters.JSON

class DashboardController extends BaseController {

	def hotelService
	def reservationService
	def reservationStatusService
	def roomPlannerService

    def index() { 
		License license = getLicense(request)
		def hotel = license.hotel
		def usersList = license.users
		def roomCategoryList = hotel.roomCategories
		def roomList = hotelService.listRooms(license)
		def reservationList = reservationService.getReservations(license, new Date()-6, new Date()+8)
		def checkinList = reservationService.getCheckins(license, new Date(), 5)
		def checkoutList = reservationService.getCheckouts(license, new Date(), 5)
		Plan plan = roomPlannerService.getCurrentPlan(license, false)

		[
			licenseInstance: license,
			hotelInstance: hotel,
			userInstanceList: usersList,
			hotelRoomCategoriesCount: roomCategoryList.size(),
			hotelRoomsCount: roomList.size(),
			roomCategoryInstanceList: roomCategoryList,
			reservationInstanceList: reservationList,
			todayCheckinList: checkinList,
			todayCheckoutList: checkoutList,
			score: plan?.score,
			plan: plan
		]
	}

	def showCharts() {
		License license = getLicense(request)
		
		Plan plan = roomPlannerService.getCurrentPlan(license)
		
		def startDate = new DateTime()
		def endDate = startDate.plusDays(7)
		
		def planningWindow = []
		for (DateTime date : new DateTimeRange(startDate.minusDays(6), endDate.plusDays(2))) {
			planningWindow << date
		}
		
		def rooms = Room.getAllFor(license)
		def hotel = license.hotel
		def roomCategoryList = hotel.roomCategories
		def reservationList = hotel.reservations

		[
			licenseInstance: license,
			hotelInstance: hotel,
			roomCategoryInstanceList: roomCategoryList,
			reservationInstanceList: reservationList,
			planningWindow: planningWindow,
			rooms: rooms,
			score: plan.score,
			plan: plan
		]
	}

	def showCurrentPlan() {
		License license = getLicense(request)
		
		Plan plan = roomPlannerService.getCurrentPlan(license)
		
		def startDate = new DateTime()
		def endDate = startDate.plusDays(7)
		
		def planningWindow = []
		for (DateTime date : new DateTimeRange(startDate.minusDays(6), endDate.plusDays(2))) {
			planningWindow << date
		}
		
		def hotel = license.hotel
		def rooms = hotelService.listRooms(license) //Room.getAllFor(license)
		def roomCategoryList = hotelService.listRoomCategories(license) //hotel.roomCategories
		def reservationList = reservationService.getReservations(license, startDate.toDate(), endDate.toDate())

		[
			licenseInstance: license,
			hotelInstance: hotel,
			roomCategoryInstanceList: roomCategoryList,
			reservationInstanceList: reservationList,
			planningWindow: planningWindow,
			rooms: rooms,
			score: plan.score,
			plan: plan
		]    	
	}

	def showCurrentPlanSvg() {
		License license = getLicense(request)

		def hotel = license.hotel
		def allRooms = hotelService.listRooms(license)
		def allRoomCategories = hotelService.listRoomCategories(license)

		def firstDate = new DateTime().withTime(12,0,0,0).minusDays(3)
		def lastDate = firstDate.plusDays(14)
		
		def activeReservations = hotelService.listActiveReservations(license)
		//def planningWindow = []

		Plan plan = roomPlannerService.getCurrentPlan(license)
		def displayReservations = reservationService.getReservations(license, firstDate.toDate(), lastDate.toDate())
		def displayRoomAssignments = plan.roomAssignments

		def reservationStatusList = reservationStatusService.listReservationStatus()

		[
			licenseInstance: license,
			hotelInstance: hotel,
			roomCategoryInstanceList: allRoomCategories,
			reservationInstanceList: activeReservations,
			allRooms: allRooms,
			allRoomsJSON: new JSON(allRooms).toString(),
			displayReservations: displayReservations,
			displayReservationsJSON: new JSON(displayReservations).toString(),
			displayRoomAssignments: displayRoomAssignments,
			displayRoomAssignmentsJSON: new JSON(displayRoomAssignments).toString(),
			reservationStatusListJSON: new JSON(reservationStatusList).toString(),
			constraintMatches: plan.constraintMatches,
			constraintMatchesJSON: new JSON(plan.constraintMatches).toString(),
			firstDate: firstDate,
			lastDate: lastDate,
			score: plan.score
		]
	}

	def getCurrentPlan() {
		License license = getLicense(request)
		Plan plan = roomPlannerService.getCurrentPlan(license, true)
		log.trace("$plan")
		
		render(template: 'plandetails', model: [plan: plan])
	}

	/**
		For testing purposes
	*/
	def newConfiguration() {
		License license = getLicense(request)

		log.trace("Create new plan")

		Plan plan = roomPlannerService.deleteSavedPlan(license)

		def startDate = new DateTime()
		def endDate = startDate.plusDays(7)
		
		def planningWindow = []
		for (DateTime date : new DateTimeRange(startDate.minusDays(6), endDate.plusDays(2))) {
			planningWindow << date
		}

		def rooms = Room.getAllFor(license)
		def hotel = license.hotel
		def roomCategoryList = hotel.roomCategories
		def reservationList = hotel.reservations

		redirect(action: 'index')
	}

}
