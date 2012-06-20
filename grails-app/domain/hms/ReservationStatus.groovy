package hms

class ReservationStatus extends DomainBaseClass {

    static constraints = {
	}
	
	String colorCode
	String name
	String shortDescription
	String description
	Boolean isActive
}
