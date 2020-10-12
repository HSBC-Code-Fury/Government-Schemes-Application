<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.hsbc.controller.*"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<%
	
	String sid = (String)session.getAttribute("schemeId");
	String cid = (String)session.getAttribute("citizenId");
	System.out.println("hello from apply.jsp");
	System.out.println(cid + " " + sid);

	ApplySchemeDao dao = new ApplySchemeDao();
	if (dao.validateScheme(cid, sid)) {
	%>
	<jsp:forward page="eligible.html"></jsp:forward>
	<%
		} else {
	%>
	<jsp:forward page="noteligible.html"></jsp:forward>
	<%
		}
	%>
</body>
</html>