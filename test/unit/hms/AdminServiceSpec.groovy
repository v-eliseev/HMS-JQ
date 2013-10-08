package hms

import grails.test.mixin.*
import spock.lang.*

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(AdminService)
@Mock([Partner, SystemUser])
class AdminServiceSpec extends Specification {

	def adminService

	def setup() {
		adminService = new AdminService()
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

}
