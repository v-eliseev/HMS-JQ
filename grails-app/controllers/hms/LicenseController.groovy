package hms

class LicenseController extends BaseController {

    static defaultAction = "create"

    def licenseService

    def create() {
        def licenseInstance = licenseService.createLicense("demo", params.email)
        [ licenseInstance: licenseInstance ]
    }
}
