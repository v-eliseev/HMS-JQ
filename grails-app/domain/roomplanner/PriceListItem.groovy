package roomplanner

class PriceListItem {

	Date moment
	BigDecimal rate

	RoomCategory roomCategory
	Room room

    static constraints = {
    	roomCategory nullable: true
    	room: nullable: true
    }
}
