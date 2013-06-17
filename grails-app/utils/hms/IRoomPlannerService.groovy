package hms

interface IRoomPlannerService {
	
	def convertData(def roomCategories, def rooms, def reservations, def roomAssignments)
	def callPlanner(def dtoRoomCategories, def dtoRooms, def dtoReservations, def roomAssignments)
	def convertResponse(def license, def dtoPlan)
}