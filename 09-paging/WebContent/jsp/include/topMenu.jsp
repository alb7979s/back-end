<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">페이징 정리</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="<c:url value='/house/list0' />">House0</a></li>
      <li><a href="<c:url value='/house/list1' />">House1</a></li>
      <li><a href="<c:url value='/house/list2' />">House2</a></li>
      <li><a href="<c:url value='/house/list3' />">House3</a></li>
      <li><a href="<c:url value='/house/list4' />">House4</a></li>
      <li><a href="<c:url value='/house/list5' />">House5</a></li>
      <li><a href="<c:url value='/jsp/house/list6.html' />">House6</a></li>
      <li><a href="<c:url value='/house/list7' />">House7</a></li>
    </ul>
  </div>
</nav> 