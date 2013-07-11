package hms

import org.joda.time.Interval

class Reservation extends DomainBaseClass {
	
	// General data
	Date fromDate
	Date toDate
	//Interval bookingInterval
	Integer adults
	RoomCategory roomCategory
	
	//ReservationStatus reservationStatus
 	//DistributionChannel distributionChannel
    //ReservationMotive reservationMotive
    //ReservationType reservationType
    //CancellationReason cancellationReason
	String notes
	
	//Hotel hotel
	static belongsTo = Hotel  
	
    static constraints = {
		//distributionChannel(nullable:true)
		//reservationMotive(nullable:true)
		//reservationType(nullable:true) // TODO
		//reservationStatus(nullable:true) // TODO
		//cancellationReason(nullable:true)
		notes(nullable: true)
		//hotel(nullable: false)
		adults(nullable: false)
		roomCategory(nullable: false)
    }

   	static mapping = {
		sort fromDate: 'asc'
	}

	
	static def getAllFor(License license) {
		def hotel = license.getHotel()
		def result = hotel.reservations
		result
	}

	static def getAllFor(License license, Date fromDate, Date toDate) {
		def hotel = license.getHotel()
		def planningWindow = new Interval(fromDate, toDate)
		def result = hotel.reservations.findAll { 
			new Interval(it.fromDate, itToDate).overlap(planningWindow)
		}
		result
	}

}
