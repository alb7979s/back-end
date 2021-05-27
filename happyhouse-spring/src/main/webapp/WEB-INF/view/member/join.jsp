<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Lato"
	rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Montserrat"
	rel="stylesheet" type="text/css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>회원가입</title>
<link rel="stylesheet" href="${root}/css/main.css">

<script type="text/javascript">
	var idDup = false;
	var emailDup = false;
	$(document).ready(function() {
		$("#registerBtn").click(function() {
			join();
		});
	});
	function msgAndFocus(attr, msg){
		alert(msg);
		$(attr).focus();
	}
	function join() {
		if ($("#id").val() == "") {
			msgAndFocus("#id", "아이디를 입력해주세요");
			return;
		} else if ($("#pwd").val() == "") {
			msgAndFocus("#pwd", "비밀번호를 입력해주세요");
			return;
		} else if ($("#pwd").val() != $("#pwdcheck").val()) {
			msgAndFocus("#pwdcheck", "비밀번호가 같지 않습니다.");
			return;
		} else if ($("#emailinput").val() == "") {
			msgAndFocus("#emailinput", "이메일을 입력해주세요");
			return;
		} else if (idDup) {
			msgAndFocus("#id", "아이디를 바꿔주세요.");
			return;
		} else if (emailDup) {
			msgAndFocus("#emailinput", "email을 바꿔주세요.");
			return;
		} else {
			$("#memberform").submit(); 
		}
	}
	function setMsg(id, msg, color){
		$(id).text(msg);
		console.log(id + " " + msg + " " + color);
		$(id).css({'color': color});
	}
	function setDup(attr, flag){
		if(attr == "#id") {
			idDup = flag;
			if(flag) setMsg("#idDupMsg", "이미 존재하는 아이디 입니다.", 'red');
			else setMsg("#idDupMsg", "사용 가능한 아이디 입니다.", 'blue');
		}
		else if(attr == "#emailinput") {
			emailDup = flag;
			if(flag) setMsg("#emailDupMsg", "이미 존재하는 이메일 입니다.", 'red');
			else setMsg("#emailDupMsg", "사용 가능한 이메일 입니다.", 'blue');
		}
		return flag;
	}
	function dupCheck(items, attr, emaildomain = false){
		target = $(attr).val() + (emaildomain ? ("@"+$("#emaildomain option:selected").val()) : '');
		for(let i=0; i < items.length; i++){
			console.log(items[i] + " " + target);
			if(items[i] == target) {
				return setDup(attr, true);
			}
		}
		return setDup(attr, false);
	}
	/* 문자열로 받길래 배열로 바꿔 넘겨주긴 했는데.. 객체로 못받나? */
	function idCheck() {
		dupCheck("${idList}".substr(1, "${idList}".length-2).split(", "), "#id");
	}
	function emailCheck() {
		dupCheck("${emailList}".substr(1, "${emailList}".length-2).split(", "), "#emailinput", true);
	}
	function keyCheck(){
		if(event.keyCode == 13){
			join();
		}
	}
</script>
</head>
<body>
	<%@include file="../main/header.jsp"%>

	<div class="jumbotron2 text-center" align="center" style="margin: 70px 0 0">
		<p style="font-size: 130%;">회원가입</p>
	</div>
	<div class="container" align="center" style="width: 40%;">
		<form id="memberform" method="post" action="${root}/member/join"
			enctype="multipart/form-data">
			<div class="profile">
				<span class="img"></span> 
				<span class="file txt-photo">
					<input type="file" id="profile" name="profile" />
				</span>
			</div>
			<div class="form-group" align="left">
				<label for="">아이디</label> <input type="text" class="form-control"
					id="id" onKeyUp="idCheck()" name="id">
				<div id="idDupMsg"></div>
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
				<label for="name">소속</label> <input type="text" class="form-control"
					id="dpt" name="dpt">
			</div>
			<div class="form-group" align="left">
				<label for="email">이메일</label><br>
				<div class="custom-control-inline input-inline" id="email">
					<input type="text" class="form-control" onKeyUp="emailCheck(); keyCheck()"
						id="emailinput" name="email" size="25"> @ <select
						class="form-control" id="emaildomain" name="emaildomain"
						onchange="emailCheck()">
						<option value="naver.com">naver.com</option>
						<option value="kakao.com">kakao.com</option>
						<option value="google.com">google.com</option>
						<option value="nate.com">nate.com</option>
						<option value="hanmail.net">hanmail.net</option>
					</select>
				</div>
				<div id="emailDupMsg"></div>
			</div>


			<div class="form-group" align="center">
				<button type="button" id="registerBtn" class="btn btn-primary">회원가입</button>
				<button type="reset" class="btn btn-warning">초기화</button>
			</div>
		</form>
	</div>

	<script>
	$(document).ready(function() {
		$.ajax({
	   		 url:"/sido",
	   		 method:"post",
	   		 dataType: "json",
	   		 contentType:"application/json; charset=UTF-8",
	   		 success:function(sido){
	   			 console.dir(sido)
	   			 $("#dong").empty().append( "<option value=''> 동 </option>" )

	   			 list = sido.sidoName;
	   			 list2 = sido.sidoCode;
	   			 
	   			 for(let i =0; i<list.length; i++){
	   				 //console.log(list[i]+" "+list2[i]);
	   				 $("#city").append( "<option value='"+list2[i]+"' name='city'> "+ list[i]+" </option>" )
	   			 }
	   			 
	   		 }
	   	 })
	});
	
	var maxCount = 3;								
	var count = 0;   					
	function CountChecked(field){ 		
		if (field.checked) 			
			count += 1;						
		else count -= 1;						
		
		if (count > maxCount) {
			alert("최대 3개까지만 선택가능합니다!");
		field.checked = false;						
		count -= 1;		
		}
	}
   	
   	 function getGugunList(sidoCode){
   		 console.log(sidoCode);
   		 $.ajax({
   		 url:"/gugun",
   		 data: sidoCode,
   		 method:"post",
   		 dataType: "json",
   		 contentType:"application/json; charset=UTF-8",
   		 success:function(gugunList){
   			
   			 $("#gugun").empty().append( "<option value=''> 시/구/군 </option>" )
   			 
   			 //console.dir(sidoList)
   			 for(gugun of gugunList){
   				//console.log(gugun.code + ","+ gugun.name);
   				$("#gugun").append( "<option value='"+gugun+"' name='gugun' >"+ gugun+" </option>" )
   			 }
   			 
   		 }
   	 	})
   	 }
   	 
   	 function getDongList(gugun){
   		 $.ajax({
   			 url:"/dong",
   			 data: gugun,
   			 method:"post",
       		 dataType: "json",
       		 contentType:"application/json; charset=UTF-8",
   			 success:function(dongList){
   				
   				 $("#dong").empty().append( "<option value=''> 동 </option>" )
   				 
   				 for(dong of dongList){
   				 	$("#dong").append( "<option value='"+dong+"' name='dong' >"+ dong+" </option>" )
   				 }
   				 
   			 }
   		 	})
   	 }
   	// html file API
   	let uploadFile = null;
	let profile = document.querySelector("#profile");
	profile.onchange = function (event) {		// onchange:여기선 인풋창에 있는 값이 바뀌었을 때 호출
		
    	let file = event.target.files[0];		// event.target: 이벤트가 발생한 그 객체 자체
		console.dir(event.target);
		console.dir(event.target.files);
		
    	if (file.type.substring(0, 5) != 'image') {
    		alert("이미지를 선택하세요");
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
    imgFrame.ondrop = function (event) {			// 2. ondrop: 그 영역으로 drop할 수 있는 이벤트(여기선 대상이 .img)
    	uploadFile = event.dataTransfer.files[0];	// 실제 드랍된애에 대한 정보 뽑아냄, 여러개면 files for루프로 돌려서 하면 됨
    	if (uploadFile.type.substring(0, 5) != 'image') {
    		alert("이미지를 선택하세요");
    		return false;
    	}
    	console.log(uploadFile)
        this.innerHTML = `<img src="\${URL.createObjectURL(uploadFile)}">`;
        return false;
    }
	</script>
</body>
</html>