package hms

import groovy.transform.ToString
import groovy.transform.EqualsAndHashCode

@ToString(includeNames = true, includeFields = true)
@EqualsAndHashCode
class Room extends DomainBaseClass {

	String name
	RoomCategory roomCategory
	String description
	Integer adults = 1
	
	static belongsTo = [roomCategory:RoomCategory] //, Reservation]
	
//	static hasMany = [reservations: Reservation]
		
    static constraints = {
		name(blank:false)
		roomCategory(nullable:false)
		description(nullable:true)
		adults(min:0)
    }
	
	static mapping = {
		sort 'name'
	}

	static def getAllFor(License license) {
		def hotel = license.getHotel()
		def result = hotel.roomCategories*.rooms
		result.removeAll([null])
		result.flatten()
	}

}
