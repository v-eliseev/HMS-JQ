package hms.auth

import hms.DomainBaseClass

class Role extends DomainBaseClass {

	String authority

	static mapping = {
		cache true
	}

	static constraints = {
		authority blank: false, unique: true
	}
}
