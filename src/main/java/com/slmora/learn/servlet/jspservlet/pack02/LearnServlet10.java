/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 9/3/2020 6:43 AM
 */
package com.slmora.learn.servlet.jspservlet.pack02;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * This Class created for Servlet with mapping /servletlearn10
 *
 * @Author: SLMORA
 * @DateTime: 9/3/2020 6:43 AM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          9/3/2020      SLMORA                Initial Code
 */
public class LearnServlet10 extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    static final Logger LOGGER = LogManager.getLogger(LearnServlet10.class);

    @Override
    protected void doPost(
            HttpServletRequest req,
            HttpServletResponse resp)
            throws
            ServletException,
            IOException
    {
//        super.doPost(req, resp);
        LOGGER.info("Test doPost Method in LearnServlet10");

        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();
        ServletContext context = req.getServletContext();

        String firstName=req.getParameter("firstName");
        String lastName=req.getParameter("lastName");
        String userName=req.getParameter("username");

        if (!"".equals(userName) && null != userName){
            session.setAttribute("sessionUsername",userName);
            context.setAttribute("contextUsername",userName);
        }

        out.println("<h1> Hi This is LearnServlet10</h1>");
        out.println("<hr>");
        out.println("<h3> First Name : "+firstName+"</h3>");
        out.println("<h3> Last Name : "+lastName+"</h3>");
        out.println("<h3> User Name : "+userName+"</h3>");
        out.println("<h3> Session User Name : "+session.getAttribute("sessionUsername")+"</h3>");
        out.println("<h3> Context User Name : "+context.getAttribute("contextUsername")+"</h3>");
//        out.println("<h3> Servlet Config Init User Name : "+this.getServletConfig().getInitParameter("defaultUser")+"</h3>");
        out.println("<h3> Servlet Config Init User Name : "+this.getInitParameter("defaultUser")+"</h3>");

    }
}
