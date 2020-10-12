<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		String cid = (String)request.getAttribute("citizenId");
		out.print("<h2>Your CitizenId is "+cid+"</h2>");
		out.print("<h2 style=color:red>Save this for future reference</h2>");
		
	%>
	<h3><a href="citizenlogin.html">Go to Login Page</a></h3>
</body>
</html>