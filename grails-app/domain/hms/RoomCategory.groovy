package hms

class RoomCategory extends DomainBaseClass {

	String name
	String shortDescription
	String description
	Boolean isBookableOnline = true
	
	Hotel hotel
	static belongsTo = [hotel:Hotel]
	
	static hasMany = [rooms: Room, roomFeatures: RoomFeature]

	static constraints = {
		name(blank: false)
		shortDescription(nullable: true)
		description(nullable: true)
		isBookableOnline()
		//hotel(nullable: false)
	}

	static mapping = {
		sort 'name'
		rooms sort: 'name', order: 'asc'
	}

//	Set<RoomFeature> getFeatures() {
//		RoomCategoryRoomFeature.findAllByRoomCategory(this).collect { it.roomFeature } as Set
//	}

	static def getAllFor(License license) {
		def hotel = license.getHotel()
		def result = hotel.roomCategories
		result
	}
}
