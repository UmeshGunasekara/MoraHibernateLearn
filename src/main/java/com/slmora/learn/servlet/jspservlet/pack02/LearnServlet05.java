/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 8/9/2020 5:36 PM
 */
package com.slmora.learn.servlet.jspservlet.pack02;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * This Class created for Servlet with mapping /servletlearn05
 *
 * @Author: SLMORA
 * @DateTime: 8/9/2020 5:36 PM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          8/9/2020        SLMORA              Initial Code
 */
public class LearnServlet05 extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    static final Logger LOGGER = LogManager.getLogger(LearnServlet05.class);

    @Override
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse resp)
            throws
            ServletException,
            IOException
    {
//        super.doPost(req, resp);
        LOGGER.info("Test doGet Method in LearnServlet04");

        PrintWriter out = resp.getWriter();

        out.println("<h1> Hi This is LearnServlet04</h1>");
    }

    @Override
    protected void doPost(
            HttpServletRequest req,
            HttpServletResponse resp)
            throws
            ServletException,
            IOException
    {
//        super.doPost(req, resp);
        LOGGER.info("Test doPost Method in LearnServlet05");

        PrintWriter out = resp.getWriter();

        String firstName=req.getParameter("firstName");
        String lastName=req.getParameter("lastName");

        out.println("<h1> Hi This is LearnServlet04</h1>");
        out.println("<hr>");
        out.println("<h3> First Name : "+firstName+"</h3>");
        out.println("<h3> Last Name : "+lastName+"</h3>");
    }
}
