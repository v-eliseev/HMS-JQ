package hms

import groovy.transform.ToString
import groovy.transform.EqualsAndHashCode

@ToString(includeNames = true, includeFields = true)
@EqualsAndHashCode
class Setting {

	String key
	String value

    static constraints = {
    	key unique: true
    	value nullable: true
    }

    static mapping = {
		datasource 'plancache'

		key column: '`KEY`'
		value column: '`VALUE`'
	}
}
