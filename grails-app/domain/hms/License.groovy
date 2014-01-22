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
		public int getId() { return value }		
	}

	/**
	 * Key format: XXXXX-XXXXX-XXXXX-XXXXX-XXXXXX
	 * Used characters: [A-Z2-7]
	 */

    static constraints = {
		key nullable: false, empty: false, unique: true
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
		key column: '`KEY`'
		sort 'key'
		sort users: 'username', order: 'asc'
		mode sqlType: 'integer'	
	}

}
