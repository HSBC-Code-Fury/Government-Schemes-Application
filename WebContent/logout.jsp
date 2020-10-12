<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logout Success</title>
</head>
<body>
	<%
		session.invalidate();
		response.setHeader("Cache-Control", "no-store");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0"); 
	%>
	<jsp:forward page="Home.html"></jsp:forward>
</body>
</html>