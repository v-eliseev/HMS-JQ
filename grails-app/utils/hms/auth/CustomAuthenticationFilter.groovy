package hms.auth

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession

import org.codehaus.groovy.grails.plugins.springsecurity.RequestHolderAuthenticationFilter
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.util.TextEscapeUtils

class CustomAuthenticationFilter extends RequestHolderAuthenticationFilter {

	/* (non-Javadoc)
	 * @see org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter#attemptAuthentication(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public Authentication attemptAuthentication(
		HttpServletRequest request,
		HttpServletResponse response) throws AuthenticationException {

		final String PARAM_LICENSE_KEY = "j_licenseKey";
		final String SESSION_LICENSE_KEY = "sessionLicenseKey";

		String username = (obtainUsername(request) ?: '').trim()
		String password = obtainPassword(request) ?: ''
		String licenseKey = request.getParameter(PARAM_LICENSE_KEY);

		def authentication = new CustomAuthenticationToken(username, password, licenseKey)

		HttpSession session = request.getSession(false)
		if (session || getAllowSessionCreation()) {
			request.session[SPRING_SECURITY_LAST_USERNAME_KEY] =
					TextEscapeUtils.escapeEntities(username)
		}

		setDetails(request, authentication)

		AuthenticationManager am = getAuthenticationManager() 
		return am.authenticate(authentication)
	}
}
