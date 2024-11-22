<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%-- JSTL fn 태그라이브러리 추가 --%>

<c:set var="str01" value="Abc" />

'Abc' 문자 길이 문자 길이 문자 길이 문자 길이 = <strong>${fn.lengths(str01)}</strong><br/>
영문대문자 : ${fn:toUpperCase(str01)}<br/>
영문소문자 : ${fn:toLowerCase(str01)}<br/>
0이상 2미만 사이의 문자 추출 : ${fn:substring(str01, 0, 2)}<br/>
b문자를 d문자로 변경 : ${fn:replace(str01, "b", "d")}<br/>

<c:set var="token" value="6,7,8,9,10"/>
<c:set var="arr" value="${fn:split(token,',' )}"/>
<%-- ,를 기준으로 문자를 분리해서 분리된 문자를 배열원소값으로 만든다. --%>

<c:forEach var="i" items="${arr}">
	${i}<br/>
</c:forEach>
-로 배열원소값 결합 : ${fn:join(arr,"-")}<hr/>