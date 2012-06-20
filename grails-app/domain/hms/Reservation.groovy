package hms

class Reservation extends DomainBaseClass {
	
	// General data
	Date fromDate
	Date toDate
	//ReservationStatus reservationStatus
 	//DistributionChannel distributionChannel
    //ReservationMotive reservationMotive
    //ReservationType reservationType
    //CancellationReason cancellationReason
	String notes
	
	//static hasMany = [rooms:Room, customers:Customer, articles:Article]
	
    static constraints = {
		//distributionChannel(nullable:true)
		//reservationMotive(nullable:true)
		//reservationType(nullable:true) // TODO
		//reservationStatus(nullable:true) // TODO
		//cancellationReason(nullable:true)
		notes nullable:true
    }
}
