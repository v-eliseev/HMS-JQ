package hms

import grails.test.mixin.*
import spock.lang.*

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(LicenseService)
@Mock(License)
class LicenseServiceSpec {

	def licenseService

	def 'License Key must have all symbols and digits in range'() {

		when:
			boolean minDigit = false, maxDigit = false, minLetter = false, maxLetter = false
			def counter = 0
			def final MAX_COUNT = 100
			while (!(minDigit && maxDigit && minLetter && maxLetter) && counter < MAX_COUNT) {
				def key = licenseService.generateLicenseKey()
				if (!minDigit && key.contains(License.digits[0])) minDigit = true
				if (!maxDigit && key.contains(License.digits[License.digits.size()-1])) maxDigit = true
				if (!minLetter && key.contains(License.letters[0])) minLetter = true
				if (!maxLetter && key.contains(License.letters[License.letters.size()-1])) maxLetter = true
			}

		then:
			minDigit
			maxDigit
			minLetter
			maxLetter
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

		when:
			License licenseOK = new License(
					key: service.generateLicenseKey(),
					issued: new Date(),
					expires: new Date() + 30,
					demoMode: true
					).save()

			License licenseExpired = new License(
					key: service.generateLicenseKey(),
					issued: new Date() - 40,
					expires: new Date() - 10,
					demoMode: true
					).save()

			License licenseNotActive = new License(
					key: service.generateLicenseKey(),
					issued: new Date() + 10,
					expires: new Date() + 40,
					demoMode: true
					).save()

			License licenseWrongKey = new License(
					key: "This is a wrong key format",
					issued: new Date(),
					expires: new Date() + 30,
					demoMode: true
					).save()

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
}
