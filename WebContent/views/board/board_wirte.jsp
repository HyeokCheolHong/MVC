<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>서블릿 MVC 뷰페이지 연습</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<%-- jQuey라이브러리 읽어오기, jQuery CDN 방식 --%>
	<script src="./js/b.js"></script>
	<!-- 해당jsp에서 실행하면 경로가 잘못되어서 실행이 안되는데 컨텍스트인 ServiceWriteController.java 파일에서 실행 -->
</head>
<body>
	<h3>서블릿 MVC 뷰페이지</h3>
	<form method="post" action="/MVC/b_write_ok" onsubmit="return check();">
		<%-- /MBC는 컨텍스트 패스 경로, /b_write_ok는 서블릿 컨트롤러에서 등록될 매핑주소이다. --%>
		<label for="b_title">제목</label>
		<input type="text" name="b_title" id="b_title" size="30"/><br/><br/> 
		<label for="b_cont">내용</label>
		<textarea name="b_cont" id="b_cont" rows="10" cols="34"/></textarea>
		<hr/>
		<button type="submit">전송</button>
		<button type="reset" onclick="location='board_list'">취소</button>
	</form>
</body>
</html>