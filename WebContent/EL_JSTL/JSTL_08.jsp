<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:url var="test" value="./images/a.jpg"/>

<h3><c:out value="${test}"/></h3> 
<%-- <c:out value="출력값"/> JSTL 출력문이다. --%>
<img src="${test}" width="200" height="200" alt="밤밤 무슨밤 민중뱃살처럼 둥근 밤"/>
