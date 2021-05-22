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
    <%@include file="../main/header.jsp" %>

	<div class="jumbotron text-center">
      <h1>Happy House</h1> 
      <!-- <p style="font-size: 130%;">선별진료소 목록</p> -->
    </div>
    
    <div class="container-fluid" style="width:80%;">
      <form id="searchform">
	    <div class="dropdown" style="float: right; height: 51px;">
	    <!--    <button type="button" class="btn dropdown-toggle dropbtn" data-toggle="dropdown">검색</button>-->
	     	<select class="btn dropdown-toggle dropbtn" data-toggle="dropdown" name="key" id="key" onchange="inputPlaceholder();">
	   	 		<option value="sido" <c:if test="${result.key =='sido'}">selected</c:if>>시도</option>
	   	 		<option value="sigungu" <c:if test="${result.key =='sigungu'}">selected</c:if>>시,군,구</option>
	    		<option value="medi_name" <c:if test="${result.key =='medi_name'}">selected</c:if>>진료소 이름</option>
	    		<option value="address" <c:if test="${result.key =='address'}">selected</c:if>>주소</option>
	    		<option value="phone_no" <c:if test="${result.key =='phone_no'}">selected</c:if>>전화번호</option>
			</select>
	      <input type="text" name="word" id="word" value="${result.word}" placeholder="검색어를 입력해주세요.">
	      <button id="searchBtn" type="button" onclick="search();" class="btn btn-primary">검색</button>
	    </div>
     </form>
     
     <c:choose>
			<c:when test="${ result.word ne null}">
				<p class="pList">검색하신 [${result.word}]와 관련된 코로나 선별 진료소 목록입니다.</p>
			</c:when>
			<c:when test="${result.city ne null}">
				<p class="pList">관심지역인 [${result.city}, ${result.gugun}]와 관련된 코로나 선별 진료소 목록입니다.</p>
			</c:when>
			<c:otherwise>
				<p class="pList">코로나 선별 진료소 목록</p>	
			</c:otherwise>
	</c:choose>
		
		</br></br>
		
      <table class="table">
	    <thead>
	      <tr>
	        <th>번호</th>
	        <th>시도</th>
	        <th>시군구</th>
	        <th>선별진료소</th>
	        <th>주소</th>
	        <th>평일 운영시간</th>
	        <th>토요일 운영시간</th>
	        <th>일요일 운영시간</th>
	        <th>전화번호</th>
	      </tr>
	    </thead>
	    <tbody>
		    <c:forEach var="clinic" items="${result.clinic}" varStatus="loop">
		      <tr>
		        <td>${ ((result.pageResult.pageNo-1) *10) + (loop.index%10+1) }</td>
		        <td>${clinic.sido}</td>
		        <td>${clinic.sigungu}</td>
		        <td>${clinic.medi_name}</td>
		        <td>${clinic.address}</td>
		        <td>${clinic.weekday_oper_time}</td>
		        <td>${clinic.saturday_oper_time}</td>
		        <td>${clinic.holiday_oper_time}</td>
		        <td>${clinic.phone_no}</td>
		      </tr>
		    </c:forEach>
	    </tbody>
	  </table>
    </div>
    

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
     function goPage(pageNo){
    	//	alert(pageNo);
    	let key = document.getElementById("key").value;
 		let word = document.getElementById("word").value;
     	if(key!='' && word!=''){
     		location.href="${root}/clinic/search?pageNo="+pageNo+"&key="+key+"&word="+word;
     	}
     	
     	else location.href="${root}/clinic/list?pageNo="+pageNo;
     }
     </script>
     
     <script type="text/javascript">
		function inputPlaceholder(){
			document.getElementById("word").value="";
			document.getElementById("word").placeholder="검색어를 입력해주세요.";
		}
		
		function search(){
			if(document.getElementById("word").value == ""){
				alert("검색어를 입력하세요");
				return;
			}
			
			document.getElementById("searchform").action = "${ root }/clinic/search";
			document.getElementById("searchform").submit(); 
		}
	</script>
</body>
</html>