package hms

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
    }

    def create() {
    	License license = getLicense(request)

		// def newUser = adminService.createUser(params.username, params.password, params.email, license)
		// def userRole = adminService.getUserRole()
		// SecUserRole.create(newUser, userRole)

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
}
