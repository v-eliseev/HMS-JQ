package hms

import grails.test.mixin.*
import spock.lang.*

import hms.auth.SecUser
import hms.auth.SecRole
import hms.auth.SecUserRole

import org.codehaus.groovy.grails.plugins.codecs.SHA1Codec
import org.codehaus.groovy.grails.plugins.codecs.HexCodec

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(LicenseService)
@Mock([License, Hotel, RoomCategory, Room, Reservation, ReservationStatus, SecUser, SecRole, SecUserRole])
class LicenseServiceSpec extends Specification {

	def licenseService

	def setup() {
		licenseService = new LicenseService()

		mockCodec SHA1Codec
		mockCodec HexCodec
		mockCodec Base32BytesCodec
	}

	def 'License Key must have all symbols and digits in range'() {

		// when:
		// 	boolean minDigit = false
		// 	boolean maxDigit = false
		// 	boolean minLetter = false
		// 	boolean  maxLetter = false
			
		// 	def counter = 0
		// 	def final MAX_COUNT = 100
		// 	while (!(minDigit && maxDigit && minLetter && maxLetter) && counter < MAX_COUNT) {
		// 		def key = licenseService.generateLicenseKey()
		// 		if (!minDigit && key.contains(License.digits[0])) { minDigit = true }
		// 		if (!maxDigit && key.contains(License.digits[License.digits.size()-1])) { maxDigit = true }
		// 		if (!minLetter && key.contains(License.letters[0])) { minLetter = true }
		// 		if (!maxLetter && key.contains(License.letters[License.letters.size()-1])) { maxLetter = true }
		// 	}

		// then:
		// 	minDigit
		// 	maxDigit
		// 	minLetter
		// 	maxLetter
	}
	
	// def 'Test if generated key is unique' () {

	// 	when:
	// 		def final TRY_MAX = 3
	// 		def counter = 1
	// 		while(true) {
	// 			def tryCount = 0
	// 			License license = null
	// 			while (tryCount < TRY_MAX) {
	// 				try {
	// 					license = service.createDemoLicense()
	// 				} catch (Exception e) {
	// 					println "********" + counter
	// 					tryCount++
	// 				}
	// 				break
	// 			}
	// 			if (!license)
	// 				break

	// 			if ((++counter % 10000) == 0)
	// 				print '.'
	// 		}

	// 	then:

	// }

	def 'Check licenses' () {
		given:
			def timestamp = System.currentTimeMillis()
			def keyData1 = [ownerName: "John Dow", ownerEmail: "john.dow@aa.cc", timestamp: timestamp]
			def keyData2 = [ownerName: "John Dow", ownerEmail: "john.dow@aa.cc", timestamp: timestamp+1]
			def keyData3 = [ownerName: "John Dow", ownerEmail: "john.dow@aa.cc", timestamp: timestamp+2]

		when:
			License licenseOK = new License(
					key: licenseService.generateLicenseKey(keyData1),
					issued: new Date(),
					expires: new Date() + 30,
					mode: License.LicenseMode.DEMO
					).save(flush:true)

			License licenseExpired = new License(
					key: licenseService.generateLicenseKey(keyData2),
					issued: new Date() - 40,
					expires: new Date() - 10,
					mode: License.LicenseMode.DEMO
					).save(flush:true)

			License licenseNotActive = new License(
					key: licenseService.generateLicenseKey(keyData3),
					issued: new Date() + 10,
					expires: new Date() + 40,
					mode: License.LicenseMode.DEMO
					).save(flush:true)

			License licenseWrongKey = new License(
					key: "This is a wrong key format",
					issued: new Date(),
					expires: new Date() + 30,
					mode: License.LicenseMode.DEMO
					).save(flush:true)

		then:
			licenseService.checkLicense(licenseOK) == true
			licenseService.checkLicense(licenseExpired) == false
			licenseService.checkLicense(licenseNotActive) == false
			licenseService.checkLicense(licenseWrongKey) == false

		cleanup:
			licenseOK.delete(flush:true)
			licenseExpired.delete(flush:true)
			licenseNotActive.delete(flush:true)
			licenseWrongKey.delete(flush:true)
	}

	def 'Check demo license creation' () {
		when:
			def license = licenseService.createDemoLicense("Vladislav Eliseev", "aa@bb.cc")

		then:
			license != null

		cleanup:
			license.delete(flush:true)
	}

	def 'Check hotel creation within demo license' () {
		given:
			def hotelCountBefore = Hotel.list().size()

		when:
			def license = licenseService.createDemoLicense("Vladislav Eliseev", "aa@bb.cc")

		then:
			license != null
			Hotel.list().size() == hotelCountBefore + 1
	}

	def 'Check predefined demo license creation' () {
		given:
			def licenseKey = "XXXXX-XXXXX-XXXXX-XXXXX-XXXXXX"

		when:
			def license = licenseService.createDemoLicense("Vladislav Eliseev", "aa@bb.cc", licenseKey)

		then:
			license != null
			license.key == licenseKey

		cleanup:
			license.delete(flush:true)
	}

	def 'Check production license creation' () {
		when:
			def license = licenseService.createStandardLicense("Vladislav Eliseev", "aa@bb.cc")

		then:
			license != null

		cleanup:
			license.delete(flush:true)
	}

	def 'Check license disabling' () {
		given:
			def license = licenseService.createStandardLicense("Vladislav Eliseev", "aa@bb.cc")
			assert license.enabled == true
		
		when:
			licenseService.disableLicense(license.id)

		then:
			license.enabled == false
	}

	def 'Check license prolongation via date' () {
		given:
			def license = licenseService.createStandardLicense("Vladislav Eliseev", "aa@bb.cc")
			def expires = license.expires
		
		when:
			licenseService.prolongateLicense(license.id, "2013-12-31")

		then:
			license.expires
	}

	def 'Check license prolongation via period' () {
		given:
			def license = licenseService.createStandardLicense("Vladislav Eliseev", "aa@bb.cc")
			def expires = license.expires
		
		when:
			licenseService.prolongateLicense(license.id, "P1M")

		then:
			license.expires
	}

	def 'Check license prolongation wrong format exception' () {
		given:
			def license = licenseService.createStandardLicense("Vladislav Eliseev", "aa@bb.cc")
		
		when:
			licenseService.prolongateLicense(license.id, "XXXX")

		then:
			thrown IllegalArgumentException

		when:
			licenseService.prolongateLicense(license.id, null)

		then:
			thrown IllegalArgumentException

		cleanup:
			license.delete(flush:true)
	}

	def 'Check license set production mode' () {
		given:
			def license = licenseService.createDemoLicense("Vladislav Eliseev", "aa@bb.cc")
			assert license.mode == License.LicenseMode.DEMO 
		when:
			licenseService.setProductionMode(license.id)

		then:
			license.mode == License.LicenseMode.PRODUCTION
	}

}
