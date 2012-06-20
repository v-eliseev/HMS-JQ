package hms.auth

import org.codehaus.groovy.grails.plugins.springsecurity.GrailsUserDetailsService;
import org.codehaus.groovy.grails.plugins.springsecurity.SpringSecurityUtils
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.authority.GrantedAuthorityImpl
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

class CustomUserDetailsService implements GrailsUserDetailsService {

	static final List NO_ROLES = [
		new GrantedAuthorityImpl(SpringSecurityUtils.NO_ROLE)
	]

	@Override
	public UserDetails loadUserByUsername(String username, boolean loadRoles)
	throws UsernameNotFoundException, DataAccessException {
		return loadUserByUsername(username)
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User.withTransaction { status ->

			User user = User.findByUsernameAndLicense(username, licenseKey)
			if (!user) throw new UsernameNotFoundException(
				'User not found', username)

			def authorities = user.authorities.collect {
				new GrantedAuthorityImpl(it.authority)
			}

			return new CustomUserDetails(user.username, user.password, user.enabled,
			!user.accountExpired, !user.passwordExpired,
			!user.accountLocked, authorities ?: NO_ROLES, user.id,
			user.license.key)
		}
	}
}
