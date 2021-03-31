<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 원래 공유는 서블릿에서 하는 작업인데 테스트 할라고 그냥 여기에 씀 --%>
<%
	List<String> list = Arrays.asList("one", "two", "three");
	pageContext.setAttribute("list", list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--
		for(int i = 0; i < 10; i++) {...}
		
		for(User u : users) {...}
	
	 --%>
	 <select>
	 <c:forEach var="i" begin="1960" end="2010" step="1">		
	 	<option>${i}</option>		<%-- 프로그램에서 만들어 낸건 굳이 c:out 안써도 됨, 사용자가 입력하는 부분만 잘 처리해주면 됨--%>
	 </c:forEach>
	 </select>
	 
	 <div>
	 	<c:forEach var="msg" items="${list}">
	 		${msg}
	 	</c:forEach>
	 </div>
	 
	 <%-- tip, varStatus --%>
	 <div>
	 	<c:forEach var="msg" items="${list}" varStatus="loop">
	 		${loop.index} - ${loop.count} - ${loop.first} - ${loop.last} - ${msg}<br>
	 	</c:forEach>
	 </div>
	 <div>
	 	<c:forEach var="msg" items="${list}" varStatus="loop">
			<c:if test="${not loop.first}">, </c:if>${msg}
	 	</c:forEach>
	 </div>
	 
</body>
</html>