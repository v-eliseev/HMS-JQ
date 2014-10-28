package hms

import grails.test.mixin.*
import spock.lang.*

import filters.RenderingFilters

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(TestController)
@Mock(RenderingFilters)
class TestControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    def "Test rendering filters"() {
    	when:
        withFilters(action:"index") {
            controller.index()
        }

        then:
        response.redirectedUrl == result

        where:
        role    || mobile || result
        'admin' || true   || '/admin'
        'user'  || true   || '/user'
        'admin' || false  || '/admin'
        'user'  || false  || '/user'
    }
}
