package listener;

import servlet.ServletWithoutAnnotation;

import javax.servlet.ServletRegistration;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.stream.Collectors;

@WebListener
public class CustomServletRequestListener implements ServletRequestListener {


    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        System.out.println("SERVLET_REQUEST_LISTENER: requestDestroyed");
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        String requestURI = ((HttpServletRequest) servletRequestEvent.getServletRequest()).getRequestURI();
        System.out.println("SERVLET_REQUEST_LISTENER: requestInitialized, uri: " + requestURI);

        ServletRegistration servletRegistration =
                servletRequestEvent.getServletContext().getServletRegistration(ServletWithoutAnnotation.NO_ANNOTATION_SERVLET_NAME);

        //----- mapping of this new servlet
        Collection<String> servletMapping = servletRegistration.getMappings();
        System.out.println("SERVLET_REQUEST_LISTENER: new servlet's mapping : " +
                servletMapping.stream().collect(Collectors.joining(", ")));

        if(!servletMapping.contains(requestURI))
        {
            servletRegistration.addMapping(requestURI);
            System.out.println("SERVLET_CONTEXT_LISTENER: add uri to servlet mapping");
        }

    }
}
