package hms

class RoomFeature extends DomainBaseClass {

	String name
	String shortDescription
	String description
	
	static belongsTo = [Hotel, RoomCategory]
	static hasMany = [roomCategories: RoomCategory]
	
    static constraints = {
    }
}
