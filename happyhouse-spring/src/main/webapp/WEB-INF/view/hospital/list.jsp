<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>HappyHouse</title>
<link rel="stylesheet" href="${root}/css/main.css">

</head>
<body>
    <nav class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <a class="navbar-brand" href="${root}/" style="font-size:2em;"><span class="glyphicon glyphicon-home"></span></a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
          <ul class="nav navbar-nav navbar-left">
            <li><a href="${root}/notice">공지사항</a></li>
            <li><a href="${root}/favorite">나의관심지역</a></li>
            <li><a href="${root}/clinic">선별진료소</a></li>
            <li><a href="${root}/hospital">국가안심병원</a></li>
          </ul>
          <%@ include file="../main/login.jsp" %>
        </div>
      </div>
    </nav>

	<div class="jumbotron text-center">
      <h1>Happy House</h1> 
      <p style="font-size: 130%;">국민 안심 병원 목록</p>
    </div>
    
    <div class="container-fluid" style="width:80%;">
      <table class="table">
	    <thead>
	      <tr>
	        <th>번호</th>
	        <th>시도</th>
	        <th>시군구</th>
	        <th>기관명</th>
	        <th>유형</th>
	        <th>전화번호</th>
	      </tr>
	    </thead>
	    <tbody>
		    <c:forEach var="hospital" items="${result.hospital}" varStatus="loop">
		      <tr>
		        <td>${hospital.no}</td>
		        <td>${hospital.sido}</td>
		        <td>${hospital.sigungu}</td>
		        <td>${hospital.medi_name}</td>
		        <td>${hospital.type}</td>
		        <td>${hospital.phone_no}</td>
		      </tr>
		    </c:forEach>
	    </tbody>
	  </table>
    </div>
    
    <!-- 페이징 -->
    <c:if test="${result.pageResult.count != 0}"> 
		<nav>
			<ul class="pagination botBar">
				<!-- 이전 -->
				<li class="<c:if test="${not result.pageResult.prev}">disabled</c:if>">
				<a href="#1" <c:if test="${result.pageResult.prev}">onclick="goPage(${result.pageResult.beginPage-1});"</c:if>
					aria-label="dataevious"> <span aria-hidden="true">&laquo;</span>
				</a></li>
				<c:forEach var="i" begin="${result.pageResult.beginPage}" end="${result.pageResult.endPage}">
					<c:choose>
						<c:when test="${i eq result.pageResult.pageNo}">
							<li class="page-item active"><a href="#1">${i}</a></li>
						</c:when>
						<c:otherwise>
							<li><a class="page-item" href="#1" onclick="goPage(${i});">${i}</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<!-- 다음 -->
				<li class="<c:if test="${not result.pageResult.next}">disabled</c:if>">
				
				<a href="#1" <c:if test="${result.pageResult.next}">onclick="goPage(${result.pageResult.endPage + 1});"</c:if>
					aria-label="Next"> <span aria-hidden="true">&raquo;</span>
				</a></li>
			</ul>
		</nav>
     </c:if>
     
     <script>
     $("ul.nav > li ").removeClass("active");
 	 $("ul.nav > li:eq(${pr.pageNo})").addClass("active");
     function goPage(pageNo){
    	//	alert(pageNo);
    	location.href="${root}/hospital/list?pageNo="+pageNo;
     }
     </script>
</body>
</html>