package hms

class RoomCategoryController extends BaseController {

	static defaultAction = "index"
	
	def hotelService
	def roomCategoryService

	/**
	 * Handling mobile views
	 */
	def afterInterceptor = [action: this.&handleMobile]

	def index() {
		License license = getLicense(request)

		def roomCategoryList = hotelService.listRoomCategories(license)
		[
			roomCategoryInstanceList: roomCategoryList
		]
	}

	def add() {
		License license = getLicense(request)
	}

	def create() {
		License license = getLicense(request)

		redirect action: 'index'
	}

	def edit() {
		License license = getLicense(request)
	}

	def update() {
		License license = getLicense(request)

		redirect action: 'index'
	}

	def delete() {
		License license = getLicense(request)

		redirect action: 'index'
	}

}
