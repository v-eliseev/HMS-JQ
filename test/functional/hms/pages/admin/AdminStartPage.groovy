package hms.pages

import geb.Page

class AdminStartPage extends Page {

	static url = "http://localhost:9090/HMS-JQ/"

	static at = {
		title ==~ /.*Admin/
	}

	static content = {
	}

}