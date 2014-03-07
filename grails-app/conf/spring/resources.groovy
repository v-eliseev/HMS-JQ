
import grails.plugin.springsecurity.SpringSecurityUtils

// Place your Spring DSL code here
beans = {

	passwordEncoder(hms.auth.CustomPasswordEncoder)
	
	saltSource(hms.auth.CustomSaltSource)
	
	userDetailsService(hms.auth.CustomUserDetailsService)

	authenticationProcessingFilter(hms.auth.CustomAuthenticationFilter){
		def conf = SpringSecurityUtils.securityConfig
		authenticationManager = ref('authenticationManager')
		sessionAuthenticationStrategy = ref('sessionAuthenticationStrategy')
		authenticationSuccessHandler = ref('authenticationSuccessHandler')
		authenticationFailureHandler = ref('authenticationFailureHandler')
		rememberMeServices = ref('rememberMeServices')
		authenticationDetailsSource = ref('authenticationDetailsSource')
		filterProcessesUrl = conf.apf.filterProcessesUrl
		usernameParameter = conf.apf.usernameParameter
		passwordParameter = conf.apf.passwordParameter
		continueChainBeforeSuccessfulAuthentication = conf.apf.continueChainBeforeSuccessfulAuthentication
		allowSessionCreation = conf.apf.allowSessionCreation
		postOnly = conf.apf.postOnly
		storeLastUsername = conf.apf.storeLastUsername
	}

	daoAuthenticationProvider(hms.auth.CustomAuthenticationProvider) {
		passwordEncoder = ref('passwordEncoder')
		saltSource = ref('saltSource')
		preAuthenticationChecks = ref('preAuthenticationChecks')
		postAuthenticationChecks = ref('postAuthenticationChecks')
	}
	
	securityEventListener(hms.auth.CustomSecurityEventListener)
}
