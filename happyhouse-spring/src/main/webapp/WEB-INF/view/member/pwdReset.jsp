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
	function resetPwd() {
		if (document.getElementById("pwd").value == "") {
			alert("비밀번호를 입력해주세요");
			return;
		}
		else if (document.getElementById("pwdCheck").value == "") {
			alert("비밀번호를 다시 입력해주세요");
			return;
		}
		else if ($("#pwd").val() != $("#pwdCheck").val()) {
			alert("비밀번호가 맞지 않습니다.");
			return;
		} else {
			alert("비밀번호 변경이 완료되었습니다.");
			document.getElementById("searchform").submit();
		}
	}

	function keyCheck(){
		// enter
		if(event.keyCode == 13){
			resetPwd();
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
		<form id="searchform" method="post" action="${root}/member/resetPwd">
			<input type="hidden" name="id" id="id" value="${searchedid}">
			<div class="form-group">
				<label for="id">새로운 비밀번호를 입력해주세요</label>
				<input type="password" class="form-control" value="" onKeydown="keyCheck()" id="pwd" name="pwd" placeholder="" style="width:300px">
			</div>
			<div class="form-group">
				<label for="email">비밀번호 확인</label>
				<input type="password" class="form-control" value="" onKeydown="keyCheck()" id="pwdCheck" name="pwdCheck" placeholder="" style="width:300px">
			</div>
			<div class="text-danger">${msg}</div>
			<div class="form-group" align="center">
				<button type="button" class="btn btn-warning" onclick="resetPwd();">비밀번호 변경</button>
			</div>
		</form>
	</div>

</body>
</html>
