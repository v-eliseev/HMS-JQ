package hms

class ArticleGroup extends DomainBaseClass {

	String name

	static hasMany = [articles:Article]

    static constraints = {
		name(blank:false)
	}
}