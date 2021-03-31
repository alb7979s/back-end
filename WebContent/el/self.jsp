<%@page import="java.util.ArrayList"%>
<%@page import="com.coffee.el.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//여기 작성
	List<User> list = new ArrayList<>();
	User user = new User();
	user.setName("짝짝짝");
	list.add(user);
	request.setAttribute("list", list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 실행시 화면에 "짝짝짝"이 뜨도록 코드 작성 --%>
	${list[0].name}
	
</body>
</html>