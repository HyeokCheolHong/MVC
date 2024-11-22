<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h3>JSTL c:chose 다중 조건문</h3>

<ul>
	<c:choose>
		<c:when test="${param.name == 'WON MINJUNG'}">
			<li> 당신의 이름은 <b>${param.name}</b> 입니다.</li>
		</c:when>
		<c:otherwise>
			<li>해당 사항 없습니다!</li>
		</c:otherwise>
	</c:choose>
</ul>