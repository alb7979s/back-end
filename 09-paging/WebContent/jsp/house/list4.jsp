<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>페이징 게시판</title>
<%@ include file="/jsp/include/basicInclude.jsp" %>
</head>
<body>
<%-- 아래서 c:import 결과값으로 받아오려면 scope 설정 해줘야함 %-->
<%-- 아니면  아래서 <%@ include file="" %> 이거로 선언해주던지 --%>
<c:set var="pr" value="${result.pageResult}" scope="request"/>
<div class="container">

	<div class="header">
		<c:import url="/jsp/include/topMenu.jsp" />
	</div>

	<div class="content">
		<ol class="breadcrumb">
		  <li><a href="#1">Home</a></li>
		  <li class="active">House4</li>
		</ol>
		<hr>		
		<div class="row">
		    <div class="col-md-10"></div>
		    <div class="col-md-2" style="text-align: right">
				전체 ${pr.count}개
		    </div>
		</div>
		<div class="table-responsive">
		<table class="table table-hover">
			<thead>
			<tr>
				<th>번호</th>
				<th>아파트명</th>
				<th>동</th>
				<th>거래일</th>
				<th>거래금액</th>
				<th>건축년도</th>
				<th>층</th>
				<th>면적</th>
			</tr>
			</thead>
			<c:forEach var="house" items="${result.list}" varStatus="loop">
				<tr>
					<!-- db에 없을때는 이렇게 해줄 수 있음! -->
					<!-- <td>${(pr.pageNo -1) * 10 + loop.count}</td>  -->
					<td>${house.no}</td>
					<td>${house.aptName}</td>
					<td>${house.dong}</td>
					<td>${house.dealYear}/${house.dealMonth}/${house.dealDay}</td>
					<td>${house.dealAmount}만원</td>
					<td>${house.buildYear}년</td>
					<td>${house.floor}층</td>
					<td>${house.area} 평방미터</td>
				</tr>
			</c:forEach>
			<c:if test="${empty result.list}">
				<tr>
					<td colspan='8'>입력된 정보가 없습니다.</td>
				</tr>
			</c:if>
		</table>
		</div>
		<!-- 페이징 처리 -->		
		<c:if test="${pr.count != 0}">
            <c:import url="/jsp/include/page.jsp"/>
        </c:if>
	</div>		
	
	<div class="footer">
		<%@ include file="/jsp/include/bottom.jsp" %>
	</div>
</div>
<script>
	// 상단 메뉴 선택 상태 만들기
	$("ul.nav > li").removeClass("active");	//지워주고	
	$("ul.nav > li:eq(4)").addClass("active");	//첫번째거 active 만들어줌(동적으로 만들 수 있대)
	
	function goPage(pageNo) {
		location.href="list4?pageNo=" + pageNo;
	}
</script>
</body>
</html>












