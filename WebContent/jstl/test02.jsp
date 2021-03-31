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
		out : 출력태그
		
		
	 --%>
	<div>
		<c:out value="out을 이용한 출력" />
	</div>
	<div>
		${"out을 이용한 출력"}
	</div>
	
	<c:set var="msg" value="<h1>out을 이용한 출력</h1>"/>
	<div>
		<c:out value="${msg}"/>		<%-- out의 장점? 보안!! 태그 해석 안하고 그냥 출력, 사용자 입력에 태그 넣어서<script>악성코드</script>넣어놔서 실행되게 하면 큰일남 (xss) --%>
	</div>
	<div>
		${msg}
	</div>
	
	<div>
		<c:out value="${homepage}" default="홈페이지가 등록되지 않았습니다."/> <%-- out 다른 기능, default로 앞에 있는 값 없을때 보여줄 수 있음--%>		
	</div>
</body>
</html>