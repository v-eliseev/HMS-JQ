package roomplanner

import groovy.transform.ToString
import groovy.transform.EqualsAndHashCode

@ToString(includeNames = true, includeFields = true)
@EqualsAndHashCode
class RoomAssignment implements Serializable {
	
	static mapping = {
		datasource 'plancache'
	}
	
	long reservationId
	long roomId
	boolean moveable

	Plan plan
	static belongsTo = [plan:Plan]

    static constraints = {
    	reservationId nullable: true
    }
}
