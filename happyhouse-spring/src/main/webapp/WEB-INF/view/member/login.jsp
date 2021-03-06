<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />

<c:set var="memberDto" value="${sessionScope.userinfo}" />
<!DOCTYPE html>

<html lang="ko">
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
<script type="text/javascript">
	function login() {
		if (document.getElementById("id").value == "") {
			alert("아이디를 입력하세요");
			return;
		} else if (document.getElementById("pwd").value == "") {
			alert("비밀번호를 입력하세요");
			return;
		} else {
			document.getElementById("loginform").action = "${root}/member/login";
			document.getElementById("loginform").submit();
		}
	}

	function moveJoin(){
		location.href="${root}/member/moveJoin";
	}
	
	function keyCheck(){
		// enter
		if(event.keyCode == 13){
			login();
		}
	}
</script>
</head>
<body>
	<%@include file="../main/header.jsp" %>

	<div class="jumbotron text-center">
		<h1>Happy House</h1>
		<p style="font-size: 130%;">내 집 마련의 꿈을 이루세요 !</p>
	</div>

	<div class="container" align="center">
		<form id="loginform" method="post" action="${root}/member/login">
			<input type="hidden" name="act" id="act" value="login">
			<div class="form-group">
				<label for="">아이디</label>
				<input type="text" class="form-control" onKeydown="keyCheck()" id="id" name="id" value="${searchedid}" placeholder="" style="width:300px">
			</div>
			<div class="form-group">
				<label for="">비밀번호</label>
				<input type="password" class="form-control" onKeydown="keyCheck()" id="pwd" name="pwd" placeholder="" style="width:300px">
			</div>
			<div class="form-group" align="center">
				<button type="button" class="btn btn-warning" onclick="login();">로그인</button>
				<button type="button" class="btn btn-primary" onclick="moveJoin();">회원가입</button>
			</div>
			<div class="text-danger">${msg}</div>
			<div>
				<a href="${root}/member/moveIdSearch">아이디 찾기</a> | <a href="${root}/member/movePwdSearch">비밀번호 찾기</a>
			</div>
		</form>
	</div>

</body>
</html>
