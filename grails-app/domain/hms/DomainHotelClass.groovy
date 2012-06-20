package hms

class DomainHotelClass extends DomainBaseClass {

	Hotel hotel
	static belongsTo = Hotel

    static constraints = {
		hotel nullable: false
    }
}
