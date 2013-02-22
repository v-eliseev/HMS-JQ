package hms

import hms.Hotel
import hms.License
import grails.converters.*

class UserController extends BaseController {

	static defaultAction = "index"

	/**
	 * Handling mobile views
	 */
	def afterInterceptor = [action: this.&handleMobile]

	def index() {
		License license = getLicense(request)

		def hotel = license.hotel
		def roomCategoryList = hotel.roomCategories
		def reservationList = hotel.reservations

		[
			licenseInstance: license,
			hotelInstance: hotel,
			roomCategoryInstanceList: roomCategoryList,
			reservationInstanceList: reservationList
		]
	}
	
	def addReservation() {
	}
	
	def doAddReservation() {
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
