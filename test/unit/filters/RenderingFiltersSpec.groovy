package filters

import grails.test.mixin.*
import spock.lang.*

import hms.TestController
import hms.MobileService

@TestFor(TestController)
@Mock([RenderingFilters, MobileService])
class RenderingFiltersSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    def "Test rendering filters"() {
    	given:
    	defineBeans {
    		mobileService(MobileService)
    	}

    	when:
        withFilters(controller: "test", action:"index") {
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
