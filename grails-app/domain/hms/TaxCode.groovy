package hms

import groovy.transform.ToString
import groovy.transform.EqualsAndHashCode

@ToString(includeNames = true, includeFields = true)
@EqualsAndHashCode
class TaxCode extends DomainBaseClass {

	String name
	String amountText
	String description
	Double value
	String units

    static constraints = {
	}

  	static mapping = {
		value column: '`VALUE`'
	}
}