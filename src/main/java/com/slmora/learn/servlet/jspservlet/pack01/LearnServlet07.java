/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 8/16/2020 2:45 PM
 */
package com.slmora.learn.servlet.jspservlet.pack01;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * This Class created for Servlet with mapping /servletlearn07
 *
 * @Author: SLMORA
 * @DateTime: 8/16/2020 2:45 PM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          8/16/2020      SLMORA                Initial Code
 */
@WebServlet(
        description = "This is a simple servlet for ServletLearn07",
        urlPatterns = "/servletlearn07"
)
public class LearnServlet07 extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    static final Logger LOGGER = LogManager.getLogger(LearnServlet07.class);

    @Override
    protected void doPost(
            HttpServletRequest req,
            HttpServletResponse resp)
            throws
            ServletException,
            IOException
    {
//        super.doPost(req, resp);
        LOGGER.info("Test doPost Method in LearnServlet07");

        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();

        String firstName=req.getParameter("firstName");
        String lastName=req.getParameter("lastName");
        String userName=req.getParameter("username");

        if (!"".equals(userName) && null != userName){
            session.setAttribute("sessionUsername",userName);
        }

        out.println("<h1> Hi This is LearnServlet07</h1>");
        out.println("<hr>");
        out.println("<h3> First Name : "+firstName+"</h3>");
        out.println("<h3> Last Name : "+lastName+"</h3>");
        out.println("<h3> User Name : "+userName+"</h3>");
        out.println("<h3> Session User Name : "+session.getAttribute("sessionUsername")+"</h3>");

    }

}
