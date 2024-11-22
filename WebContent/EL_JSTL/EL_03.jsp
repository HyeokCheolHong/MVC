<%@ page contentType="text/html; charset=UTF-8" %>
<%
    request.setAttribute("name", "홍길동");//문자열 속성 키이름 name에 값 홍길동을 저장
%>

<h3>표현언어에서 닷(.) 연산자로 접근(선호함)</h3>
${requestScope.name}<br/> <%--이 방법은 잘 사용안한다. name키이름 값을 가져온다.--%>
${param.id}<hr/> <%--피라미터 이름 id값을 가져온다. 주소창에 다음과 같이 실행해야 한다. EL_03.jsp?id=값을 
get방식으로 전달해야 한다. --%>

<h4>표현언어에서 브라켓 연산자([])로 접근(이 연산도 선호하지 않는다.이유는 가독성이 떨어져서)</h4>
${requestScope["name"]}<br/> <%--name키이름값을 가져온다. --%>
${param['id']}<hr>

<h4>jsp 스크립트 요소인 표현식</h4>
<%=request.getAttribute("name")%><br/>
<%=request.getParameter("id")%><hr/>
