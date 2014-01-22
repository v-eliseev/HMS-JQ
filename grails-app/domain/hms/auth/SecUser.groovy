package hms.auth

import hms.DomainBaseClass
import hms.License

class SecUser extends DomainBaseClass {

	transient springSecurityService
	
	String username
	String password // hashed

	License license
	static belongsTo = [license: License]
	
	boolean enabled = true
	boolean accountExpired = false
	boolean accountLocked = false
	boolean passwordExpired = false

	String email
	Date expirePassword = null 
	Integer expirePasswordType = 0 // never
	Integer expirePasswordEveryCode = 1 // 1 month

	Date expireAccount = null
	Integer expireAccountType = 0 // never
	Integer expireAccountEveryCode = 1 // 1 month

	static constraints = {
		username unique: 'license'
		password blank: false
		license nullable: false
		email nullable: false
		expirePassword nullable: true
		expireAccount nullable: true
	}

	static mapping = {
		password column: '`PASSWORD`'
	}

	Set<SecRole> getAuthorities() {
		SecUserRole.findAllByUser(this).collect { it.role } as Set
	}

	def beforeDelete = {
		SecUserRole.withNewSession {
			SecUserRole.findAllByUser(this)*.delete(flush:true)
		}
	}

	@Override
	String toString() {
		username + "@" + license?.key
	}

}
