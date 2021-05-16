<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
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
<c:set var="notices" value="${result.list}" />
<c:set var="pr" value="${result.pageResult}" />
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="60">

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
    <h1>공지사항</h1>
  </div>

  <div class="container menu" id="board" style="padding-top: 50px;height: 1000px;">
    <button id = "goWriteBtn" type="button" class="btn clickMakeBoard btn-primary">글쓰기</button>
    <form action ="${root}/notice/search" method="GET">
	    <div class="dropdown" style="float: right; height: 51px;">
	    <!--    <button type="button" class="btn dropdown-toggle dropbtn" data-toggle="dropdown">검색</button>-->
	     	<select class="btn dropdown-toggle dropbtn" data-toggle="dropdown" name="type" id="type">
	   	 		<option value="userid">작성자</option>
	    		<option value="subject">제목</option>
			</select>
	      <input type="text" name="word">
	      <button id="searchBtn" type="button" class="btn btn-primary">검색</button>
	    </div>
    </form>
    <!--   <div class="dropdown-menu">
        <h4 class="dropdown-item" onclick="dropSelectTitle()">제목</h4>
        <h4 class="dropdown-item" onclick="dropSelectUser()">작성자</h4>
      </div> -->

    <div class="w3-padding w3-white notranslate">
      <table class="table table-striped">
        <thead>
          <tr>
            <th>글번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>작성일</th>
          </tr>
        </thead>
        <tbody>
		<c:forEach var="item" items = "${notices}">
			<tr>
			<input type="hidden" value="${item.noticeno}">
            	<td>${item.noticeno }</td>
            	<td>${item.subject }</td>
            	<td>${item.userid }</td>
           	 	<td>${item.regtime}</td>
          	</tr>
		</c:forEach>

        </tbody>
      </table>
    </div>
  </div>
  	<c:if test="${pr.count != 0}"> 
		<nav>
	<ul class="pagination botBar">
		<!-- 이전 -->
		<li class="<c:if test="${not pr.prev}">disabled</c:if>">
		<a href="#1" <c:if test="${pr.prev}">onclick="goPage(${pr.beginPage-1});"</c:if>
			aria-label="dataevious"> <span aria-hidden="true">&laquo;</span>
		</a></li>
		<c:forEach var="i" begin="${pr.beginPage}" end="${pr.endPage}">
			<c:choose>
				<c:when test="${i eq pr.pageNo}">
					<li class="page-item active"><a href="#1">${i}</a></li>
				</c:when>
				<c:otherwise>
					<li><a class="page-item" href="#1" onclick="goPage(${i});">${i}</a></li>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<!-- 다음 -->
		<li class="<c:if test="${not pr.next}">disabled</c:if>">
		
		<a href="#1" <c:if test="${pr.next}">onclick="goPage(${pr.endPage + 1});"</c:if>
			aria-label="Next"> <span aria-hidden="true">&raquo;</span>
		</a></li>
	</ul>
</nav>
     </c:if>
<!--  페이징
  <ul class="pagination botBar">
  	
    <li class="page-item"><a class="page-link" href="#">Previous</a></li>
    <li class="page-item"><a class="page-link" href="#">1</a></li>
    <li class="page-item"><a class="page-link" href="#">2</a></li>
    <li class="page-item"><a class="page-link" href="#">3</a></li>
    <li class="page-item"><a class="page-link" href="#">Next</a></li>
  </ul>-->
  <script>
	const goWriteBtn = document.querySelector("#goWriteBtn");
//	const hiddenform = document.querySelector("#hiddenform");
	goWriteBtn.addEventListener('click',function() {
		console.log("GoWriteBtn click");
		location.href = "${root}/notice/write";
	});
	const tbody = document.querySelector("tbody");
	tbody.addEventListener('click',function(e){
		console.log("click");
	//	console.log(e.target.children[0].value);
		console.log(e.target.tagName);
		console.log(e.target.nodeName);
		console.log(e.target.parentNode.children[0].value);
		if(e.target.nodeName === "TD"){
	//		console.log("${root}");
			location.href="${root}/notice/detail?number=" + e.target.parentNode.children[0].value;			
			
		}else{
			//location.href="${root}/main?act=detail&number=" + e.target.children[0].value;			
		}
		
	},true);
	$("ul.nav > li ").removeClass("active");
	$("ul.nav > li:eq(${pr.pageNo})").addClass("active");
	function goPage(pageNo){
	//	alert(pageNo);
		location.href="${root}/notice/list?pageNo="+pageNo;
	}
  </script>
</body>

</html>