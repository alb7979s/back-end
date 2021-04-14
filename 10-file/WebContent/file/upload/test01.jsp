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
		<h2>파일 전송 데이터 포멧 이해하기</h2>
		<hr>
		<%--
			***파일 업로드시 필수 사항
			1. enctype 속성의 값을 "multipart/form-data" 으로 설정한다.
			   - 만약, 설정되어 있지 않다면 파일의 내용이 서버로 전송되지 않는다.
			2. 파일 데이터가 많이 있을 수 있기 때문에 post 방식으로 전송해야 한다.   
		 --%>
		<!-- 직접 작성하기 - 파일연관 form 태그 속성  -->
		<form action="test01" enctype="multipart/form-data" method="post">
			<div>
				<label for="msg1">메세지1</label><input type="text" id="msg1" name="msg1" />
			</div>
			<div>
				<label for="msg2">메세지2</label><input type="text" id="msg2" name="msg2" />
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
	$("ul.nav.navbar-nav > li:eq(0)").addClass("active");
</script>
</body>
</html>

























