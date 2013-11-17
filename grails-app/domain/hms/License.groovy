package hms

import hms.auth.SecUser

enum LicenseType { PRODUCTION, DEMO }

class License extends DomainBaseClass {

	enum LicenseMode {
		DEMO(1),
		PRODUCTION(2),
		TEST(3)

		LicenseMode(int value) { this.value = value }
		private final int value
		public int value() { return value }		
	}

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
	
	Boolean enabled = true
	String key
	String email
	Date expires
	Date issued
	LicenseMode mode
	Owner owner

	Hotel hotel

	static hasMany = [users: SecUser]
	
	@Override
	String toString() {
		key
	}

	static mapping = {
		key column: '`key`'
		sort 'key'
		sort users: 'username', order: 'asc'
		mode sqlType: 'integer'	
	}

}
