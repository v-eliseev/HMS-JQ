package hms.auth

import hms.DomainBaseClass
import hms.License

class SecUser extends DomainBaseClass {

	transient springSecurityService
	
	String username
	String password // hashed

	License license
	static belongsTo = License
	
	boolean enabled = true
	boolean accountExpired = false
	boolean accountLocked = false
	boolean passwordExpired = false

	String email
	Date expirePassword = null  // never
	Date expireAccount = null // never

	static constraints = {
		username blank: false, unique: 'license'
		password blank: false
		license nullable: false
		email nullable: false
		expirePassword nullable: true
		expireAccount nullable: true
	}

	static mapping = {
		password column: '`password`'
	}

	Set<SecRole> getAuthorities() {
		SecUserRole.findAllByUser(this).collect { it.role } as Set
	}
	
	@Override
	String toString() {
		username + "@" + license?.key
	}

}
