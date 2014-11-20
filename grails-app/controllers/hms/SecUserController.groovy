package hms

import hms.auth.SecUser

class SecUserController extends BaseController {

	static defaultAction = "index"

	def adminService

	/**
	 * Handling mobile views
	 */
	def afterInterceptor = [action: this.&handleMobile]
    
    def index() { 
		License license = getLicense(request)
		def userList = license.users
		[
			userInstanceList: userList
		]
    }

    def add() {
		License license = getLicense(request)
		def allRoles = adminService.getAllRoles()
		
		[
			roleInstanceList: allRoles
		]
    }

    def show() {
		License license = getLicense(request)

		def user = adminService.getUser(params.id)
		def allRoles = adminService.getAllRoles()

		render(view: "add", model: [ user: user, roleInstanceList: allRoles	])
    }

    def create() {
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

    def edit() {
    	License license = getLicense(request)
		def user = adminService.getUser(params.id)		
		[
			userInstance: user
		]
    }

    def update() {
    	License license = getLicense(request)

		redirect action: 'index'
    }

    def delete() {
    	License license = getLicense(request)

		adminService.deleteUser(params.id)

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
