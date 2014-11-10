package hms.auth

import groovy.transform.ToString

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken

@ToString(includeNames = true, includeFields = true, includeSuper = true)
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
