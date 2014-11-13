package hms

import hms.auth.SecRole

class DispatchController extends BaseController {

    def index() {
    	log.trace("In Dispatch#index")

    	def user = getCurrentUser(request)
    	def authorities = user.getAuthorities()

    	log.trace("User: $user, Authorities: $authorities")

    	// check valid values

    	// if (authorities.size() > 1) {
    	// 	// show role selection
    	// }

    	// if (authorities.size() == 0) {
    	// 	// no authorities
    	// }

    	// authorities.size() == 1
    	switch (authorities.asList()[0].authority) {
    		case "ROLE_ADMIN":
    			redirect(controller:"admin")
    			break

    		case "ROLE_USER":
    			redirect(controller:"user")
    			break
    	}
    }
}
