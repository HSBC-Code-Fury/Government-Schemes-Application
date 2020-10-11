
<!DOCTYPE html>
<html>
<head>
<!-- (Author- Pratham Sharma) THis jsp file is the Employee home page after successful login and provides links  to add schemes and display schemes also gives a logout button -->
<title>Employee Home</title>
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
<%session.getAttribute("empid"); %>
<body>
	<h2>Welcome Employee</h2>
	<a href="addScheme.jsp?empid=${empid}">Add Scheme</a><br>
	<a href="ShowSchemes.jsp?empid=${empid}">View All Schemes</a>
	<form action="LOGOUT">
		<input type="button" value="LOGOUT">
	</form>
</body>
<footer>
		<p>
			This site is developed by HSBC<br> <a
				href="mailto:hege@example.com">hsbc.co.in</a>
		</p>
</footer>
</html>
