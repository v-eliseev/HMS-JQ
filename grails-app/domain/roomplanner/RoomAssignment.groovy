package roomplanner

class RoomAssignment {
	
	static mapping = {
		datasource 'cache'
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
