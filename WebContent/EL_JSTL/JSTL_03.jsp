<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="msg" value="${'안녕하세요'}" /> <%-- JSTL msg변수 설정 --%>

<c:set var="age" scope="page"> <%-- scope속성은 JSTL 변수 age가 적용될 범위를 설정. 기본값은 page이다. --%>
 ${30}
</c:set>

<c:out value="${msg}" /> <%-- msg 변수값 출력. jstl출력문 --%>
<hr/>
나이:${age}
<hr/>

<c:remove var="age" scope="page" /> 
<%--age변수 제거 --%>
나이:<c:out value="${age}" />

<hr/>

<c:catch var="errmsg">
 예외 발생전
 <%=10/0%>
 예외 발생후
</c:catch> <%--c:catch문은 JSTL 예외 처리문 --%>

<c:out value="${errmsg}" />
