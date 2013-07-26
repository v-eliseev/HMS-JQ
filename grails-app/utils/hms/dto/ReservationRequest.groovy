package hms.dto

import groovy.transform.ToString

import hms.RoomCategory

@ToString(includeNames = true, includeFields = true, excludes = 'dateCreated,lastUpdated,metaClass')
class ReservationRequest {
	Date fromDate
	Date toDate
	Integer adults
	RoomCategory roomCategory
}