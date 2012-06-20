package hms

/**
 * MobileDecoratorMapper
 * Copyright 2011 Graham Daley
 * Released under the terms of the
 * GNU General Public License version 2 (GPLv2)
 */
 
import javax.servlet.http.HttpServletRequest
import com.opensymphony.module.sitemesh.*
import org.codehaus.groovy.grails.web.sitemesh.GrailsLayoutDecoratorMapper
import org.codehaus.groovy.grails.web.sitemesh.GrailsNoDecorator
 
/**
 * MobileDecoratorMapper
 *
 * @author gdaley
 */
class MobileDecoratorMapper extends GrailsLayoutDecoratorMapper {
    public Decorator getDecorator(HttpServletRequest request, Page page) {
        MobileService mobileService = new MobileService()
        String viewSuffix = mobileService.isMobileUser(request) ? ".mobile" : ""
        Decorator decorator = super.getDecorator(request, page)
        if (null == decorator || decorator instanceof GrailsNoDecorator) {
            decorator = getNamedDecorator(request, "main" + viewSuffix)
        }
        else {
            String decoratorName = decorator.getName()
            decorator = getNamedDecorator(request, decoratorName + viewSuffix)
        }
 
        return decorator
    }
}
