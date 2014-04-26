package xeger

import grails.test.mixin.*
import spock.lang.*

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
class XegerSpec extends Specification {

	void "Test generating string"() {
		given:
			String regex = "[ab]{4,6}c"
			Xeger generator = new Xeger(regex)

		when:
    		String result = generator.generate()

    	then:
    		result.matches(regex);
	}
}
