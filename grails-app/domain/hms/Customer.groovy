package hms

import groovy.transform.ToString
import groovy.transform.EqualsAndHashCode

@ToString(includeNames = true, includeFields = true)
@EqualsAndHashCode
class Customer extends DomainBaseClass {
	
	// Contact Data
	String name
	String salutation
	String phoneNr
	String faxNr
	String eMail
	
	// Address
	String addressType
	String address1
	String address2
	String address3
	String zipCode
	String city
	String country
	
	// Additional data
	String company
	Date dob
	String carLicensePlate
	String passportNr
	
	RateCode defaultRateCode
	
//	static hasMany = [reservations:Reservation]

    static constraints = {
		dob(nullable:true)
    }
}
