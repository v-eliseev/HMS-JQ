package hms.pages

import geb.Page

class LoginPage extends Page {

	static url = "http://localhost:9090/HMS-JQ/login/auth"

	static at = {
		title ==~ /.*Login/
	}

	static content = {
		userName { $("input", name : "j_username") }
    	password { $("input", name : "j_password") }
		loginButton() { $("input", value: "Login") }
		// deleteButton(to: ListPage) { $("input", value: "Delete") }
	}

}