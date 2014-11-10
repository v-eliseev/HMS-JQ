package hms.auth

import java.security.MessageDigest

import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.encoding.PasswordEncoder

class CustomPasswordEncoder implements PasswordEncoder {

	@Override
	public String encodePassword(String password, Object licenseKey) throws DataAccessException {
		String salted = password + '_' + licenseKey

		MessageDigest md = MessageDigest.getInstance("SHA-256")
		md.update(salted.getBytes())

		byte[] byteData = md.digest()

		StringBuffer sb = new StringBuffer()
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1))
		}

		return sb.toString()
	}

	@Override
	public boolean isPasswordValid(String encodedPassword, String rawPassword, Object licenseKey)
			throws DataAccessException {
		return (encodedPassword == encodePassword(rawPassword, licenseKey))	}
	
}