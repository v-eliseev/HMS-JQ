package roomplanner

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
