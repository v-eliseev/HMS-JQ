package hms.util

class EventLogItem implements Serializable {
	
	Date timestamp
	Enum type
	String notes

    static constraints = {
    }
}
