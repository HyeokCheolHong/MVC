<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- JSTL 코어 태그 립 추가 --%>

<c:import url="http://localhost:8052/MVC/EL_JSTL/cityName.jsp" var="data"/>
<%-- 외부 자원을 임포트해서 결과물을 data변수에 저장 --%>
	<c:out value="${data}"/>
	<%-- JSTL 출력문 --%>
		<hr/>
		${data}
		<hr/>
		<%-- EL출력법 --%>
