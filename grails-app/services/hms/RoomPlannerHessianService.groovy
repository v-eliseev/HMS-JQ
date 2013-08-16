package hms

import roomplanner.Plan
import roomplanner.RoomAssignment
import roomplanner.Score
import roomplanner.ConstraintMatch

import roomplanner.api.RoomCategory as RoomCategoryDto
import roomplanner.api.Room as RoomDto
import roomplanner.api.Reservation as ReservationDto
import roomplanner.api.RoomAssignment as RoomAssignmentDto
import roomplanner.api.Plan as PlanDto

import org.joda.time.Interval

class RoomPlannerHessianService implements IRoomPlannerService {

    def roomPlannerRemoteService

	def convertData(def roomCategories, def rooms, def reservations, def roomAssignments) {
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
        
        log.trace("Reservations: " + reservations)
        def reservationsDto = reservations.collect { reservation ->
            new ReservationDto(
                id: reservation.id,
                roomCategory: roomCategoriesDto.find { it.id == reservation.roomCategory.id },
                adults: reservation.adults,
                bookingInterval: new Interval(reservation.fromDate.getTime(), reservation.toDate.getTime())
            )
        }
        log.trace("ReservationsDto: " + reservationsDto)
        
        def roomAssignmentsDto = roomAssignments.collect { roomAssignment ->
            new RoomAssignmentDto (
                id: roomAssignment.id,
                room: roomsDto.find { it.id == roomAssignment.room.id },
                reservation:  reservationsDto.find { it.id == roomAssignment.reservation.id },
                moveable: false
            )
        }
        log.trace("RoomAssignments: " + roomAssignmentsDto)

        [ roomCategoriesDto, roomsDto, reservationsDto, roomAssignmentsDto ]

	}

	def callPlanner(def roomCategoriesDto, def roomsDto, def reservationsDto, def roomAssignmentsDto) {
        def plan
        try {
            log.trace("RoomPlanner call..")
            plan = roomPlannerRemoteService.doPlan(roomCategoriesDto, roomsDto, reservationsDto, roomAssignmentsDto)
            log.trace("...done")
        } 
        catch (Exception e) {
            log.error("Exception calling RoomPlanner" + e.message)
            throw new Exception(e)
        }
        plan
	}

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
}
