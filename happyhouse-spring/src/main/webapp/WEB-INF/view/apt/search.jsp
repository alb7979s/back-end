<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
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

<script type="text/javascript">
function searchCity() {
	if (document.getElementById("word").value == "") {
		alert("검색어를 입력해주세요.");
		return;
	} else {
		console.log("ok");
		document.getElementById("searchform").action = "${root}/apt";
		document.getElementById("searchform").submit();
	}
}
</script>
</head>
<body>
    <div class="jumbotron text-center">
      <h1>Happy House</h1> 
      <p style="font-size: 130%;">내 집 마련의 꿈을 이루세요 !</p>
      <div style="display: inline-block; text-align:center;">
        <form id="searchform" method="get" action="">
            <div class="input-group">
                <select class="form-control" name="key" id="key" style="width:100px;">
                    <option value="dong" selected="selected">동</option>
			    	<option value="AptName">아파트</option>
                </select>
            	<input type="text" class="form-control" id="word" name="word" size="50" placeholder="검색어를 입력해주세요" style="width:600px;">
            	<button onclick="searchCity();" type="button" class="btn btn-warning"><span class="glyphicon glyphicon-search"></span></button>
            </div>
        </form>
      </div>
    </div>
</body>
</html>