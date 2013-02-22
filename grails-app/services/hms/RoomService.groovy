package hms

class RoomService {

	def getRoom = { id ->
		Room.get(id)
	}

	def listCategory(catId) {
		Room.findAllWhere(roomCategory:catId)
	}
	
	def search(value) {
		Room.findAllLike("%"+value+"%")
	}

	def listAll(license) {
		Room.getAllFor(license)
	}
}
