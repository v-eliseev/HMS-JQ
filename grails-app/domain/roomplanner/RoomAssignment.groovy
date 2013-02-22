package roomplanner

class RoomAssignment {
	
	static mapping = {
		datasource 'cache'
	}
	
	long reservationId
	long roomId
	boolean moveable

	static belongsTo = Plan

    static constraints = {
    }
}
