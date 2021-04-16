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
		<h2>cos.jar 라이브러리를 이용한 업로드 파일 서버에 저장하기</h2>
		<hr>
		<form action="test02" 
			  method="post"
		      enctype="multipart/form-data">
			<div>
				<label for="msg1">메세지1</label>
				<input type="text" id="msg1" name="msg1" />
			</div>
			<div>
				<label for="msg2">메세지2</label>
				<input type="text" id="msg2" name="msg2" />
			</div>
			<div>
				<label for="attach">첨부파일</label>
				<input type="file" id="attach" name="attach" />
			</div>
			<div class="center"><button>전송</button></div>
		</form>
	</div>	
	<div class="footer">
		<%@ include file="/include/bottom.jsp" %>
	</div>	
</div>
<script>
	$("ul.nav.navbar-nav > li").removeClass("active");
	$("ul.nav.navbar-nav > li:eq(1)").addClass("active");
</script>
</body>
</html>