package test.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;


public class WebAppInitializer implements WebApplicationInitializer {
 
    private static final String DISPATCHER_SERVLET_NAME = "mainservlet";
 
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(WebAppConfig.class);
        context.register(SecurityConfig.class);
        ContextLoaderListener listener = new ContextLoaderListener(context);
        servletContext.addListener(listener);
        DelegatingFilterProxy filter = new DelegatingFilterProxy("springSecurityFilterChain");
        servletContext.addFilter("springSecurityFilterChain", filter).addMappingForUrlPatterns(null, false, "/*");
        context.setServletContext(servletContext);
        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);
        ServletRegistration.Dynamic servlet = servletContext.addServlet(DISPATCHER_SERVLET_NAME, dispatcherServlet);
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
    }
}