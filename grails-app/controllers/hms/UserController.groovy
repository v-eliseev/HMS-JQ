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

	def index() {
		License license = getLicense(request)

		def hotel = license.hotel
		def roomCategoryList = hotel.roomCategories
		def reservationList = hotel.reservations
		def checkinList = reservationService.getCheckins(license, new Date(), 5)
		def checkoutList = reservationService.getCheckouts(license, new Date(), 5)

		[
			licenseInstance: license,
			hotelInstance: hotel,
			roomCategoryInstanceList: roomCategoryList,
			reservationInstanceList: reservationList,
			todayCheckinList: checkinList,
			todayCheckOutList: checkoutList
		]
	}

	def showCurrentPlan() {
		License license = getLicense(request)
		
		Plan plan = roomPlannerService.getCurrentPlan(license)
		
		def startDate = new DateTime()
		def endDate = startDate.plusDays(7)
		
		def planningWindow = []
		for (DateTime date : new DateTimeRange(startDate.minusDays(7), endDate.plusDays(2))) {
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
			plan: plan
		]
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
	
	def addReservation() {
		License license = getLicense(request)

		log.debug("Modal form parameters: ${params}")

		def fromDate = Date.parse("MM/dd/yyyy", params.from)
		def toDate = Date.parse("MM/dd/yyyy", params.to)
		def adults = params.int('adults')
		def roomCategory = RoomCategory.get(params.long('roomCategoryId'))

		reservationService.createReservation(license, fromDate, toDate, roomCategory)

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
