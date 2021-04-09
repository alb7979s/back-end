<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>EL 연산자</h2>
	<div>5 + 5 = <% out.println(5 + 5); %></div>
	<div>5 + 5 = <%= 5 + 5 %></div>
	<div>5 + 5 = ${5 + 5}</div>
	<div> 5 % 2 = ${5 mod 2}</div>
	<div> 5 == 2 = ${5 eq 2}</div>
	<div>empty "a" = ${empty "a"}</div>
	<div>empty "" = ${empty ""}</div>
	
	<%--참고1 
	JSP 2.2까지는 문자열 연산 안됨(숫자로 바꿔서 연산)
	JSP 2.3부터는 문자열 연산 지원(+=)
	--%>
	<div>"100" + "200" = ${"100" + "200"}</div>		<%-- 300 나옴, 숫자로 바꿔서 처리해줌 --%>
	<%-- <div>"a" + "b" = ${"a" + "b"}</div>				 에러남, 숫자로 바꾸려해서 --%>
	<div>"a" + "b" = ${"a" += "b"}</div>			
	
	<%-- 참고2, .js로 빼서 쓰는거 권장
	<script>
		alert(${5 + 5}); 	//이거 el 문법임, 서버 거쳐서 올 때 먼저 처리함
		alert(`${5 + 5}`);	//따라서 이렇게 하고 싶으면 .js 파일을 따로 빼던지, $앞에 \붙여줌
	</script>
	 --%>
</body>
</html>


