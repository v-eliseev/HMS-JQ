package hms

import groovy.transform.ToString
import groovy.transform.EqualsAndHashCode

@ToString(includeNames = true, includeFields = true)
@EqualsAndHashCode
class ArticleGroup extends DomainBaseClass {

	String name

	static hasMany = [articles:Article]

    static constraints = {
		name(blank:false)
	}
}