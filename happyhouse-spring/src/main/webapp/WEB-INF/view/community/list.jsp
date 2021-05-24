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
<c:set var="communities" value="${result.list}" />
<c:set var="pr" value="${result.pageResult}" />
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="60">

  <%@include file="../main/header.jsp" %>

  <div class="jumbotron text-center">
    <h1>커뮤니티 게시판</h1>
  </div>

  <div class="container menu" id="board" style="padding-top: 50px;">
    <button id = "goWriteBtn" type="button" class="btn clickMakeBoard btn-primary">글쓰기</button>
    
	<form id="searchform">
	    <div class="dropdown" style="float: right; height: 51px;">
	    <!--    <button type="button" class="btn dropdown-toggle dropbtn" data-toggle="dropdown">검색</button>-->
	     	<select class="btn dropdown-toggle dropbtn" data-toggle="dropdown" name="key" id="key" onchange="inputPlaceholder();">
	   	 		<option value="userid" <c:if test="${result.key =='userid'}">selected</c:if>>작성자</option>
	   	 		<option value="subject" <c:if test="${result.key =='subject'}">selected</c:if>>제목</option>
	    		<option value="content" <c:if test="${result.key =='content'}">selected</c:if>>내용</option>
	    	</select>
	      <input type="text" name="word" id="word" value="${result.word}" placeholder="검색어를 입력해주세요.">
	      <button id="searchBtn" onclick="search();" class="btn btn-primary">검색</button>
	    </div>
     </form>

    <div class="w3-padding w3-white notranslate">
      <table class="table table-striped">
        <thead>
          <tr>
            <th class="col-md-2">글번호</th>
            <th class="col-md-5">제목</th>
            <th class="col-md-2">작성자</th>
            <th class="col-md-2">작성일</th>
            <th class="col-md-1">조회수</th>
            <th class="col-md-1">♥</th>
          </tr>
        </thead>
        <tbody>
		<c:forEach var="item" items = "${result.communities}">
			<tr>
			<input type="hidden" value="${item.no}"/>
            	<td class="col-md-2">${item.no }</td>
            	<td class="col-md-5">${item.subject }</td>
            	<td class="col-md-2">${item.userid }</td>
           	 	<td class="col-md-2">${item.regtime}</td>
           	 	<td class="col-md-1">${item.views}</td>
           	 	<td class="col-md-1">${item.like}</td>
          	</tr>
		</c:forEach>

        </tbody>
      </table>
    </div>
 
  	<c:if test="${pr.count != 0}"> 
		<nav>
	<ul class="pagination botBar">
		<!-- 이전 -->
		<li class="<c:if test="${not pr.prev}">disabled</c:if>">
		<a href="#1" <c:if test="${pr.prev}">onclick="goPage(${pr.beginPage-1});"</c:if>
			aria-label="dataevious"> <span aria-hidden="true">&laquo;</span>
		</a></li>
		<c:forEach var="i" begin="${pr.beginPage}" end="${pr.endPage}">
			<c:choose>
				<c:when test="${i eq pr.pageNo}">
					<li class="page-item active"><a href="#1">${i}</a></li>
				</c:when>
				<c:otherwise>
					<li><a class="page-item" href="#1" onclick="goPage(${i});">${i}</a></li>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<!-- 다음 -->
		<li class="<c:if test="${not pr.next}">disabled</c:if>">
		
		<a href="#1" <c:if test="${pr.next}">onclick="goPage(${pr.endPage + 1});"</c:if>
			aria-label="Next"> <span aria-hidden="true">&raquo;</span>
		</a></li>
	</ul>
</nav>
     </c:if>
     
      </div>
  <script>
	const goWriteBtn = document.querySelector("#goWriteBtn");
//	const hiddenform = document.querySelector("#hiddenform");
	goWriteBtn.addEventListener('click',function() {
		console.log("GoWriteBtn click");
		location.href = "${root}/community/write";
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
			location.href="${root}/community/detail?number=" + e.target.parentNode.children[0].value;			
			
		}else{
			//location.href="${root}/main?act=detail&number=" + e.target.children[0].value;			
		}
		
	},true);

	function goPage(pageNo){
		let key = document.getElementById("key").value;
		let word = document.getElementById("word").value;
    	if(key!='' && word!=''){
    		location.href="${root}/community/?pageNo="+pageNo+"&key="+key+"&word="+word;
    	}
    	
    	else location.href="${root}/community/list?pageNo="+pageNo;
	}
  </script>
  
  <script type="text/javascript">
		function inputPlaceholder(){
			document.getElementById("word").value="";
			document.getElementById("word").placeholder="검색어를 입력해주세요.";
		}
		
		function search(){
			let key = document.getElementById("key").value;
			let word = document.getElementById("word").value;
			if(document.getElementById("word").value == ""){
				alert("검색어를 입력하세요");
				return;
			}

			document.getElementById("searchform").action = '${ root }/community/';
			document.getElementById("searchform").submit();
			
		}
	</script>
</body>

</html>