package hms.auth

import org.codehaus.groovy.grails.plugins.springsecurity.GrailsUser
import org.springframework.security.core.GrantedAuthority

class CustomUserDetails extends GrailsUser {

   String licenseKey

   CustomUserDetails(String username, String password, boolean enabled,
                 boolean accountNonExpired, boolean credentialsNonExpired,
                 boolean accountNonLocked,
                 Collection<GrantedAuthority> authorities,
                 long id, String licenseKey) {
      super(username, password, enabled, accountNonExpired,
            credentialsNonExpired, accountNonLocked, authorities, id)

      this.licenseKey = licenseKey
   }
}