package hms

import roomplanner.Plan
import roomplanner.RoomAssignment
import roomplanner.Score

import hms.dto.ReservationRequest
import roomplanner.api.Reservation as ReservationDto

import org.joda.time.Interval

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
			log.trace("Saved plan found")
		}
		else {
			currentPlan = createNewPlan(license)
		}
		currentPlan
	}

	def deleteSavedPlan(License license) {
		Plan plan = getSavedPlan(license)
		if (plan != null) {
			log.trace("Delete saved plan...")
			
			plan.delete()
			Hotel h = license.hotel
			license.hotel = null
			license.save()
			h.delete()

			license.hotel = DemoDataScript.generateRandomData(license)
			license.save()

			log.trace("...succeed")
		}
		plan = createNewPlan(license)
	}

	def createNewPlan(License license) {
		Plan plan = getSavedPlan(license)
		if (plan != null) {
			log.trace("Delete saved plan...")
			
			plan.delete()
		}

		def roomCategories = RoomCategory.getAllFor(license)
		def rooms = Room.getAllFor(license)
		def reservations = Reservation.getAllFor(license)
		def roomAssignments = []
		
		plan = callRoomPlanner(license, roomCategories, rooms, reservations, roomAssignments)
		plan.save()
		plan
	}

	/**
		Checks if reservation is feasible and returns RoomAssignment data, otherwise returns null
	*/
	def RoomAssignment checkReservation(License license, ReservationRequest reservationRequest) {

		def roomCategories = RoomCategory.getAllFor(license)
		def rooms = Room.getAllFor(license)
		def reservations = Reservation.getAllFor(license)
		def roomAssignments = []

		log.trace("Hotel data acquired...")
		log.trace("RoomCategories: " + roomCategories)
		log.trace("Rooms: " + rooms)
		log.trace("Reservations: " + reservations)

		def plan = callRoomPlanner(license, roomCategories, rooms, reservations, roomAssignments, reservationRequest)
		
		log.trace("RoomAssignments: $plan.roomAssignments")
		
		RoomAssignment roomAssignment = null
		if (plan.score.feasible) {
			roomAssignment = plan.roomAssignments.find { it.reservationId == -1 }
		
			log.trace("RoomAssignment found: $roomAssignment")
		}
		roomAssignment
	}


	/**
		Creates a new plan on given data
	*/
	protected Plan callRoomPlanner(License license, def roomCategories, def rooms, def reservations, def roomAssignments, def reservationRequest = null) {

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

		if (reservationRequest != null) {
			log.trace("Reservation to check: $reservationRequest")
            reservationsDto << new ReservationDto(
                id: -1,
                roomCategory: roomCategoriesDto.find { it.id == reservationRequest.roomCategory.id },
                adults: reservationRequest.adults,
                bookingInterval: new Interval(reservationRequest.fromDate.getTime(), reservationRequest.toDate.getTime())
            )
		}

		log.trace("Reservation to plan: $reservationsDto")

		def planDto = remoteService.callPlanner(roomCategoriesDto, roomsDto, reservationsDto, roomAssignmentsDto)
		
		Plan plan = remoteService.convertResponse(license, planDto)
		plan
	}
	
}