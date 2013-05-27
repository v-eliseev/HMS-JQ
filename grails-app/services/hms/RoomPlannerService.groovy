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

	def roomPlannerServiceClient
	
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
			
			plan.delete(flush: true)
			Hotel h = license.hotel
			license.hotel = null
			license.save(flush: true)
			h.delete(flush: true)

			license.hotel = DemoDataScript.generateRandomData(license)
			license.save(flush: true)

			log.debug("...succeed")
		}
		plan = createNewPlan(license)
	}

	protected Plan createNewPlan(License license) {
		PlanDto planSoap = null
		
		// if (roomPlannerServiceClient == null) {
		// 	log.debug("Client is null")
		// 	throw new Exception("Client is null")
		// }
		// else {
		// 	log.debug("Client is OK")
		// }

		try {

			def roomCategories = RoomCategory.getAllFor(license)
			def rooms = Room.getAllFor(license)
			def reservations = Reservation.getAllFor(license)
			def roomAssignments = []
			
			log.debug("Hotel data acquired...")
			log.debug("RoomCategories: " + roomCategories)
			log.debug("Rooms: " + rooms)
			log.debug("Reservations: " + reservations)

			List<RoomCategoryDto> dtoRoomCategories = roomCategories.collect { roomCategory ->
				new RoomCategoryDto(
					id: roomCategory.id
				)
			}
			log.debug("Room Categories: " + dtoRoomCategories)
			
			List<RoomDto> dtoRooms = rooms.collect { room ->
				new RoomDto(
					id: room.id,
					roomCategory: dtoRoomCategories.find { it.id == room.roomCategory.id },
					adults: room.adults
				)
			}
			log.debug("Rooms: " + dtoRooms)
			
			List<ReservationDto> dtoReservations = reservations.collect { reservation ->
				new ReservationDto(
					id: reservation.id,
					roomCategory: dtoRoomCategories.find { it.id == reservation.roomCategory.id },
					adults: reservation.adults,
					bookingInterval: reservation.fromDate.getTime() + "-" + reservation.toDate.getTime()
				)
			}
			log.debug("Reservations: " + dtoReservations)
			
			List<RoomAssignmentDto> dtoRoomAssignments = []
			
			log.debug("RoomPlanner call..")
			planSoap = roomPlannerServiceClient.doPlan(dtoRooms, dtoRoomCategories, dtoReservations, dtoRoomAssignments)
			log.debug("...done")
		} catch (SOAPFaultException e) {
			log.error("Error calling RoomPlanner" + e.message)
		}

		log.debug("PlanSOAP:" + planSoap)

		Plan plan = new Plan()
		plan.licenseId = license.id
		plan.score = new Score(
			feasible: planSoap.score.feasible,
			hard: planSoap.score.hardScoreConstraints,
			soft: planSoap.score.softScoreConstraints
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
		plan.save(flush: true)
		plan
	}
}
