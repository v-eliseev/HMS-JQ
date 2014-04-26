package hms

import groovy.transform.ToString
import groovy.transform.EqualsAndHashCode

@ToString(includeNames = true, includeFields = true)
@EqualsAndHashCode
class ReservationStatus extends DomainBaseClass {

	enum StatusCode {
		NEW(1),
		CANCELLED(2),
		PLANNED(3),
		CHECKED_IN(4),
		CHECKED_OUT(5),
		NO_SHOW(6)

		public StatusCode(int value) { this.value = value }
		private final int value
		public int getId() { return value }		
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
		code sqlType: 'integer'	
	}
	
}
