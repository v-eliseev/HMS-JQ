package filters

import hms.RequestUtils 

class LicenseFilters {

    def filters = {
        addLicenseToModel(
            //controller:'*',
            controllerExclude:'(superuser|login)', 
            action:'*'
        ) {

            before = {
                log.trace("Before...")
                def licenseInstance = RequestUtils.getLicense(request)
                if (!licenseInstance) {
                    log.trace("Redirecting to login page...")
                    redirect(controller: 'login')
                    return false
                }
            }

            after = { Map model ->
                log.trace("After...")
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
