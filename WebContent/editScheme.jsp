<%@page import="com.hsbc.governmentschemes.dao.EmployeeDaoImpl" %>
<%@page import="com.hsbc.governmentschemes.model.Scheme" %>
<%@page import="com.hsbc.governmentschemes.model.SchemeCriteria" %>
<!DOCTYPE html>
<!-- (Author- Pratham Sharma) THis jsp file is the edit scheme page where the form submits new values for the scheme to the EmployeeServlet which then updates to the DB -->
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel='stylesheet' type='text/css' media='screen' href='style.css'>
</head>
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
<%
if(session.getAttribute("empid")==null) {
	response.sendRedirect("employeelogin.html");
}

session.getAttribute("schemeList");
session.getAttribute("schemeCriteriaList");
EmployeeDaoImpl dao = new EmployeeDaoImpl();
String id = request.getParameter("uniqueId");
Scheme s = dao.getSchemeById(id);
SchemeCriteria sc = dao.getSchemeCriteriaById(id);
%>
<body>
	<form action="LOGOUT">
			<input type="button" value="LOGOUT">
	</form>
	
	<form method="POST" action="EDIT">
		Unique ID: <input type="text" name="uniqueId" value="<% s.getUniqueId();%>">
		Name: <input type="text" name="name" value="<% s.getName();%>">
		Summary: <input type="text" name="summary" value="<% s.getSummary();%>">
		Description: <textarea rows="10" cols="10" name="description"> <% s.getDescription();%></textarea>
		Ministry: <input type="text" name="ministry"  value="<% s.getMinistry();%>">
		Sector: <input type="text" name="sector" value="<% s.getSector();%>">
		Start Date: <input type="text" name="startDate" value="<% s.getStartDate();%>">
		Status: <input type="text" name="status" value="<% s.getStatus();%>">
		Eligibility criteria: <input type="text" name="minAge" value="<% sc.getMinAge();%>">
	                      <input type="text" name="maxAge" value="<% sc.getMaxAge();%>">
	                      <input type="text" name="profession" value="<% sc.getProfession();%>">
	                      <input type="text" name="incomemGroup" value="<% sc.getIncomeGroup();%>">
	                      <input type="text" name="gender">
		Re-Select Documents required: <input type="checkbox" id="adhaar" name="adhaar" >Adhaar Card
				 			<input type="checkbox" id="pan" name="pan">Pan Card
				  			<input type="checkbox" id="voterId" name="voterId">Voter Id
				  			<input type="checkbox" id="residentialProof" name="residentialProof">Residential Proof
		Payment Banks: <input type="text" name="paymentBanks" value="<% s.getPaymentBanks();%>">
		<input type="submit" value="Edit Scheme" >
	</form>
	<footer>
		<p>
			This site is developed by HSBC<br> <a
				href="mailto:hege@example.com">hsbc.co.in</a>
		</p>
	</footer>
</body>
</html>
