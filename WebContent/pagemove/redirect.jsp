<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%
	String msg = (String)request.getAttribute("msg");	//object로 반환하는거 String으로 형변환해서 받아준거
	Date date = (Date)request.getAttribute("dDay");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>redirect 된 페이지</h2>
	<h3>msg : <%= msg %></h3>
	<h3>date : <%= date %></h3>
</body>
</html>