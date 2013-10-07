package hms

import hms.auth.SecUserRole

class LicenseService {

	def generateLicenseKey() {

		def key = ""

		for (i in 1..5) {
			// Groups
			def digitPos = License.digitPosition[i-1]
			for (j in 1..5) { // Positions
				def nextValue = ((j == digitPos) ? generateDigit() : generateLetter())
				key = key + nextValue
			}
			if (i != 5) key = key + "-"
		}
		
		key
	}

	def checkLicense(License license) {

		// Key pattern
		def keyPattern = ""
		for (i in 1..5) {
			// Groups
			def digitPos = License.digitPosition[i-1]
			for (j in 1..5) { // Positions
				def nextValue = ((j == digitPos) ? "["+ License.digits + "]" : "["+ License.letters + "]")
				keyPattern = keyPattern + nextValue
			}
			if (i != 5) keyPattern = keyPattern + "-"
		}

		def today = new Date()
		def valid = (
				(license.expires >= today) &&
				(license.issued <= today) &&
				(license.key ==~ keyPattern)
				)

		valid
	}

	def createDemoLicense(String licenseKey = null) {
		Hotel h = DemoDataScript.generateRandomData()
		log.trace("Hotel with demo data created: " + h)
		License newLicense = new License(
				key: licenseKey ? licenseKey : generateLicenseKey(),
				issued: new Date(),
				expires: new Date() + 30,
				demoMode: true,
				email: "v-eliseev@yandex.ru",
				hotel: h
				)
		if (!newLicense.save()) {
			newLicense.errors.each { log.error(it) }
			throw new Exception('License was not created')
		}
		log.trace("License created: " + newLicense)
		newLicense
	}

	def createStandardLicense() {
		Hotel h = new Hotel()
		License newLicense = new License(
				key: generateLicenseKey(),
				issued: new Date(),
				expires: new Date() + 365,
				demoMode: false,
				email: "v-eliseev@yandex.ru",
				hotel: h
				)
		if (!newLicense.save()) {
			newLicense.errors.each { log.error(it) }
			throw new Exception('License was not created')
		}
		newLicense
	}

	def deleteLicense(id) {
		def licenseInstance = License.get(id)

		licenseInstance.users.each {
			SecUserRole.removeAll(it)
		}
			
		licenseInstance.delete()
	}

	def changeEmail(String email, License license) {
		license.email = email
		license.save()
	}

	// private boolean checkUnique(key) {
	// 	def keys = License.findAllByKey(key)
	// 	return (keys == null || keys.isEmpty())
	// }

	private def generateLetter() {
		int value = Math.ceil(Math.random() * License.letters.size())
		License.letters[value-1]
	}

	private def generateDigit() {
		int value = Math.ceil(Math.random() * License.digits.size())
		License.digits[value-1]
	}

}
