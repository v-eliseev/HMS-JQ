package hms

import groovy.transform.ToString
import groovy.transform.EqualsAndHashCode

@ToString(includeNames = true, includeFields = true)
@EqualsAndHashCode
class PermanentRoomAssignment extends DomainBaseClass {

	Room room
	Reservation reservation

    static constraints = {
    }
}
