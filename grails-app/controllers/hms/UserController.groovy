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
	}
	
	def doAddReservation() {
		License license = getLicense(request)

		log.debug("Modal form parameters: ${params}")

		def fromDate = new Date(params.fromDate)
		def toDate = new Date(params.toDate)
		def adults = params.int('adults')
		def roomCategoryId = params.long('roomCategoryId')

		reservationService.createReservation(license, fromDate, toDate, roomCategoryId)

		redirect action: 'index'
	}
	
	def checkReservation() {
		def from = params.from
		def to = params.to
		def adults = params.int('adults')

		
		def jsonData = [status: 'OK']
		
		render jsonData as JSON
	}
}
