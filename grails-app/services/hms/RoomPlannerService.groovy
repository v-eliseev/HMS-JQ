package hms

import roomplanner.Plan
import roomplanner.RoomAssignment
import roomplanner.Score

class RoomPlannerService {

	def grailsApplication

	def roomPlannerSoapService
	def roomPlannerHessianService

	def getSavedPlan(License license) {
		Plan.findByLicenseId(license.id)
	}

	def getCurrentPlan(License license) {
		Plan currentPlan = Plan.findByLicenseId(license.id)
		if (currentPlan) {
			log.debug("Saved plan found")
		}
		else {
			currentPlan = createNewPlan(license)
		}
		currentPlan
	}

	def deleteSavedPlan(License license) {
		Plan plan = getSavedPlan(license)
		if (plan != null) {
			log.debug("Delete saved plan...")
			
			plan.delete()
			Hotel h = license.hotel
			license.hotel = null
			license.save()
			h.delete()

			license.hotel = DemoDataScript.generateRandomData(license)
			license.save()

			log.debug("...succeed")
		}
		plan = createNewPlan(license)
	}

	def createNewPlan(License license) {
		def roomCategories = RoomCategory.getAllFor(license)
		def rooms = Room.getAllFor(license)
		def reservations = Reservation.getAllFor(license)
		def roomAssignments = []
		
		callRoomPlanner(license, roomCategories, rooms, reservations, roomAssignments)
	}

	/**
		Checks if reservation is feasible and returns RoomAssignment data, otherwise returns null
	*/
	def RoomAssignment checkReservation(License license, Reservation reservation) {

		def roomCategories = RoomCategory.getAllFor(license)
		def rooms = Room.getAllFor(license)
		def reservations = Reservation.getAllFor(license)
		def roomAssignments = []

		log.debug("Hotel data acquired...")
		log.debug("RoomCategories: " + roomCategories)
		log.debug("Rooms: " + rooms)
		log.debug("Reservations: " + reservations)

		reservations << reservation

		def plan = callRoomPlanner(license, roomCategories, rooms, reservations, roomAssignments)
		RoomAssignment roomAssignment = null
		if (plan.feasible) {
			roomAssignment = plan.roomAssignments.find { it.reservationId == reservation.id }
		}
		roomAssignment
	}


	/**
		Creates a new plan on given data
	*/
	protected Plan callRoomPlanner(License license, def roomCategories, def rooms, def reservations, def roomAssignments) {

		def remoteService = null

		def mode = grailsApplication.config.service.roomplanner.mode
		switch (mode) {
			case "SOAP":
				remoteService = roomPlannerSoapService
				break
			case "Hessian":
				remoteService = roomPlannerHessianService
				break
			default:
				throw new Exception("Unsupported remote type: [${mode}]")
		}


		def (roomCategoriesDto, roomsDto, reservationsDto, roomAssignmentsDto) = 
			remoteService.convertData(roomCategories, rooms, reservations, roomAssignments)

		def planDto = remoteService.callPlanner(roomCategoriesDto, roomsDto, reservationsDto, roomAssignmentsDto)
		
		Plan plan = remoteService.convertResponse(license, planDto)
		plan
	}
	
}