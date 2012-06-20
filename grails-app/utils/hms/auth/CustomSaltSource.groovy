package hms.auth

import org.springframework.security.authentication.dao.SaltSource
import org.springframework.security.core.userdetails.UserDetails;

class CustomSaltSource implements SaltSource {

	@Override
	public Object getSalt(UserDetails user) {
		return user.licenseKey
	}
	
}