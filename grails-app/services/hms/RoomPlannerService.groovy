package hms

import roomplanner.Plan
import roomplanner.RoomAssignment
import roomplanner.Score
import ws.roomplanner.Reservation as ReservationDto
import ws.roomplanner.Room as RoomDto
import ws.roomplanner.RoomCategory as RoomCategoryDto
import ws.roomplanner.RoomAssignment as RoomAssignmentDto
import ws.roomplanner.Plan as PlanDto


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
			currentPlan.save(flush: true)
		}
		currentPlan
	}

	def deleteSavedPlan(License license) {
		Plan plan = getSavedPlan(license)
		if (plan != null) {
			plan.delete(flush: true)
			Hotel h = license.hotel
			license.hotel = null
			license.save(flush: true)
			h.delete(flush: true)

			license.hotel = DemoDataScript.generateRandomData(license)
			license.save(flush: true)

		}
		plan = createNewPlan(license)
		plan.save()

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
			
			log.trace("Hotel data acquired...")
			log.trace("RoomCategories: " + roomCategories)
			log.trace("Rooms: " + rooms)
			log.trace("Reservations: " + reservations)

			List<RoomCategoryDto> dtoRoomCategories = roomCategories.collect { roomCategory ->
				new RoomCategoryDto(
					id: roomCategory.id
				)
			}
			log.trace("Room Categories: " + dtoRoomCategories)
			
			List<RoomDto> dtoRooms = rooms.collect { room ->
				new RoomDto(
					id: room.id,
					roomCategory: dtoRoomCategories.find { it.id == room.roomCategory.id },
					adults: room.adults
				)
			}
			log.trace("Rooms: " + dtoRooms)
			
			List<ReservationDto> dtoReservations = reservations.collect { reservation ->
				new ReservationDto(
					id: reservation.id,
					roomCategory: dtoRoomCategories.find { it.id == reservation.roomCategory.id },
					adults: reservation.adults,
					bookingInterval: reservation.fromDate.getTime() + "-" + reservation.toDate.getTime()
				)
			}
			log.trace("Reservations: " + dtoReservations)
			
			List<RoomAssignmentDto> dtoRoomAssignments = []
			
			log.debug("RoomPlanner call..")
			planSoap = roomPlannerServiceClient.doPlan(dtoRooms, dtoRoomCategories, dtoReservations, dtoRoomAssignments)
			log.debug("...done")
		} catch (Exception e) {
			log.error("Error calling RoomPlanner", e)
		}

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
		plan
	}
}
