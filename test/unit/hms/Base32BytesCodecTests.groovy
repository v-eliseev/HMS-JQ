package hms

import org.junit.*
import grails.test.mixin.*
import grails.test.GrailsUnitTestCase

import org.joda.time.DateTime
import org.codehaus.groovy.grails.plugins.codecs.SHA1Codec
import org.codehaus.groovy.grails.plugins.codecs.HexCodec

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
class Base32BytesCodecTests extends GrailsUnitTestCase {

	@Before
	protected void setUp() {
		super.setUp()
		loadCodec SHA1Codec
		loadCodec HexCodec
		loadCodec Base32BytesCodec
	}

	void testCodec() {
		def source = 'Vladislav Eliseev|v-eliseev@yandex.ru|' + new DateTime()
		def shaCode = source.encodeAsSHA1()
		def shortCode = shaCode.substring(0,32)
		def licenseKey = shortCode.decodeHex().encodeAsBase32Bytes()
		println licenseKey
		def restoredCode = licenseKey.decodeBase32Bytes().encodeAsHex()

		assert restoredCode == shortCode
	}
}