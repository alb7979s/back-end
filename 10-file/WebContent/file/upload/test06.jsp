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
		<h2>Apache Commons 라이브러리 이용하기</h2>
		<hr>
		<form action="test06" 
			  method="post"
		      enctype="multipart/form-data">
			<div>
				<label for="msg">메세지</label>
				<input type="text" id="msg" name="msg" />
			</div>
			<div>
				<label for="attach">첨부파일</label>
				<input type="file" id="attach" name="attach" multiple="multiple"  />
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
	$("ul.nav.navbar-nav > li:eq(5)").addClass("active");
</script>
</body>
</html>













