package hms

import grails.test.mixin.*
import spock.lang.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@Mock(ReservationStatus)
class ReservationStatusServiceSpec extends Specification {

	def reservationStatusService

	def setup() {
		reservationStatusService = new ReservationStatusService()
	}

	def 'Check getStatusPlanned' () {
		when:
			def rs = reservationStatusService.getStatusPlanned()
		then:
			ReservationStatus.list().size() == 1
		cleanup:
			rs.delete(flush:true)
	}
}
