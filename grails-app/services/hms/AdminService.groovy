package hms

import hms.auth.CustomPasswordEncoder
import hms.auth.Role
import hms.auth.User

class AdminService {

	def createUser(String username, String password, License license) {

		def hash = new CustomPasswordEncoder().encodePassword(password, license.key)
		def newUser = new User(username: username, password: hash, license: license)
		if (!newUser.save())
			throw Exception('User was not created')

		license.addToUsers(newUser)
		license.save()
			
		newUser
	}

	def checkUser(String username, String password, License license) {

		def hash = new CustomPasswordEncoder().encodePassword(password, license.key)
		def user = User.findByUsernameAndPasswordAndLicense(username, hash, license)

		user != null
	}
	
	def changePassword(String username, String currentPassword, String newPassword, License license) {

		def hash = new CustomPasswordEncoder().encodePassword(currentPassword, license.key)
		def user = User.findByUsernameAndPasswordAndLicense(username, hash, license)

		if (!user) {
			throw Exception("User not found")
		}
		
		hash = new CustomPasswordEncoder().encodePassword(newPassword, license.key)
		user.password = hash
		user.save()
		
		user
	}

	def createDemoUser(License license) {
		if (!license.demoMode) {
			throw Exception("Demo license is required")
		}
		User newUser = createUser("admin", "admin", license)
		newUser
	}
	
	
	
	def getAdminRole() {
		getRole('ROLE_ADMIN')
	}
	
	def getUserRole() {
		getRole('ROLE_USER')
	}
	
	def getRole(String roleCode) {
		Role.findByAuthority(roleCode) ?: new Role(authority: roleCode).save()
	}

}
