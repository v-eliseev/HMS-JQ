package hms

class ReservationStatus extends DomainBaseClass {

	enum StatusCode {
		NEW,
		CANCELLED,
		PLANNED,
		CHECKED_IN,
		CHECKED_OUT,
		NO_SHOW

		// StatusCode(String value) { this.value = value }
		// private final String value
		// public String value() { return value }		
	}

	StatusCode code
	String shortDescription
	String description
	String colorCode
	Boolean isActive

    static constraints = {
    	code nullable: false
    	shortDescription nullable: true
    	description nullable: true
    	colorCode nullable: true
    	isActive nullable: true
	}

	static mapping = {
		code sqlType: 'varchar(12)'	
	}
	
}
