package com.hsbc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hsbc.dao.CitizenDao;

public class ValidateCitizenServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		String citizenId = req.getParameter("uname");
		String password = req.getParameter("pass");

		CitizenDao dao = new CitizenDao();

		boolean flag = dao.validateCitizen(citizenId, password);

		if (flag == true) { 
			HttpSession session = req.getSession();
			session.setAttribute("citizenId", citizenId);
			RequestDispatcher dispatcher = req.getRequestDispatcher("viewallschemes.jsp");
			dispatcher.forward(req, resp);
		}
		else { 
			RequestDispatcher rd = req.getRequestDispatcher("citizenlogin.html");
			rd.forward(req, resp); 
		}


	}

}
