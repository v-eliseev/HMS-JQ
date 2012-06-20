package hms.jq

import hms.AdminService
import hms.Hotel
import hms.HotelService
import hms.License
import hms.ServiceFactory
import hms.auth.User
import hms.auth.UserRole


class AdminController extends BaseController {

	static defaultAction = "index"

	/**
	 * Handling mobile views
	 */
	def afterInterceptor = [action: this.&handleMobile]

	def index() {
		
		License license = getLicense(request)
				
		def usersList = license?.users
		def hotel = Hotel.findByLicense(license)
		def roomCategoryList = hotel.roomCategories
		
		[licenseInstance: license, hotelInstance: hotel, userInstanceList: usersList, roomCategoryInstanceList: roomCategoryList]
	}

	def createUser() {
	}
	
	def doCreateUser() {
		AdminService adminService = ServiceFactory.getServiceFactory().getServiceByName("adminService")
		License license = getLicense(request)
		def newUser = adminService.createUser(params.username, params.password, license)
		def userRole = adminService.getUserRole()
		UserRole.create(newUser, userRole)
		
		redirect action: 'index'
	}
	
	def createHotel() {
	}

	def doCreateHotel() {
		HotelService hotelService = ServiceFactory.getServiceFactory().getServiceByName("hotelService")
		License license = getLicense(request)
		def newHotel = hotelService.createHotel(params.name, license)
		redirect action: 'index'
	}

	def changePassword() {	
		AdminService adminService = ServiceFactory.getServiceFactory().getServiceByName("adminService")
		User user = getCurrentUser(request)
		
		[username: user.username]
	}
	
	def doChangePassword() {
		AdminService adminService = ServiceFactory.getServiceFactory().getServiceByName("adminService")
		License license = getLicense(request)
		
		adminService.changePassword(params.username, params.currentPassword, params.newPassword, license)
		
		redirect action: 'index'
	}
}