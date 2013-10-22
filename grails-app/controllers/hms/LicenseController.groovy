package hms

class LicenseController extends BaseController {

    static defaultAction = "create"

    def licenseService

    def create() {
        def licenseInstance = licenseService.createLicense(LicenseType.DEMO, params.email)
        [ licenseInstance: licenseInstance ]
    }
}
