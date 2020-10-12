<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.hsbc.controller.*"%>
<%@page import="java.util.*"%>

<!DOCTYPE html>
<html style="height: 100%;">
<head>
<meta charset='utf-8'>
<meta http-equiv='X-UA-Compatible' content='IE=edge'>
<title>Home page</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link rel='stylesheet' type='text/css' media='screen' href='style.css'>

</head>
<script>
		function go() {
			window.location
					.replace(
							"logout.jsp",
							'window',
							'toolbar=1,location=1,directories=1,status=1,menubar=1,scrollbars=1,resizable=1');
		}
	</script>
<body style="height: 100%;">

	<div class="sidebar">
		<hr>
		<a href="viewallschemes.html" class="active"> View Schemes</a>
		<hr>
	</div>

	<div class="topnav">
		<div class="topnav-left">
			<a href="Logo">Logo</a>
		</div>

		<a href="employeehome.html">Home</a> <a class="redirect" href="javascript:go()">Logout</a>

	</div>


	<div class="headName">
		<h2>All Available schemes</h2>
	</div>


	<div class="main">

		<%
		String citizenId = (String)session.getAttribute("citizenId");
		ApplySchemeDao dao = new ApplySchemeDao();
		List<Scheme> list = dao.getAllSchemes();
		pageContext.setAttribute("list", list);
		%>
		<table align="center"  border="1">
			<tr>
				<th>SchemeName</th>
				<th>Summary</th>
				<th>Desc</th>
				<th>Ministry</th>
				<th>Sector</th>
			</tr>
			<c:forEach items="${list}" var="l">
				<tr>
					<td>${l.name}</td>
					<td>${l.summary}</td>
					<td>${l.description}</td>
					<td>${l.ministry}</td>
					<td>${l.sector}</td>
					<td><a href="applyscheme.jsp?schemeId=${l.schemeId}">Apply</a></td>
				</tr>
			</c:forEach>
		</table>

	</div>

	<footer>
		<p>
			This site is developed by RuntimeTerror Team<br> <a
				href="mailto:hege@example.com">hsbc.co.in</a>
		</p>
	</footer>

</body>

</html>