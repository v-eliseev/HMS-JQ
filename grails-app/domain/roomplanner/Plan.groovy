package roomplanner

class Plan {

	static mapping = {
		datasource 'cache'
	} 
	
	static hasMany = [roomAssignments: RoomAssignment]
	
	Score score
	long licenseId
	
	static embedded = ['score']
	
    static constraints = {
    }

}

class Score {
	Boolean feasible
	Double hard
	Double soft
}
