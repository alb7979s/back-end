<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>상품등록</h2>
	<form id="regist" method="post" action="regist">
		<label for="id">아이디</label>
		<input type="text" id="id" name="id">
		<label for="name">상품이름</label>
		<input type="text" id="name" name="name">
		<label for="price">상품가격</label>
		<input type="number" id="price" name="price">
		<label for="desc">설명</label>
		<input type="text" id="description" name="description">
		<button type="submit">제출</button>
	</form>
	<a href="${root }/">목록보기</a>
</body>
</html>