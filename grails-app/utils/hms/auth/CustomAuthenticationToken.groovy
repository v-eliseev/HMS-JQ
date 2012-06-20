package hms.auth

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken

class CustomAuthenticationToken extends UsernamePasswordAuthenticationToken implements Serializable {

	private static final long serialVersionUID = 1
	
	final String licenseKey

	CustomAuthenticationToken(principal, credentials, String licenseKey) {
		super(principal, credentials)
		this.licenseKey = licenseKey
	}

	CustomAuthenticationToken(principal, credentials, String licenseKey, Collection authorities) {
		super(principal, credentials, authorities)
		this.licenseKey = licenseKey
	}
}
