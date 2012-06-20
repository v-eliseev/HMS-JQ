package hms.jq

import hms.Customer

class CustomerController extends DomainObjectController {
	
	public CustomerController() {
		super(Customer.class)
	}
}
