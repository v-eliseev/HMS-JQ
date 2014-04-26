package hms

import groovy.transform.ToString
import groovy.transform.EqualsAndHashCode

@ToString(includeNames = true, includeFields = true)
@EqualsAndHashCode
class RoomFeature extends DomainBaseClass {

	String name
	String shortDescription
	String description
	
	static belongsTo = [Hotel, RoomCategory]
	static hasMany = [roomCategories: RoomCategory]
	
    static constraints = {
    }
}
