package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;

public class ServletWithoutAnnotation extends HttpServlet {
    public static final String NO_ANNOTATION_SERVLET_NAME = "NoAnnotation";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.printf("CUSTOM_SERVLET_TWO:  doGet; time:" + LocalTime.now() + "\n");
        resp.setStatus(322);

        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<h1>Servlet [Get] : This URL has been added to mapping!</h1>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.printf("CUSTOM_SERVLET_TWO:  doPost; time:" + LocalTime.now() + "\n");
        super.doPost(req, resp);
    }
}
