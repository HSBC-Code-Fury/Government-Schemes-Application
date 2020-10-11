<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<!-- (Author- Pratham Sharma) THis jsp file is the add scheme page where the form submits new values for the new scheme to the EmployeeServlet which then updates to the DB -->
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel='stylesheet' type='text/css' media='screen' href='style.css'>
</head>
<%
if(session.getAttribute("empid")==null) {
	response.sendRedirect("employeelogin.html");
}
%>
<body>
<div class="sidebar">
		<a href="addScheme.jsp">Add Schemes</a>
		<hr>
		<a href="ShowSchemes.jsp" class="active"> View Schemes</a>
		<hr>
	</div>

	<div class="topnav">
		<div class="topnav-left">
			<a href="Logo">Logo</a>
		</div>

		<a href="EmployeeHome.jsp">Home</a> 

	</div>
	<form action="LOGOUT">
		<input type="button" value="LOGOUT">
	</form>
	<form method="POST" action="employee">
	Unique ID: <input type="text" name="uniqueId">
	Name: <input type="text" name="name">
	Summary: <input type="text" name="summary">
	Description: <textarea rows="10" cols="10"></textarea>
	Ministry: <input type="text" name="ministry">
	Sector: <input type="text" name="sector">
	Start Date: <input type="text" name="startDate">
	Status: <input type="text" name="status">
	Payment Banks: <input type="text" name="paymentBanks">
	Eligibility criteria: <input type="text" name="minAge">
	                      <input type="text" name="maxAge">
	                      <input type="text" name="profession">
	                      <input type="text" name="incomemGroup">
	                      <input type="text" name="gender">
	Documents required: <input type="checkbox" id="adhaar" name="documents" >Adhaar Card
				 		<input type="checkbox" id="pan" name="documents">Pan Card
				  		<input type="checkbox" id="voterId" name="documents">Voter Id
				  		<input type="checkbox" id="residentialProof" name="documents">Residential Proof
	<input type="submit" value="Add Scheme" >
	</form>
	<footer>
		<p>
			This site is developed by HSBC<br> <a
				href="mailto:hege@example.com">hsbc.co.in</a>
		</p>
	</footer>
</body>
</html>
