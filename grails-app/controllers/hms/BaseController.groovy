package hms

import hms.License
import hms.ServiceFactory
import hms.auth.SecUser

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpSession

import org.springframework.security.core.context.SecurityContext
import org.springframework.security.core.userdetails.UserDetails

class BaseController {

	def mobileService
	def grailsApplication
	def springSecurityService
	
	/**
	 * Handle mobile views
	 * @param model
	 * @param modelAndView
	 * @return
	 */
	protected handleMobile(model, modelAndView) {
		if (modelAndView && mobileService.isMobileBrowser(request)) {
		   modelAndView.viewName = '/mobile/' + modelAndView.viewName
		}
	 }
	
	protected License getLicense(HttpServletRequest request) {
		//RequestUtils.getLicense(request)
		springSecurityService.currentUser.license
	}
	
	protected SecUser getCurrentUser(HttpServletRequest request) {
		//RequestUtils.getCurrentUser(request)
		springSecurityService.currentUser
	}

}
