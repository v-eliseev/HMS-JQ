package hms

import hms.auth.SecRole
import hms.auth.SecUser

import org.joda.time.DateTime
import org.joda.time.Period
import org.joda.time.format.ISOPeriodFormat
import org.joda.time.format.PeriodFormatter
import org.joda.time.format.ISODateTimeFormat
import org.joda.time.format.DateTimeFormatter

class LicenseService {

	def adminService

	def generateLicenseKey(def keyData) {

		def name = keyData.ownerName
		def email = keyData.ownerEmail
		def timestamp = keyData.timestamp

		if (!name || !email || !timestamp) {
			log.error("Empty value for mandatory argument")
			throw new IllegalArgumentException("Empty value for mandatory argument")
		}

		def source = "$name|$email|$timestamp"

		log.debug("Creating license for [$source] ...")

		def licenseKeyRaw = source.encodeAsSHA1().substring(0,32).decodeHex().encodeAsBase32Bytes()

		log.trace("Raw key: $licenseKeyRaw")

		def licenseKey = 
			licenseKeyRaw.substring(0,5) + '-' +
			licenseKeyRaw.substring(5,10) + '-' +
			licenseKeyRaw.substring(10,15) + '-' +
			licenseKeyRaw.substring(15,20) + '-' +
			licenseKeyRaw.substring(20,26)

		log.debug("... done. Key: [$licenseKey]")

		licenseKey
	}

	def checkLicense(License license) {

		def base32Alphabet = "A-Z2-7"

		// Key pattern
		def keyPattern = "^[$base32Alphabet]{5}-[$base32Alphabet]{5}-[$base32Alphabet]{5}-[$base32Alphabet]{5}-[$base32Alphabet]{6}\$"

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
			licenseInstance = createDemoLicense(ownerName, email)
			SecRole adminRole = adminService.getAdminRole()
			SecUser adminUser = adminService.createUser("admin", "admin", email, licenseInstance, [adminRole])
			break

		case "PRODUCTION" : 
			licenseInstance = createStandardLicense(ownerName, email)
			SecRole adminRole = adminService.getAdminRole()
			SecUser adminUser = adminService.createUser("admin", "admin", email, licenseInstance, [adminRole])
			break

		case "TEST" :
			licenseInstance = createTestLicense(ownerName, email)
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
	def createDemoLicense(def ownerName, def ownerEmail, String licenseKey = null) {
		Hotel h = DemoDataScript.generateRandomData()
		log.trace("Hotel with demo data created: " + h)
		DateTime now = new DateTime().withTimeAtStartOfDay()
		def key = licenseKey ? licenseKey : generateLicenseKey([ownerName: ownerName, ownerEmail: ownerEmail, timestamp: System.currentTimeMillis()])
		License newLicense = new License(
				key: key,
				issued: now.toDate(),
				expires: now.plusMonths(1).toDate(),
				mode: License.LicenseMode.DEMO,
				email: ownerEmail,
				hotel: h
				)
		if (!newLicense.save(flush:true)) {
			newLicense.errors.each { log.error(it) }
			throw new Exception('License was not created')
		}
		log.trace("License created: " + newLicense)
		newLicense
	}

	// private 
	def createStandardLicense(def ownerName, def ownerEmail) {
		Hotel h = new Hotel()
		DateTime now = new DateTime().withTimeAtStartOfDay()
		def key = generateLicenseKey([ownerName: ownerName, ownerEmail: ownerEmail, timestamp: System.currentTimeMillis()])
		License newLicense = new License(
				key: key,
				issued: now.toDate(),
				expires: now.plusYears(1).toDate(),
				mode: License.LicenseMode.PRODUCTION,
				email: ownerEmail,
				hotel: h
				)
		if (!newLicense.save(flush:true)) {
			newLicense.errors.each { log.error(it) }
			throw new Exception('License was not created')
		}
		newLicense
	}

	def createTestLicense(def ownerName, def ownerEmail, String licenseKey = "XXXXX-XXXXX-XXXXX-XXXXX-XXXXXX") {
		createDemoLicense(ownerName, ownerEmail, licenseKey)
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
		license.save(flush:true)
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

}
