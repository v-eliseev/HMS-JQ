package hms

interface IRoomPlannerService {
	
	def convertData(def license, def roomCategories, def rooms, def reservations, def roomAssignments, def pricelist)
	def callPlanner(def license, def dtoRoomCategories, def dtoRooms, def dtoReservations, def roomAssignments, def pricelist)
	def convertResponse(def license, def dtoPlan)
}