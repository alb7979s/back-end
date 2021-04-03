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
			document.getElementById("loginform").action = "${root}/member";
			document.getElementById("loginform").submit();
		}
	}

	function moveJoin() {
		document.location.href = "${root}/view/member/join.jsp";
	}
</script>
</head>
<body>
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#" style="font-size: 2em;"><span
					class="glyphicon glyphicon-home"></span></a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav navbar-left">
					<li><a href="#">공지사항</a></li>
					<li><a href="#">주변탐방</a></li>
					<li><a href="#">나의관심지역</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="jumbotron text-center">
		<h1>Happy House</h1>
		<p style="font-size: 130%;">내 집 마련의 꿈을 이루세요 !</p>
	</div>

	<div class="container" align="center">
		<form id="loginform" method="post" action="">
			<input type="hidden" name="act" id="act" value="login">
			<div class="form-group">
				<label for="">아이디</label>
				<input type="text" class="form-control" id="id" name="id" placeholder="" style="width:300px">
			</div>
			<div class="form-group">
				<label for="">비밀번호</label>
				<input type="password" class="form-control" id="pwd" name="pwd" placeholder="" style="width:300px">
			</div>
			<div class="form-group" align="center">
				<button type="button" class="btn btn-warning" onclick="login();">로그인</button>
				<button type="button" class="btn btn-primary" onclick="moveJoin();">회원가입</button>
			</div>
			<div>${msg}</div>
			<div>
				<a href="">아이디 찾기</a> | <a href="">비밀번호 찾기</a>
			</div>
		</form>
	</div>

</body>
</html>
