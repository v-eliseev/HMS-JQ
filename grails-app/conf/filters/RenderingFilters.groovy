package filters

import hms.RequestUtils 
import hms.auth.SecUser

class RenderingFilters {

    def filters = {

        /**
            Rendering mobile version
        */
        mobileAware(controller:'Test', action:'*') {
            before = {

            }
            after = { Map model ->

                log.debug("mobileAware rendering")

            }
            afterView = { Exception e ->

            }
        }

        /**
            Rendering views according to given authorities
        */
        roleAware(controller:'Test', action:'*') {
            before = {

            }
            after = { Map model ->

                log.debug("roleAware rendering")
                def user = RequestUtils.getCurrentUser(request)
                def roles = user?.getAuthorities()

            }
            afterView = { Exception e ->

            }
        }
    }
}
