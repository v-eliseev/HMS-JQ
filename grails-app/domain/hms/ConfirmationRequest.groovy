package hms


class ConfirmationRequest extends DomainBaseClass {

	// enum RequestType {
	// 	ChangePassword(1),
	// 	ChangeEmail(2)

	// 	RequestType(int value) {this.value = value}	
 // 		private final int value
	// 	public int value() {return value}
	// }

	License license
	String uuid
	Date expires
	Integer type
	String data

	static belongsTo = License

    static constraints = {
    }
}
