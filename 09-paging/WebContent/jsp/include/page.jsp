<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<nav>
              <ul class="pagination">
              <!-- 이전 -->
              <li class="<c:if test="${not pr.prev}">disabled</c:if>">
              	  <!-- 경로 동적으로 바꿀거임(여러 방법중 하나), href="#1"은 그냥 페이지 이동 안하려고 넣은거-->
                  <a href="#1" <c:if test="${pr.prev}"> onclick="goPage(${pr.beginPage - 1});"</c:if> aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                  </a>
                </li>
                <c:forEach var="i" begin="${pr.beginPage}" end="${pr.endPage}">
                    <c:choose>
                        <c:when test="${i eq pr.pageNo}">
                            <li class="active"><a href="#1">${i}</a></li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="#1" onclick="goPage(${i});">${i}</a></li>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
                <!-- 다음 -->
                <li class="<c:if test="${not pr.next}">disabled</c:if>">
                  <a href="#1" <c:if test="${pr.next}"> onclick="goPage(${pr.endPage + 1});"</c:if> aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                  </a>
                </li>
              </ul>
            </nav>