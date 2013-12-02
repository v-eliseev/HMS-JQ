package hms

import grails.util.Holders

class RoomPlannerServiceFactory {

	static def getService() {

		def remoteService

		def ctx = Holders.grailsApplication.mainContext

		def mode = Holders.grailsApplication.config.service.roomplanner.mode
		switch (mode) {
			case "SOAP":
				remoteService = (hms.RoomPlannerSoapService) ctx.getBean('roomPlannerSoapService')
				break
			case "Hessian":
				remoteService = (hms.RoomPlannerHessianService) ctx.getBean('roomPlannerHessianService')
				break
			default:
				throw new Exception("Unsupported remote type: [${mode}]")
		}

		remoteService
	}
}