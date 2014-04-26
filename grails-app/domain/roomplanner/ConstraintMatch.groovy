package roomplanner

import groovy.transform.ToString
import groovy.transform.EqualsAndHashCode

@ToString(includeNames = true, includeFields = true)
@EqualsAndHashCode
class ConstraintMatch implements Serializable {

	static mapping = {
		datasource 'plancache'
	} 

	String rule
	RoomAssignment roomAssignment
	Double weight

	Plan plan
	static belongsTo = [plan:Plan]

    static constraints = {
    	roomAssignment nullable: true
    }

}