package com.hsbc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.SessionCookieConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ApplyCitizenServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		HttpSession session = req.getSession();
		
		System.out.println(session.getAttribute("citizenId"));
		
		RequestDispatcher rd = req.getRequestDispatcher("Logout");
		/*
		 * String citizenId = req.getParameter("citizenId"); String bank =
		 * req.getParameter("selectbox"); String accountNumber =
		 * req.getParameter("ACCNO"); //String dateOfBirth = req.getParameter("Bank");
		 * String accType = req.getParameter("Type"); String branch =
		 * req.getParameter("Branch"); String ifscCode = req.getParameter("IFSC");
		 * 
		 * CitizenDao dao = new CitizenDao();
		 * 
		 * dao.applyScheme(citizenDetails);
		 * 
		 * RequestDispatcher rd = req.getRequestDispatcher("CitizenLogin.html");
		 * rd.forward(req, resp);
		 */
	}
	
}	
