<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일</title>
<%@ include file="/include/basicInclude.jsp" %>
</head>
<body>
<div class="container">
	<div class="header">
		<c:import url="/include/topMenu.jsp" />
	</div>

	<div class="content">
		<h2>Ajax를 이용한 파일 업로드</h2>
		<hr>
		<form id="fileForm">
			<div>
				<label for="msg">메세지</label>
				<input type="text" id="msg" name="msg" />
			</div>
			<div>
				<label for="attach">첨부파일</label>
				<input type="file" id="attach" name="attach" multiple="multiple"  />
			</div>
			<div class="center"><button type="button">전송</button></div>
			<div id="result"></div>
		</form>
	</div>
	<div class="footer">
		<%@ include file="/include/bottom.jsp" %>
	</div>		
</div>
<script>
	$("button").click(function () {
		/* 직접 작성하기 - Ajax 파일업로드 처리하기 */
		
	});
	$("ul.nav.navbar-nav > li").removeClass("active");
	$("ul.nav.navbar-nav > li:eq(7)").addClass("active");
</script>
</body>
</html>