package hms

import grails.transaction.Transactional

import roomplanner.Pricelist
import roomplanner.PricelistItem

@Transactional
class PricelistService {

	def reservationService

	def getPricelist(def license) {

		def pricelist = Pricelist.findByLicenseId(license.id)
		if (pricelist != null) {
			log.trace("Delete saved pricelist...")
			pricelist.delete()
		}
		buildPricelist(license)
	}	

    def buildPricelist(def license) {

		def fromDate = reservationService.getFirstReservation(license).fromDate
    	def toDate = reservationService.getLastReservation(license).toDate

    	def pricelist = new Pricelist(
    		licenseId: license.id,
    		fromDate: fromDate,
    		toDate: toDate
    	)

    	log.debug("Building pricelist from [$fromDate] to [$toDate]...")

    	(fromDate..toDate).each { date ->
    		def rooms = Room.getAllFor(license)

    		log.debug("Rooms: $rooms")

    		rooms.each { room ->
				def item = new PricelistItem(
    				onDate: date,
    				roomId: room.id,
    				rate: 45g  // TODO change
    			)
				pricelist.addToItems(item)
    		}
    	}
    	pricelist.save(flush:true)
    	log.debug("...Done")
    	pricelist
	}
}
