package filters

import hms.RequestUtils 

class LicenseFilters {

    def filters = {
        addLicenseToModel(
            //controller:'*',
            controllerExclude:'(superuser|login|logout)', 
            action:'*'
        ) {

            before = {

            }

            after = { Map model ->
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
