package hms.auth

import org.codehaus.groovy.grails.plugins.springsecurity.GormUserDetailsService
import org.codehaus.groovy.grails.plugins.springsecurity.GrailsUser
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.dao.SaltSource
import org.springframework.security.authentication.encoding.PasswordEncoder
import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException
import org.springframework.security.core.authority.GrantedAuthorityImpl
import org.springframework.security.core.userdetails.UserDetailsChecker
import org.springframework.security.core.userdetails.UsernameNotFoundException


class CustomAuthenticationProvider implements AuthenticationProvider {

	protected final Logger log = LoggerFactory.getLogger(getClass())

	PasswordEncoder passwordEncoder
	SaltSource saltSource
	UserDetailsChecker preAuthenticationChecks
	UserDetailsChecker postAuthenticationChecks

	Authentication authenticate(Authentication auth) throws AuthenticationException {
		CustomAuthenticationToken authentication = auth

		String password = authentication.credentials
		String username = authentication.principal
		String licenseKey = authentication.licenseKey

		String hql = '''\
			from SecUser u
			where u.license.key=:licenseKey
			and u.username=:username'''

		CustomUserDetails userDetails
		def authorities

		// use withTransaction to avoid lazy loading exceptions
		SecUser.withTransaction { status ->
			SecUser user = SecUser.executeQuery(hql,
					[licenseKey: licenseKey, username: username],
					[max: 1])[0]

			if (!user) {
				// TODO customize 'springSecurity.errors.login.fail' i18n message in app's messages.properties with org name
				log.warn "User not found: $username for license $licenseKey"
				throw new UsernameNotFoundException('User not found', username)
			}

			authorities = user.authorities.collect { new GrantedAuthorityImpl(it.authority) }
			authorities = authorities ?: GormUserDetailsService.NO_ROLES

			userDetails = new CustomUserDetails(user.username, user.password,
					user.enabled, !user.accountExpired, !user.passwordExpired,
					!user.accountLocked, authorities, user.id, licenseKey)
		}

		preAuthenticationChecks.check userDetails
		additionalAuthenticationChecks userDetails, authentication
		postAuthenticationChecks.check userDetails

		def result = new CustomAuthenticationToken(userDetails,
				authentication.credentials, licenseKey, authorities)
		result.details = authentication.details
		result
	}

	protected void additionalAuthenticationChecks(GrailsUser userDetails,
	CustomAuthenticationToken authentication) throws AuthenticationException {

		def salt = saltSource.getSalt(userDetails)

		if (authentication.credentials == null) {
			log.debug 'Authentication failed: no credentials provided'
			throw new BadCredentialsException('Bad credentials', userDetails)
		}

		String presentedPassword = authentication.credentials
		if (!passwordEncoder.isPasswordValid(userDetails.password, presentedPassword, salt)) {
			log.debug 'Authentication failed: password does not match stored value'

			throw new BadCredentialsException('Bad credentials', userDetails)
		}
	}

	boolean supports(Class<? extends Object> authenticationClass) {
		CustomAuthenticationToken.isAssignableFrom authenticationClass
	}
}
