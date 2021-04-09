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
            <li><a href="${root}/favorite">나의관심지역</a></li>
            <li><a href="${root}/clinic">선별진료소</a></li>
            <li><a href="${root}/hospital">국가안심병원</a></li>
          </ul>
          <%@ include file="/view/main/login.jsp" %>
        </div>
      </div>
    </nav>

	<div class="jumbotron text-center">
      <h1>Happy House</h1> 
      <c:if test="${userinfo == null}">
      	<p style="font-size: 130%;">로그인이 필요한 서비스 입니다.</p>
      </c:if>
      <c:if test="${userinfo != null}">
	      <c:if test="${favoriteinfo == null}">
	      	<p style="font-size: 130%;">나의 관심 지역</p>
	      	<button onclick = "location.href = '${root}/view/favorite/favorite.jsp'">설정</button> 
	      </c:if>
	      <c:if test="${favoriteinfo != null}">
	      	<p style="font-size: 130%;">나의 관심 지역: ${favoritedong}</p>
	      	<button onclick = "location.href = '${root}/view/favorite/favorite.jsp'">수정</button> 
	      </c:if>
      </c:if>
    </div>
    
    <div class="container-fluid" style="width:80%;">
		<c:if test="${favoriteinfo.size() != 0}">
			<c:forEach var="apt" items="${favoriteinfo}">
				<div class="col-sm-4 col-xs-12">
		            <div class="panel panel-default text-center">
		              <div class="panel-heading">
		                <h1>${apt.aptName}</h1>
		              </div>
		              <div class="panel-body" style="margin-top:15px;margin-bottom:15px;">
		                <p><strong>거래금액</strong> ${apt.dealAmount}</p>
		                <p><strong>면적</strong> ${apt.area}</p>
		                <p><strong><span class="glyphicon glyphicon-calendar"></span></strong> ${apt.dealYear}.${apt.dealMonth}.${apt.dealDay}</p>
		              </div>
		              <div class="panel-footer">
		                <div><button class="btn btn-lg" data-toggle="modal" data-target="#detailModal">상세정보</button></div>
		                <div><button class="btn btn-lg" data-toggle="modal" data-target="#mapModal">지도보기</button></div>
		              </div>
		            </div>      
		            <!-- 상세정보 Modal -->
		            <div class="modal fade" id="detailModal" role="dialog" style="margin-top:50px;">
		                <div class="modal-dialog">
		                <!-- Modal content-->
		                <div class="modal-content">
		                    <div class="modal-header">
		                    <button type="button" class="close" data-dismiss="modal">&times;</button>
		                    <h4 class="modal-title">e-편한세상</h4>
		                    </div>
		                    <div class="modal-body">
		                        <div class="panel panel-default text-center" style="border:1px solid rgb(216, 216, 216);">
		                            <div class="panel-body">
		                                <p><strong>거래금액</strong> 52,200만원</p>
		                                <p><strong>면적</strong> 84.56</p>
		                                <p><strong>거래구분</strong> 아파트매매</p>
		                                <p><strong><span class="glyphicon glyphicon-calendar"></span></strong> 2021.3.12</p>
		                            </div>
		                        </div>
		                    </div>
		                    <div class="modal-footer">
		                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		                    </div>
		                </div>
		                </div>
		            </div>
		        </div>
			</c:forEach>
		</c:if>
		<c:if test="${aptinfo.size() == 0}">
			<div class="container-fluid" style="width:80%;">
				<h2>검색결과가 없습니다.</h2>
			</div>
		</c:if>
	</div>
    	
</body>
</html>