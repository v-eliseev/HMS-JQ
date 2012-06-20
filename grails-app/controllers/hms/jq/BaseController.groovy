package hms.jq

import javax.servlet.http.HttpSession

import org.springframework.security.core.context.SecurityContext
import org.springframework.security.core.userdetails.UserDetails

import hms.License;
import hms.auth.CustomPasswordEncoder
import hms.auth.User

class BaseController {

	def mobileService
	
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
	
	protected License getLicense(javax.servlet.http.HttpServletRequest request) {
		HttpSession sess = request.session
		SecurityContext ctx = sess.getAttribute("SPRING_SECURITY_CONTEXT")
		String licenseKey = ctx?.authentication?.principal?.licenseKey
		License license = License.findByKey(licenseKey)
		return license
	}
	
	protected User getCurrentUser(javax.servlet.http.HttpServletRequest request) {
		HttpSession sess = request.session
		SecurityContext ctx = sess.getAttribute("SPRING_SECURITY_CONTEXT")
		UserDetails userDetails = ctx?.authentication?.principal
		License license = getLicense(request)
		def user = User.findByUsernameAndPasswordAndLicense(userDetails.username, userDetails.password, license)
		return user
	}

}
