<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<head>
	<!-- 왜 생각대로 안되지 이 부분 디버깅 필요 -->
	<script>
		function active(num){
			$("ul.navbar-nav > li").removeClass("active");
			$(`ul.navbar-nav > li:eq(${num})`).addClass("active");
		}
	</script>
</head>
<body>
	<nav class="navbar navbar-default navbar-fixed-top top">
	   <div class="container">
	     <div class="navbar-header">
	       <a class="navbar-brand" href="${root}/" style="font-size:2em;"><span class="glyphicon glyphicon-home"></span></a>
	     </div>
	     <div class="collapse navbar-collapse" id="myNavbar">
	       <ul class="nav navbar-nav navbar-left">
	         <li><a href="${root}/notice" onclick="active(1)">공지사항</a></li>
	         <li><a href="${root}/favorite" onclick="active(2)">나의관심지역</a></li>
	         <li><a href="${root}/clinic" onclick="active(3)">선별진료소</a></li>
	         <li><a href="${root}/hospital" onclick="active(4)">국가안심병원</a></li>
	         <li><a href="${root}/apt" onclick="active(5)">실거래가 검색</a></li>
	       </ul>
	       <%@ include file="../main/login.jsp" %>
	     </div>
	   </div>
	 </nav>
</body>
