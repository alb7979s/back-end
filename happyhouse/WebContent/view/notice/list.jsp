<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <title>HappyHouse</title>
  <link rel="stylesheet" href="${root}/css/main.css">
</head>

<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="60">

  <nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
      <div class="navbar-header">
        <a class="navbar-brand" href="index.jsp" style="font-size:2em;"><span class="glyphicon glyphicon-home"></span></a>
      </div>
      <div class="collapse navbar-collapse" id="myNavbar">
     <ul class="nav navbar-nav navbar-left">
          <li><a href="${root}/notice">공지사항</a></li>
          <li><a href="#">주변탐방</a></li>
          <li><a href="#">나의관심지역</a></li>
        </ul>

      </div>
    </div>
  </nav>

  <div class="jumbotron text-center">
    <h1>공지사항</h1>
  </div>

  <div class="container menu" id="board" style="padding-top: 50px;height: 1000px;">
  <form id="hiddenform" action="" method="post">
  	<input type ="hidden" name = "act" value="mvwrite">
    <button id = "goWriteBtn" type="button " class="btn clickMakeBoard btn-primary">글쓰기</button>
  </form>
    <div class="dropdown" style="float: right; height: 51px;">
    <!--    <button type="button" class="btn dropdown-toggle dropbtn" data-toggle="dropdown">검색</button>-->
     	<select class="btn dropdown-toggle dropbtn" data-toggle="dropdown" name="type" id="type">
   	 		<option  value="id">작성자</option>
    		<option  value="subject">제목</option>
		</select>
      <input type="text">
      <button type="button " class="btn btn-primary">검색</button>
    <!--   <div class="dropdown-menu">
        <h4 class="dropdown-item" onclick="dropSelectTitle()">제목</h4>
        <h4 class="dropdown-item" onclick="dropSelectUser()">작성자</h4>
      </div> -->

    </div>
    <div class="w3-padding w3-white notranslate">
      <table class="table table-striped">
        <thead>
          <tr>
            <th>글번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>작성일</th>
          </tr>
        </thead>
        <tbody>
		<c:forEach var="item" items = "${notices}">
			<tr>
			<input type="hidden" value="${item.noticeno}">
            	<td>${item.noticeno }</td>
            	<td>${item.subject }</td>
            	<td>${item.userid }</td>
           	 	<td>${item.regtime}</td>
          	</tr>
		</c:forEach>

        </tbody>
      </table>
    </div>
  </div>
  <div class="container menu" id="makeBoard" style="display: none;padding-top: 50px; height:1000px;">
    <h1 style="color: black;">게시판</h1>
    <form>
      <div class="form-group">
        <label for="exampleFormControlInput1" style="color: black; font-size: 20px; font-weight: bold">제목</label>
        <input type="title" class="form-control" id="exampleFormControlInput1">
      </div>
      <div class="form-group">
        <label for="exampleFormControlTextarea1"
          style="resize: horizontal; color: black; font-size: 20px; font-weight: bold">내용</label>
        <textarea class="form-control" id="exampleFormControlTextarea1" rows="25"></textarea>
      </div>
    </form>
    <div id="upde" style="text-align:center;">
      <button type="button" class="btn btn-warning" id = "boardUdate" style="display: none;">수정</button>
      <button type="button" class="btn btn-warning" id = "boardUdateFinish" style="display: none;">저장</button>
      <button type="button" class="btn btn-danger">삭제</button>
    </div>
    <div id="post" style="text-align: center; margin-top: 50px; padding-bottom: 100px; padding-bottom: 0;">
      <button type="button " class="btn btn-lg postBoard">POST
      </button>
    </div>
    <div id="back" style="text-align: center; margin-top: 50px; padding-bottom: 100px;">
      <button type="button " class="btn btn-lg backBoard">BACK
      </button>
    </div>
  </div>
<!--  
  <ul class="pagination botBar">
    <li class="page-item"><a class="page-link" href="#">Previous</a></li>
    <li class="page-item"><a class="page-link" href="#">1</a></li>
    <li class="page-item"><a class="page-link" href="#">2</a></li>
    <li class="page-item"><a class="page-link" href="#">3</a></li>
    <li class="page-item"><a class="page-link" href="#">Next</a></li>
  </ul>-->
  </div>
  <script>
	const goWriteBtn = document.querySelector("#goWriteBtn");
	const hiddenform = document.querySelector("#hiddenform");
	goWriteBtn.addEventListener('click',function() {
		hiddenform.action = "${root}/notice";
		hiddenform,submit();
	});
	const tbody = document.querySelector("tbody");
	tbody.addEventListener('click',function(e){
		console.log("click");
	//	console.log(e.target.children[0].value);
		console.log(e.target.tagName);
		console.log(e.target.nodeName);
		console.log(e.target.parentNode.children[0].value);
		if(e.target.nodeName === "TD"){
	//		console.log("${root}");
			location.href="${root}/notice?act=detail&number=" + e.target.parentNode.children[0].value;			
			
		}else{
			//location.href="${root}/main?act=detail&number=" + e.target.children[0].value;			
		}
		
	},true);
  </script>
</body>

</html>