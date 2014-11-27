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
        renderView(controller:'(assets|login|logout|superuser)', action:'*', invert: true) {
            after = { Map model ->
				
				// skip redirect requests
				if (!model) { return true }

                // skip AJAX requests 
                if (request.xhr) { return true }

                log.trace("In RenderingFilters")
                def viewName = new StringBuilder()

                if (mobileService.isMobileUser(request)) viewName << "/mobile"
                
                def user = RequestUtils.getCurrentUser(request)
                def authorities = user?.getAuthorities()

                log.trace("User: $user")
                
                def namespace
                if (authorities != null) {
                    switch (authorities.asList()[0].authority) {
                    case "ROLE_ADMIN":
                        namespace = "admin"
                        break
                    case "ROLE_USER":
                        namespace = "user"
                        break
                    default:
                        throw new IllegalArgumentException()
                    }
                }
                if (namespace != null) viewName << "/${namespace}"
                viewName << "/${controllerName}"
                if (actionName != null) viewName << "/${actionName}" 

                log.debug("Rendering $viewName")
                modelAndView = new ModelAndView(viewName.toString(), model)
            }
        }
    }
}
