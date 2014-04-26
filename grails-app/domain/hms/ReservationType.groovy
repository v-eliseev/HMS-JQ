package hms

import groovy.transform.ToString
import groovy.transform.EqualsAndHashCode

@ToString(includeNames = true, includeFields = true)
@EqualsAndHashCode
class ReservationType extends DomainBaseClass {

	String name
	String shortName
	String description
	Boolean isActive
	
    static constraints = {
    }
}
