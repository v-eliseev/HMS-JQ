package hms.auth

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

import org.slf4j.Logger;
import org.slf4j.LoggerFactory

import org.springframework.context.ApplicationListener
import org.springframework.security.authentication.event.AbstractAuthenticationEvent
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.logout.LogoutHandler

class CustomSecurityEventListener implements
ApplicationListener<AbstractAuthenticationEvent>, LogoutHandler {

	protected final Logger log = LoggerFactory.getLogger(getClass())

	/**
	 * 
	 */
	void onApplicationEvent(AbstractAuthenticationEvent event) {
		event.authentication.with {
			def username = principal.hasProperty('username')?.getProperty(principal) ?: principal
			log.info "event=${event.class.simpleName} username=${username} " +
					"remoteAddress=${details.remoteAddress} sessionId=${details.sessionId}"
		}
	}

	/**
	 * 
	 */
	void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
		authentication.with {
			def username = principal.hasProperty('username')?.getProperty(principal) ?: principal
			log.info "event=Logout username=${username} " +
					"remoteAddress=${details.remoteAddress} sessionId=${details.sessionId}"
		}
	}
}