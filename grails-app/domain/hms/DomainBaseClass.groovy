package hms

abstract class DomainBaseClass implements java.io.Serializable {
	
	Date dateCreated
	Date lastUpdated

	static mapping = {
		tablePerHierarchy false
	}
	static constraints = {
	}
}