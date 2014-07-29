package hms

import geb.spock.GebSpec

import hms.pages.*
 
class AdminLoginSpec extends GebSpec {
 
    def "Show login page"() {
        given:
        via RootPage
 
        expect:
        at LoginPage
 
        when:
            loginForm.j_username = "admin"
            loginForm.j_password = "admin"

            if (!licenseKeyInputDiv.displayed) {
                changeLicenseKey.click()
                waitFor {
                    licenseKeyInputDiv.displayed
                }
            }
            loginForm.j_licenseKey = "WR9WX-Q9CTF-2QFCY-YRY9V-PPHK6A"
            loginButton.click()
 
        then:
        at AdminStartPage
 
        // and:
        // firstResultLink.text() == "Wikipedia"
 
        // when:
        // firstResultLink.click()
 
        // then:
        // waitFor { at WikipediaPage }
    }
}