grails.project.work.dir = "../../work/HMS-JQ"

grails.servlet.version = "2.5" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.target.level = 1.6
grails.project.source.level = 1.6
//grails.project.war.file = "target/${appName}-${appVersion}.war"

grails.server.port.http = 9090

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

        grailsPlugins()
        grailsHome()
        grailsCentral()

        //mavenLocal()
        mavenCentral()

        // uncomment these to enable remote dependency resolution from public Maven repositories
        //mavenRepo "http://snapshots.repository.codehaus.org"
        //mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
    }
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.

        runtime 'mysql:mysql-connector-java:5.1.25'
		//build 'org.jadira.usertype:usertype.jodatime:2.0.1'
        build 'org.freemarker:freemarker:2.3.19'

        test "org.spockframework:spock-grails-support:0.7-groovy-2.0"
    }

    plugins {
        compile (":lesscss-resources:1.3.3")
        compile ":cxf:1.1.1"
        compile ":cxf-client:1.5.3"
        runtime ":mail:1.0.1"
        compile ":quartz:1.0-RC8"

        runtime ":jquery:1.10.0"
        compile ":jquery-ui:1.8.24"
        compile ":jquery-mobile:1.1.0.5"

        runtime ":resources:1.2.RC2"

        compile ":spring-security-core:1.2.7.3"
        //compile ":spring-mobile:0.4"

        runtime ":hibernate:$grailsVersion"

        // Uncomment these (or add new ones) to enable additional resources capabilities
        //runtime ":zipped-resources:1.0"
        //runtime ":cached-resources:1.0"
        //runtime ":yui-minify-resources:0.1.4"

        runtime ":database-migration:1.3.3"

        compile ':cache:1.0.1'

        build   ":tomcat:$grailsVersion"

        test(":spock:0.7") {
            exclude "spock-grails-support"
        }
        test ":code-coverage:1.2.6"

        //compile ":CodeNarc:0.18.1"
    }
}
