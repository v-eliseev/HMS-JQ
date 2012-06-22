package hms

class Hotel extends DomainBaseClass {

	// Contact Data
	String name
	String phone
	String fax
	String eMail
	String webSite

	// Registration Data
	String registrationNr
	String taxNr

	// Payment Data
	String bankName
	String bankCode
	String accountNr
	String bicCode
	String iban

	// Default settings
	String countryCode

	// Invoice numbers
	String invoicePrefix
	String invoiceStartId
	String invoiceSuffix

	static hasMany = [roomCategories: RoomCategory, reservations: Reservation]

	License license
	static belongsTo = License
	
	static constraints = {
		license nullable: false
		name nullable: true
		
		phone nullable: true
		fax nullable: true
		eMail nullable: true
		webSite nullable: true
		
		registrationNr nullable: true
		taxNr nullable: true
		
		bankName nullable: true
		bankCode nullable: true
		accountNr nullable: true
		bicCode nullable: true
		iban nullable: true
	
		countryCode nullable: true
		
		invoicePrefix nullable: true
		invoiceStartId nullable: true
		invoiceSuffix nullable: true
		
	}
	
	@Override
	String toString() {
		name + "@" + license?.key
	}
}
