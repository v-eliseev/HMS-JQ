package roomplanner

class Pricelist implements Serializable {

	static mapping = {
		datasource 'plancache'
	} 

	long licenseId
	Date dateFrom
	Date dateTo

	Date dateCreated
	Date lastUpdated

	static hasMany = [items: PricelistItem]

    static constraints = {
    }
}
