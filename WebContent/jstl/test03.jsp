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
		}
	--%>
	<%--
		여기서 사용할거(그냥 임의로 만들어준거임)
		S : 슈퍼 관리자
		A : 일반 관리자
		U : 사용자
	 --%>
	<c:set var="auth" value="S" />
	<c:set var="auth" value="U" />
	<c:if test="${ auth eq 'S'}">
		<h2>슈퍼 관리자 입니다.</h2>	
	</c:if>
	<c:if test="${ auth eq 'A'}">
		<h2>일반 관리자 입니다.</h2>	
	</c:if>
	<c:if test="${ auth eq 'U'}">
		<h2>사용자 입니다.</h2>	
	</c:if>
</body>
</html>