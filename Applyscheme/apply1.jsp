<%@page import="java.util.List"%>
<%@page import="com.govt.applyscheme.ApplySchemeDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<!-- This is a dummy applycscheme form -->
<body>
<%
	ApplySchemeDao dao=new ApplySchemeDao();
	List<String> list=dao.getAllSchemes();
	pageContext.setAttribute("list",list);

%>


<form action="apply">
<label class="labelClass">Select Scheme Id</label><select name="sid" id="sid">
<c:forEach items="${list}" var="val">
<option value="${val}">${val}</option>
</c:forEach>
</select>

<input type=submit value=submit>
</form>
</body>
</html>