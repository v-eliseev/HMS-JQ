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

	def 'Check getStatusPlanned new' () {
		when:
			def rs = reservationStatusService.getStatusPlanned()

		then:
			ReservationStatus.list().size() == 1
			ReservationStatus.list()[0].code == ReservationStatus.StatusCode.PLANNED

		cleanup:
			rs.delete(flush:true)
	}

	def 'Check getStatusPlanned found' () {
		when:
			def rs1 = reservationStatusService.getStatusPlanned()
			def rs2 = reservationStatusService.getStatusPlanned()

		then:
			rs1.id == rs2.id
			ReservationStatus.list().size() == 1
			ReservationStatus.list()[0].code == ReservationStatus.StatusCode.PLANNED

		cleanup:
			rs1.delete(flush:true)
	}

}
