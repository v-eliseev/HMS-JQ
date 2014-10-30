package filters

import hms.RequestUtils 
import hms.auth.SecUser

class RenderingFilters {

    def mobileService

    def filters = {

        /**
            Rendering mobile version
        */
        mobileAware(controller:'test', action:'*') {
            after = { Map model ->
                log.debug("mobileAware rendering")
                String viewPrefix = mobileService.isMobileUser(request) ? "/m/" : ""
                
            }
        }

        /**
            Rendering views according to given authorities
        */
        roleAware(controller:'test', action:'*') {
            after = { Map model ->
                log.debug("roleAware rendering")
                def user = RequestUtils.getCurrentUser(request)
                def roles = user?.getAuthorities()

            }
        }
    }
}
