<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>상품 목록</h2>
<table border="1">
	<thead>
		<th>아이디</th>
		<th>이름</th>
		<th>가격</th>
		<th>설명</th>
	</thead>
	<tbody>
		<c:forEach var="product" items="${products}">
			<tr>
				<td>${product.id }</td>
				<td>${product.name }</td>
				<td>${product.price }</td>
				<td>${product.description }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<a href="${root }/moveRegist">새 상품 등록</a>

</body>
</html>