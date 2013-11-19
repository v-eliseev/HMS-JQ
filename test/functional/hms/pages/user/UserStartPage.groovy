package hms.pages

import geb.Page

class UserStartPage extends Page {

	static url = "http://localhost:9090/HMS-JQ/"

	static at = {
		title ==~ /.*/   // TODO change
	}

	static content = {
	}

}