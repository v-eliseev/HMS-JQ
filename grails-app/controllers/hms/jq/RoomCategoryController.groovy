package hms.jq

import grails.converters.JSON
import hms.Room
import hms.RoomCategory

class RoomCategoryController extends DomainObjectController {

	public RoomCategoryController() {
		super(RoomCategory.class)
	}

	def show = {
		def roomCategory = service.show(params.id)
		def roomFeatures = roomCategory.roomFeatures
		def rooms = Room.findByRoomCategory(roomCategory)

		[roomCategoryInstance: roomCategory, 
			roomFeatureInstanceList: roomFeatures, 
			roomInstanceList: rooms]
	}

	def editJSON = {
		def object = null
		def message = ""
		def state = "FAIL"
		def id

		// determine our action
		switch (params.oper) {
			case 'add':
			// add instruction sent
				object = new RoomCategory(params)
				if (! object.hasErrors() && object.save()) {
					message = "object Added"
					id = object.id
					state = "OK"
				} else {
					message = "Could Not Save Object"
				}

				break;
			case 'edit':
				object = service.update(params.id, params)
				if (object) {
					message = "Object Updated"
					id = object.id
					state = "OK"
				} else {
					message = "Could Not Update Customer"
				}
				break;
			case 'del':
				service.delete(params.id)
				message = "Object Deleted"
				state = "OK"
				break;
		}

		def response = [message:message,state:state,id:id]

		render response as JSON
	}
}
