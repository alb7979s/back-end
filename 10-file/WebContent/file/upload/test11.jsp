<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일</title>
<%@ include file="/include/basicInclude.jsp" %>
<link rel="stylesheet" href="../css/test08.css">
<style>
	.profile {	
		margin-bottom: 10px; 
	}
</style>
</head>
<body>
<div class="container">
	<div class="header">
		<c:import url="/include/topMenu.jsp" />
	</div>

	<div class="content">
		<h2>업로드 파일 모듈화11</h2>
		<hr>
		<form action="test11" 
			  method="post"
		      enctype="multipart/form-data">
		   <div class="profile">
				<span class="img"></span> 
				<span class="file txt-photo">
					<input type="file" id="profile" name="profile" />
				</span>
				<ul>
					<li>- gif 혹은 jpg 형식</li>
					<li>- 100kbyte 이내<br />&nbsp;&nbsp;사진만 업로드 가능
					</li>
					<li>- 권장사이즈 100*150</li>
				</ul>
			</div>
			<div>
				<label for="id">아이디</label>
				<input type="text" id="id" name="id" />
			</div>
			<div>
				<label for="name">이름</label>
				<input type="text" id="name" name="name" />
			</div>
			<div>
				<label for="password">패스워드</label>
				<input type="password" id="password" name="password" />
			</div>
			<div>
				<label>좋아하는 언어</label>
				<input type="checkbox" id="lang1" name="lang" value="Java" /> Java
				<input type="checkbox" id="lang2" name="lang" value="SQL" /> SQL
				<input type="checkbox" id="lang3" name="lang" value="CSS" /> CSS
			</div>
			<div>
				<label for="attach">첨부파일</label>
				<input type="file" id="attach" name="attachs" multiple="multiple"  />
			</div>
			<div class="center"><button>전송</button></div>
		</form>
	</div>	
	<div class="footer">
		<%@ include file="/include/bottom.jsp" %>
	</div>	
</div>
<script>
	let profile = document.querySelector("#profile");
	profile.onchange = function (event) {
		
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
    
    
    let imgFrame = document.querySelector(".img");
    imgFrame.ondragover = function (event) {
        return false;
    }
    
    imgFrame.ondrop = function (event) {
    	uploadFile = event.dataTransfer.files[0];
    	if (uploadFile.type.substring(0, 5) != 'image') {
    		alert("이미지를 선택하세요");
    		return false;
    	}
    	if (uploadFile.size >= 100 * 1024) {
    		alert("100kb 미만의 파일을 선택하세요");
    		return false;
    	}  
    	console.log(uploadFile)
        this.innerHTML = `<img src="\${URL.createObjectURL(uploadFile)}">`;
        return false;
    }
    
	$("ul.nav.navbar-nav > li").removeClass("active");
	$("ul.nav.navbar-nav > li:eq(11)").addClass("active");
</script>
</body>
</html>













