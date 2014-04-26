package hms.security

import hms.DomainBaseClass

import groovy.transform.ToString
import groovy.transform.EqualsAndHashCode

@ToString(includeNames = true, includeFields = true, includes = "username, realmCode")
@EqualsAndHashCode
class SystemUser extends DomainBaseClass {

	Long realmCode
	String username
	String password

    static constraints = {
    	realmCode nullable: true
    	username nullable: false, blank: false, unique: true
    	password nullable: false, blank: false
    }

   	static mapping = {
		password column: '`PASSWORD`'
	}
}