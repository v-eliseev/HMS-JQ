package hms.pages

import geb.Page

class SuperuserPage extends Page {

	static url = "http://superuser:password@localhost:9090/HMS-JQ/superuser"

	static at = {
		title ==~ /.*superuser.*/
	}

	static content = {
		createLicenseForm { $("form#createLicenseForm") }
		submitButton() { $("button#submit") }		
	}

}