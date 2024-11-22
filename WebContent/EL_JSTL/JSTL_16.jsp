<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<h3>JSTL 코어 태그 예제 -> c:if, c:choose</h3>

<c:set var="country" value="${'korea'}"/>
<c:if test="${country != null}">
	국가명 : <c:out value="${nara}"/><hr/>
</c:if>

<c:if test="${!empty country}">
	국가명 : ${country}<hr/>
</c:if>

<c:choose>
	<c:when test="${country == 'korea'}">
		${country}의 겨울은 추울까?
	</c:when>
	
	<c:when test="${country == 'canada'}">
		<c:out value="${country}"/>의 겨울은 더 춥나요?
	</c:when>
	
	<c:otherwise>그 외의 나라들의 겨울은 알수 없다</c:otherwise>
</c:choose>