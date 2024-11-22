<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<fmt:requestEncoding value="UTF-8"/>
<!--  METHOD=POST방식으로 전송되는 한글을 깨지지 않도록 한다 -->

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<body>
		<h3>JSTL fmt태그 예제</h3>
		파라미터 name 값 : <c:out value="${param.name}"/><hr/>
		<form method="post" action="JSTL_17.jsp">
			<label for="name">이름</label>
			<input type=text" name="name=" id="name" size="16" />
			<label for="name">이름</label>
			<input type=text" name="name=" id="name" size="16" />
			<label for="name">이름</label>
			<input type=text" name="name=" id="name" size="16" />
			<label for="name">이름</label>
			<input type=text" name="name=" id="name" size="16" />
			<label for="name">이름</label>
			<input type=text" name="name=" id="name" size="16" />
			<input type="submit" value="전송"/>
			
			
		</form>
	</body>
</html>