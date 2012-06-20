package hms

class RoomCategoryRoomFeature implements Serializable {

	RoomCategory roomCategory
	RoomFeature roomFeature

	static mapping = {
		id composite: ['roomCategory', 'roomFeature']
		version false
	}
	
	static RoomCategoryRoomFeature create(RoomCategory roomCategory, RoomFeature roomFeature, boolean flush = false) {
		new RoomCategoryRoomFeature(roomCategory: roomCategory, roomFeature: roomFeature).save(flush: flush, insert: true)
	}

	static boolean remove(RoomCategory roomCategory, RoomFeature roomFeature, boolean flush = false) {
		RoomCategoryRoomFeature instance = RoomCategoryRoomFeature.findByRoomCategoryAndRoomFeature(roomCategory, roomFeature)
		if (!instance) {
			return false
		}

		instance.delete(flush: flush)
		true
	}
}
