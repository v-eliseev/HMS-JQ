package roomplanner

class PricelistItem implements Serializable {

	static mapping = {
		datasource 'plancache'
	} 

	Pricelist pricelist
	static belongsTo = [pricelist:Pricelist]

	Date onDate
	BigDecimal rate
	long roomId

    static constraints = {
    }
}

