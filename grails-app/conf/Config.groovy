import hms.CustomLogAppender

// locations to search for config files that get merged into the main config
// config files can either be Java properties files or ConfigSlurper scripts

// grails.config.locations = [ "classpath:${appName}-config.properties",
//                             "classpath:${appName}-config.groovy",
//                             "file:${userHome}/.grails/${appName}-config.properties",
//                             "file:${userHome}/.grails/${appName}-config.groovy"]

// if(System.properties["${appName}.config.location"]) {
//    grails.config.locations << "file:" + System.properties["${appName}.config.location"]
// }

grails.project.groupId = appName // change this to alter the default package name and Maven publishing destination
grails.mime.file.extensions = true // enables the parsing of file extensions from URLs into the request format
grails.mime.use.accept.header = false
grails.mime.types = [ html: ['text/html','application/xhtml+xml'],
                      xml: ['text/xml', 'application/xml'],
                      text: 'text/plain',
                      js: 'text/javascript',
                      rss: 'application/rss+xml',
                      atom: 'application/atom+xml',
                      css: 'text/css',
                      csv: 'text/csv',
                      all: '*/*',
                      json: ['application/json','text/json'],
                      form: 'application/x-www-form-urlencoded',
                      multipartForm: 'multipart/form-data'
                    ]

// URL Mapping Cache Max Size, defaults to 5000
//grails.urlmapping.cache.maxsize = 1000

// DBConsole resources
grails.resources.adhoc.patterns = ['/dbconsole/images/*', '/dbconsole/css/*', '/dbconsole/js/*'] 

// The default codec used to encode data with ${}
grails.views.default.codec = "none" // none, html, base64
grails.views.gsp.encoding = "UTF-8"
grails.converters.encoding = "UTF-8"
// enable Sitemesh preprocessing of GSP pages
grails.views.gsp.sitemesh.preprocess = true
// scaffolding templates configuration
grails.scaffolding.templates.domainSuffix = 'Instance'

// Set to false to use the new Grails 1.2 JSONBuilder in the render method
grails.json.legacy.builder = false
// enabled native2ascii conversion of i18n properties files
grails.enable.native2ascii = true
// whether to install the java.util.logging bridge for sl4j. Disable for AppEngine!
grails.logging.jul.usebridge = true
// packages to include in Spring bean scanning
grails.spring.bean.packages = []

// request parameters to mask when logging exceptions
grails.exceptionresolver.params.exclude = ['password']

// set per-environment serverURL stem for creating absolute links
environments {
    development {
        grails.roomplannerURL = "http://localhost:8080/RoomPlanner"
        //grails.roomplannerURL = "http://192.168.0.35/tomcat/RoomPlanner"
    }
    test {
        grails.roomplannerURL = "http://192.168.0.35/tomcat/RoomPlanner"
    }
    production {
        grails.roomplannerURL = "http://192.168.0.35/tomcat/RoomPlanner"
    }
}

// log4j configuration
log4j = {
    // Example of changing the log pattern for the default console
    // appender:
    //
    //appenders {
    //    console name:'stdout', layout:pattern(conversionPattern: '%c{2} %m%n')
    //}
	
	// appenders {
	// 	appender new CustomLogAppender(
	// 		name: "dblogger"
	// 		)
	//}

  appenders {
    rollingFile name: "logFile", maxFileSize: 1024000, file: "hms-jq.log"
  }

  root {
    error 'console', 'logFile'
  }
	
//	root {
//		console, dblogger
//	}

    error  'org.codehaus.groovy.grails.web.servlet',  //  controllers
           'org.codehaus.groovy.grails.web.pages', //  GSP
           'org.codehaus.groovy.grails.web.sitemesh', //  layouts
           'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
           'org.codehaus.groovy.grails.web.mapping', // URL mapping
           'org.codehaus.groovy.grails.commons', // core / classloading
           'org.codehaus.groovy.grails.plugins', // plugins
           'org.codehaus.groovy.grails.orm.hibernate', // hibernate integration
           'org.springframework',
           'org.hibernate',
           'net.sf.ehcache.hibernate'
    
    // Enable Hibernate SQL logging with param values
    //trace  'org.hibernate.type'
    //debug  'org.hibernate.SQL'

    error  'grails.app'

    warn   'org.mortbay.log'

	  debug  'grails.app.conf', 
           'grails.app.bootstrap',
           'grails.app.services.hms', 
           'grails.app.domain.hms', 
           'grails.app.domain.roomplanner', 
           'grails.app.controllers.hms', 
           'grails.app.controllers.roomplanner',
           'grails.app.utils'
    
    error  'org.apache.cxf'


    debug  'hms.DemoDataScript'
}

// Added by the Spring Security Core plugin:
grails.plugins.springsecurity.userLookup.userDomainClassName = 'hms.auth.SecUser'
grails.plugins.springsecurity.userLookup.authorityJoinClassName = 'hms.auth.SecUserRole'
grails.plugins.springsecurity.authority.className = 'hms.auth.SecRole'
grails.plugins.springsecurity.useSecurityEventListener = true
grails.plugins.springsecurity.logout.handlerNames =
	['rememberMeServices',
	 'securityContextLogoutHandler',
	 'securityEventListener']

// environments {
//   development {
//     grails.plugins.springsecurity.mock.active = true
//     grails.plugins.springsecurity.mock.fullName = "Administrator"
//     grails.plugins.springsecurity.mock.email = "admin@email.com"
//     grails.plugins.springsecurity.mock.username =  "admin"
//     grails.plugins.springsecurity.mock.roles = [ 'ROLE_USER', 'ROLE_ADMIN' ]
//     grails.plugins.springsecurity.ipRestrictions = [ '/**': ['127.0.0.0/8', '::1/128'] ]
//   }
// }   
	
service.roomplanner.soap.url = "${grails.roomplannerURL}/services/roomPlannerSoap"
service.roomplanner.hessian.url = "${grails.roomplannerURL}/hessian/roomPlannerRemote"
service.roomplanner.burlap.url = "${grails.roomplannerURL}/burlap/roomPlannerRemote"

service.roomplanner.mode = "Hessian"

cxf {
	client {
		roomPlannerServiceClient {
			wsdl = "src/java/roomPlanner.wsdl" //only used for wsdl2java script target
			//wsdlArgs = "-autoNameResolution"
			outputDir = "src/java/ws"
      namespace = "ws.roomplanner"

			clientInterface = ws.roomplanner.RoomPlannerService
			serviceEndpointAddress = "${service.roomplanner.soap.url}"
			receiveTimeout = 0 //no timeout
			connectionTimeout = 0 //no timeout
      allowChunking = true
		}
	}
}

grails {
   mail {
     host = "smtp.gmail.com"
     port = 465
     username = "vladislav.eliseev@gmail.com"
     password = "zAN9uX3c"
     props = ["mail.smtp.auth":"true",             
              "mail.smtp.socketFactory.port":"465",
              "mail.smtp.socketFactory.class":"javax.net.ssl.SSLSocketFactory",
              "mail.smtp.socketFactory.fallback":"false"]
   }
}

// jquery {
//   sources = "jquery"
//   version = "2.0.2"
// }