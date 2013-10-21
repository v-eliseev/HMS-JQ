package hms


class Owner extends DomainBaseClass {

	String firstname
	String lastname
	String phone
	String country
	String zip
	String city
	String state
	String address1
	String address2

	License license
	static belongsTo = [license:License]

    static constraints = {
    }
}
