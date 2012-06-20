package hms

import hms.auth.Role;

import java.util.Set;

class RoomCategory extends DomainBaseClass {

	String name
	String shortDescription
	String description
	Boolean isBookableOnline = true
	
	static belongsTo = Hotel
	
	static hasMany = [rooms: Room, roomFeatures: RoomFeature]

	static constraints = {
		name(blank: false)
		shortDescription(nullable: true)
		description(nullable: true)
		isBookableOnline()
	}

//	Set<RoomFeature> getFeatures() {
//		RoomCategoryRoomFeature.findAllByRoomCategory(this).collect { it.roomFeature } as Set
//	}
	
}
