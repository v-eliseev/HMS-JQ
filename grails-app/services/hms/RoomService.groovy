package hms

class RoomService extends CRUDService {

	def getDomainClass() {
		Room.class
	}
	
	def listCategory(catId) {
		Room.findAllWhere(roomCategory:catId)
	}
	
	def search(value) {
		Room.findAllLike("%"+value+"%")
	}
}
