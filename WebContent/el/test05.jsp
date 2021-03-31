<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String sArr[] = {"메가", "스벅", "빽다방"};
	request.setAttribute("shop", sArr);		//공유
	
	List<String> list = Arrays.asList("메가", "스벅", "빽다방");
	request.setAttribute("shop2", list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>${shop}</div>
	<div>${shop[0]} - ${shop[2]}</div>
	
	<div>${shop2}</div>
	<div>${shop2[0]} - ${shop2[2]}</div>		<%-- shop2.get(0), shop2.get(2) --%>
</body>
</html>