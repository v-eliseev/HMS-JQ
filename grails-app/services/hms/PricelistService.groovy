package hms

import grails.transaction.Transactional

import roomplanner.Pricelist
import roomplanner.PricelistItem
import roomplanner.DateTimeRange

import org.joda.time.DateTime

@Transactional
class PricelistService {

	def reservationService

	def getPricelist(def license) {
		def pricelist = getSavedPricelist(license)
		if (pricelist == null) {
			log.trace("Building new pricelist...")
			pricelist = buildPricelist(license)
		}
		pricelist
	}

	def rebuildPricelist(def license) {
		def pricelist = getSavedPricelist(license)
		if (pricelist != null) {
			log.trace("Delete saved pricelist...")
			pricelist.delete()
		}
		buildPricelist(license)
	}

	private def getSavedPricelist(def license) {
		Pricelist.findByLicenseId(license.id)
	}	

    private def buildPricelist(def license) {

		def fromDate = new Date(reservationService.getFirstReservation(license).fromDate.getTime())
    	def toDate = new Date(reservationService.getLastReservation(license).toDate.getTime())

    	def pricelist = new Pricelist(
    		licenseId: license.id,
    		fromDate: fromDate,
    		toDate: toDate
    	)

    	log.debug("Building pricelist from [$fromDate] to [$toDate]...")

		Iterator<DateTime> iterator = new DateTimeRange(
											new DateTime(fromDate.getTime()), 
											new DateTime(toDate.getTime()))
										.iterator()
		while (iterator.hasNext()) {
			DateTime date = iterator.next()

    		def rooms = Room.getAllFor(license)

    		log.debug("Date: $date; Rooms: $rooms")

    		rooms.each { room ->
				def item = new PricelistItem(
    				onDate: new Date(date.getMillis()),
    				roomId: room.id,
    				rate: 45g  // TODO change
    			)
				pricelist.addToItems(item)
    		}
    	}
    	if (!pricelist.save(flush:true)) {
    		log.error("Error generating pricelist: $pricelist")
    		throw new Exception("Error generating pricelist")
    	}
    	log.debug("...Done")
    	pricelist
	}
}
