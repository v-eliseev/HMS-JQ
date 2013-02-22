package hms

class RoomCategoryService {
	
	def getRoomCategory = { id ->
		RoomCategory.get(id)
	}
}