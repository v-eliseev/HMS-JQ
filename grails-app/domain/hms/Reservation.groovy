package hms

import org.joda.time.Interval

class Reservation extends DomainBaseClass {
	
	// General data
	Date fromDate
	Date toDate
	//Interval bookingInterval
	Integer adults
	RoomCategory roomCategory
	
	ReservationStatus status
 	//DistributionChannel distributionChannel
    //ReservationMotive reservationMotive
    //ReservationType reservationType
    //CancellationReason cancellationReason
	String notes
	
	Hotel hotel
	static belongsTo = [hotel:Hotel]  
	
    static constraints = {
		//distributionChannel(nullable:true)
		//reservationMotive(nullable:true)
		//reservationType(nullable:true) // TODO
		status nullable: false
		//cancellationReason(nullable:true)
		notes nullable: true
		//hotel(nullable: false)
		adults nullable: false
		roomCategory nullable: false
    }

   	static mapping = {
		sort 'fromDate'
	}

	
	static def getAllFor(License license) {
		def hotel = license.getHotel()
		def result = hotel.reservations
		result
	}

	static def getAllFor(License license, Date fromDate, Date toDate) {
		def hotel = license.getHotel()

		def c = Reservation.createCriteria()
		def result = c {
			eq('hotel', hotel)
			or {
				between('fromDate', fromDate, toDate)
				between('toDate', fromDate, toDate)
				and {
					lt('fromDate', fromDate)
					gt('toDate', toDate)
				}
			}
		}
		result
	}

}
