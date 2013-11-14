package hms

import roomplanner.Plan
import roomplanner.RoomAssignment
import roomplanner.Score
import roomplanner.ConstraintMatch

import ws.roomplanner.Reservation as ReservationDto
import ws.roomplanner.Room as RoomDto
import ws.roomplanner.RoomCategory as RoomCategoryDto
import ws.roomplanner.RoomAssignment as RoomAssignmentDto
import ws.roomplanner.Plan as PlanDto
import ws.roomplanner.License as LicenseDto
import ws.roomplanner.Pricelist as PricelistDto
import ws.roomplanner.PricelistItem as PricelistItemDto

import javax.xml.ws.soap.SOAPFaultException

import org.joda.time.DateTime

class RoomPlannerSoapService implements IRoomPlannerService {

	// SOAP client
	def roomPlannerServiceClient


	/**
		Converts domain data to SOAP DTO
	*/
	def convertData(def license, def roomCategories, def rooms, def reservations, def roomAssignments, def pricelist) {

        def licenseDto = new LicenseDto(key: license.key)

		def roomCategoriesDto = roomCategories.collect { roomCategory ->
			new RoomCategoryDto(
				id: roomCategory.id
			)
		}
		log.trace("Room Categories: " + roomCategoriesDto)
		
		def roomsDto = rooms.collect { room ->
			new RoomDto(
				id: room.id,
				roomCategory: roomCategoriesDto.find { it.id == room.roomCategory.id },
				adults: room.adults
			)
		}
		log.trace("Rooms: " + roomsDto)
		
		def reservationsDto = reservations.collect { reservation ->
			new ReservationDto(
				id: reservation.id,
				roomCategory: roomCategoriesDto.find { it.id == reservation.roomCategory.id },
				adults: reservation.adults,
				bookingInterval: reservation.fromDate.getTime() + "-" + reservation.toDate.getTime()
			)
		}
		log.trace("Reservations: " + reservationsDto)
		
		def roomAssignmentsDto = roomAssignments.collect { roomAssignment ->
			new RoomAssignmentDto (
				id: roomAssignment.id,
				room: roomsDto.find { it.id == roomAssignment.room.id },
				reservation:  reservationsDto.find { it.id == roomAssignment.reservation.id },
				moveable: false
			)
		}
 		

 		log.debug("Pricelist: $pricelist")
 		def pricelistDto = new PricelistDto(
            licenseId: pricelist.licenseId,
            fromDate: new DateTime(pricelist.fromDate.getTime()),
            toDate: new DateTime(pricelist.toDate.getTime())
            )
        pricelist.items.each {
            def item = new PricelistItemDto(
                onDate: new DateTime(it.onDate.getTime()),
                roomId: it.roomId,
                rate: it.rate
                )
            //log.debug("  Item: $item")
            pricelistDto.items.add(item)
        }

		[ licenseDto, roomCategoriesDto, roomsDto, reservationsDto, roomAssignmentsDto, pricelistDto ]
	}

	/**
		Converts SOAP response to domain data
	*/
	def convertResponse(def license, def dtoPlan) {
        log.trace("dtoPlan:" + dtoPlan)

        Plan plan = new Plan()
        plan.licenseId = license.id
        plan.score = new Score(
            feasible: dtoPlan.score.feasible,
            hard: dtoPlan.score.hardScoreConstraints,
            soft: dtoPlan.score.softScoreConstraints
        )

        dtoPlan.roomAssignments.each {
            log.trace("dtoRoomAssignment: [id: $it.id, roomId: $it.room.id, reservationId: $it.reservation.id, moveable: $it.moveable]")
            def ra = new RoomAssignment(
                        roomId: it.room.id,
                        reservationId: it.reservation.id,
                        moveable: it.moveable
                        )
            log.trace("RoomAssignment: [roomId: $ra.roomId, reservationId: $ra.reservationId, moveable: $ra.moveable]")
            plan.addToRoomAssignments(ra)
        }

        dtoPlan.score.scoreDetails.each { scoreDetail ->
            log.trace("ScoreDetail: [constraintName: $scoreDetail.constraintName, roomAssignments: $scoreDetail.roomAssignments, weight: $scoreDetail.weight")
            def c = new ConstraintMatch(
                rule: scoreDetail.constraintName,
                roomAssignment: plan.roomAssignments.find { it.reservationId == scoreDetail.roomAssignments[0].reservation.id },
                weight: scoreDetail.weight
                )
            log.trace("Constraint: [rule: \"$c.rule\", roomAssignment: $c.roomAssignment, weight: $c.weight]")
            plan.addToConstraintMatches(c)
        }

        plan
	}

	/**
		Calls the planner via SOAP
	*/
	def callPlanner(def license, def dtoRoomCategories, def dtoRooms, def dtoReservations, def dtoRoomAssignments, def dtoPricelist) {
		def plan
		try {
			log.trace("RoomPlanner call..")
			plan = roomPlannerServiceClient.doPlan(license, dtoRooms, dtoRoomCategories, dtoReservations, dtoRoomAssignments, dtoPricelist)
			log.trace("...done")
		} 
		catch (SOAPFaultException se) {
			log.error("SOAPException calling RoomPlanner" + se.message)
			throw new Exception(se)
		}
		plan
	}
}
