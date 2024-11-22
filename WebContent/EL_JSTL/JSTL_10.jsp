<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%-- DataBase 연동을하기 위한 SQL JSTL 태그립 추가 --%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title></title>
</head>
<body>
	<h3>JSTL SQL 태그를 사용한 DB연동</h3>
	<sql:setDataSource var="con" driver="oracle.jdbc.OracleDriver" url="jdbc:oracle:thin:@127.0.0.1:1521:xe" user="fintech" password="56789"/>
	<!-- 해당 정보(oracle DB연동)가 "con"이라는 변수에 담긴다 -->
	
	<sql:update dataSource="${con}">
		insert into test values(1, '홍길동')
	</sql:update>
	
	<sql:update dataSource="${con}">
		insert into test values(2, '이순신')
	</sql:update>
	
	<sql:query var="rs" dataSource="${con}">
		select * from test
	</sql:query>
	
	<c:forEach var="data" items="${rs.rows}">
		<!-- JSTL forEach 반복문 -->
		${data['num']}
		${data['name']}
		<hr/>
	</c:forEach>
</body>
</html>