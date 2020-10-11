<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!-- (Author- Pratham Sharma) THis jsp file displays all the schemes in the DB and gives functionality to edit and delete schemes -->
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<%
if(session.getAttribute("empid")==null) {
	response.sendRedirect("employeelogin.html");
}
session.getAttribute("schemeList");
session.getAttribute("schemeCriteriaList");%>

<form action="LOGOUT">
		<input type="button" value="LOGOUT">
</form>
<table border="5">
	<tr>
		<th>Scheme ID</th>
		<th>Scheme Name</th>
		<th>Ministry</th>
		<th>Status</th>
		<th>Date</th>
		<th>Edit</th>
		<th>Delete</th>
	</tr>
	<c:forEach var="s" items="${schemeList}">
	<tr>
		<th>${s.uniqueId}</th>
		<th>${s.name}</th>
		<th>${s.ministry}</th>
		<th>${s.status}</th>
		<th>${s.date}</th>
		<th><a href="editScheme.jsp/id=${s.uniqueId}&empid=${empid}">update</a></th>
		<th><a href="EmployeeServlet/action=DELETE&id=${s.uniqueId}&empid=${empid}">DELETE</a></th>
	</tr>
	</c:forEach>
	
</table>

</body>
</html>
