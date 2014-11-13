package hms

import roomplanner.Plan

class DashboardController extends BaseController {

	def hotelService
	def reservationService
	def roomPlannerService

    def index() { 
		License license = getLicense(request)
		def hotel = license.hotel
		def usersList = license.users
		def roomCategoryList = hotel.roomCategories
		def roomList = hotelService.listRooms(license)
		def reservationList = reservationService.getReservations(license, new Date()-6, new Date()+8)
		def checkinList = reservationService.getCheckins(license, new Date(), 5)
		def checkoutList = reservationService.getCheckouts(license, new Date(), 5)
		Plan plan = roomPlannerService.getCurrentPlan(license, false)

		[
			licenseInstance: license,
			hotelInstance: hotel,
			userInstanceList: usersList,
			hotelRoomCategoriesCount: roomCategoryList.size(),
			hotelRoomsCount: roomList.size(),
			roomCategoryInstanceList: roomCategoryList,
			reservationInstanceList: reservationList,
			todayCheckinList: checkinList,
			todayCheckoutList: checkoutList,
			score: plan?.score,
			plan: plan
		]
	
	}
}
