package hms

import hms.Hotel
import hms.License
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
	
	def addReservation() {
		License license = getLicense(request)

		log.debug("Modal form parameters: ${params}")

		def fromDate = new Date(params.fromDate)
		def toDate = new Date(params.toDate)
		def adults = params.int('adults')
		def roomCategory = RoomCategory.get(params.long('roomCategoryId'))

		reservationService.createReservation(license, fromDate, toDate, roomCategory)

		redirect action: 'index'
	}
	
	def checkReservation() {
		License license = getLicense(request)

		def fromDate = new Date(params.fromDate)
		def toDate = new Date(params.toDate)
		def adults = params.int('adults')
		def roomCategory = RoomCategory.findById(params.long('roomCategoryId'))

		def reservation = new Reservation(
			fromDate: fromDate,
			toDate: toDate,
			adults: adults,
			roomCategory: roomCategory,
			status: reservationStatusService.getStatusNew()
		)

		def roomAssignment = roomPlannerService.checkReservation(license, reservation)
		
		def result = (roomAssignment != null) ? 'OK' : 'Not OK'
		def jsonData = [status: result]
		
		render jsonData as JSON
	}
}
