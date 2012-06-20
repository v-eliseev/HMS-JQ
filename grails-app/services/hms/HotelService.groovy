package hms

import hms.CRUDService
import hms.Hotel

class HotelService extends CRUDService {

	def getDomainClass() {
		Hotel.class
	}
	
	def createHotel(String name, License license) {
		def newHotel = new Hotel(name: name, license: license)
		if (!newHotel.save()) {
			newHotel.errors.each { log.error(it) }
			throw Exception('Hotel was not created')
		}

		license.addToHotels(newHotel)
		license.save()
			
		newHotel
	}
	
	def list(License license) {
		Hotel.findByLicense(license)
	}

}
