grails.servlet.version = "3.0" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.work.dir = "../../work/HMS-JQ"
grails.project.target.level = 1.6
grails.project.source.level = 1.6
//grails.project.war.file = "target/${appName}-${appVersion}.war"

grails.project.fork = [
    // configure settings for compilation JVM, note that if you alter the Groovy version forked compilation is required
    //  compile: [maxMemory: 256, minMemory: 64, debug: false, maxPerm: 256, daemon:true],

    // configure settings for the test-app JVM, uses the daemon by default
    test: false, //[maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, daemon:true],
    // configure settings for the run-app JVM
    run: false, //[maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
    // configure settings for the run-war JVM
    war: false, //[maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
    // configure settings for the Console UI JVM
    console: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256]
]

def env = System.getProperty('grails.env')

if (env in ['development', 'test', 'jenkins', 'test_mysql']) {
    grails.server.port.http = 9090
}
else {
    grails.server.port.http = 80
}

/**
    Define versions
*/

def configName
def systemConfig = new ConfigObject()
// try {
//     def directory = new File(getClass().protectionDomain.codeSource.location.path).parent
//     systemConfig = new ConfigSlurper(grailsSettings.grailsEnv).parse(new File(directory + File.separator + "SystemConfig.groovy").toURI().toURL())
// } catch (Exception e) {
//     def myClassLoader = new URLClassLoader([ classesDir.toURI().toURL()] as URL[], rootLoader) 
//     systemConfig = new ConfigSlurper(grailsSettings.grailsEnv).parse(myClassLoader.loadClass("SystemConfig"))
// }

def mysqlConnectorVersion = "5.1.30" //systemConfig.roomplanner.mysql.connector.version
def roombixUiVersion = "0.1-SNAPSHOT" //systemConfig.roomplanner.roombixUi.version
def roomplannerApiVersion = "0.5-SNAPSHOT" //systemConfig.roomplanner.roomplannerApi.version
/**

*/
grails.project.dependency.resolver = "maven" // or ivy
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "error" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    checksums true // Whether to verify checksums on resolve
    //legacyResolve false // whether to do a secondary resolve on plugin installation, not advised and here for backwards compatibility

    repositories {
        inherits true // Whether to inherit repository definitions from plugins

        grailsPlugins()
        grailsHome()
        mavenLocal()
        grailsCentral()
        mavenCentral()

        // uncomment these to enable remote dependency resolution from public Maven repositories
        //mavenRepo "http://snapshots.repository.codehaus.org"
        //mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"

        mavenRepo 'http://repo.spring.io/milestone'
        
        if (env in ['jenkins', 'prod']) {
          mavenRepo 'http://192.168.0.37:8080/artifactory/HMS'
        }
    }
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.

        runtime "mysql:mysql-connector-java:$mysqlConnectorVersion"
        // runtime 'org.postgresql:postgresql:9.3-1100-jdbc41'

        compile 'org.freemarker:freemarker:2.3.20'
        compile 'joda-time:joda-time:2.3'
        //compile 'joda-time:joda-time-hibernate:1.3'

        test "org.spockframework:spock-grails-support:0.7-groovy-2.0"
        test "org.gebish:geb-spock:0.9.2"

        def seleniumVersion = "2.41.0"
        test "org.seleniumhq.selenium:selenium-htmlunit-driver:$seleniumVersion"
        test "org.seleniumhq.selenium:selenium-chrome-driver:$seleniumVersion"
        test "org.seleniumhq.selenium:selenium-firefox-driver:$seleniumVersion"
        test "org.seleniumhq.selenium:selenium-support:$seleniumVersion"
    }

    plugins {

        compile ":scaffolding:2.0.3"

        //compile ":hibernate:3.6.10.13" 
        compile ":hibernate4:4.3.5.1"
        build ":tomcat:7.0.52.1"

        compile ":cxf:1.1.1"
        compile ":cxf-client:1.6.1"
        compile ":remoting:1.3"
        
        runtime ":mail:1.0.5-SNAPSHOT"
        compile ":quartz:1.0.1"
        //compile ":quartz2:2.1.6.2"

        runtime ":jquery:1.11.0.2"
        // compile ":jquery-ui:1.8.24"
        // compile ":jquery-mobile:1.1.0.5"

        compile ":spring-security-core:2.0-RC2"
        //compile ":spring-mobile:0.4"

        // Uncomment these (or add new ones) to enable additional resources capabilities
        //runtime ":zipped-resources:1.0"
        //runtime ":cached-resources:1.0"
        //runtime ":yui-minify-resources:0.1.4"

        runtime ":database-migration:1.4.0"

        compile ':cache:1.1.3'

        test(":spock:0.7") { 
            exclude "spock-grails-support" 
            export = false
        }
        test (":geb:0.9.3-SNAPSHOT") {
            export = false
        }

        if (env == 'jenkins') {
            test (":code-coverage:1.2.7") {
                export = false
            }
        }

        test (":codenarc:0.20") {
            export = false
        }

        runtime ":roomplanner-api:$roomplannerApiVersion"
        runtime ":roombix-ui:$roombixUiVersion"
    }
}

coverage {
   exclusions = ["**/SystemConfig*"]
}

codenarc {
    extraIncludeDirs = ['grails-app/jobs']
    reports = {
        Jenkins('xml') {                    
            outputFile = 'target/analysis-reports/CodeNarcReport.xml'
            title = 'CodeNarc Analysis Report'
        }
    }
}
