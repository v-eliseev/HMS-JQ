package hms

import hms.auth.SecUser

class License extends DomainBaseClass {

	static String digits = "2346789"
	static String letters = "BCDFGHJKMPQRTVWXY"
	static digitPosition = [3, 2, 1, 4, 5]
	
	/**
	 * Key format: XXXXX-XXXXX-XXXXX-XXXXX-XXXXX
	 * Used characters: BCDFGHJKMPQRTVWXY2346789	
	 */

    static constraints = {
		key nullable: false, empty: false
		email nullable: true
		expires nullable: true
		issued nullable: true
		owner nullable: true
		hotel nullable: true
    }
	
	String key
	String email
	Date expires
	Date issued
	boolean demoMode
	Owner owner

	Hotel hotel

	static hasMany = [users: SecUser]
	
	@Override
	String toString() {
		key
	}
}
