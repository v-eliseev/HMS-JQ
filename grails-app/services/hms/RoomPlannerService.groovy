package hms

import roomplanner.Plan
import roomplanner.RoomAssignment
import roomplanner.Score
import ws.roomplanner.Reservation as ReservationDto
import ws.roomplanner.Room as RoomDto
import ws.roomplanner.RoomCategory as RoomCategoryDto
import ws.roomplanner.RoomAssignment as RoomAssignmentDto
import ws.roomplanner.Plan as PlanDto

import javax.xml.ws.soap.SOAPFaultException


class RoomPlannerService {

	def grailsApplication

	// SOAP client
	def roomPlannerServiceClient
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
		
		createNewPlanSOAP(license, roomCategories, rooms, reservations, roomAssignments)
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

		Plan plan = createNewPlanSOAP(license, roomCategories, rooms, reservations, roomAssignments)
		RoomAssignment roomAssignment = null
		if (plan.feasible) {
			roomAssignment = plan.roomAssignments.find { it.reservationId == reservation.id }
		}
		roomAssignment
	}


	/**
		Creates a new plan on given data
	*/
	protected Plan createNewPlanSOAP(License license, def roomCategories, def rooms, def reservations, def roomAssignments) {

		List<RoomCategoryDto> dtoRoomCategories = []
		List<RoomDto> dtoRooms = []
		List<ReservationDto> dtoReservations = []
		List<RoomAssignmentDto> dtoRoomAssignments = []

		convertDataSOAP(
			roomCategories, rooms, reservations, roomAssignments,
			dtoRoomCategories, dtoRooms, dtoReservations, dtoRoomAssignments
		)
		PlanDto planDto = callPlannerSOAP(dtoRoomCategories, dtoRooms, dtoReservations, dtoRoomAssignments)
		Plan plan = convertResponseSOAP(license, planDto)
		plan
	}


	/**
		Converts domain data to SOAP DTO
	*/
	private convertDataSOAP(
		def roomCategories,
		def rooms,
		def reservations,
		def roomAssignments,
		List<RoomCategoryDto> dtoRoomCategories,
		List<RoomDto> dtoRooms,
		List<ReservationDto> dtoReservations,
		List<RoomAssignmentDto> dtoRoomAssignments
		) {

			dtoRoomCategories = roomCategories.collect { roomCategory ->
				new RoomCategoryDto(
					id: roomCategory.id
				)
			}
			log.debug("Room Categories: " + dtoRoomCategories)
			
			dtoRooms = rooms.collect { room ->
				new RoomDto(
					id: room.id,
					roomCategory: dtoRoomCategories.find { it.id == room.roomCategory.id },
					adults: room.adults
				)
			}
			log.debug("Rooms: " + dtoRooms)
			
			dtoReservations = reservations.collect { reservation ->
				new ReservationDto(
					id: reservation.id,
					roomCategory: dtoRoomCategories.find { it.id == reservation.roomCategory.id },
					adults: reservation.adults,
					bookingInterval: reservation.fromDate.getTime() + "-" + reservation.toDate.getTime()
				)
			}
			log.debug("Reservations: " + dtoReservations)
			
			dtoRoomAssignments = roomAssignments.collect { roomAssignment ->
				new RoomAssignmentDto (
					id: roomAssignment.id,
					room: dtoRooms.find { it.id == roomAssignment.room.id },
					reservation:  dtoReservations.find { it.id == roomAssignment.reservation.id },
					moveable: false
				)
			}
	}

	/**
		Converts SOAP response to domain data
	*/
	private Plan convertResponseSOAP(License lisense, PlanDto planDto) {
		
		log.debug("PlanDTO:" + planDto)

		Plan plan = new Plan()
		plan.licenseId = license.id
		plan.score = new Score(
			feasible: planDto.score.feasible,
			hard: planDto.score.hardScoreConstraints,
			soft: planDto.score.softScoreConstraints
		)
		planSoap.roomAssignments.each {
			plan.addToRoomAssignments(
					new RoomAssignment(
						roomId: it.room.id,
						reservationId: it.reservation.id,
						moveable: it.moveable
						).save()
					)
		}
		plan.save()
		plan

	}

	/**
		Calls the planner via SOAP
	*/
	private PlanDto callPlannerSOAP(
		List<RoomCategoryDto> dtoRoomCategories,
		List<RoomDto> dtoRooms,
		List<ReservationDto> dtoReservations,
		List<RoomAssignmentDto> dtoRoomAssignments
		) {
		try {
			log.debug("RoomPlanner call..")
			planSoap = roomPlannerServiceClient.doPlan(dtoRooms, dtoRoomCategories, dtoReservations, dtoRoomAssignments)
			log.debug("...done")
		} 
		catch (SOAPFaultException se) {
			log.error("SOAPException calling RoomPlanner" + se.message)
			throw new Exception(se)
		}
	}
}
