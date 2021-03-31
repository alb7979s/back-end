<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--
		if (5 > 3) {
			참일 경우 실행코드
		} else if(조건) {
		
		} else {
		
		}
	--%>
	<%--
		if => when으로 바꾸고
		choose로 밖에한번 더 감싸면 됨
		else는 otherwise로!
	 --%>
	<c:set var="auth" value="S" />
	<c:set var="auth" value="" />
	<c:choose>
		<c:when test="${ auth eq 'S'}">
			<h2>슈퍼 관리자 입니다.</h2>	
		</c:when>
		<c:when test="${ auth eq 'A'}">
			<h2>일반 관리자 입니다.</h2>	
		</c:when>
		<c:when test="${ auth eq 'U'}">
			<h2>사용자 입니다.</h2>	
		</c:when>
		<c:otherwise>
			<h2>허용되지 않은 사용자 입니다.</h2>	
		</c:otherwise>
	</c:choose>
</body>
</html>