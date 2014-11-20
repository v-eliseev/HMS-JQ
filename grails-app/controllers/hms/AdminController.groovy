package hms

import hms.auth.SecUser

class AdminController extends BaseController {

	def adminService
	def hotelService

	static defaultAction = "index"
	
	/**
	 * Handling mobile views
	 */
	def afterInterceptor = [action: this.&handleMobile]

	def index() {
		
		License license = getLicense(request)
		def hotel = license.hotel
		def usersList = license.users
		def roomCategoryList = hotel.roomCategories
		def roomList = hotelService.listRooms(license)
		
		[
			licenseInstance: license,
			hotelInstance: hotel, 
			userInstanceList: usersList, 
			hotelRoomCategoriesCount: roomCategoryList.size(),
			hotelRoomsCount: roomList.size(),
		]
	}

	def addUser() {
		License license = getLicense(request)
		def allRoles = adminService.getAllRoles()
		
		[
			roleInstanceList: allRoles
		]
	}

	def showUser() {
		License license = getLicense(request)
		
		def user = adminService.getUser(params.id)
		def allRoles = adminService.getAllRoles()

		render(view: "addUser", model: [ user: user, roleInstanceList: allRoles	])
	}

	def saveUser() {
		License license = getLicense(request)

		def roles = params.list('roles').collect { adminService.getRole(it) }

		adminService.createUser(
			params.username, 
			params.password, 
			params.email, 
			license, 
			roles)

		redirect action: 'index'
	}


	def resetPassword() {
		License license = getLicense(request)

		def user = SecUser.get(params.id)		
		adminService.resetPassword(user, license)

		redirect action: 'index'
	}

	
	def changePassword() {	
		License license = getLicense(request)
		SecUser user = getCurrentUser(request)
		
		[
			hotelInstance: license.hotel,
			username: user.username
		]
	}

	def doChangePassword() {
		License license = getLicense(request)
		
		adminService.changePassword(params.username, params.currentPassword, params.newPassword, license)
		
		redirect action: 'index'
	}
}