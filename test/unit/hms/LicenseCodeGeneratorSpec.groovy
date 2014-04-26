package hms

import grails.test.mixin.*
import grails.test.mixin.support.*
import spock.lang.*

import org.codehaus.groovy.grails.plugins.codecs.SHA1Codec
import org.codehaus.groovy.grails.plugins.codecs.HexCodec

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestMixin(GrailsUnitTestMixin)
class LicenseCodeGeneratorSpec extends Specification {

	def licenseService

	def setup() {
		licenseService = new LicenseService()

		mockCodec SHA1Codec
		mockCodec HexCodec
		mockCodec Base32BytesCodec
	}

	def 'test license code generation' () {
		given: 
			def source = 'Vladislav Eliseev|v-eliseev@yandex.ru|' + System.currentTimeMillis()

		when:			
			def shaCode = source.encodeAsSHA1()
			def shortCode = shaCode.substring(0,32)
			def licenseKey = shortCode.decodeHex().encodeAsBase32Bytes()
		then:
			def restoredCode = licenseKey.decodeBase32Bytes().encodeAsHex()
			restoredCode == shortCode
	}

	def 'test generating license code' () {
		given:
			def source = [
				ownerName: "Vladislav Eliseev",
				ownerEmail: "v-eliseev@yandex.ru",
				timestamp: System.currentTimeMillis()
			]

		when:
			def licenseKey = licenseService.generateLicenseKey(source)

		then:
			licenseKey != null
	}

	def 'test empty ownerName' () {
		given:
			def source = [
				ownerEmail: "v-eliseev@yandex.ru",
				timestamp: System.currentTimeMillis()
			]

		when:
			licenseService.generateLicenseKey(source)

		then:
			thrown IllegalArgumentException
	}

	def 'test empty email' () {
		given:
			def source = [
				ownerName: "Vladislav Eliseev",
				timestamp: System.currentTimeMillis()
			]

		when:
			licenseService.generateLicenseKey(source)

		then:
			thrown IllegalArgumentException
	}
	
	def 'test empty timestamp' () {
		given:
			def source = [
				ownerName: "Vladislav Eliseev",
				email: "v-eliseev@yandex.ru"
			]

		when:
			licenseService.generateLicenseKey(source)

		then:
			thrown IllegalArgumentException
	}

}
