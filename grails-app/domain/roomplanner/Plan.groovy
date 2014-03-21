package roomplanner

import groovy.transform.ToString

@ToString(includeNames = true, includeFields = true, includes = "licenseId, score")
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

@ToString(includeNames = true, includeFields = true)
class Score {
	Boolean feasible
	Double hard
	Double soft
}
