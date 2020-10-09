<%@page import="com.hsbc.governmentschemes.dao.EmployeeDaoImpl" %>
<%@page import="com.hsbc.governmentschemes.model.Scheme" %>
<!DOCTYPE html>
<!-- (Author- Pratham Sharma) THis jsp file is the edit scheme page where the form submits new values for the scheme to the EmployeeServlet which then updates to the DB -->
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%
if(session.getAttribute("empid")==null) {
	response.sendRedirect("employeelogin.html");
}

request.getAttribute("schemeList");
EmployeeDaoImpl dao = new EmployeeDaoImpl();
String id = request.getParameter("uniqueId");
Scheme s = dao.getSchemeById(id);
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
		Payment Banks: <input type="text" name="paymentBanks" value="<% s.getPaymentBanks();%>">
		<input type="submit" value="Edit Scheme" >
	</form>
</body>
</html>