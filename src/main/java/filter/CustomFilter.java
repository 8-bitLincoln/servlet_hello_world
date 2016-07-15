package filter;

import javax.servlet.*;
import java.io.IOException;

public class CustomFilter implements Filter {

    String usedInDoFilter;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        usedInDoFilter = "New String Here";
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("FILTER : doFilter");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        usedInDoFilter = null;
    }
}
