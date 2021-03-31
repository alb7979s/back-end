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
		//데이터 공유를 대체하는 c:set 태그
		request.setAttribute("msg", "test");
		
		scope 속성을 설정하지 않으면 디폴트로 "page"를 설정한다.(session, application은 서버단에서 처리해서 내려올거라서 보통 테스트할때만 씀)
	 --%>
	 
	<c:set scope="request" var="msg" value="test"/>	
	<div>${msg}</div>   <!-- test찍힘 -->
	
	<%-- cnt 값 1늘려서 출력 --%>
	<c:set var="cnt" value="7" />
	<c:set var="cnt" value="${cnt+1}"/>
	${cnt}
</body>
</html>