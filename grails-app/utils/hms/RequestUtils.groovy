package hms

import javax.servlet.http.HttpSession

import org.springframework.security.core.context.SecurityContext
import org.springframework.security.core.userdetails.UserDetails

import org.apache.commons.logging.LogFactory

import hms.auth.SecUser

class RequestUtils {

	private static final log = LogFactory.getLog(this.getClass())
	
	public static License getLicense(javax.servlet.http.HttpServletRequest request) {
        License license = null
        HttpSession sess = request.session
        SecurityContext ctx = sess.getAttribute("SPRING_SECURITY_CONTEXT")
        String licenseKey = ctx?.authentication?.principal?.licenseKey
        log.debug("License Key: ${licenseKey}")
        if (licenseKey) {
            license = License.findByKey(licenseKey)
        }
        return license
    }

    public static SecUser getCurrentUser(javax.servlet.http.HttpServletRequest request) {
        License license = null
        SecUser user = null
        HttpSession sess = request.session
        SecurityContext ctx = sess.getAttribute("SPRING_SECURITY_CONTEXT")
        UserDetails userDetails = ctx?.authentication?.principal
        String licenseKey = userDetails?.licenseKey
        if (licenseKey) {
            license = License.findByKey(licenseKey)
        }
        if (license && userDetails) {
            user = SecUser.findByUsernameAndPasswordAndLicense(userDetails.username, userDetails.password, license)
        }
        return user
    }
}