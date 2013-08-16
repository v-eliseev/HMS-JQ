package roomplanner

class Plan {

	static mapping = {
		datasource 'cache'
	} 
	
	Date dateCreated
	Date lastUpdated

	static hasMany = [roomAssignments: RoomAssignment, constraintMatches: ConstraintMatch]
	
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
