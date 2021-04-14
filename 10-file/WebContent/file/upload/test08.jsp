<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일</title>
<%@ include file="/include/basicInclude.jsp" %>
<link rel="stylesheet" href="../css/test08.css">
</head>
<body>
<div class="container">
	<div class="header">
		<c:import url="/include/topMenu.jsp" />
	</div>

	<div class="content">
		<h2>이미지 선택 미리보기</h2>
		<hr>
	    <div class="profile">
			<span id="imgFrame" class="img"></span> 
			<span class="file txt-photo">
				<input type="file" id="attach" name="attach" />
			</span>
			<ul>
				<li>- gif 혹은 jpg 형식</li>
				<li>- 100kbyte 이내<br />&nbsp;&nbsp;사진만 업로드 가능
				</li>
				<li>- 권장사이즈 100*150</li>
			</ul>
			<div class="center"><button type="button">전송</button></div>
			<div id="result"></div>
		</div>
	</div>	
	<div class="footer">
		<%@ include file="/include/bottom.jsp" %>
	</div>	
</div>
<script>
	$("button").click(function () {
		// 전체 선택된 파일의 name과 size 속성의 값을 콘솔 확인...
		let files = $("input[name='attach']")[0].files;
		
		// 폼의 데이터를 조작해서 전송...
		var fd = new FormData();
		
		// 폼데이터의 일부를 추가한다.
		fd.append("msg", $("input[name='msg']").val());

		for (var i = 0; i < files.length; i++) {
			fd.append("attach", files[i]);
		}
		
		$("#result").html("");
		
		$.ajax({
			url: "<c:url value='/upload/test08' />",
			data: fd,
			type: "POST",
			processData: false,
			contentType: false,
			success: function (data) {
				$("#result").html(data);
			}
		});
	});
	
	let attach = document.querySelector("#attach");
	/* 직접 작성하기 - 파일 선택시 파일 미리보기  */  
    
	$("ul.nav.navbar-nav > li").removeClass("active");
	$("ul.nav.navbar-nav > li:eq(8)").addClass("active");
</script>
</body>
</html>