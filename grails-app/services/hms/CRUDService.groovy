package hms

abstract class CRUDService {

    static transactional = true
	
	/**
	 * Returns a domain class
	 * @return
	 */
	abstract getDomainClass()
	
	
	/**
	 * Creates a new object
	 * @param obj
	 * @return
	 */
	def create(obj) {
		if(!obj.save(flush:true)) {
			obj.errors.each { log.error(it) }
		}
		obj
	}
	
	/**
	 * Updates given attributes of an object
	 * @param id
	 * @param params
	 * @return
	 */
	def update(id, params) {
		def obj = getDomainClass().get(id)
		if(obj) {
			obj.properties = params
			if(!obj.save(flush:true)) {
				obj.errors.each { log.error(it) }
			}
		}
		else {
			log.error("No object " + getDomainClass().name + "(" + id + ") found.")
		}
		obj
	}
	
	/**
	 * Updates the whole object
	 * @param obj
	 * @return
	 */
	def update(obj) {
		if(obj) {
			if(!obj.save(flush:true)) {
				obj.errors.each { log.error(it) }
			}
		}
		else {
			log.error("No object " + getDomainClass().name + "(" + id + ") found.")
		}
		obj
	}
	
	/**
	 * Deletes the object by given id
	 * @param id
	 * @return
	 */
	def delete(id) {
		def obj = getDomainClass().get(id)
		if(obj) {
			if(!obj.delete(flush:true)) {
				obj.errors.each { log.error(it) }
			}
		}
		else {
			log.error("No object " + getDomainClass().name + "(" + id + ") found.")
		}
	}
	
	/**
	 * Lists all objects
	 * @return
	 */
    def list() {
		getDomainClass().list()
    }
	
	/**
	 * Retrieves an object by id
	 * @param id
	 * @return
	 */
	def show(id) {
		getDomainClass().get(id)
	}
}
