package roomplanner

import hms.Reservation
import hms.Room
import hms.RoomCategory

import org.joda.time.DateTime
import org.joda.time.Interval
import org.joda.time.Duration

class PlanHelper {
	
	static List<Reservation> getReservation(DateTime forDate, Room room, List<RoomAssignment> inList) {
		def result = []
		
		def assignments = inList.findAll { it.roomId == room.id }
		
		assignments.each { assignment ->
			Reservation reservation = Reservation.findById(assignment.reservationId) 
			if (convertInterval(reservation.fromDate, reservation.toDate).contains(forDate)) {
				result << reservation
				//TODO handle multiple bookings
				//return
			}
		}	
		return result
	}

	static List<Reservation> getRoomAssignments(Room room, DateTime fromDate, DateTime toDate, List<RoomAssignment> inList) {

		def result = []

		def assignments = inList.findAll { it.roomId == room.id }

		Iterator<DateTime> iterator = new DateTimeRange(fromDate, toDate).iterator()
		while (iterator.hasNext()) {
			DateTime date = iterator.next()

			def ra = null
			assignments.each { assignment ->
				Reservation reservation = Reservation.findById(assignment.reservationId) 
				if (convertInterval(reservation.fromDate, reservation.toDate).contains(date)) {
					ra = reservation
					def days = new Duration(fromDate, toDate).toStandardDays().getDays() - 1 
					days.times() { 
						if (iterator.hasNext()) { iterator.next() } 
					}
				} 
			}
			result << ra
		}
		return result
	}
	
	static Map<RoomCategory, Integer> getAvailableRooms(Interval forInterval, List<Room> inList, List<RoomAssignment> inPlan) {
		def result = [:]
		
//		def rooms = inList.findAll { room ->
//			inPlan.findAll { assignment ->
//				assignment.room.id == room.id
//			}
//		} 
		
		return result
	}
	
	private static Interval convertInterval(String v) {
		int dashIndex = v.indexOf('-');
		long start = Long.valueOf(v.substring(0, dashIndex));
		long end = Long.valueOf(v.substring(dashIndex + 1));
		return new Interval(start, end);
	}
	
	private static Interval convertInterval(Date fromDate, Date toDate) {
		return new Interval(fromDate.getTime(), toDate.getTime())
	}

}
