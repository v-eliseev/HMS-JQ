package hms

import hms.auth.SecUser
import hms.auth.SecUserRole

class AdminController extends BaseController {

	def adminService

	static defaultAction = "index"
	
	/**
	 * Handling mobile views
	 */
	def afterInterceptor = [action: this.&handleMobile]

	def index() {
		
		License license = getLicense(request)
		// def hotel = license.hotel
		// def usersList = license.users
		// def roomCategoryList = hotel.roomCategories
		// def reservationList = hotel.reservations
		
		[
			// hotelInstance: hotel, 
			// userInstanceList: usersList, 
			// roomCategoryInstanceList: roomCategoryList,
			// reservationInstanceList: reservationList
		]
	}

	def resetPassword() {
		def user = SecUser.get(params.id)		

		//AdminService adminService = getServiceFactory().getServiceByName("adminService")
		License license = getLicense(request)
		
		adminService.resetPassword(user, license)

		redirect action: 'showUsers'
	}

	
	def createHotel() {
	}

	def doCreateHotel() {
		HotelService hotelService = getServiceFactory().getServiceByName("hotelService")
		License license = getLicense(request)
		def newHotel = hotelService.createHotel(params.name, license)
				
		redirect action: 'index'
	}

	def changePassword() {	
		//AdminService adminService = getServiceFactory().getServiceByName("adminService")
		SecUser user = getCurrentUser(request)
		License license = getLicense(request)
		
		[
			hotelInstance: license.hotel,
			username: user.username
		]
	}

	def doChangePassword() {
		//AdminService adminService = getServiceFactory().getServiceByName("adminService")
		License license = getLicense(request)
		
		adminService.changePassword(params.username, params.currentPassword, params.newPassword, license)
		
		redirect action: 'index'
	}
}