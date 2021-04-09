<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--
		${id}
		
		id를 해석하는 순서 이해
		1. EL에서 제공하는 기본객체에 동일한 이름이 있는지 찾는다.
		2. 만약, 1번에서 찾지 못한 경우 JSP 4가지 공유영역에서 찾는다.(pageContext, request, session, application)
		     찾는 순서 : 가까운거부터, pageContex -> request -> session -> application
		3. 1, 2번에서 못찾은 경우는 빈문자열로 표시한다.(자동 null 처리)
	 --%>
	 
	 <h2>객체 찾기 이해하기</h2>
	 <div>
	 	msg: <%= request.getParameter("msg") %>			<%-- null 찍힘 --%>
	 </div>
	 <div>
	 	msg(el): ${ param.msg } 						<%-- 빈문자열 찍힘 --%>
	 </div>
	 <div>
	 	id(el) : ${id}
	 </div>
</body>
</html>