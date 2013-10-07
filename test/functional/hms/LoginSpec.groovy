package hms

import geb.spock.GebSpec

import hms.pages.*
 
class LoginSpec extends GebSpec {
 
    def "Show login page"() {
        given:
        via RootPage
 
        expect:
        at LoginPage
 
        // when:
        // search.field.value("wikipedia")
 
        // then:
        // waitFor { at GoogleResultsPage }
 
        // and:
        // firstResultLink.text() == "Wikipedia"
 
        // when:
        // firstResultLink.click()
 
        // then:
        // waitFor { at WikipediaPage }
    }
}