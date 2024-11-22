<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%-- JSTL fmt 태그립 추가 --%>

<c:set var="price" value="10000" />
통화형 : <fmt:formatNumber type="currency" currencySymbol="&#8361;" value="${price}"/>
<%-- fmt:formatNumber JSTL은 숫자양식, currency속성은 통화 형식, currencySymbol속성은 통화형식일때 표현하는 기호 --%>

<hr/>
<c:set var="now" value="<%=new java.util.Date() %>"/>
<fmt:formatDate value="${now}" type="date" dateStyle="full" />
<%-- fmt:formatDate JSTL은 날짜양식, date를 풀스타일로 지정 --%>

<hr/>
<fmt:formatDate value="${now}" type="time" />
<%-- time은 시간 --%>