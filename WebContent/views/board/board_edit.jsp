<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>서블릿 MVC 수정 폼</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<%-- jQuey라이브러리 읽어오기, jQuery CDN 방식 --%>
	<script src="./js/b.js"></script>
	<!-- 해당jsp에서 실행하면 경로가 잘못되어서 실행이 안되는데 컨텍스트인 ServiceWriteController.java 파일에서 실행 -->
</head>
<body>
	<h3>서블릿 MVC 게시판 수정</h3>
	<!-- method로 post 보내는 방식 -->
	<%-- <form method="post" action="/board_edit_ok" onsubmit="return check();">
		/MBC는 컨텍스트 패스 경로, /b_write_ok는 서블릿 컨트롤러에서 등록될 매핑주소이다.
		<label for="b_title">제목</label>
		<input type="text" name="b_title" id="b_title" size="30" value="${eb.b_title}"/><br/><br/> 
		<label for="b_cont">내용</label>
		<textarea name="b_cont" id="b_cont" rows="10" cols="34"/>${eb.b_cont}</textarea>
		<hr/>
		<button type="submit">수정</button>
		<button type="submit">취소</button>
	</form> --%>
	
	<!-- action에서 post 보내는 방식 -->
	<form method="post" action="board_edit_ok?bno=${eb.b_no}" onsubmit="return check();">
		<%-- ?bno=번호는 get으로 전송되고, 수정할 제목인 b_title과 수정할 내용인 b_cont는 post방식으로 전송된다. --%>
		<%-- 같은 매핑주소라도 서버에서 받는 방식을 달리 할수 있음 (CRUE 방식) --%>
		<label for="b_title">제목</label>
		<input type="text" name="b_title" id="b_title" size="30" value="${eb.b_title}"/><br/><br/> 
		<label for="b_cont">내용</label>
		<textarea name="b_cont" id="b_cont" rows="10" cols="34">${eb.b_cont}</textarea>
		<hr/>
		<button type="submit">수정</button>
		<button type="reset" onclick="location='board_list'">취소</button>
	</form>
</body>
</html>