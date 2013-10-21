package hms

import hms.auth.SecRole
import hms.auth.SecUser
import hms.auth.SecUserRole

class SuperuserController extends BaseController {
	
	static defaultAction = "index"

	def licenseService
	def adminService
	def confirmationRequestService
	def mailerService

	/**
	 * Handling mobile views
	 */
	def afterInterceptor = [action: this.&handleMobile]

	def index() {
		def list = licenseService.getAllEnabledLicenses()

		[
			licenseInstanceList: list
		]
	}

	def createLicense() {

		def licenseInstance
		def email = params.email
		switch (params.licenseType) {
		case "demo": 
			licenseInstance = licenseService.createDemoLicense(email)
			SecRole adminRole = adminService.getAdminRole()
			SecUser adminUser = adminService.createUser("admin", "admin", email, licenseInstance, [adminRole])
			break

		case "production": 
			licenseInstance = licenseService.createStandardLicense(email)
			SecRole adminRole = adminService.getAdminRole()
			SecUser adminUser = adminService.createUser("admin", "admin", email, licenseInstance, [adminRole])
			break

		default:
			log.error("Wrong license type")
			throw new IllegalArgumentException("Wrong license type")
		} 

		redirect(action: "showLicense", id: licenseInstance.id)
	}

	def showLicense() {
		def licenseInstance = License.get(params.id)
		if (!licenseInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'license.label', default: 'License'),
				params.id
			])
			redirect(action: "index")
			return
		}

		[licenseInstance: licenseInstance]
	}

	def disableLicense() {
		licenseService.disableLicense(params.id)
		redirect(action: "index")
	}

	def deleteLicense() {
		licenseService.deleteLicense(params.id)		
		redirect(action: "index")
	}

	def changeDemoToProduction() {
		def licenseInstance = License.get(params.id)

		licenseInstance.demoMode = false
		licenseInstance.save()

		redirect(action: "showLicense", id: licenseInstance.id)
	}

	def prolongateLicense() {
		def licenseInstance = License.get(params.id)

		licenseInstance.expires = licenseInstance.expires + 365
		licenseInstance.save()

		redirect(action: "showLicense", id: licenseInstance.id)
	}

	def resetAdminPassword() {
		def licenseInstance = License.get(params.id)

		//TODO change from form data
		def content = [oldPassword: 'admin', newPassword: 'admin1']

		def cr = confirmationRequestService.createPasswordConfirmationRequest(licenseInstance, content)
		def model = [
			link: 'confirmChangingPassword?uuid=' + cr.uuid, 
			firstname: licenseInstance.owner?.firstname,
			lastname: licenseInstance.owner?.lastname,
			key: licenseInstance.key
		]
		mailerService.sendConfirmationOnPasswordChange(licenseInstance, model)

		redirect(action: "showLicense", id: licenseInstance.id)
	}

	def changeEmail() {
		def licenseInstance = License.get(params.id)

		//TODO change from form data
		def content = [newEmail: 'v-eliseev@yandex.ru']

		def cr = confirmationRequestService.createEmailConfirmationRequest(licenseInstance, content)
		def model = [
			link: 'confirmChangingEmail?uuid=' + cr.uuid, 
			firstname: licenseInstance.owner?.firstname,
			lastname: licenseInstance.owner?.lastname,
			key: licenseInstance.key
		]
		mailerService.sendConfirmationOnEmailChange(licenseInstance, model)

		redirect(action: "showLicense", id: licenseInstance.id)
	}
	
	def showLicenses() {
		def list = licenseService.getAllLicenses()
		[
			licenseInstanceList: list
		]
	}

	def showApplicationStatus() {
	}

	def cleanup() {
		// def crList = ConfirmationRequest.findAllByExpiresLessThanEquals(new Date())
		// def licList = License.findAllByDemoModeAndExpiresLessThanEquals(true, new Date()-1)
		// [confirmationRequests: crList, expiredDemoLicenses: licList]
	}

	def cleanupNow() {

	}
}
