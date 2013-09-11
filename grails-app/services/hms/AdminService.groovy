package hms

import hms.auth.CustomPasswordEncoder
import hms.auth.SecRole
import hms.auth.SecUser
import hms.auth.SecUserRole

class AdminService {

	def createUser(String username, String password, String email, License license) {

		def hash = new CustomPasswordEncoder().encodePassword(password, license.key)
		log.trace("Create user: $username, password: $hash, email: $email, license: $license")
		def newUser = new SecUser(username: username, password: hash, email: email, license: license)
		if (!newUser.save()) {
			log.trace("... Failed")
		 	throw new Exception('User was not created')
		}
		license.addToUsers(newUser)
		license.save()
		log.trace("... Successful")
			
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
		if (!license.demoMode) {
			throw new Exception("Demo license is required")
		}
		SecUser newUser = createUser("admin", "admin", "aa@bb.cc", license)
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
		SecRole.findByAuthority(roleCode) ?: new SecRole(authority: roleCode).save()
	}

	def getAllRoles() {
		SecRole.findAll()
	}

}
