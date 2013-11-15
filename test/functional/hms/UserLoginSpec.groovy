package hms

import geb.spock.GebSpec

import hms.pages.*
 
class UserLoginSpec extends GebSpec {
 
    def "Show login page"() {
        given:
        via RootPage
 
        expect:
        at LoginPage
 
        when:
            loginForm.j_username = "user"
            loginForm.j_password = "test"
            //loginForm.j_licenseKey = ""
            loginButton.click()
 
        then:
        at UserStartPage
        // waitFor { at GoogleResultsPage }
 
        // and:
        // firstResultLink.text() == "Wikipedia"
 
        // when:
        // firstResultLink.click()
 
        // then:
        // waitFor { at WikipediaPage }
    }
}