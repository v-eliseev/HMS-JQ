package hms.util

import hms.auth.SecUser

class Configuration {

	SecUser user
	String key
	String value

    static constraints = {
    	user nullable: false
    	key  nullable: false, blank: false
    }
}
