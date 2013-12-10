package hms

import grails.plugin.spock.IntegrationSpec

class RoomPlannerServiceFactorySpec extends IntegrationSpec {

	void 'Check service factory for roomPlanner' () {
		when:
			def service = RoomPlannerServiceFactory.getService()

		then:
			service != null
	}
}