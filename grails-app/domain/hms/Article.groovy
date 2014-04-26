package hms

import groovy.transform.ToString
import groovy.transform.EqualsAndHashCode

@ToString(includeNames = true, includeFields = true)
@EqualsAndHashCode
class Article extends DomainBaseClass {

	String number
	String name
	String description
	ArticleGroup articleGroup
	Double price
	TaxCode taxCode
	Boolean isBookableOnline = true

	static constraints = {
		number(blank:false)
		name(blank:false)
		description(nullable:true)
		articleGroup(nullable:true)
		price()
		taxCode(nullable:true)
		isBookableOnline()
	}
}