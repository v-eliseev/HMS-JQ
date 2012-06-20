package hms

class CancellationReason extends DomainBaseClass {

    static constraints = {
	}
	
	String name
	String shortDescription
	String description
}