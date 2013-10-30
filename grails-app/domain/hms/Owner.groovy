package hms


class Owner extends DomainBaseClass {

	String name
	String email
	String phone
	String country
	String zip
	String city
	String state
	String address1
	String address2

	static belongsTo = License

    static constraints = {
    	name nullable: true
    	email nullable: true
    	phone nullable: true
		country nullable: true
		zip nullable: true
		city nullable: true
		state nullable: true
		address1 nullable: true
		address2 nullable: true
    }
}
