package hms.jq

import hms.Hotel
import hms.HotelService
import hms.License
import hms.ServiceFactory

class HotelController extends BaseController {
	
	static defaultAction = "index"
	
	/**
	 * Handling mobile views
	 */
	def afterInterceptor = [action: this.&handleMobile]

	def index = {
		HotelService service = ServiceFactory.getServiceFactory().getServiceByDomainClass(Hotel.class)
		License license = getLicense(request)
		def hotelsList = service.list()
		
		if (hotelsList.size() == 1) {
			redirect action: 'show', params: [id: hotelsList[0].id]
			return
		}
		[hotelInstanceList: hotelsList]
	}

	def show = {
		HotelService service = ServiceFactory.getServiceFactory().getServiceByDomainClass(Hotel.class)
		Hotel object = service.show(params.id)
		[hotel: object]
	}

	def save = {
		HotelService service = ServiceFactory.getServiceFactory().getServiceByDomainClass(Hotel.class)
		Hotel object = service.update(params.id, params)
		redirect (action: 'index', params: params)
	}
	
	def editSystemData = {
	}
}
