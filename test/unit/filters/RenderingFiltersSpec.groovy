package filters

import grails.test.mixin.*
import spock.lang.*

import hms.TestController
import hms.MobileService
import hms.LicenseService
import hms.AdminService
import hms.License
import hms.Hotel
import hms.RoomCategory
import hms.Room
import hms.Reservation
import hms.ReservationStatus
import hms.auth.SecRole
import hms.auth.SecUser
import hms.auth.SecUserRole

import org.codehaus.groovy.grails.plugins.codecs.SHA1Codec
import org.codehaus.groovy.grails.plugins.codecs.HexCodec
import hms.Base32BytesCodec

@TestFor(TestController)
@Mock([RenderingFilters, 
    MobileService, 
    SecUser, SecRole, SecUserRole, 
    License, Hotel, RoomCategory, Room, Reservation, ReservationStatus])
class RenderingFiltersSpec extends Specification {

    def licenseService
    def adminService
    def license
    def adminUser
    def userUser
    def springSecurityService

    // static loadExternalBeans = true
    // static doWithSpring = {
    //     wurflHolder(net.sourceforge.wurfl.core.GeneralWURFLEngine, "classpath:/wurfl/wurfl-latest.zip")
    // }

    def setup() {
        licenseService = new LicenseService()
        adminService = new AdminService()
        mockCodec SHA1Codec
        mockCodec HexCodec
        mockCodec Base32BytesCodec

        def roleAdmin = adminService.getAdminRole()
        def roleUser = adminService.getUserRole()
        license = licenseService.createDemoLicense("Vladislav Eliseev", "v-eliseev@yandex.ru")
        adminUser = adminService.createUser("admin","admin","admin@test.ts",license,[roleAdmin])
        userUser = adminService.createUser("user","user","user@test.ts",license,[roleUser])
    }

    def cleanup() {
    }

    def "Test rendering filters"() {
    	given:
    	defineBeans {
    		mobileService(MobileService) {
            }
    	}
        and: 'add mobile parameter'
        if (mobile) {
            request.setParameter('mobile', 'y')
        }
        and: 'add appropriate user'
        def user
        if (role != null) {
            switch (role) {
                case "admin":
                    user = adminUser
                    break
                case "user":
                    user = userUser
                    break
            }
        }
        //request.setParameter)

        when:
        withFilters(controller: "test", action:"index") {
            controller.index()
        }

        then:
        response.status == 200
        //view == "${result}/test/index"

        log.debug response

        where:
        role    || mobile || result
        null    || true   || '/mobile/superuser'
        'admin' || true   || '/mobile/admin'
        'user'  || true   || '/mobile/user'
        // null    || false  || '/superuser'
        // 'admin' || false  || '/admin'
        // 'user'  || false  || '/user'
    }
}
