package servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;

public class CustomServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.printf("CUSTOM_SERVLET:  doGet; time:" + LocalTime.now() + "\n");

        //present to session listener
        HttpSession session = req.getSession();
        session.invalidate();

        URL url = new URL("localchost");
        url.openConnection();
        url.openStream();
    }

    @Override
    protected long getLastModified(HttpServletRequest req) {
        System.out.printf("CUSTOM_SERVLET:  getLastModified; time:" + LocalTime.now() + "\n");
        return super.getLastModified(req);
    }

    @Override
    protected void doHead(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.printf("CUSTOM_SERVLET:  doHead; time:" + LocalTime.now() + "\n");
        super.doHead(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.printf("CUSTOM_SERVLET:  doPost; time:" + LocalTime.now() + "\n");
        super.doPost(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.printf("CUSTOM_SERVLET:  doPut; time:" + LocalTime.now() + "\n");
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.printf("CUSTOM_SERVLET:  doDelete; time:" + LocalTime.now() + "\n");
        super.doDelete(req, resp);
    }

    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.printf("CUSTOM_SERVLET:  doOptions; time:" + LocalTime.now() + "\n");
        super.doOptions(req, resp);
    }

    @Override
    protected void doTrace(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.printf("CUSTOM_SERVLET:  doTrace; time:" + LocalTime.now() + "\n");
        super.doTrace(req, resp);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.printf("CUSTOM_SERVLET:  service(HttpServletRequest); time:" + LocalTime.now() + "\n");
        super.service(req, resp);
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.printf("CUSTOM_SERVLET:  service(ServletRequest); time:" + LocalTime.now() + "\n");
        super.service(req, res);
    }
}
