/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 8/1/2020 1:14 PM
 */

package com.slmora.learn.servlet.jspservlet.pack01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This Class created for Servlet with mapping /servletlearn02
 *
 * @Author: SLMORA
 * @DateTime: 8/1/2020 1:14 PM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          8/1/2020        SLMORA              Initial Code
 * 1.1          8/9/2020        SLMORA              Move to package com.slmora.learn.servlet.jspservlet.pack01 form com.slmora.learn.servlet
 *
 * 1.0
 * To ignore super forwarding comment the super.doGet(req, resp);
 * then Server will response with doGet method body
 *
 */
@WebServlet(
        description = "This is a simple servlet for ServletLearn02",
        urlPatterns = "/servletlearn02")
public class LearnServlet02 extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    static final Logger LOGGER = LogManager.getLogger(LearnServlet02.class);

    @Override
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse resp)
            throws
            ServletException,
            IOException
    {
//        super.doGet(req, resp);
        LOGGER.info("Test doGet Method in LearnServlet02");

        PrintWriter out = resp.getWriter();

        out.println("<h1> Hi This is LearnServlet02 </h1>");
    }
}