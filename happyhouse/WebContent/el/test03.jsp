<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- 공유 --%>
<%
	pageContext.setAttribute("msg", "초롱초롱");
	request.setAttribute("name", "당신");
	request.setAttribute("msg", "request - 초롱초롱");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2> ${name}, ${msg}, ${requestScope.msg}</h2>
</body>
</html>