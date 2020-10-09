<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<!-- (Author- Pratham Sharma) THis jsp file is the add scheme page where the form submits new values for the new scheme to the EmployeeServlet which then updates to the DB -->
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%
if(session.getAttribute("empid")==null) {
	response.sendRedirect("employeelogin.html");
}
%>
<body>
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
	<input type="submit" value="Add Scheme" >
	</form>
</body>
</html>