package hms

import roomplanner.Plan
import roomplanner.RoomAssignment
import roomplanner.Score
import roomplanner.ConstraintMatch

import roomplanner.api.RoomCategory as RoomCategoryDto
import roomplanner.api.Room as RoomDto
import roomplanner.api.Reservation as ReservationDto
import roomplanner.api.RoomAssignment as RoomAssignmentDto
import roomplanner.api.License as LicenseDto
import roomplanner.api.Pricelist as PricelistDto
import roomplanner.api.PricelistItem as PricelistItemDto

import org.joda.time.Interval
import org.joda.time.DateTime

class RoomPlannerHessianService implements IRoomPlannerService {

    def roomPlannerRemoteService

	/**
        Converts domain data to service DTO
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

        def pricelistDto = new PricelistDto(
            licenseId: pricelist.licenseId,
            fromDate: new DateTime(pricelist.fromDate.getTime()),
            toDate: new DateTime(pricelist.toDate.getTime())
            )
        log.debug("PriceList: $pricelistDto")
        pricelist.items?.each {
            def item = new PricelistItemDto(
                onDate: new DateTime(it.onDate.getTime()),
                roomId: it.roomId,
                rate: it.rate
                )
            pricelistDto.items?.add(item)
        }

        [ licenseDto, roomCategoriesDto, roomsDto, reservationsDto, roomAssignmentsDto, pricelistDto ]
	}

    /**
        Calls the planner via Hessian
    */
	def callPlanner(def licenseDto, def roomCategoriesDto, def roomsDto, def reservationsDto, def roomAssignmentsDto, def pricelistDto) {
        def plan
        try {
            log.trace("RoomPlanner call..")
            plan = roomPlannerRemoteService.doPlan(licenseDto, roomCategoriesDto, roomsDto, reservationsDto, roomAssignmentsDto, pricelistDto)
            log.trace("...done")
        } 
        catch (Exception e) {
            log.error("Exception calling RoomPlanner" + e.message)
            throw new Exception(e)
        }
        plan
	}

    /**
        Calls status
    */
    def getStatus() {
        def status
        try {
            status = roomPlannerRemoteService.getStatus()
        }
        catch (Exception e) {
            log.error("Exception calling RoomPlanner" + e.message)
            throw new Exception(e)
        }
        status
    }

    /**
        Converts service response to domain data
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
}
