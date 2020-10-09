/*
 * @Author Pratham Sharma
 * 
 * Class- EmployeeServlet is the controller class which overrides three methods doPost, doGet, doDelete 
 * 
 * Each Method has session scoped session variable to validate if the employee is in the session or not
 * 
 * They also use EmployeeDao business logic methods to execute the request from the employee 
 * 
 * 	
 */
package com.hsbc.governmentschemes.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hsbc.governmentschemes.dao.EmployeeDaoImpl;
import com.hsbc.governmentschemes.model.Scheme;

import java.util.Date;
import java.util.List;

public class EmployeeServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		if(req.getParameter("action")=="LOGOUT") {
			HttpSession session = req.getSession();
			session.invalidate();
		}
		
		EmployeeDaoImpl dao = new EmployeeDaoImpl();
		String username=req.getParameter("uname");
		String password = req.getParameter("pass");
		int valid = dao.validateEmployeeDetails(username, password);
		if(valid==1) {
			List<Scheme> s = dao.displayAllSchemes();
			req.setAttribute("schemeList", s);
			HttpSession session2 = req.getSession();
			session2.setAttribute("empid", username);
			RequestDispatcher rd = req.getRequestDispatcher("ShowSchemes.jsp");
			rd.forward(req, resp);
		}
		else {
			RequestDispatcher rd = req.getRequestDispatcher("EmployeeLogin.html");
			rd.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=null;
		if(session.getAttribute("empid")==null) {
			resp.sendRedirect("employeelogin.html");
		}
		resp.setContentType("text/html");
		EmployeeDaoImpl dao = new EmployeeDaoImpl();
		String action=req.getParameter("action");
		if(action=="EDIT") {
			String uniqueId =req.getParameter("uniqueId");
			String name =req.getParameter("name");
			String summary =req.getParameter("summary");
			String description =req.getParameter("description");
			String ministry =req.getParameter("ministry");
			String sector =req.getParameter("sector");
			String date = req.getParameter("startDate");
			String status = req.getParameter("status");
			String paymentBanks = req.getParameter("paymentBanks");
			Date convDate=null;
			try {
				 convDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dao.editScheme(new Scheme(uniqueId, name, summary, description, ministry, sector, convDate, status, paymentBanks));
		}
		
		
		String uniqueId =req.getParameter("uniqueId");
		String name =req.getParameter("name");
		String summary =req.getParameter("summary");
		String description =req.getParameter("description");
		String ministry =req.getParameter("ministry");
		String sector =req.getParameter("sector");
		String date = req.getParameter("startDate");
		String status = req.getParameter("status");
		String paymentBanks = req.getParameter("paymentBanks");
		Date convDate=null;
		try {
			 convDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dao.addScheme(new Scheme(uniqueId, name, summary, description, ministry, sector, convDate, status, paymentBanks));
		RequestDispatcher rd = req.getRequestDispatcher("ShowSchemes.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=null;
		if(session.getAttribute("empid")==null) {
			resp.sendRedirect("employeelogin.html");
		}
		EmployeeDaoImpl dao = new EmployeeDaoImpl();
		String id = req.getParameter("uniqueId");
		RequestDispatcher rd = req.getRequestDispatcher("ShowSchemes.jsp");
		rd.forward(req, resp);
	}
	
	
	
}
