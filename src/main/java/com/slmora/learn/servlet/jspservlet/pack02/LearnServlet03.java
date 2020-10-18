/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 8/9/2020 3:11 PM
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
 * This Class created for Servlet with mapping /servletlearn03
 *
 * @Author: SLMORA
 * @DateTime: 8/9/2020 3:11 PM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          8/9/2020        SLMORA              Initial Code
 *
 * 1.0
 * for this servlet configuration will come from deployment descriptor web.xml
 *
 */
public class LearnServlet03 extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    static final Logger LOGGER = LogManager.getLogger(LearnServlet03.class);

    @Override
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse resp)
            throws
            ServletException,
            IOException
    {
//        super.doGet(req, resp);
        LOGGER.info("Test doGet Method in LearnServlet03");

        PrintWriter out = resp.getWriter();

        out.println("<h1> Hi This is LearnServlet03 </h1>");
    }
}
