<%@ tag body-content="empty" pageEncoding="utf-8" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ attribute name="data" type="kr.co.mlec.happyhouse.repository.dto.PageResultDto" %>
			<nav>
			  <ul class="pagination">
			    <li class="<c:if test="${not data.prev}">disabled</c:if>">
			      <a href="#1" <c:if test="${data.prev}">onclick="goPage(${data.beginPage - 1});"</c:if> aria-label="Previous">
			        <span aria-hidden="true">&laquo;</span>
			      </a>
			    </li>

				<c:forEach var="i" begin="${data.beginPage}" end="${data.endPage}">
				    <c:choose>
				    	<c:when test="${i eq data.pageNo}">
						    <li class="active"><a href="#1">${i}</a></li>
				    	</c:when>
				    	<c:otherwise>
						    <li><a href="#1" onclick="goPage(${i});">${i}</a></li>
				    	</c:otherwise>
				    </c:choose>
				</c:forEach>
				
			    <li class="<c:if test="${not data.next}">disabled</c:if>">
			      <a href="#1" <c:if test="${data.next}">onclick="goPage(${data.endPage + 1});"</c:if> aria-label="Next">
			        <span aria-hidden="true">&raquo;</span>
			      </a>
			    </li>	
			  </ul>
			</nav>