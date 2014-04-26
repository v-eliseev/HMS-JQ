package hms

import hms.auth.SecUser

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpSession

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
		springSecurityService.currentUser.license
	}
	
	protected SecUser getCurrentUser(HttpServletRequest request) {
		springSecurityService.currentUser
	}

}
