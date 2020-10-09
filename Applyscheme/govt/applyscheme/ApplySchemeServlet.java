package com.govt.applyscheme;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ApplySchemeServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		String sid=req.getParameter("sid");
		
		ApplySchemeDao dao=new ApplySchemeDao();
		System.out.println(sid);
		
		try {
			System.out.println(dao.validateScheme("citi3",sid));
			if(dao.validateScheme("citi2",sid))
				{
					RequestDispatcher rd=req.getRequestDispatcher("valid.html");
					rd.forward(req, resp);
				}
			else {
				RequestDispatcher rd=req.getRequestDispatcher("Invalid.html");
				rd.forward(req, resp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
