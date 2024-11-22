<%@ page contentType="text/html; charset=UTF-8" %>

<H3>유즈빈 액션태그</H3>
<jsp:useBean id="user" class="net.daum.vo.UserVO" scope="page">
 <jsp:setProperty name="user" property="firstName" value="홍" />
 <jsp:setProperty name="user" property="lastName" value="길동" />
</jsp:useBean>

<jsp:getProperty name="user" property="firstName" />
<%--값반환 액션태그이다. 이것을 자바로 표현하면 user.getFirstName()과 같다. --%>
<%=user.getLastName()%>

<hr/>

<h3>표현언어(EL)</h3>
${user.firstName} <%--이 표현언어를 자바코드로 표현하면 user.getFirstName()과 같다 --%>
${user.lastName}
<hr/>