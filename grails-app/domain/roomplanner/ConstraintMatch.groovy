package roomplanner

class ConstraintMatch {

	static mapping = {
		datasource 'cache'
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