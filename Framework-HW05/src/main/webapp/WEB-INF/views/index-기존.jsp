<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page contentType="text/html; charset=utf-8" %>
<c:set var="root" value="${pageContext.request.contextPath }"/>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"
	integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ=="
	crossorigin="anonymous"></script>
</head>
<body>
	<h1 style="text-align: center; margin: 50px auto;">
	Welcome To SSAFY</h1>
	<hr>
	<h2>상품 관리</h2>
	<button id="showList">목록조회</button>
	<div id="check"></div>
	<ul id="pilist"></ul>
	<button id="insertBtn">추가</button>
	<button id="modifyBtn">수정</button>
	<button id="deleteBtn">삭제</button>
	<!-- id 웬만하면 dto랑 맞춰줌 -->
	<table style="margin: 30px 0;">
		<tr>
			<td style="width: 100px; background-color: gray;">ID</td>
			<td><input type="text" id="id"></td>
		</tr>
		<tr>
			<td style="background-color: gray;">이름</td>
			<td><input type="text" id="name"></td>
		</tr>
		<tr>
			<td style="background-color: gray;">가격</td>
			<td><input type="text" id="price"></td>
		</tr>
	</table>
	<div>
		<textarea style="width: 100%; height: 100px;" id="description"></textarea>
	</div>
	<div id="result">조회 성공을 표시할 div</div>
	<script>
		
		function resultMsg(msg){
			$("#result").html(msg);
		}
		
		function infoClear() {
			$("#id").val("");						
			$("#name").val("");						
			$("#price").val("");
			$("#description").val("");			
		}
		
		function makeList(result) {
			let html = '';
			$(result).each(function (index, product) {
				html += `<li>\${product.id}</li>`;
			});
			$("#pilist").html(html);
		}
		
		//수정 버튼 클릭시
		$("#modifyBtn").click(function() {
			$.ajax({
				url: '${root}/product/update',
				type: "POST",
				data: {
					id: $("#id").val(),
					price: $("#price").val(),
					description: $("#description").val()
				},
				success: function(result) {
					makeList(result);
					infoClear();
					resultMsg("수정 성공!");
				}
			});
		})
		
		//추가 버튼 클릭시
		$("#insertBtn").click(function() {
			$.ajax({
				url: '${root}/product/insert',
				type: "POST",
				data: {
					id: $("#id").val(),
					name: $("#name").val(),
					price: $("#price").val(),
					description: $("#description").val()
				},
				success: function(result) {
					makeList(result);
					infoClear();
					resultMsg("추가 성공!");
				}
			});
		})
		
		//삭제 버튼 클릭시, 얘는 픽스되어 있어서 바로 click 이고 아래는 동적으로 생성되는거라 onclick
		$("#deleteBtn").click(function() {
			console.log($("#id").val());
			$.ajax({
				url: '${root}/product/delete',
				data: "id=" + $("#id").val(),
				success: function(result) {
					makeList(result);
					// 삭제된 정보 클리어
					infoClear();
					// 삭제 메세지 출력
					resultMsg("삭제 성공!");
				}
			});
		})
	
	
		// 목록 아이디 클릭시
		// pilist의 li태그가 클릭되게 되면!, #pilist가 부모가 되고 동적으로 생성된거의 자식li
		$("#pilist").on('click', 'li', function() {
			// 이벤트 발생한거 안에 있는 text
			console.log($(this).text());
			$.ajax({
				url: '${root}/product/detail',
				data: "id=" + $(this).text(),
				success: function(product) {
					$("#id").val(product.id);						
					$("#name").val(product.name);						
					$("#price").val(product.price);						//input이라 val
					$("#description").val(product.description);		//textarea이라 text					
				}
			});
		})
	
		// 문서가 로딩되면 상품 목록을 가져와 화면에 출력함
		function productList() {
			$.ajax({
				url: '${root}/product/list',
				success: function(result) {
					makeList(result);
				}
			});
		}
		
		
		// id가 showList인 버튼이 클릭되면(목록 조회 버튼 클릭시)
		$("#showList").click(function() {
			productList();
		});
		
		// 페이지 로딩시 호출
		productList();
	</script>
</body>
</html>