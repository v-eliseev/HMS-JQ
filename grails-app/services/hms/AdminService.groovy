package hms

import hms.auth.CustomPasswordEncoder
import hms.auth.SecRole
import hms.auth.SecUser
import hms.auth.SecUserRole

import hms.security.SystemUser

class AdminService {

	def createUser(String username, String password, String email, License license, def roles) {

		if (roles == null || roles.size() == 0) {
			log.error("User must have at least one role")
			throw new IllegalArgumentException("User must have at least one role")
		}

		def hash = new CustomPasswordEncoder().encodePassword(password, license.key)
		log.trace("Create user: $username, password: $hash, email: $email, license: $license")
		def newUser = new SecUser(username: username, password: hash, email: email, license: license)
		if (!newUser.save(flush:true)) {
			log.trace("... Failed")
		 	throw new Exception('User was not created')
		}
		license.addToUsers(newUser)
		license.save()
		log.trace("... Successful")

		roles.each() {
			SecUserRole.create(newUser, it, true)
		}
			
		newUser
	}

	def checkUser(String username, String password, License license) {

		def hash = new CustomPasswordEncoder().encodePassword(password, license.key)
		def user = SecUser.findByUsernameAndPasswordAndLicense(username, hash, license)

		user != null
	}

	def getUser(def id) {
		SecUser.get(id)
	}
	
	def changePassword(String username, String currentPassword, String newPassword, License license) {

		def hash = new CustomPasswordEncoder().encodePassword(currentPassword, license.key)
		def user = SecUser.findByUsernameAndPasswordAndLicense(username, hash, license)

		if (!user) {
			throw new Exception("User not found")
		}
		
		hash = new CustomPasswordEncoder().encodePassword(newPassword, license.key)
		user.password = hash
		user.save()
		
		user
	}

	def resetPassword(SecUser user, License license) {

		def hash = new CustomPasswordEncoder().encodePassword("", license.key)
		user.password = hash
		user.save()
		
		user
	}

	def createDemoUser(License license) {
		if (license?.mode != License.LicenseMode.DEMO) {
			log.error("Demo license is required")
			throw new IllegalArgumentException("Demo license is required")
		}

		def adminRole = getAdminRole()
		SecUser newUser = createUser("admin", "admin", "aa@bb.cc", license, [adminRole])

		newUser
	}

	def deleteUser(id) {
		def userInstance = SecUser.get(id)
		SecUserRole.removeAll(userInstance)
		userInstance.delete()
	}
	
	def getAdminRole() {
		getRole('ROLE_ADMIN')
	}
	
	def getUserRole() {
		getRole('ROLE_USER')
	}
	
	def getRole(String roleCode) {
		SecRole.findByAuthority(roleCode) ?: new SecRole(authority: roleCode).save(flush:true)
	}

	def getAllRoles() {
		SecRole.findAll()
	}

    def createSystemUser(def username, def password) {

		log.trace("Creating system user: [$username]:[$password]...")
    	def systemUser = new SystemUser(
    		username: username,
    		password: password
    		)
		if(!systemUser.save(flush:true)) {
			log.error("SystemUser [$username] was not created")
			throw new Exception("SystemUser was not created")
		}

		log.trace("...done.")
		systemUser
	}
}
