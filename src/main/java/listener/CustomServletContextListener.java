package listener;

import servlet.ServletWithoutAnnotation;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebListener;
import java.util.Map;
import java.util.stream.Collectors;

@WebListener
public class CustomServletContextListener implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("SERVLET_CONTEXT_LISTENER: contextInitialized");

        //----- registration new servlet
        ServletContext servletContext = servletContextEvent.getServletContext();
        ServletRegistration servletRegistration = servletContext.getServletRegistrations()
                .get(ServletWithoutAnnotation.NO_ANNOTATION_SERVLET_NAME);
        if(servletRegistration == null){
            servletContext.addServlet(ServletWithoutAnnotation.NO_ANNOTATION_SERVLET_NAME, ServletWithoutAnnotation.class);
            System.out.println("SERVLET_CONTEXT_LISTENER: servlet has been added");
        }

        //----- servlet registrations map
        Map<String, ? extends ServletRegistration> servletRegistrationsMap = servletContext.getServletRegistrations();
        System.out.println("SERVLET_CONTEXT_LISTENER: registered servlets - " +
                servletRegistrationsMap.entrySet().stream().map(Map.Entry::getKey).collect(Collectors.joining(", ")));


        /*
        About servlets initialization:
        The facility to add servlets is provided during servlet context initialization. Given that it is impossible
        to add new servlets at runtime i.e. anytime after the Servlet Context is initialised, you should add the correct
        set of servlets during the servlet context initialization.
        */
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("SERVLET_CONTEXT_LISTENER: contextDestroyed");
    }
}
