package hms

import geb.spock.GebSpec

import hms.pages.*
 
class SuperuserLoginSpec extends GebSpec {
 
    def "Show superuser page"() {
        given:
        to SuperuserPage
 
        // expect:
        // at LoginPage
 
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