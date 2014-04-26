package hms.util

import hms.auth.SecUser

import groovy.transform.ToString
import groovy.transform.EqualsAndHashCode

@ToString(includeNames = true, includeFields = true)
@EqualsAndHashCode
class Configuration {

	SecUser user
	String key
	String value

    static constraints = {
    	user nullable: false
    	key  nullable: false, blank: false
    	value nullable: true
    }

	static mapping = {
		key column: '`KEY`'
		value column: '`VALUE`'
	}
}
