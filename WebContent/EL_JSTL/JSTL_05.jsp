<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="score" value="<%=new int[]{90,100,80,85,95,75}%>" />

**점수 출력**<br/>
<c:forEach var="s" items="${score}" begin="0" end="5">
 ${s}<br/>
 <c:set var="total" value="${total+s}" /> <%-- 누적합을 구해서 total에 저장 --%>
</c:forEach> <%-- c:forEach는 JSTL 반복문 --%>
<hr/>
점수 총합=<c:out value="${total}" />
<%-- <c:out value="출력할 값" /> 는 JSTL출력문 --%>
<HR/>

**홀수값 출력**
<BR/>
<c:forEach var="i" begin="1" end="10" step="2">
  <%-- begin시작속성, end는 끝 속성, step은 증가 --%>
   ${i}&nbsp;&nbsp; <%-- &nbsp;은 한칸의 빈공백을 처리, 두번 사용하면 두칸의 빈공백 처리 --%>
</c:forEach>