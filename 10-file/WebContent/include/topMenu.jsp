<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">파일 업로드, 다운로드 정리</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="<c:url value='/upload/test01' />">업로드1</a></li>
      <li><a href="<c:url value='/upload/test02' />">업로드2</a></li>
      <li><a href="<c:url value='/upload/test03' />">업로드3</a></li>
      <li><a href="<c:url value='/upload/test04' />">업로드4</a></li>
      <li><a href="<c:url value='/upload/test05' />">업로드5</a></li>
      <li><a href="<c:url value='/upload/test06' />">업로드6</a></li>
      <li><a href="<c:url value='/download/test' />">다운로드</a></li>
      <li><a href="<c:url value='/upload/test07' />">Ajax업로드7</a></li>
      <li><a href="<c:url value='/upload/test08' />">파일선택-미리보기8</a></li>
      <li><a href="<c:url value='/upload/test09' />">파일드래그-미리보기9</a></li>
      <li><a href="<c:url value='/upload/test10' />">업로드 DB 저장10</a></li>
      <li><a href="<c:url value='/upload/test11' />">업로드 파일 모듈화11</a></li>
    </ul>
  </div>
</nav> 