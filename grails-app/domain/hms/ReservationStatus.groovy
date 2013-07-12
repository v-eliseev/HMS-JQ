package hms

class ReservationStatus extends DomainBaseClass {

	enum StatusCode {
		NEW("New"),
		CANCELLED("Cancelled"),
		PLANNED("Planned"),
		CHECKED_IN("Checkedin"),
		CHECKED_OUT("Checkedout")

		StatusCode(String code) { this.value = value }
		private final String value
		public int value() { return value }		
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
		code sqlType: 'varchar(10)'	
	}
	
}
