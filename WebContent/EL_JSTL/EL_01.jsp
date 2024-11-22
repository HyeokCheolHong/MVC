<%@ page contentType="text/html; charset=UTF-8" %>

<H3>EL(Expression Language:표현언어(줄여서 EL이라고 한다.외부라이브러리가 필요없다.))</H3>
[1]정수형 : ${100}<br/>
[2]실수형 : ${5.6}<br/>
[3]문자열형 : ${"홍길동"}<br/>
[4]논리형 : ${true}<br/>
[5]null : ${null}<hr/>

<%
  String input=null;
%>

<h3>표현언어 연산자</h3>
\${7+3} = ${7+3}<br/>
\${5/2} = ${5/2}<br/>
\${5 mod 2} = ${5 mod 2}<br/> <%-- mod는 나머지 연산 --%>
\${2 gt 10} = ${2 gt 10}<br/> <%-- gt는 ~보다 크다 --%>
\${empty input} : ${empty input}<hr/> 
