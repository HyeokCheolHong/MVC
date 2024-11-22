<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title></title>
</head>
<body>
	<table border="1">
		<tr>
			<th colspan="5">서블릿 MVC 게시판 목록</th>
		</tr>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>내용</th>			
			<th>등록날짜</th>		
			<th>조회수</th>	
		</tr>
		<c:if test="${!empty blist}">
			<c:forEach var="b" items="${blist}">
				<tr>
					<th><c:out value="${b.b_no}"/></th>
					<td style="padding-left:12px;"><a href="board_cont?bno=${b.b_no}"><strong>${b.b_title}</strong></a></td>
					<!-- 현재 주소창 + board_cont?bno= (DB연동 NO) 값에 따른 주소로 이동 -->
					<th>${b.b_cont}</th>
					<!-- <th>$b.b_date</th> -->
					<!-- 
					문제) jstl+el문제이다. 등록날짜가 년월일만 나오게 만들어 보자
					 -->
					<th>${fn:substring(b.b_date,0,10)}</th>
					<th>${b.b_hit}</th>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${empty blist}">
			<tr>
				<th colspan="5">게시판 목록이 없습니다!</th>
			</tr>
		</c:if>
		<tr>
			<th colspan="5"><input type="button" value="글쓰기" onclick="location='b_write';"/></th>
		</tr>		
	</table>
</body>
</html>