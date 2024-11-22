<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%-- JSTL 코어 태그립 추가 --%>

<jsp:useBean id="user" class="net.daum.vo.UserVO" />
<jsp:setProperty property="firstName" name="user" value="홍" />
<%--값 저장 액션태그이다. 위의 것을 자바코드로 표현하면 user.setFirstName("홍") 과 같은 기능을 한다 --%>
<jsp:setProperty property="lastName" name="user" value="길동" />

<h3>기존의 스크립트 요소를 사용한 예</h3>
<form>
  성:
 <% if(user.getFirstName() != null){%>
  <input type="text" name="firstName" size="3" value="<%=user.getFirstName()%>" />
 <% } %>
 이름:
 <% if(user.getLastName() != null) { %>
  <input type="text" name="lastName" size="8" value="<%=user.getLastName()%>" />
 <% } %>
</form>

<hr/>

<h3>EL과 jstl을 사용한 예</h3>
<form>
 성:
 <c:if test="${!empty user.firstName}"> <%--JSTL c:if 조건문 --%>
  ${user.firstName}
 </c:if>
 이름:
 <c:if test="${!empty user.lastName}">
  ${user.lastName}
 </c:if>
</form>
