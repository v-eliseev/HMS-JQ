package hms.jq

class CustomTagLib {

	static namespace = "hms"

	/**
		<hms:booleanIcon value = "${userInstance.enabled}" inverse/>
	*/
	def booleanIcon = { attrs, body ->
		def colorCode = ""
		def iconCode = ""
		def iconColorCode = ""

		def value = attrs['value']
		// invert value if requested
		if (attrs['inverse']) {
			value = !value
		}
		
		if (value) {
			colorCode = "badge-success"
			iconCode = "icon-ok"
			iconColorCode = "icon-white"
		}  
		else {
			colorCode = "badge-important"
			iconCode = "icon-remove"
			iconColorCode = "icon-white"
		}

		out << "<span class=\"badge " + colorCode + "\"><i class=\"" + iconCode + " " + iconColorCode + "\"></i></span>"
	}

}
