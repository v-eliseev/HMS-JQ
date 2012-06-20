package hms.jq

import java.awt.event.ItemEvent;

import hms.Room
import hms.RoomCategory
import hms.ServiceFactory



class RoomController extends DomainObjectController {

	public RoomController() {
		super(Room.class)
	}

	def index = {
		def roomList = service.list()
		[dataList: roomList]
	}

	def add = {
		def roomCategoryService = ServiceFactory.getServiceFactory().getServiceByDomainClass(RoomCategory.class)
		def roomCategories = roomCategoryService?.list()
		[roomCategories: roomCategories]
	}

	def addRoom = {

		def listId = hyphen_range(params.name)
		def roomCategoryService = ServiceFactory.getServiceFactory().getServiceByDomainClass(RoomCategory.class)
		def roomCategory = roomCategoryService?.show(params.roomCategory)
		listId.each { itemId ->

			Room r = new Room(
					name: itemId,
					roomCategory: roomCategory,
					description: "",
					maxOccupants: 1
					)
			r.save()
		}
		redirect(action: "index")
	}

	def editRoom = {
		def roomCategoryService = ServiceFactory.getServiceFactory().getServiceByDomainClass(RoomCategory.class)
		def roomCategory = roomCategoryService?.show(params.roomCategory)
		def r = service.show(params.id)

		r.name = params.name
		r.roomCategory = roomCategory
		r.description = ""
		r.maxOccupants = 1

		r.save()
		redirect(action: "index")
	}

	def show = {
		def room = service.show(params.id)
		def roomCategoryService = ServiceFactory.getServiceFactory().getServiceByDomainClass(RoomCategory.class)
		def roomCategory = roomCategoryService?.show(room.roomCategory.id)
		[
					roomName: room.name,
					roomCategory: roomCategory.name
				]
	}

	def edit = {
		def roomCategoryService = ServiceFactory.getServiceFactory().getServiceByDomainClass(RoomCategory.class)
		def roomCategories = roomCategoryService?.list()
		def room = service.show(params.id)
		def roomCategory = roomCategoryService?.show(room.roomCategory.id)

		[
					roomId: room.id,
					roomName: room.name,
					roomCategory: roomCategory.id,
					roomCategories: roomCategories]
	}

	def delete = {
		def checkedList = []
		params.each { item->
			if (item.key.matches("^cb[0-9]+") && item.value.equals("on")) {
				checkedList.add(item.key.find("[0-9]+"))
			}
		}
		checkedList.each { item ->
			service.delete(item)			
		}
		redirect(action: "index")
	}
	
	private def hyphen_range = { str ->
		// Takes a range in form of "a-b" and generate a list of numbers between a and b inclusive.
		// Also accepts comma separated ranges like "a-b,c-d,f" will build a list which will include
		// Numbers from a to b, c to d and f

		def listId = []
		str.split(',').each { elem ->
			def val = elem.split('-')
			if (val.size() == 1) { // a number
				listId.add(val[0].trim())
			} else if (val.size() == 2) { // a range inclusive
				for (i in val[0].trim()..val[1].trim()) {
					listId.add(i)
				}
			}
			else {// more than one hyphen
				println('format error in %s' % val)
			}
		}
		listId.sort()
		listId
	}
}