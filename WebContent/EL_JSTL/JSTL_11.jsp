<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="true" >
	<!-- JSTL c:if 조건문 -->
	무조건 실행<hr/>
</c:if>

<c:if test="${param.name == 'hong'}">
	<!-- 브라우저 주소창에 name 값이 hong 일 경우 -->
	name 파라미터 값이 <strong>${param.name}</strong> 입니다<hr/>
</c:if>

<c:if test="${param.age >= 18}">
	<!-- 브라우저 주소창에 age 값이 18이상일경우 -->
	당신의 나이는 18세 이상입니다.
</c:if>
<%-- 실행할 때 브라우저 주소창에 *.jsp?name=hong 이나 *.jsp?age=20 주소창에 노출되는 get 방식으로 전달해서 테스트를 진행 --%>
<%-- 예시 > http://localhost:8052/MVC/EL_JSTL/JSTL_11.jsp?name=hong&age=20 --%>