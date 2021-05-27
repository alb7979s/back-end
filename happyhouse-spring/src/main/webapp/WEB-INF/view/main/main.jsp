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
<script>
</script>
</head>
<body>

	<%@include file="header.jsp" %>

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
      <div class="row slideanim" id="main_notice">
     	<!-- 로딩할 때, ajax로 공지사항 최근 6개 불러옴 -->   
      </div>
     
    </div>
    
<!--    	<div class="container-fluid bg-grey">
      <h2 class="text-center">뉴스기사</h2>
      <div class="row slideanim">
        <div class="col-sm-4">
            <div class="panel2 panel-default text-center" style="border:1px solid rgb(216, 216, 216);">
                <div class="panel-body">
                    <p><strong>무슨무슨일</strong></p>
                    <p>lalalalalalalala </p>
                    <p style="text-align:right;margin-right:20px;">자세히</p>
                </div>
            </div>
        </div>
        <div class="col-sm-4">
          <div class="panel2 panel-default text-center" style="border:1px solid rgb(216, 216, 216);">
            <div class="panel-body">
                <p><strong>무슨무슨일</strong></p>
                <p>lalalalalalalala </p>
                <p style="text-align:right;margin-right:20px;">자세히</p>
            </div>
        </div>
        </div>
        <div class="col-sm-4">
            <div class="panel2 panel-default text-center" style="border:1px solid rgb(216, 216, 216);">
                <div class="panel-body">
                    <p><strong>무슨무슨일</strong></p>
                    <p>lalalalalalalala</p>
                    <p style="text-align:right;margin-right:20px;">자세히</p>
                </div>
            </div>
        </div>
      </div>
    </div> -->
    
    <footer class="container-fluid text-center">
      <a href="#top" title="To Top">
        <span class="glyphicon glyphicon-chevron-up"></span>
      </a>
      <p>Copyright by SSAFY. All rights reserved.</p>
    </footer>
    
   <script>
 
	   $.ajax({
			 url:"/notice",
			 method:"post",
			 dataType: "json",
			 contentType:"application/json; charset=UTF-8",
			 success:function(data){
				 /* console.log(data); */
				
				 var result = '';
				 if(data==null){
					 result+='<h2>등록된 공지사항이 없습니다.</h2>'
				 }
				 else{
					 $.each(data, function(index, item){
						 /* console.log(index); */
						 result+='<div class="col-sm-4">'
						 result+='<div class="panel2 panel-default text-center" style="border:1px solid rgb(216, 216, 216);">'
						 result+='<div class="panel-body">'
						 result+='<p><strong>공지  #'+item.noticeno+'</strong></p>'
						 result+='<p>'+item.subject+'</p>'
						 result+='<p style="text-align:right; margin-right:20px;">'
						 result+='<a style="color:gray; text-decoration:none;" href="${root}/notice/detail?number='+item.noticeno+ '">자세히</a>'
						 result+='</p></div></div></div>'
						 
						 if(index==2)
							 result+=' <br><br>';
					 })
				 }
				 
				 $("#main_notice").html(result);
				 
			 },
			 error:function(data){
				 console.log("메인화면 -공지사항 6개 오류");
			 },
		 }); 

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
