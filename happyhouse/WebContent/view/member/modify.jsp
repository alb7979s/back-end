<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정 페이지</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#registerBtn").click(function() {
				
			if($("#pwd").val() != $("#pwdcheck").val()) {
				alert("비밀번호가 맞지 않습니다.");
				return;
			} else {
				$("#temp").attr("value","modify");
				$("#memberform").submit();
			}
		});
		$("#cancleBtn").click(function() {
			document.location.href = "/happyhouse/index.jsp";
		});

		$("#withdrawBtn").click(function() {
			$("#temp").attr("value","withdraw");
			$("#memberform").submit();
		});

	});
</script>
</head>
<body>
	<div align="center">
		<h2 class="text-center">수정하기</h2>
	</div>
	<div class="container" align="center">
		<div class="col-lg-6" align="center">
			<form id="memberform" method="post" action="${root}/member">
				<input id="temp" type="hidden" name="act" id="act" value="modify">
				<div class="form-group" align="left">
					<label for="">아이디</label> <input type="text" class="form-control" id="id"
						name="id" value="${userinfo.id}" readonly/>
				</div>
				<div class="form-group" align="left">
					<label for="">비밀번호</label> <input type="password"
						class="form-control" id="pwd" name="pwd">
				</div>
				<div class="form-group" align="left">
					<label for="">비밀번호재입력</label> <input type="password"
						class="form-control" id="pwdcheck" name="pwdcheck">
				</div>
				<div class="form-group" align="left">
					<label for="name">소속</label> <input type="text"
						class="form-control" id="dpt" name="dpt">
				</div>
				<div class="form-group" align="left">
					<label for="email">이메일</label><br>
					<div id="email" class="custom-control-inline">
						<input type="text" class="form-control" name="email" size="25">
						@ <select class="form-control" id="emaildomain" name="emaildomain">
							<option value="naver.com">naver.com</option>
							<option value="google.com">google.com</option>
							<option value="daum.net">daum.net</option>
							<option value="nate.com">nate.com</option>
							<option value="hanmail.net">hanmail.net</option>
						</select>
					</div>
				</div>
				<div class="form-group" align="center">
					<button type="button" id="registerBtn" class="btn btn-primary">수정</button>
					<button type="button" id="cancleBtn" class="btn btn-primary">취소</button>
					<button type="button" id="withdrawBtn" class="btn btn-warning">삭제</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>