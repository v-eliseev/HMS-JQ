package hms

class HotelService {

	def createRandomHotelData(License license) {
		license.hotel = DemoDataScript.generateRandomData(license)
		license.save(flush:true)
	}
	
	def createHotel(String name, License license) {
		def newHotel = new Hotel(name: name)
		if (!newHotel.save(flush:true)) {
			newHotel.errors.each { log.error(it) }
			throw Exception('Hotel was not created')
		}

		license.addToHotels(newHotel)
		license.save(flush:true)
			
		newHotel
	}
	
	def get(License license) {
		Hotel.getFor(license)
	}

	def show(def objectId) {
		Hotel.get(objectId)
	}

	/**
	*	
	*/
	def listRooms(License license) {
		Room.getAllFor(license)
	}

	/**
	*	
	*/
	def listRoomCategories(License license) {
		RoomCategory.getAllFor(license)
	}

	def listActiveReservations(License license) {
		[]
	}

	def listReservations(License license) {
		Reservation.getAllFor(license)
	}

}
