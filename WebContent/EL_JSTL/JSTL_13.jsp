<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import ="java.util.*" %>

<h2>JSTL과 EL</h2>
<h4>1부터 100까지의 홀수 합</h4>

<c:set var="sum" value="0"/>
	<!-- JSTL c:set문으로 누적합을 저장할 sum변수 선언과 초기화 -->
	<c:forEach var="i" begin="1" end="100" step="2">
		<c:set var="sum" value="${sum+i}"/>
	</c:forEach>
홀수 누적합 = <strong><c:out value="${sum}"></c:out></strong>
<hr/>

<h4>7단 구구단</h4>
<<ul>
  <c:forEach var="k" begin="1" end="9" step="1">
  	<li><b>7 X ${k} = ${7*k}</b></li>
  </c:forEach>
</ul>

<hr/>

<%
	HashMap<String,Object> hm = new HashMap<>();
	hm.put("name", "홍길동");
	hm.put("today", new Date());
%>

<h4>키, 값 쌍으로 출력</h4>
<c:set var="map" value="<%=hm%>" />
<c:forEach var="i" items="${map}">
	${i.key} : ${i.value}<br/>
	<%-- 키, 값 쌍으로 출력 --%>
</c:forEach>
	