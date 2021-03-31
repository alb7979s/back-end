<%@page import="com.coffee.el.User"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	// 일반적으로 map은 ajax에서만 쓰고, el에선 잘 안씀
	Map<String, String> map = new HashMap<>();
	map.put("id", "d");
	map.put("name", "ㄷ");
	request.setAttribute("user", map);
	
	// vo 객체 사용하면, 하나의 맵은 하나의 vo로 표현 가능
	User user = new User();
	user.setId("d");
	user.setName("대전");
	request.setAttribute("user2", user);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- target 잘 안씀, jstl - 01 var때 헷갈려해서 참조만 하라고
		<c:set target="${user2} property="name" value="타겟을 통한 이름 설정"/>	
	--%>
	<div>${user}</div>		<%-- map객체 toString() 된거 출력됨 --%>
	<div>${user.id}</div>
	<div>${user["name"]}</div>
	
	<div>${user2}</div>		<%-- user객체 toString() 된거 출력됨 --%>
	<div>${user2.id}</div>
	<div>${user2["name"]}</div>
	
	<%-- 2.2부터 이렇게 메서드로 바로 호출도 가능해짐 --%>
	<div>${user2.getId()}</div>
</body>
</html>