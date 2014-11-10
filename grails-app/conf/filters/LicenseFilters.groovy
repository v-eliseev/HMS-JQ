package filters

import hms.RequestUtils 

class LicenseFilters {

    def filters = {
        addLicenseToModel(
            controllerExclude:'(superuser|login|assets|license)', 
            action:'*'
        ) {

            before = {
                log.debug("Before...")
                def licenseInstance = RequestUtils.getLicense(request)
                if (!licenseInstance) {
                    log.debug("Redirecting to login page...")
                    redirect(controller: 'login')
                    return false
                }
            }

            after = { Map model ->
                log.debug("After...")
                if (model) {
                    def licenseInstance = RequestUtils.getLicense(request)
                    if (licenseInstance) {
                        model.licenseInstance = licenseInstance
                    }
                }
            }

            afterView = { Exception e ->

            }
        }
    }


}
