package roomplanner

class PricelistItem {

	static mapping = {
		datasource 'plancache'
	} 

	Date moment
	BigDecimal rate

	RoomCategory roomCategory
	Room room

    static constraints = {
    	roomCategory nullable: true
    	room nullable: true
    }
}
