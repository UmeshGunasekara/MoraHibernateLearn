/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 8/9/2020 7:23 PM
 */
package com.slmora.learn.servlet.jspservlet.pack01;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

/**
 * This Class created for Servlet with mapping /servletlearn06
 *
 * @Author: SLMORA
 * @DateTime: 8/9/2020 7:23 PM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          8/9/2020        SLMORA              Initial Code
 * 1.1          8/16/2020       SLMORA              Added doPostContent
 */
@WebServlet(
        description = "This is a simple servlet for ServletLearn06",
        urlPatterns = "/servletlearn06")
public class LearnServlet06 extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    static final Logger LOGGER = LogManager.getLogger(LearnServlet06.class);

    @Override
    protected void doPost(
            HttpServletRequest req,
            HttpServletResponse resp)
            throws
            ServletException,
            IOException
    {
//        super.doPost(req, resp);
        LOGGER.info("Test doPost Method in LearnServlet06");

        PrintWriter out = resp.getWriter();

        String firstName=req.getParameter("firstName");
        String lastName=req.getParameter("lastName");
        String userName=req.getParameter("username");
        String email=req.getParameter("email");
        String address=req.getParameter("address");
        String country=req.getParameter("country");
        String zip=req.getParameter("zip");
        String sameaddress=req.getParameter("sameaddress");
        String saveinfo=req.getParameter("saveinfo");
        String paymentMethod=req.getParameter("paymentMethod");
        String ccname=req.getParameter("ccname");
        String ccnumber=req.getParameter("ccnumber");
        String ccexpiration=req.getParameter("ccexpiration");
        String cccvv=req.getParameter("cccvv");
        List<String> state = null;
        try {
            state= Arrays.asList(req.getParameterValues("state"));
        }catch (NullPointerException ex){
            state = Arrays.asList("No state data");
        }

        out.println("<h1> Hi This is LearnServlet06</h1>");
        out.println("<hr>");
        out.println("<h3> First Name : "+firstName+"</h3>");
        out.println("<h3> Last Name : "+lastName+"</h3>");
        out.println("<h3> User Name : "+userName+"</h3>");
        out.println("<h3> Adderess : "+address+"</h3>");
        out.println("<h3> Email : "+email+"</h3>");
        out.println("<h3> Country : "+country+"</h3>");
        out.println("<h3> Zip Code : "+zip+"</h3>");
        out.println("<h3> States : </h3>");
        state.forEach(s->out.print("<h3>"+s+"</h3>"));
        out.println("<h3> Is shipping address is the same as my billing address : "+sameaddress+"</h3>");
//        out.println("</h3>");
        out.println("<h3> Save this information for next time : "+saveinfo+"</h3>");
        out.println("<h3> Payment Method : "+paymentMethod+"</h3>");
        out.println("<h3> Name on card : "+ccname+"</h3>");
        out.println("<h3> Credit card number : "+ccnumber+"</h3>");
        out.println("<h3> Credit card expiration : "+ccexpiration+"</h3>");
        out.println("<h3> Credit card CVV : "+cccvv+"</h3>");


    }

}
