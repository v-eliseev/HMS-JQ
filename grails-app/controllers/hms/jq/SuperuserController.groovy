package hms.jq

import hms.AdminService
import hms.Hotel
import hms.License
import hms.LicenseService;
import hms.ServiceFactory;
import hms.auth.Role
import hms.auth.User
import hms.auth.UserRole

class SuperuserController extends BaseController {

	static defaultAction = "index"

	/**
	 * Handling mobile views
	 */
	def afterInterceptor = [action: this.&handleMobile]

	def index() {
	}

	def createStandardLicense() {
		LicenseService licenseService = ServiceFactory.getServiceFactory().getServiceByName("licenseService")
		AdminService adminService = ServiceFactory.getServiceFactory().getServiceByName("adminService")

		License licenseInstance = licenseService.createStandardLicense()
		Role adminRole = adminService.getAdminRole()
		User adminUser = adminService.createUser("admin", "admin", licenseInstance)
		UserRole.create(adminUser, adminRole)
		Hotel hotel = new Hotel(license: licenseInstance).save()
		
		redirect(action: "show", id: licenseInstance.id)
	}

	def show() {
		def licenseInstance = License.get(params.id)
		if (!licenseInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'license.label', default: 'License'),
				params.id
			])
			redirect(action: "showLicenses")
			return
		}

		[licenseInstance: licenseInstance]
	}
	
	def showLicenses() {
		def list = License.findAll({});
		[licenseInstanceList: list]
	}

	def showApplicationStatus() {
	}
}
