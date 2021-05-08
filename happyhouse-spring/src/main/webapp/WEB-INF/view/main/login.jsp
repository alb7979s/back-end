<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
	function moveLogin() {
		location.href="${root}/member/moveLogin";
	}
	function moveJoin(){
		location.href="${root}/member/moveJoin";
	}
	function moveModify(){
		location.href="${root}/member/moveModify";
	}
	function Logout() {
		location.href="${root}/member/logout";
	}
</script>


<ul class="nav navbar-nav navbar-right">
	<c:if test="${userinfo == null}">
      <li><button type="button" class="btn btn-warning" style="margin-top: 10px; margin-right: 10px;" id="login" onclick="moveLogin();">로그인</button></li>
      <li><button type="button" class="btn btn-warning" style="margin-top: 10px; margin-right: 10px;" id="reg" onclick="moveJoin();">회원가입</button></li>
    </c:if>	
	<c:if test="${userinfo != null}">
	  <li>${userinfo.id}님 안녕하세요</li>
      <li><button type="button" class="btn btn-warning" style="margin-top: 10px; margin-right: 10px; "id = "logout" onclick="Logout();">로그아웃</button></li>
      <li><button type="button" class="btn btn-warning" style="margin-top: 10px; margin-right: 10px; "id = "myInfo" onclick="moveModify();">수정하기</button></li>
    </c:if>
</ul>