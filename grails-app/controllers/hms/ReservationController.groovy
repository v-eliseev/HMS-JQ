package hms

class ReservationController extends BaseController {

	static defaultAction = "index"

	def hotelService
	def reservationService
	def roomService

	/**
	 * Handling mobile views	
	 */
	def afterInterceptor = [action: this.&handleMobile]

	def index() {
		License license = getLicense(request)

		def reservationInstanceList = hotelService.listReservations(license)
		[
			reservationInstanceList: reservationInstanceList
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

		Reservation reservationInstance = reservationService.getReservation(params.id)
		[
			reservationInstance: reservationInstance
		]
	}

	def update() {
		License license = getLicense(request)

		redirect action: 'index'
	}

	def delete() {

	}


	// def create() {
	// 	def roomCategoryList = ServiceFactory.getServiceFactory().getServiceByDomainClass(RoomCategory.class)?.list()
	// 	def reservationMotiveList= ServiceFactory.getServiceFactory().getServiceByDomainClass(ReservationMotive.class)?.list()
	// 	def distributionChannelList= ServiceFactory.getServiceFactory().getServiceByDomainClass(DistributionChannel.class)?.list()

	// 	def roomCategoryData = []
	// 	def reservationMotiveData = []
	// 	def distributionChannelData = []

	// 	roomCategoryList.each { item ->
	// 		roomCategoryData.add([id: item.id, name: item.name])
	// 	}
	// 	reservationMotiveList.each { item ->
	// 		reservationMotiveData.add([id: item.id, name: item.name])
	// 	}
	// 	distributionChannelList.each { item ->
	// 		distributionChannelData.add([id: item.id, name: item.name])
	// 	}

	// 	def initial = [
	// 				fromDate: new Date(),
	// 				toDate: new Date() + 1
	// 		]

	// 	[
	// 		roomCategoriesList: roomCategoryData,
	// 		reservationMotivesList: reservationMotiveData,
	// 		distributionChannelsList: distributionChannelData,
	// 		initial: initial
	// 	]
	// }

	// def checkAvailabilityJSON() {
	// 	def roomCategory = params?.roomCategory;
	// 	def fromDate = params?.fromDate;
	// 	def toDate = params?.toDate;

	// 	def jsonData = [status: "OK"]
	// 	render jsonData as JSON
	// }

	// def save() {
	// 	def reservationService = ServiceFactory.getServiceFactory().getServiceByDomainClass(Reservation.class)
	// 	def reservationStatusService = ServiceFactory.getServiceFactory().getServiceByDomainClass(ReservationStatus.class)
	// 	def reservationStatusNew = reservationStatusService.getStatusNew()
	// 	def obj = new Reservation([
	// 				fromDate: new Date(params.fromDate),
	// 				toDate: new Date(params.toDate),
	// 				notes: params.notes,
	// 				reservationStatus: reservationStatusNew
	// 			])
	// 	reservationService.create(obj)
	// 	redirect (action:"list")
	// }

	// def list() {
	// 	def service = ServiceFactory.getServiceFactory().getServiceByDomainClass(Reservation.class)
	// 	def dataList = service?.list()
	// 	[dataList: dataList]
	// }
	
	// def request() {
	// 	[
	// 		fromDate: new Date(),
	// 		toDate: new Date() + 1,
	// 		guests: 1
	// 	]
	// }
	
	def listAvailableRoomTypes() {
		def parameters = params
		def roomList = roomService?.list()
		def reservationsList = reservationService?.list()
		[dataList: roomList]
	}
	
	def listAvailableRooms() {
		def parameters = params
		
		def roomList
		if (parameters.roomType == null) {
			roomList = roomService?.list()
		}
		else {
			roomList = roomService?.list()
		}
		[dataList: roomList]
	}
}
