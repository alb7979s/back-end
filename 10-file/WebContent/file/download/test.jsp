<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일</title>
<%@ include file="/include/basicInclude.jsp" %>
</head>
<body>
<div class="container">
	<div class="header">
		<c:import url="/include/topMenu.jsp" />
	</div>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<div class="content">
		<h2>파일 다운로드</h2>
		<hr>
		<div class="down">
			<div>
				<img src="${contextPath}/download.do?path=/commons/2021/04/17&name=2921131d-dc86-4a1b-81b6-6a2440372ed4.jpg" 
					 width="300"
				>
			</div>
			<div>
				<a target="_blank" href="${contextPath}/download.do?path=/commons/2021/04/17&name=2921131d-dc86-4a1b-81b6-6a2440372ed4.jpg">
					이미지 보여주기
				</a>	
			</div>
			<div>	
				<!-- dname 붙은건 다운로드! -->
				<a href="${contextPath}/download.do?path=/commons/2021/04/17&name=2921131d-dc86-4a1b-81b6-6a2440372ed4.jpg&dname=테스트.jpg">
					이미지 다운로드
				</a>
			</div>	
		</div>
	</div>	
	<div class="footer">
		<%@ include file="/include/bottom.jsp" %>
	</div>	
</div>
<script>
	$("ul.nav.navbar-nav > li").removeClass("active");
	$("ul.nav.navbar-nav > li:eq(6)").addClass("active");
</script>
</body>
</html>

















