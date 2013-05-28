package hms

class Room extends DomainBaseClass {

	String name
	RoomCategory roomCategory
	String description
	Integer adults = 1
	
	static belongsTo = [RoomCategory] //, Reservation]
	
//	static hasMany = [reservations: Reservation]
		
    static constraints = {
		name(blank:false)
		roomCategory(nullable:false)
		description(nullable:true)
		adults(min:0)
    }
	
	static def getAllFor(License license) {
		def hotel = license.getHotel()
		def result = hotel.roomCategories*.rooms
		result.removeAll([null])
		result.flatten()
		result
	}

}
