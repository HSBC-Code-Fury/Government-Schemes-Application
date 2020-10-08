package com.hsbc.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CitizenController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String str = req.getHeader("Referer");
		String[] header = str.split("/");
		int length=header.length-1;
		System.out.println(header[length]);
		if(header[length].equals("Login.html")) {
			RequestDispatcher rd = req.getRequestDispatcher("First.jsp"); //Redirect to another page
			rd.forward(req, resp);
		}
		else {
			RequestDispatcher rd = req.getRequestDispatcher("First2.jsp");//Redirect where required
			rd.forward(req, resp);
		}
		
		/*
		 * int header = Integer.parseInt(req.getParameter("prodId"));
		 * System.out.println(header);
		 */
		/*
		 * if(header == 123) { RequestDispatcher rd =
		 * req.getRequestDispatcher("First.jsp"); rd.forward(req, resp); } else {
		 * RequestDispatcher rd = req.getRequestDispatcher("First2.jsp");
		 * rd.forward(req, resp); }
		 */
		/*
		 * String header = req.getServletPath(); System.out.println(header);
		 */
		 
		
		
		
		/*
		 * Enumeration e = req.getHeaderNames(); while(e.hasMoreElements()) { String
		 * temp = (String) e.nextElement(); System.out.println(temp); }
		 */
		 
				
	}
	
}
