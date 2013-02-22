package hms

class RoomController extends BaseController {

	static defaultAction = "index"

	def hotelService
	def roomCategoryService
	def roomService
	
	/**
	 * Handling mobile views
	 */
	def afterInterceptor = [action: this.&handleMobile]

	def index() {
		License license = getLicense(request)

		def roomList = hotelService.listRooms(license)
		[
			roomInstanceList: roomList
		]
	}

	def add() {
		License license = getLicense(request)
		def roomCategories = hotelService.listRoomCategories(license)
		[
			roomCategoryInstanceList: roomCategories
		]
	}

	def create() {
		License license = getLicense(request)
		// def listId = hyphen_range(params.name)
		// def roomCategory = roomCategoryService.show(params.roomCategory)
		// listId.each { itemId ->

		// 	Room r = new Room(
		// 			name: itemId,
		// 			roomCategory: roomCategory,
		// 			description: "",
		// 			adults: 1
		// 			)
		// 	r.save()
		// }
		redirect action: 'index'
	}

	def edit() {
		License license = getLicense(request)
		def roomCategories = hotelService.listRoomCategories(license)
		def room = roomService.getRoom(params.id)
		def roomCategory = roomCategoryService.getRoomCategory(room.roomCategory.id)

		[
			roomInstance: room,
			roomCategoryInstance: roomCategory,
			roomCategoryInstanceList: roomCategories
		]
	}

	def update() {
		License license = getLicense(request)

		redirect action: 'index'
	}

	def delete()  {
		License license = getLicense(request)
		// def checkedList = []
		// params.each { item->
		// 	if (item.key.matches("^cb[0-9]+") && item.value.equals("on")) {
		// 		checkedList.add(item.key.find("[0-9]+"))
		// 	}
		// }
		// checkedList.each { item ->
		// 	service.delete(item)			
		// }
		redirect action: 'index'
	}
	
	private def hyphen_range = { str ->
		// Takes a range in form of "a-b" and generate a list of numbers between a and b inclusive.
		// Also accepts comma separated ranges like "a-b,c-d,f" will build a list which will include
		// Numbers from a to b, c to d and f

		def listId = []
		str.split(',').each { elem ->
			def val = elem.split('-')
			if (val.size() == 1) { // a number
				listId.add(val[0].trim())
			} else if (val.size() == 2) { // a range inclusive
				for (i in val[0].trim()..val[1].trim()) {
					listId.add(i)
				}
			}
			else {// more than one hyphen
				println('format error in %s' % val)
			}
		}
		listId.sort()
		listId
	}
}