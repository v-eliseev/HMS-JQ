package hms

import java.security.SecureRandom
import java.util.Date;

class LicenseUser {
	def springSecurityService

	String username
	String password

	Date dateCreated
	Date lastUpdated

	String salt
	boolean enabled
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired

	static mapping = {
		// password is a keyword in some sql dialects, so quote with backticks
		// password is stored as 44-char base64 hashed value
		password column: '`PASSWORD`', length: 44
		sort 'username'
	}
	static constraints = {
		username blank: false, size: 1..50, unique: true
		password blank: false, size: 8..100
		// salt is stored as 64-char base64 value
		salt maxSize: 64
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password'))
			encodePassword()
	}

	String getSalt() {
		if (!this.salt) {
			def rnd = new byte[48];
			new SecureRandom().nextBytes(rnd)
			this.salt = rnd.encodeBase64()
		}
		this.salt
	}

//	Set getAuthorities() {
//		UserRole.findAllByUser(this).collect { it.role } as Set
//	}

	protected encodePassword() {
		password = springSecurityService.encodePassword(password, salt) // update
	}
}