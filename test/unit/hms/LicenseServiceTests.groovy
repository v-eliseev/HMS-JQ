package hms

import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(LicenseService)
@Mock(License)
class LicenseServiceTests {

	LicenseService service = new LicenseService()

	void testLicenseKeyGeneration() {
		LicenseService service = new LicenseService()
		boolean minDigit = false, maxDigit = false, minLetter = false, maxLetter = false
		while (!(minDigit && maxDigit && minLetter && maxLetter)) {
			def key = service.generateLicenseKey()
			if (!minDigit && key.contains(License.digits[0])) minDigit = true
			if (!maxDigit && key.contains(License.digits[License.digits.size()-1])) maxDigit = true
			if (!minLetter && key.contains(License.letters[0])) minLetter = true
			if (!maxLetter && key.contains(License.letters[License.letters.size()-1])) maxLetter = true
		}
	}

	void testLicenseUnique() {
		LicenseService service = new LicenseService()

		def final TRY_MAX = 3;

		long counter = 1
		while(true) {
			def tryCount = 0
			License license = null
			while (tryCount < TRY_MAX) {
				try {
					license = service.createDemoLicense()
				} catch (Exception e) {
					println "********" + counter
					tryCount++
				}
				break
			}
			if (!license)
				break

			if ((++counter % 10000) == 0)
				print '.'
		}
	}

	void testLicenseIsValid() {
		LicenseService service = new LicenseService()

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

		assert service.checkLicense(licenseOK) == true
		assert service.checkLicense(licenseExpired) == false
		assert service.checkLicense(licenseNotActive) == false
		assert service.checkLicense(licenseWrongKey) == false
	}
}
