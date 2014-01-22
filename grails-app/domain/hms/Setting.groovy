package hms

class Setting {

	String key
	String value

    static constraints = {
    	key unique: true
    	value nullable: true
    }

    static mapping = {
		datasource 'plancache'

		key column: '`KEY`'
		value column: '`VALUE`'
	}
}
