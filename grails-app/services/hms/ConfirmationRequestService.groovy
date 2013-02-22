package hms

import java.util.Calendar

import hms.ConfirmationRequest;
import hms.License

import grails.converters.JSON

class ConfirmationRequestService {

    def createPasswordConfirmationRequest(License license, Map content) {

    	Calendar calendar = Calendar.getInstance()
    	calendar.add(Calendar.HOUR, 1)

		def cr = new ConfirmationRequest(
			uuid: UUID.randomUUID().toString(),
			type: 1,
			data: new JSON(content).toString(),
			license: license,
			expires: calendar.getTime()
		)
		
		if (!cr.save()) {
			cr.errors.each { log.error(it) }
			throw Exception("Error creating ConfirmationRequest")
		}

		cr
    }

    def createEmailConfirmationRequest(License license, Map content) {

    	Calendar calendar = Calendar.getInstance()
    	calendar.add(Calendar.HOUR, 1)

		def cr = new ConfirmationRequest(
			uuid: UUID.randomUUID().toString(),
			type: 2,
			data: new JSON(content).toString(),
			license: license,
			expires: calendar.getTime()
		)
		
		if (!cr.save()) {
			cr.errors.each { log.error(it) }
			throw Exception("Error creating ConfirmationRequest")
		}

		cr
    }

    def confirmChangingPassword() {
		AdminService adminService = getServiceFactory().getServiceByName("adminService")

		String uuid = params.uuid
		def confirmationRequest = ConfirmationRequest.findByUuid(uuid)
		def content = JSON.parse(confirmationRequest.data)
		confirmationRequest.delete()

		adminService.changePassword('admin', content.oldPassword, content.newPassword, confirmationRequest.license)

		redirect(action: "showLicense", id: confirmationRequest.license.id)
	}

	def confirmChangingEmail() {
		LicenseService licenseService = getServiceFactory().getServiceByName("licenseService")

		String uuid = params.uuid
		def confirmationRequest = ConfirmationRequest.findByUuid(uuid)
		def content = JSON.parse(confirmationRequest.data)
		confirmationRequest.delete()

		licenseService.changeEmail(content.newEmail, confirmationRequest.license)

		redirect(action: "showLicense", id: confirmationRequest.license.id)
	}


}
