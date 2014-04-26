package hms

class HotelController extends BaseController {
	
	static defaultAction = "index"

	def hotelService
	
	/**
	 * Handling mobile views
	 */
	def afterInterceptor = [action: this.&handleMobile]

	def index() {
		// License license = getLicense(request)
		// def hotelsList = hotelService.list()
		
		// if (hotelsList.size() == 1) {
		// 	redirect action: 'show', params: [id: hotelsList[0].id]
		// 	return
		// }
		// [
		// 	hotelInstanceList: hotelsList
		// ]
	}

	def edit() {
		License license = getLicense(request)
		[
			hotelInstance: license.hotel
		]
	}

	def update() {
		Hotel object = hotelService.update(params.id, params)
		redirect (action: 'index', params: params)
	}
	
}
