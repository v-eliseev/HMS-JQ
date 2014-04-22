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
			iconCode = "fa fa-check"
		}  
		else {
			colorCode = "label-danger"
			iconCode = "fa fa-times"
		}

		out << "<span class=\"label " + colorCode + "\"><i class=\"" + iconCode + "\"></i></span>"
	}

}
