package roomplanner

class Pricelist implements Serializable {

	static mapping = {
		datasource 'plancache'
	} 

	long licenseId
	Date fromDate
	Date toDate

	Date dateCreated
	Date lastUpdated

	static hasMany = [items: PricelistItem]

    static constraints = {
    }
}
