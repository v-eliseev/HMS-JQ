package hms.auth

import hms.DomainBaseClass
import hms.License

class User extends DomainBaseClass {

	transient springSecurityService
	
	String username
	String password // hashed

	License license
	static belongsTo = License
	
	boolean enabled = true
	boolean accountExpired = false
	boolean accountLocked = false
	boolean passwordExpired = false

	static constraints = {
		username blank: false, unique: 'license'
		password blank: false
		license nullable: false
	}

	static mapping = {
		password column: '`password`'
	}

	Set<Role> getAuthorities() {
		UserRole.findAllByUser(this).collect { it.role } as Set
	}
	
	@Override
	String toString() {
		username + "@" + license?.key
	}

}
