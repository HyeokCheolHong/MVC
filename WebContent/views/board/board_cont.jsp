<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>서블릿 MVC 게시판 내용보기</title>
</head>
<body>
	<table border="1">
		<tr>
			<th colspan="2">서블릿 MVC 게시판 </th>
		</tr>
		<tr>
			<th>제목</th>
			<td><c:out value="${bc.b_title}" /></td>
			<!-- ${bc.b_title}을 자바코드로 표현하면 bc.getB_title()과 같다 -->
		</tr>
		<tr>
			<th>내용</th>
			<td>${bc.b_cont}</td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${bc.b_hit}</td>
		</tr>
		<tr>
		<tr>
			<th>
				<button type="button" onclick="location='board_edit?bno=${bc.b_no}';">수정</button>
				<input type="button" value="삭제" onclick="location='board_del?bno=${bc.b_no}'" />
				<button onclick="location='board_list'">목록</button>
			</th>
		</tr>
		<tr>
	</table>
</body>
</html>