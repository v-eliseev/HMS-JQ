package hms

import hms.util.Configuration

class ConfigurationService {

    def getValue(def user, def key, def defaultValue = 0) {
    	if (!user) { throw new IllegalArgumentException("No user given") }
    	if (!key)  { throw new IllegalArgumentException("No key given") }

    	def result = Configuration.findByUserAndKey(user, key)
    	if (!result) {
    		result = defaultValue
    	}
    	result
    }

    def setValue(def user, def key, def value) {
    	if (!user) { throw new IllegalArgumentException("No user given") }
    	if (!key)  { throw new IllegalArgumentException("No key given") }

    	def result = Configuration.findByUserAndKey(user, key)
    	if (result) {
    		result.value = value
    	} else {
    		result = new Configuration(user: user, key: key, value: value)
    	}
    	result.save(flush:true)
    	result
    }
}
