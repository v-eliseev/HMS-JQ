package hms

import groovy.transform.ToString
import groovy.transform.EqualsAndHashCode

@ToString(includeNames = true, includeFields = true)
@EqualsAndHashCode
class ReservationMotive extends DomainBaseClass {

    static constraints = {
	}
	
	String name
	String shortDescription
	String description
}
