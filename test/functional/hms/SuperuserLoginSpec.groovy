package hms

import geb.spock.GebSpec

import hms.pages.*
 
class SuperuserLoginSpec extends GebSpec {
 
    def "Show superuser page"() {
        given:
        to SuperuserPage
 
        expect:
        at SuperuserPage
 
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

    def "Create demo license"() {
        given:
        to SuperuserPage

        expect:
        at SuperuserPage

        when:
        createLicenseForm.name = "Vladislav Eliseev"
        createLicenseForm.email = "v-eliseev@yandex.ru"
        submitButton.click()

        then:
        at LicensePage
    }
}