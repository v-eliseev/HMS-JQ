package hms

class ArticlePackage extends DomainBaseClass {

	String number
	String name
	String description
	ArticleGroup articleGroup
	Boolean isBookableOnline = true

	static hasMany = [articles:Article]

    static constraints = {
		number(blank:false)
		name(blank:false)
		description(nullable:true)
		articleGroup()
		isBookableOnline()
	}
}