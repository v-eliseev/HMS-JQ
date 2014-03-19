package hms

import hms.Hotel
import hms.License
import hms.dto.ReservationRequest

import roomplanner.DateTimeRange
import roomplanner.Plan

import org.joda.time.DateTime

import grails.converters.JSON

class UserController extends BaseController {

	static defaultAction = "index"

	/**
	 * Handling mobile views
	 */
	def afterInterceptor = [action: this.&handleMobile]

	def roomPlannerService
	def reservationService
	def reservationStatusService
	def hotelService
	def configurationService

	def index() {
		License license = getLicense(request)

		def hotel = license.hotel
		def roomCategoryList = hotel.roomCategories

		def reservationList = reservationService.getReservations(license, new Date()-6, new Date()+8)
		def checkinList = reservationService.getCheckins(license, new Date(), 5)
		def checkoutList = reservationService.getCheckouts(license, new Date(), 5)
		Plan plan = roomPlannerService.getCurrentPlan(license, false)

		[
			licenseInstance: license,
			hotelInstance: hotel,
			roomCategoryInstanceList: roomCategoryList,
			reservationInstanceList: reservationList,
			todayCheckinList: checkinList,
			todayCheckoutList: checkoutList,
			score: plan?.score,
			plan: plan
		]
	}

	def getCurrentPlan() {
		License license = getLicense(request)
		Plan plan = roomPlannerService.getCurentPlan(license, true)
		
		render(template: 'plandetails', model: plan)
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
		
		def rooms = Room.getAllFor(license)
		def hotel = license.hotel
		def roomCategoryList = hotel.roomCategories
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

		def model = showCurrentPlan()
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
	
	def addReservation() {
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
	
	def checkReservation() {
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
}
