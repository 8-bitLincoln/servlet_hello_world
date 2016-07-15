package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.Enumeration;

public class CustomServletTwo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.printf("CUSTOM_SERVLET_TWO:  doGet; time:" + LocalTime.now() + "\n");
        resp.setStatus(322);

        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<h1>Hello Custom Servlet Two [Get]</h1>");

        Enumeration<String> headerNames = req.getHeaderNames();
        while(headerNames.hasMoreElements())
        {
            String name = headerNames.nextElement();
            out.println(name + " : " + req.getHeader(name) + "<p>");
        }

        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.printf("CUSTOM_SERVLET_TWO:  doPost; time:" + LocalTime.now() + "\n");
        super.doPost(req, resp);
    }
}
