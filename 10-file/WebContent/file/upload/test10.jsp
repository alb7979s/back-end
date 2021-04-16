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
		<h2>업로드 디비 저장</h2>
		<hr>
		<form action="test10" 
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
				<!-- multiple은 여러개 파일 선택할 수 있도록 해주는거 -->
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
	/* html5 file이란 API 사용 */
	let uploadFile = null;
	let profile = document.querySelector("#profile");
	profile.onchange = function (event) {		// onchange:여기선 인풋창에 있는 값이 바뀌었을 때 호출
		
    	let file = event.target.files[0];
		console.dir(event.target);
		console.dir(event.target.files);
		
    	if (file.type.substring(0, 5) != 'image') {
    		alert("이미지를 선택하세요");
    		return false;
    	}
    	if (file.size >= 100 * 1024) {
    		alert("100kb 미만의 파일을 선택하세요");
    		return false;
    	}
    	uploadFile = file;
    	// 이미지 동적 추가
    	// URL.createObjectURL(file): file 정보 주면 이미지 정보를 줄 수 있는 URL을 만들어줌
    	$('.img').html(`<img src="\${URL.createObjectURL(file)}" alt='profile' />`);	
    };    
    
    // 아래 두 문단 드래그&드랍 할 수 있도록
    let imgFrame = document.querySelector(".img");	//드랍 대상 정함
    imgFrame.ondragover = function (event) {
        return false;	// 1. ondragover false로 줘야행
    }
    
    imgFrame.ondrop = function (event) {	// 2. 그 영역으로 drop할 수 있는 이벤트(여기선 대상이 .img)
    	uploadFile = event.dataTransfer.files[0];	// 실제 드랍된애에 대한 정보 뽑아냄, 여러개면 files for루프로 돌려서 하면 됨
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
	$("ul.nav.navbar-nav > li:eq(10)").addClass("active");
</script>
</body>
</html>













