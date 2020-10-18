/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 9/6/2020 5:50 PM
 */
package com.slmora.learn.servlet.jspservlet.login;

import com.slmora.learn.model.User;
import com.slmora.learn.service.jspservlet.LoginService2;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

/**
 * This Class created for Servlet with mapping /signin3
 *
 * @Author: SLMORA
 * @DateTime: 9/6/2020 5:50 PM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          9/6/2020      SLMORA                Initial Code
 */
@WebServlet(
        description = "This is a simple servlet for signin3",
        urlPatterns = "/signin3",
        initParams = {@WebInitParam(name="defaultUser", value="MORA")}
)
public class LoginServlet3 extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    static final Logger LOGGER = LogManager.getLogger(LoginServlet3.class);

    @Override
    protected void doPost(
            HttpServletRequest req,
            HttpServletResponse resp)
            throws
            ServletException,
            IOException
    {
//        super.doPost(req, resp);
        LOGGER.info("Test doPost Method in LoginServlet3");

        PrintWriter out = resp.getWriter();


        String userId=req.getParameter("userId");
        String password=req.getParameter("password");

        LoginService2 loginService = new LoginService2();

        out.println("<h1> Hi This is LoginServlet</h1>");
        out.println("<hr>");

        try{
            Optional<User> logingUser = loginService.authenticateUser(userId,password);
            if(logingUser.isPresent()){
                HttpSession session = req.getSession();
                ServletContext context = req.getServletContext();
                session.setAttribute("user",logingUser.get());
                context.setAttribute("defaultUser",this.getInitParameter("defaultUser"));
//                resp.sendRedirect("views/login_dashboard2.jsp");
                req.setAttribute("log",true);
                RequestDispatcher dispatcher = req.getRequestDispatcher("views/servlet_jsp/login_dashboard2.jsp");
                dispatcher.forward(req,resp);
                return;
            }else{
                resp.sendRedirect("views/servlet_jsp/login3.jsp");
                return;
            }
        }catch (Exception ex){
            LOGGER.error(ExceptionUtils.getFullStackTrace(ex));
            out.println("<h3> Something went wrong in Authentication process</h3>");
        }


    }

}
