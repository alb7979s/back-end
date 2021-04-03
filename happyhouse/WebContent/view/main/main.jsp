<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>HappyHouse</title>
<link rel="stylesheet" href="${root}/css/main.css">
<script>
function moveLogin() {
	document.location.href = "${root}/view/member/login.jsp";
}
function moveRegistry(){
	document.location.href = "${root}/view/member/join.jsp";
}
function moveModify(){
	document.location.href = "${root}/view/member/modify.jsp";
}
function moveLogout() {
	document.location.href = "${root}/member?act=logout";
}
</script>
</head>
<body>
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
          <ul class="nav navbar-nav navbar-right">
			<c:if test="${userinfo == null}">
            <li><button type="button" class="btn btn-warning" style="margin-top: 10px; margin-right: 10px;" id="login" onclick="moveLogin();">로그인</button></li>
            <li><button type="button" class="btn btn-warning" style="margin-top: 10px; margin-right: 10px;" id="reg" onclick="moveRegistry();">회원가입</button></li>
            </c:if>
			<c:if test="${userinfo != null}">
            <li><button type="button" class="btn btn-warning" style="margin-top: 10px; margin-right: 10px; "id = "logout" onclick="moveLogout();">로그아웃</button></li>
            <li><button type="button" class="btn btn-warning" style="margin-top: 10px; margin-right: 10px; "id = "myInfo" onclick="moveModify();">수정하기</button></li>
            </c:if>
          </ul>
        </div>
      </div>
    </nav>
    
    <%@include file="../apt/search.jsp" %>
    
    <!-- Container (Portfolio Section) -->
    <div id="about" class="container-fluid text-center bg-grey">
        <h2>About Happy House</h2>
        <div id="myCarousel" class="carousel slide text-center" data-ride="carousel">
          <!-- Indicators -->
          <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
          </ol>
      
          <!-- Wrapper for slides -->
          <div class="carousel-inner" role="listbox">
            <div class="item active">
              <h2 style="font-size:50px; margin-bottom:-50px;"><span class="glyphicon glyphicon-thumbs-up"></span></h2>
              <h4>Safe and Convenient<br><span>안전하고 편리합니다!</span></h4>
            </div>
            <div class="item">
              <h2 style="font-size:50px; margin-bottom:-50px;"><span class="glyphicon glyphicon-usd"></span></h2>
              <h4>Special deals<br><span>경험해보지 못한 거래</span></h4>
            </div>
            <div class="item">
              <h2 style="font-size:50px; margin-bottom:-50px;"><span class="glyphicon glyphicon-heart"></span></h2>
              <h4>Good<br><span>그냥 좋아요!!!</span></h4>
            </div>
          </div>
      
          <!-- Left and right controls -->
          <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
          </a>
          <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
          </a>
        </div>
    </div>

    <div class="container-fluid text-center">
      <h2><span class="glyphicon glyphicon-ok"></span>공지사항</h2>
      <br>
      <div class="row slideanim">
        <div class="col-sm-4">
            <div class="panel panel-default text-center" style="border:1px solid rgb(216, 216, 216);">
                <div class="panel-body">
                    <p><strong>첫 공지입니다.</strong></p>
                    <p>공지에요. 공지에요. 공지에요. </p>
                    <p style="text-align:right;margin-right:20px;">자세히</p>
                </div>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="panel panel-default text-center" style="border:1px solid rgb(216, 216, 216);">
                <div class="panel-body">
                    <p><strong>첫 공지입니다.</strong></p>
                    <p>공지에요. 공지에요. 공지에요. </p>
                    <p style="text-align:right;margin-right:20px;">자세히</p>
                </div>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="panel panel-default text-center" style="border:1px solid rgb(216, 216, 216);">
                <div class="panel-body">
                    <p><strong>첫 공지입니다.</strong></p>
                    <p>공지에요. 공지에요. 공지에요. </p>
                    <p style="text-align:right;margin-right:20px;">자세히</p>
                </div>
            </div>
        </div>
      </div>
      <br><br>
      <div class="row slideanim">
        <div class="col-sm-4">
            <div class="panel panel-default text-center" style="border:1px solid rgb(216, 216, 216);">
                <div class="panel-body">
                    <p><strong>첫 공지입니다.</strong></p>
                    <p>공지에요. 공지에요. 공지에요. </p>
                    <p style="text-align:right;margin-right:20px;">자세히</p>
                </div>
            </div>
        </div>
        <div class="col-sm-4">
          <div class="panel panel-default text-center" style="border:1px solid rgb(216, 216, 216);">
            <div class="panel-body">
                <p><strong>첫 공지입니다.</strong></p>
                <p>공지에요. 공지에요. 공지에요. </p>
                <p style="text-align:right;margin-right:20px;">자세히</p>
            </div>
        </div>
        </div>
        <div class="col-sm-4">
            <div class="panel panel-default text-center" style="border:1px solid rgb(216, 216, 216);">
                <div class="panel-body">
                    <p><strong>첫 공지입니다.</strong></p>
                    <p>공지에요. 공지에요. 공지에요. </p>
                    <p style="text-align:right;margin-right:20px;">자세히</p>
                </div>
            </div>
        </div>
      </div>
    </div>
    
   	<div class="container-fluid bg-grey">
      <h2 class="text-center">뉴스기사</h2>
      <div class="row slideanim">
        <div class="col-sm-4">
            <div class="panel panel-default text-center" style="border:1px solid rgb(216, 216, 216);">
                <div class="panel-body">
                    <p><strong>무슨무슨일</strong></p>
                    <p>lalalalalalalala </p>
                    <p style="text-align:right;margin-right:20px;">자세히</p>
                </div>
            </div>
        </div>
        <div class="col-sm-4">
          <div class="panel panel-default text-center" style="border:1px solid rgb(216, 216, 216);">
            <div class="panel-body">
                <p><strong>무슨무슨일</strong></p>
                <p>lalalalalalalala </p>
                <p style="text-align:right;margin-right:20px;">자세히</p>
            </div>
        </div>
        </div>
        <div class="col-sm-4">
            <div class="panel panel-default text-center" style="border:1px solid rgb(216, 216, 216);">
                <div class="panel-body">
                    <p><strong>무슨무슨일</strong></p>
                    <p>lalalalalalalala</p>
                    <p style="text-align:right;margin-right:20px;">자세히</p>
                </div>
            </div>
        </div>
      </div>
    </div>
    
    <footer class="container-fluid text-center">
      <a href="#myPage" title="To Top">
        <span class="glyphicon glyphicon-chevron-up"></span>
      </a>
      <p>Copyright by SSAFY. All rights reserved.</p>
    </footer>
    
   <script>
    $(document).ready(function(){
        // Add smooth scrolling to all links in navbar + footer link
        $(".navbar a, footer a[href='#myPage']").on('click', function(event) {
          // Make sure this.hash has a value before overriding default behavior
          if (this.hash !== "") {
            // Prevent default anchor click behavior
            event.preventDefault();
      
            // Store hash
            var hash = this.hash;
      
            // Using jQuery's animate() method to add smooth page scroll
            // The optional number (900) specifies the number of milliseconds it takes to scroll to the specified area
            $('html, body').animate({
              scrollTop: $(hash).offset().top
            }, 900, function(){
         
              // Add hash (#) to URL when done scrolling (default click behavior)
              window.location.hash = hash;
            });
          } // End if
        });
        
        $(window).scroll(function() {
          $(".slideanim").each(function(){
            var pos = $(this).offset().top;
      
            var winTop = $(window).scrollTop();
              if (pos < winTop + 600) {
                $(this).addClass("slide");
              }
          });
        });
      })
    </script>

</body>
</html>
