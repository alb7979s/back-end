<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Lato"
	rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Montserrat"
	rel="stylesheet" type="text/css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>HappyHouse</title>
  <link rel="stylesheet" href="${root}/css/main.css">
</head>

<body id="myPage" data-spy="scroll" data-target=".navbar"
	data-offset="60">

	<%@include file="../main/header.jsp" %>

	<div class="jumbotron text-center">
		<h1>커뮤니티</h1>
	</div>
	<div class="container menu" id="makeBoard"
		style="padding-top: 50px; height: 1000px;">
		<div>
			<form action="" id="updateform" method="GET">
				<div class="form-group">
					<label for="exampleFormControlInput1"
						style="color: black; font-size: 40px; font-weight: bold">제목: &nbsp;${community.subject}</label>
				</div>
				<hr/>
				<div class="like"><a></a></div>
				<div class="form-group">
					
				</div>
				<div><img src="/community/loadImage/${community.no}"/></div>
				<label for="exampleFormControlTextarea1"
						style="resize: horizontal; color: black; font-size: 25px;">${community.content}</label>
			</form>
		</div>
		<hr/>
		<!--  댓글  -->
	    <div class="container">
	        <label for="content">comment</label>
	        <form name="commentInsertForm">
	            <div class="input-group">
	               <input type="hidden" name="no" value="${community.no}"/>
	               <input type="text" class="form-control" id="content" name="content" placeholder="내용을 입력하세요.">
	               <span class="input-group-btn">
	                    <button class="btn btn-default" type="button" name="commentInsertBtn">등록</button>
	               </span>
	              </div>
	        </form>
	    </div>
	    <br/><br/>
	    <div class="container">
	        <div class="commentList"></div>
	    </div>
		<%@ include file="commentScript.jsp" %>

		<hr/>
		<c:if test="${userinfo.id == community.userid}">
			<div id="upde" style="text-align: center;">
				<button type="button" class="btn btn-warning" 
					style="" id="updateBtn">수정</button>
				<button type="button" class="btn btn-warning" id="boardUdateFinish"
					style="display: none;">저장</button>
				<button id ="deleteBtn" type="button" class="btn btn-danger" >삭제</button>
			</div>
		</c:if>
		<div id="back"
			style="text-align: center; margin-top: 50px; padding-bottom: 100px;">
			<button id="backBtn" type="button" class="btn btn-lg backBoard">BACK</button>
		</div>
	</div>

   <script>
	const deleteBtn = document.querySelector("#deleteBtn");
	const updateform = document.querySelector("#updateform");
	let hiddeninput = document.querySelector("#hiddeninput");
	if(deleteBtn){
		deleteBtn.addEventListener('click',function(){
			console.log("${root}/community/delete?number=${community.no}");
			location.href="${root}/community/delete?number=${community.no}";
		})};
	
	const backBtn = document.querySelector("#backBtn");
	backBtn.addEventListener('click',function() {
	//	location.href="${root}/community";
		location.href="${root}/community/list";
	});
	const updateBtn = document.querySelector("#updateBtn");
	if(updateBtn){
		updateBtn.addEventListener('click',function(){
			location.href="${root}/community/modify?number=${community.no}";
		})};

  </script>
</body>
</html>