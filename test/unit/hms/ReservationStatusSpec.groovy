package hms

import grails.test.mixin.*
import spock.lang.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@Mock(ReservationStatus)
class ReservationStatusSpec extends Specification {

	def 'Check object creation with value'() {
		when:
			ReservationStatus rs = new ReservationStatus(code: ReservationStatus.StatusCode.PLANNED).save()
		then:
			ReservationStatus.list().size() == 1
			ReservationStatus.list()[0].code == ReservationStatus.StatusCode.PLANNED
		cleanup:
			rs.delete(flush:true)
	}

	def 'Check object creation with String'() {
		when:
			ReservationStatus rs = new ReservationStatus(code: "PLANNED").save()
		then:
			ReservationStatus.list().size() == 1
			ReservationStatus.list()[0].code == ReservationStatus.StatusCode.PLANNED
		cleanup:
			rs.delete(flush:true)
	}

	def 'Check object deleteion'() {
		given:
			ReservationStatus rs = new ReservationStatus(code: ReservationStatus.StatusCode.PLANNED).save()
			assert ReservationStatus.list().size() == 1
		when:
			rs.delete(flush:true)
		then:
			ReservationStatus.list().size() == 0
	}

}
