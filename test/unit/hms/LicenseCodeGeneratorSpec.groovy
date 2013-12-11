package hms

import grails.test.mixin.*
import grails.test.mixin.support.*
import spock.lang.*

import org.joda.time.DateTime
import org.codehaus.groovy.grails.plugins.codecs.SHA1Codec
import org.codehaus.groovy.grails.plugins.codecs.HexCodec

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestMixin(GrailsUnitTestMixin)
class LicenseCodeGeneratorSpec extends Specification {

	def 'test license code generation' () {
		mockCodec SHA1Codec
		mockCodec HexCodec
		mockCodec Base32BytesCodec

		def source = 'Vladislav Eliseev|v-eliseev@yandex.ru|' + new DateTime()
		def shaCode = source.encodeAsSHA1()
		def shortCode = shaCode.substring(0,32)
		def licenseKey = shortCode.decodeHex().encodeAsBase32Bytes()
		println licenseKey
		def restoredCode = licenseKey.decodeBase32Bytes().encodeAsHex()

		assert restoredCode == shortCode
	}
}
