<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- JSTL 코어 태그립 추가 --%>

<c:set var="fruit" value="${param.name}" />
<%-- *.jsp?name=값 형태의 get방식으로 전달되는 피라미터 name 값을 가져와서 JSTL 변수 fruit에 저장 --%>

피라미터 name에 실려온 값:
<c:if test="${!empty fruit}">
 <c:out value="${fruit}" />
</c:if> <%--c:if JSTL 조건문이다. --%>

<hr/>
<c:choose>
 <c:when test="${fruit == 'apple'}">
  ${fruit} : 사과
 </c:when>
 <c:when test="${fruit == 'orange'}">
  <c:out value="${fruit}" /> : 오렌지
 </c:when>
 <c:otherwise>해당 사항 없을때 실행</c:otherwise>
</c:choose>