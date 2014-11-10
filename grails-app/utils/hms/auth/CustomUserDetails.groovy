package hms.auth

import groovy.transform.ToString

import grails.plugin.springsecurity.userdetails.GrailsUser

import org.springframework.security.core.GrantedAuthority

@ToString(includeNames = true, includeFields = true, includeSuper = true)
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