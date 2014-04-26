package roomplanner

import groovy.transform.ToString
import groovy.transform.EqualsAndHashCode

@ToString(includeNames = true, includeFields = true)
@EqualsAndHashCode
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
