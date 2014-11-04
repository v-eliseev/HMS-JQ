package filters

import org.springframework.web.servlet.ModelAndView 

import hms.RequestUtils 
import hms.auth.SecUser

class RenderingFilters {

    def mobileService

    def filters = {

        /**
            Rendering mobile version
        */
        renderView(controller:'test', action:'*') {
            after = { Map model ->
                def viewName = new StringBuilder()

                viewName << "/"
                viewName << (mobileService.isMobileUser(request) ? "mobile/" : "")
                
                def user = RequestUtils.getCurrentUser(request)
                def roles = user?.getAuthorities()

                def namespace = "admin" // TODO change

                viewName << namespace
                if (namespace != null)
                    viewName << "/"

                viewName << controllerName
                if (actionName != null) 
                    viewName << "/"
                viewName << actionName

                log.debug(viewName)
                modelAndView = new ModelAndView(viewName.toString(), model)

            }
        }
    }
}
