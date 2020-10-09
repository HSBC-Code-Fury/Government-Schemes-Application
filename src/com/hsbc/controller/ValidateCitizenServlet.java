package com.hsbc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ValidateCitizenServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String username = req.getParameter("uname");
		String password = req.getParameter("pass");
		
		CitizenDao dao = new CitizenDao();
		boolean flag = dao.validateCitizen(username,password);
		
		if(flag == true) {
			RequestDispatcher rd = req.getRequestDispatcher("nextpage.html");
			rd.forward(req, resp);
		}
		else {
			RequestDispatcher rd = req.getRequestDispatcher("CitizenLogin.html");
			rd.forward(req, resp);
		}
	}
	
}
