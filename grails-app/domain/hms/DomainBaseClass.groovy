package hms

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@ToString(includeNames = true, includeFields = true, excludes = 'dateCreated,lastUpdated,metaClass')
@EqualsAndHashCode
abstract class DomainBaseClass implements java.io.Serializable {
	
	Date dateCreated
	Date lastUpdated

	static mapping = {
		tablePerHierarchy false
	}
	static constraints = {
	}
}