/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 8/1/2020 11:51 AM
 */

package com.slmora.learn.servlet.jspservlet.pack01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



/**
 * This Class created for Servlet with mapping /servletlearn01
 *
 * @Author: SLMORA
 * @DateTime: 8/1/2020 11:51 AM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          8/1/2020        SLMORA              Initial Code
 * 1.1          8/9/2020        SLMORA              Move to package com.slmora.learn.servlet.jspservlet.pack01 form com.slmora.learn.servlet
 *
 * 1.0
 * This will create for servlet starting testing
 * Used only doGet method with logger with0t removing super forwarding
 * Because of super(req, resp) will get 405 response code from client side
 *
 */
@WebServlet(
        description = "This is a simple servlet for ServletLearn01",
        urlPatterns = {"/servletlearn01"})
public class LearnServlet01 extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    static final Logger LOGGER = LogManager.getLogger(LearnServlet01.class);

    @Override
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse resp)
            throws
            ServletException,
            IOException
    {
        super.doGet(req, resp);
        LOGGER.info("Test doGet Method in LearnServlet01");
    }
}
