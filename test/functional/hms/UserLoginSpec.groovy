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
            
            if (!licenseKeyInputDiv.displayed) {
                changeLicenseKey.click()
                waitFor {
                    licenseKeyInputDiv.displayed
                }
            }
            
            loginForm.j_licenseKey = "XXXXX-XXXXX-XXXXX-XXXXX-XXXXXX"
            loginButton.click()
 
        then:
        waitFor { at UserStartPage }
        // waitFor { at GoogleResultsPage }
 
        // and:
        // firstResultLink.text() == "Wikipedia"
 
        // when:
        // firstResultLink.click()
 
        // then:
        // waitFor { at WikipediaPage }
    }
}