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

class RoomPlannerSoapService implements IRoomPlannerService {

	// SOAP client
	def roomPlannerServiceClient


	/**
		Converts domain data to SOAP DTO
	*/
	def convertData(def roomCategories, def rooms, def reservations, def roomAssignments) {

		def roomCategoriesDto = roomCategories.collect { roomCategory ->
			new RoomCategoryDto(
				id: roomCategory.id
			)
		}
		log.debug("Room Categories: " + roomCategoriesDto)
		
		def roomsDto = rooms.collect { room ->
			new RoomDto(
				id: room.id,
				roomCategory: roomCategoriesDto.find { it.id == room.roomCategory.id },
				adults: room.adults
			)
		}
		log.debug("Rooms: " + roomsDto)
		
		def reservationsDto = reservations.collect { reservation ->
			new ReservationDto(
				id: reservation.id,
				roomCategory: roomCategoriesDto.find { it.id == reservation.roomCategory.id },
				adults: reservation.adults,
				bookingInterval: reservation.fromDate.getTime() + "-" + reservation.toDate.getTime()
			)
		}
		log.debug("Reservations: " + reservationsDto)
		
		def roomAssignmentsDto = roomAssignments.collect { roomAssignment ->
			new RoomAssignmentDto (
				id: roomAssignment.id,
				room: roomsDto.find { it.id == roomAssignment.room.id },
				reservation:  reservationsDto.find { it.id == roomAssignment.reservation.id },
				moveable: false
			)
		}

		[ roomCategoriesDto, roomsDto, reservationsDto, roomAssignmentsDto ]
	}

	/**
		Converts SOAP response to domain data
	*/
	def convertResponse(def license, def dtoPlan) {
		
		log.debug("dtoPlan:" + dtoPlan)

		Plan plan = new Plan()
		plan.licenseId = license.id
		plan.score = new Score(
			feasible: dtoPlan.score.feasible,
			hard: dtoPlan.score.hardScoreConstraints,
			soft: dtoPlan.score.softScoreConstraints
		)
		dtoPlan.roomAssignments.each {
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
	def callPlanner(def dtoRoomCategories, def dtoRooms, def dtoReservations, def dtoRoomAssignments) {
		def plan
		try {
			log.debug("RoomPlanner call..")
			plan = roomPlannerServiceClient.doPlan(dtoRooms, dtoRoomCategories, dtoReservations, dtoRoomAssignments)
			log.debug("...done")
		} 
		catch (SOAPFaultException se) {
			log.error("SOAPException calling RoomPlanner" + se.message)
			throw new Exception(se)
		}
		plan
	}
}
