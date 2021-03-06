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
    war: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
    // configure settings for the Console UI JVM
    console: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256]
]

def env = System.getProperty('grails.env')

if (env in ['development', 'test']) {
    grails.server.port.http = 9090
}
else {
    grails.server.port.http = 80
}

grails.project.dependency.resolver = "maven" // or ivy
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "error" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    checksums true // Whether to verify checksums on resolve
    legacyResolve false // whether to do a secondary resolve on plugin installation, not advised and here for backwards compatibility

    repositories {
        inherits true // Whether to inherit repository definitions from plugins

        mavenRepo 'http://192.168.0.35:8080/artifactory/HMS'

        grailsPlugins()
        grailsHome()
        grailsCentral()

        mavenLocal()
        mavenCentral()

        // uncomment these to enable remote dependency resolution from public Maven repositories
        //mavenRepo "http://snapshots.repository.codehaus.org"
        //mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
    }
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.

        runtime 'mysql:mysql-connector-java:5.1.26'
        compile 'org.freemarker:freemarker:2.3.20'
        compile 'joda-time:joda-time:2.3'

        test "org.spockframework:spock-grails-support:0.7-groovy-2.0"
        test "org.gebish:geb-spock:0.9.0"

        def seleniumVersion = "2.35.0"
        test "org.seleniumhq.selenium:selenium-htmlunit-driver:$seleniumVersion"
        test "org.seleniumhq.selenium:selenium-chrome-driver:$seleniumVersion"
        test "org.seleniumhq.selenium:selenium-firefox-driver:$seleniumVersion"
        test "org.seleniumhq.selenium:selenium-support:$seleniumVersion"
    }

    plugins {

        //runtime ":hibernate:3.6.10.1" 
        runtime ":hibernate4:4.1.11.1"
        runtime ":tomcat:7.0.42"

        compile ":cxf:1.1.1"
        compile ":cxf-client:1.5.6"
        compile ":remoting:1.3"
        
        runtime ":mail:1.0.1"
        compile ":quartz2:2.1.6.2"

        compile ":asset-pipeline:0.9.0"
        compile ":less-asset-pipeline:0.8.2"

        // runtime ":jquery:1.10.2"
        // compile ":jquery-ui:1.8.24"
        // compile ":jquery-mobile:1.1.0.5"

        // runtime ":resources:1.2.1"

        compile ":spring-security-core:1.2.7.3"
        //compile ":spring-mobile:0.4"

        // Uncomment these (or add new ones) to enable additional resources capabilities
        //runtime ":zipped-resources:1.0"
        //runtime ":cached-resources:1.0"
        //runtime ":yui-minify-resources:0.1.4"

        runtime ":database-migration:1.3.6"

        compile ':cache:1.1.1'

        test(":spock:0.7") { 
            exclude "spock-grails-support" 
            export = false
        }
        test (":geb:0.9.2-SNAPSHOT") {
            export = false
        }

        if (env == 'jenkins') {
            test (":code-coverage:1.2.6") {
                export = false
            }
        }

        test (":codenarc:0.19") {
            export = false
        }

       runtime ":roomplanner-api:0.5.24"
       runtime ":roombix-ui:0.1.11"
    }
}

codenarc.reports = {
    Jenkins('xml') {                    
        outputFile = 'target/analysis-reports/CodeNarcReport.xml'
        title = 'CodeNarc Analysis Report'             
    }
}
