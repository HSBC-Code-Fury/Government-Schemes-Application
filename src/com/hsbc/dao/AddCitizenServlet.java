package com.hsbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddCitizenServlet extends HttpServlet {

	final AtomicInteger count = new AtomicInteger(0);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		int temp = count.incrementAndGet();
		String uniqueId = "CITI" + temp;
		String name = req.getParameter("citFullName");
		String dateOfBirth = req.getParameter("citiDob");
		String gender = req.getParameter("citGender");
		String emailId = req.getParameter("citEmail");
		String phoneNumber = req.getParameter("citPhone");
		String address = req.getParameter("citAddress");
		String incomeGroup = req.getParameter("citIncomeGroup");
		String profession = req.getParameter("citProfession");
		String aadharId = req.getParameter("citAadhar");
		String panNumber = req.getParameter("citPanNumber");

		Citizen citizenDetails = new Citizen(uniqueId, name, dateOfBirth, gender, emailId, phoneNumber, address,
				incomeGroup, profession, aadharId, panNumber);
		
		String password = req.getParameter("citPassword");

		CitizenDao dao = new CitizenDao();
		dao.addCitizen(citizenDetails,password);

		RequestDispatcher rd = req.getRequestDispatcher("CitizenLogin.html");
		rd.forward(req, resp);
	}

}