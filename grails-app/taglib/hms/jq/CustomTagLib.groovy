package hms.jq

class CustomTagLib {

	static namespace = "hms"

	/**
	* <hms:booleanIcon value = "${userInstance.enabled}"/>
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
			colorCode = "label-success"
			iconCode = "icon-ok"
		}  
		else {
			colorCode = "label-danger"
			iconCode = "icon-remove"
		}

		out << "<span class=\"label " + colorCode + "\"><i class=\"" + iconCode + "\"></i></span>"
	}

}
