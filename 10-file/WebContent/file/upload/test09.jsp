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
		<h2>이미지 Drag 미리보기</h2>
		<hr>
	    <div class="profile">
			<span class="img"></span> 
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
		
		// 폼의 데이터를 조작해서 전송...
		let fd = new FormData();
		
		// 폼데이터의 일부를 추가한다.
		fd.append("msg", $("input[name='msg']").val());
		fd.append("attach", uploadFile);
		
		$("#result").html("");
		
		$.ajax({
			url: "<c:url value='/upload/test09' />",
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
	attach.onchange = function (event) {
		
    	let file = event.target.files[0];
    	if (file.type.substring(0, 5) != 'image') {
    		alert("이미지를 선택하세요");
    		return false;
    	}
    	if (file.size > 100 * 1024) {
    		alert("100kb 미만의 파일을 선택하세요");
    		return false;
    	}
    	uploadFile = file;
    	$('.img').html(`<img src="\${URL.createObjectURL(file)}" alt='profile' />`);
    };    
    
    
	let uploadFile = null;
    let imgFrame = document.querySelector(".img");
    
    /* 직접 작성하기 - 이미지 Drag 파일 미리보기  */  
    
    
    
	$("ul.nav.navbar-nav > li").removeClass("active");
	$("ul.nav.navbar-nav > li:eq(9)").addClass("active");
</script>
</body>
</html>