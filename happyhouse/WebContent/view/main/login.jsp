<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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


<ul class="nav navbar-nav navbar-right">
	<c:if test="${userinfo == null}">
      <li><button type="button" class="btn btn-warning" style="margin-top: 10px; margin-right: 10px;" id="login" onclick="moveLogin();">로그인</button></li>
      <li><button type="button" class="btn btn-warning" style="margin-top: 10px; margin-right: 10px;" id="reg" onclick="moveRegistry();">회원가입</button></li>
    </c:if>	
	<c:if test="${userinfo != null}">
	  <li>${userinfo.id}님 안녕하세요</li>
      <li><button type="button" class="btn btn-warning" style="margin-top: 10px; margin-right: 10px; "id = "logout" onclick="moveLogout();">로그아웃</button></li>
      <li><button type="button" class="btn btn-warning" style="margin-top: 10px; margin-right: 10px; "id = "myInfo" onclick="moveModify();">수정하기</button></li>
    </c:if>
</ul>