package hms

import grails.test.mixin.*
import spock.lang.*

import hms.security.SystemUser
import hms.auth.SecUser
import hms.auth.SecRole
import hms.auth.SecUserRole

import org.codehaus.groovy.grails.plugins.codecs.SHA1Codec
import org.codehaus.groovy.grails.plugins.codecs.HexCodec

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(AdminService)
@Mock([SystemUser, License, SecUser, SecRole, SecUserRole, 
	Hotel, RoomCategory, Room, Reservation, ReservationStatus])
class AdminServiceSpec extends Specification {

	def adminService
	def licenseService

	def setup() {
		adminService = new AdminService()
		licenseService = new LicenseService()

		mockCodec SHA1Codec
		mockCodec HexCodec
		mockCodec Base32BytesCodec
	}

	def 'Check systemUser creation' () {
		when:
			assert adminService != null
			def su = adminService.createSystemUser("supervisor","password")
			assert su != null

		then:
			SystemUser.list().size() == 1

		cleanup:
			su.delete(flush:true)

	}

	def 'Check duplicate systemUser creation' () {
		given:
			assert adminService != null
			def su1 = adminService.createSystemUser("supervisor","password")
			assert su1 != null

		when:
			def su2 = adminService.createSystemUser("supervisor","password")

		then:
			Exception e = thrown()

		cleanup:
			su1.delete(flush:true)

	}

	def 'Demo license creation check' () {
		when:
			def demoLicense = licenseService.createDemoLicense("Vladislav Eliseev", "aa@bb.cc")
			def adminUser = adminService.createDemoUser(demoLicense)

		then:
			demoLicense != null
			adminService.checkUser("admin", "admin", demoLicense) == true
			adminUser.getAuthorities().size() == 1

		cleanup:
			demoLicense.delete(flush:true)
	}

}
