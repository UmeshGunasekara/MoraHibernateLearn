/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 10/18/2020 1:01 PM
 */
package com.slmora.learn.servlet.hibernate;

import com.slmora.learn.dto.jdbc.SBUser01Dto;
import com.slmora.learn.service.jdbc.SBUser01Service01;
import com.slmora.learn.service.jdbc.impl.SBUser01Service01Impl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * This Class created for
 *
 * @Author: SLMORA
 * @DateTime: 10/18/2020 1:01 PM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          10/18/2020      SLMORA                Initial Code
 */
@WebServlet(
        description = "This is a simple servlet for JDBC test Learn Hibernate Servlet 01",
        urlPatterns = "/hibernatelearnservlet02")
public class LearnHibernateServlet02 extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    static final Logger LOGGER = LogManager.getLogger(LearnHibernateServlet02.class);

    @Override
    protected void doPost(
            HttpServletRequest req,
            HttpServletResponse resp)
            throws
            ServletException,
            IOException
    {
//        super.doPost(req, resp);
        LOGGER.info("Test doPost Method in LearnHibernateServlet02");

        PrintWriter out = resp.getWriter();
        SBUser01Service01 sbUser01Service01 =  new SBUser01Service01Impl();

        String firstName=req.getParameter("firstName");
        String lastName=req.getParameter("lastName");
        String userName=req.getParameter("userName");
        String email=req.getParameter("email");
        String address=req.getParameter("address");
        String country=req.getParameter("country");
        String zip=req.getParameter("zip");
        String state=req.getParameter("state");

        SBUser01Dto user01 = SBUser01Dto.of(
                firstName,
                lastName,
                firstName+" "+lastName,
                userName,
                email,
                address,
                country,
                state,
                zip);

        String sbUserId = sbUser01Service01.addSBUser01FromSBUser01Dto(user01).toString();

        req.setAttribute("sbUserId", sbUserId);
        RequestDispatcher dispatcher = req.getRequestDispatcher("views/hibernate/jdbc_add_sbuser01.jsp");
        dispatcher.forward(req,resp);
        return;

    }

}
