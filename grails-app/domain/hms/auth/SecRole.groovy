package hms.auth

import hms.DomainBaseClass

class SecRole extends DomainBaseClass {

	String authority

	static mapping = {
		cache true
	}

	static constraints = {
		authority blank: false, unique: true
	}

	def beforeDelete() {
		SecUserRole.withNewSession {
			SecUserRole.findAllByRole(this)*.delete(flush:true)
		}
	}
}
