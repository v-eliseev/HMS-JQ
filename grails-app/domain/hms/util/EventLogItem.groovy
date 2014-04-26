package hms.util

import groovy.transform.ToString
import groovy.transform.EqualsAndHashCode

@ToString(includeNames = true, includeFields = true)
@EqualsAndHashCode
class EventLogItem implements Serializable {
	
	Date timestamp
	Enum type
	String notes

    static constraints = {
    	timestamp column: '`TIMESTAMP`'
    }
}
