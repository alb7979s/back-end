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
		<h2>썸네일 생성하기</h2>
		<hr>
		<form action="test05" 
			  method="post"
		      enctype="multipart/form-data">
			<div>
				<label for="msg1">메세지1</label><input type="text" id="msg1" name="msg1" />
			</div>
			<div>
				<label for="msg2">메세지2</label><input type="text" id="msg2" name="msg2" />
			</div>
			<div>
				<label for="attach1">첨부파일1</label><input type="file" id="attach1" name="attach1" />
			</div>
			<div>
				<label for="attach2">첨부파일2</label><input type="file" id="attach2" name="attach2" />
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
	$("ul.nav.navbar-nav > li:eq(4)").addClass("active");
</script>
</body>
</html>













