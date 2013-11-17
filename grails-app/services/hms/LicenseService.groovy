package hms

import hms.auth.SecRole
import hms.auth.SecUser
import hms.auth.SecUserRole

import org.joda.time.DateTime
import org.joda.time.Period
import org.joda.time.format.ISOPeriodFormat
import org.joda.time.format.PeriodFormatter
import org.joda.time.format.ISODateTimeFormat
import org.joda.time.format.DateTimeFormatter

class LicenseService {

	def adminService

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

	def createLicense(def licenseType, def ownerName, def email) {
		def licenseInstance
		switch (licenseType) {
		case "DEMO" : 
			licenseInstance = createDemoLicense(email)
			SecRole adminRole = adminService.getAdminRole()
			SecUser adminUser = adminService.createUser("admin", "admin", email, licenseInstance, [adminRole])
			break

		case "PRODUCTION" : 
			licenseInstance = createStandardLicense(email)
			SecRole adminRole = adminService.getAdminRole()
			SecUser adminUser = adminService.createUser("admin", "admin", email, licenseInstance, [adminRole])
			break

		case "TEST" :
			licenseInstance = createTestLicense(email)
			SecRole adminRole = adminService.getAdminRole()
			SecUser adminUser = adminService.createUser("admin", "admin", email, licenseInstance, [adminRole])
			break

		default:
			log.error("Wrong license type")
			throw new IllegalArgumentException("Wrong license type")
		} 

		def owner = new Owner(
			name: ownerName,
			email: email
			)
		if (!owner.save(flush:true)) {
			owner.errors.each { log.error(it) }
			throw new Exception('License owner was not created')
		}

		licenseInstance.owner = owner
		if (!licenseInstance.save(flush:true)) {
			licenseInstance.errors.each { log.error(it) }
			throw new Exception('License owner was not created')
		}

		licenseInstance
	}

	// private
	def createDemoLicense(def email, String licenseKey = null) {
		Hotel h = DemoDataScript.generateRandomData()
		log.trace("Hotel with demo data created: " + h)
		DateTime now = new DateTime().withTimeAtStartOfDay()
		License newLicense = new License(
				key: licenseKey ? licenseKey : generateLicenseKey(),
				issued: now.toDate(),
				expires: now.plusMonths(1).toDate(),
				mode: License.LicenseMode.DEMO,
				email: email,
				hotel: h
				)
		if (!newLicense.save()) {
			newLicense.errors.each { log.error(it) }
			throw new Exception('License was not created')
		}
		log.trace("License created: " + newLicense)
		newLicense
	}

	// private 
	def createStandardLicense(def email) {
		Hotel h = new Hotel()
		DateTime now = new DateTime().withTimeAtStartOfDay()
		License newLicense = new License(
				key: generateLicenseKey(),
				issued: now.toDate(),
				expires: now.plusYears(1).toDate(),
				mode: License.LicenseMode.PRODUCTION,
				email: email,
				hotel: h
				)
		if (!newLicense.save()) {
			newLicense.errors.each { log.error(it) }
			throw new Exception('License was not created')
		}
		newLicense
	}

	def createTestLicense(def email) {
		createDemoLicense(email, "XXXXX-XXXXX-XXXXX-XXXXX-XXXXX")
	}

	def deleteLicense(def id) {
		def licenseInstance = License.get(id)
		licenseInstance.delete()
	}

	def disableLicense(def id) {
		def licenseInstance = License.get(id)
		licenseInstance.enabled = false
		licenseInstance.save(flush:true)
	}

	def enableLicense(def id) {
		def licenseInstance = License.get(id)
		licenseInstance.enabled = true
		licenseInstance.save(flush:true)
	}

	def getAllLicenses() {
		def list = License.findAll({})
		list
	}

	def getAllEnabledLicenses() {
		def list = License.findAll({ enabled == true })
		list
	}

	def getAllDisabledLicenses() {
		def list = License.findAll({ enabled == false })
		list
	}

	def changeEmail(String email, License license) {
		license.email = email
		license.save()
	}

	def prolongateLicense(def id, def iso8601PeriodOrDate) {
		def licenseInstance = License.get(id)

		def fromDate = new DateTime().withTimeAtStartOfDay()

		try {
			Period period = parseISOPeriod(iso8601PeriodOrDate)
			licenseInstance.expires = fromDate.plus(period).toDate()
		} 
		catch (Exception e1) {
			log.info("Period parse failed, try Date")
			try {
				DateTime dateTime = parseISODate(iso8601PeriodOrDate)
				licenseInstance.expires = dateTime.toDate()
			}
			catch (Exception e2) {
				log.error("License was not prolongated due to wrong data/period format")
				throw new IllegalArgumentException("License was not prolongated due to wrong data/period format")
			}
		}
		licenseInstance.save(flush:true)
	}

	def setProductionMode(def id) {
		def licenseInstance = License.get(id)

		licenseInstance.mode = License.LicenseMode.PRODUCTION
		licenseInstance.save(flush:true)
	}

	// private boolean checkUnique(key) {
	// 	def keys = License.findAllByKey(key)
	// 	return (keys == null || keys.isEmpty())
	// }

	private Period parseISOPeriod(String iso8601Period) {
    	Period result = null
    	PeriodFormatter formatter = ISOPeriodFormat.standard()

	    // Try the stadnard period format of the form
    	// The standard ISO format - PyYmMwWdDThHmMsS
    	try {
       		result = formatter.parsePeriod(iso8601Period)
    	}
    	catch(Exception e) {
			log.error("Wrong period [$iso8601Period]")
			throw new IllegalArgumentException("Wrong period [$iso8601Period]")
    	}
    	result
  	}

	private DateTime parseISODate(String iso8601Date) {
    	DateTime result = null
    	DateTimeFormatter formatter = ISODateTimeFormat.dateElementParser()

    	try {
       		result = formatter.parseDateTime(iso8601Date)
    	}
    	catch(Exception e) {
			log.error("Wrong date [$iso8601Date]")
			throw new IllegalArgumentException("Wrong date [$iso8601Date]")
    	}
    	result
  	}

	private def generateLetter() {
		int value = Math.ceil(Math.random() * License.letters.size())
		License.letters[value-1]
	}

	private def generateDigit() {
		int value = Math.ceil(Math.random() * License.digits.size())
		License.digits[value-1]
	}

}
