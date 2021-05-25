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

<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="60">

	<%@include file="../main/header.jsp" %>

	<div class="jumbotron text-center">
		<h1>공지사항</h1>
	</div>
	<div class="container menu" id="makeBoard"
		style="padding-top: 50px; height: 1000px;">
		<h1 style="color: black;">게시판</h1>
		<form action="" id="writeform" method="post">
		<!--
		
		
		input hidden
		
		
		 -->
			<div class="form-group">
				<label for="exampleFormControlInput1"
					style="color: black; font-size: 20px; font-weight: bold">제목</label>
				<input type="title" class="form-control" name = "subject"
					id="exampleFormControlInput1">
			</div>
			<div class="form-group">
				<label for="exampleFormControlTextarea1"
					style="resize: horizontal; color: black; font-size: 20px; font-weight: bold">내용</label>
				<textarea class="form-control" id="exampleFormControlTextarea1" name = "content"
					rows="25"></textarea>
			</div>
		</form>
		<div id="upde" style="text-align: center; display: none;">
			<button type="button" class="btn btn-warning" id="boardUdate"
				style="display: none;">수정</button>
			<button type="button" class="btn btn-warning" id="boardUdateFinish"
				style="display: none;">저장</button>
			<button type="button" class="btn btn-danger">삭제</button>
		</div>
		<div style="text-align: center;">
            <span id="post">
                <button id="postBtn" type="button" class="btn btn-lg postBoard">POST</button>
            </span>
            <span id="back">
                <button id="backBtn" type="button" class="btn btn-lg backBoard">BACK</button>
            </span>
	    </div>
	</div>

	<script>
		const writeform = document.querySelector("#writeform");
		const backBtn = document.querySelector("#backBtn");
		const postBtn = document.querySelector("#postBtn");
		postBtn.addEventListener('click',function() {
			writeform.action = "${root}/notice/write";
			writeform.submit();
		});
		backBtn.addEventListener('click',function() {
		//	location.href="${root}/notice";
			location.href="${root}/notice/list";
		});
	
  	</script>
</body>
</html>