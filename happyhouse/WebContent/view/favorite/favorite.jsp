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
	$(document).ready(function() {
		$("#registerBtn").click(function() {
			$("#favoriteform").submit();
		});
	});
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
					<li><a href="${root}/notice">공지사항</a></li>
		            <li><a href="${root}/favorite">나의관심지역</a></li>
		            <li><a href="${root}/clinic">선별진료소</a></li>
		            <li><a href="${root}/hospital">국가안심병원</a></li>
				</ul>
				<%@ include file="/view/main/login.jsp" %>
			</div>
		</div>
	</nav>

	<div class="jumbotron text-center">
		<h1>Happy House</h1>
		<p style="font-size: 130%;">내 집 마련의 꿈을 이루세요 !</p>
	</div>

	<div class="container" align="center">
		<form id="favoriteform" method="post" action="${root}/favorite">
			<input type="hidden" name="act" id="act" value="set">
			<div class="form-group" align="left">
					<div id="dong" class="custom-control-inline">
						<select class="form-control" id="dong" name="dong">
							<option value="평창동">평창동</option>
							<option value="사직동">사직동</option>
							<option value="숭인동">숭인동</option>
							<option value="신영동">신영동</option>
							<option value="목동">목동</option>
						</select>
					</div>
				</div>
				<div class="form-group" align="center">
					<button type="button" id="registerBtn" class="btn btn-primary">설정</button>
					<button type="reset" class="btn btn-warning">초기화</button>
				</div>
		</form>
	</div>

</body>
</html>
