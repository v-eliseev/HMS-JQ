package roomplanner

class Plan implements Serializable {

	static mapping = {
		datasource 'plancache'
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
