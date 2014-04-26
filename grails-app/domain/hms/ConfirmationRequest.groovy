package hms

import groovy.transform.ToString
import groovy.transform.EqualsAndHashCode

@ToString(includeNames = true, includeFields = true)
@EqualsAndHashCode
class ConfirmationRequest extends DomainBaseClass {

	License license
	String uuid
	Date expires
	Integer type
	String data

	static belongsTo = License

    static constraints = {
    	data column: '`DATA`'
    }
}
