<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!-- (Author- Pratham Sharma) THis jsp file displays all the schemes in the DB and gives functionality to edit and delete schemes -->
<html>
<head>
<title>Insert title here</title>
</head>
<link rel='stylesheet' type='text/css' media='screen' href='style.css'>
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
<footer>
		<p>
			This site is developed by HSBC<br> <a
				href="mailto:hege@example.com">hsbc.co.in</a>
		</p>
	</footer>
</body>
</html>
