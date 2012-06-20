package hms

class Room extends DomainBaseClass {

	String name
	RoomCategory roomCategory
	String description
	Integer maxOccupants = 1
	
	static belongsTo = RoomCategory
		
    static constraints = {
		name(blank:false)
		roomCategory(nullable:false)
		description(nullable:true)
		maxOccupants(min:0)
    }
}
