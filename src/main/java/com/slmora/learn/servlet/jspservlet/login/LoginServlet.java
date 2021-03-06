/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 9/5/2020 10:08 PM
 */
package com.slmora.learn.servlet.jspservlet.login;

import com.slmora.learn.service.jspservlet.LoginService;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * This Class created for Servlet with mapping /signin
 *
 * @Author: SLMORA
 * @DateTime: 9/5/2020 10:08 PM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          9/5/2020      SLMORA                Initial Code
 */
@WebServlet(
        description = "This is a simple servlet for signin",
        urlPatterns = "/signin",
        initParams = {@WebInitParam(name="defaultUser", value="MORA")}
)
public class LoginServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    static final Logger LOGGER = LogManager.getLogger(LoginServlet.class);

    @Override
    protected void doPost(
            HttpServletRequest req,
            HttpServletResponse resp)
            throws
            ServletException,
            IOException
    {
//        super.doPost(req, resp);
        LOGGER.info("Test doPost Method in LoginServlet");

        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();

        String userId=req.getParameter("userId");
        String password=req.getParameter("password");

        if (!"".equals(userId) && null != userId){
            session.setAttribute("userId",userId);
        }

        LoginService loginService = new LoginService();

        out.println("<h1> Hi This is LoginServlet</h1>");
        out.println("<hr>");
        try{
            if(loginService.authenticateUser(userId,password)){
                out.println("<h3> User "+userId+" Successfully Login</h3>");
                out.println("<h3> Session User Name : "+session.getAttribute("userId")+"</h3>");
                out.println("<h3> Servlet Config Init User Name : "+this.getInitParameter("defaultUser")+"</h3>");
            }else{
                out.println("<h3> User "+userId+" authenticate not success</h3>");
                out.println("<h3> Servlet Config Init User Name : "+this.getInitParameter("defaultUser")+"</h3>");
            }
        }catch (Exception ex){
            LOGGER.error(ExceptionUtils.getFullStackTrace(ex));
            out.println("<h3> Something went wrong in Authentication process</h3>");
        }


    }

}