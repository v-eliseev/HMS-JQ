package hms.jq

class UserController extends BaseController {

	static defaultAction = "index"
	
		/**
		 * Handling mobile views
		 */
		def afterInterceptor = [action: this.&handleMobile]
	
    def index() { 
		
	}
}
