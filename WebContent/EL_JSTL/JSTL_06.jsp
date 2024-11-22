<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- JSTL 코어 태그립 추가 --%>

<c:forTokens var="cityName" items="서울,부산,인천" delims=","> 
<%-- ,를 기준으로 문자열을 분리 즉 파싱한다. JSTL c:forTokens 문이다. --%>
   <c:out value="${cityName}" /><hr/>
</c:forTokens>