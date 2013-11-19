package hms.pages

import geb.Page

class LoginPage extends Page {

	static url = "http://localhost:9090/HMS-JQ/login/auth"

	static at = {
		title ==~ /.*Login/
	}

	static content = {
		loginForm { $("form#loginForm") }
		changeLicenseKey { $("a#changeLicenseKey") }
		loginButton() { $("button#submit") }
		licenseKeyInputDiv(required: false) { $("div#license_input") }
	}

}