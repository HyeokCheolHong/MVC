<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- JSTL 코어 태그립 추가 --%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>서블릿 MVC 로그인 폼</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<%-- jQuery CDN 라이브러리 --%>
	<script>
		function login_check(){
			if($.trim($('#login_id').val()).length == 0) {
				alert('로그인 아이디를 입력하세요');
				$('#login_id').val('').focus();
				return false;
			}
			if($.trim($('#login_pwd').val()).length == 0) {
				alert('로그인 비밀번호를 입력하세요');
				$('#login_pwd').val('').focus();
				return false;
			}
		}
	</script>
</head>
<body>
	<c:if test="${empty id}"> <%-- 로그인 전 --%>
		<form method="post" action="login_ok.do" onsubmit="return login_check();">
			<table border="1">
				<tr>
					<th>아이디</th>
					<td>
						<input name="login_id" id="login_id" size="14" tabindex="1" placeholder="아이디를 입력하세요!"/>
					</td>
					<%-- type속성을 생략하면 기본값이 text이다. tabindex="1"로 지정하면 탭키를 눌렀을 때 첫번째로 포커스를 가진다. --%>
					<th rowspan="2">
						<input type="submit" value="로그인" class="login_submit"/>
					</th>
				</tr>
				
				<tr>
					<th>비밀번호</th>
					<td>
						<input type="password" name="login_pwd" id="login_pwd" size="14" tabindex="2" placeholder="비번을 입력하세요"/>
					</td>
				</tr>
				
				<tr>
					<th colspan="3">
						<button type="button">아이디 찾기</button>
						<button type="button">비밀번호 찾기</button>
						<button type="button" onclick="location='mem_join.do'">회원가입</button>
					</th>	
				</tr>
			</table>
		</form>
	</c:if>
	<c:if test="${!empty id}"> <%-- 로그인 한 경우(로그인 이후) --%>
		<form method="post" action="logout.do">
			<table border="1">
				<tr>
					<th>
						<input type="button" value="정보수정"/>
						<input type="submit" value="로그아웃"/>
					</th>
				</tr>
				<tr>
					<th>${id}님 로그인 환여합니다!</th>
				</tr>
				
				<c:if test="${!empty profile}"> <%-- 회원 프로필 사진이 있는 경우만 실행 --%>
					<tr>
						<th>
							<img src="./upload${profile}" width="100" height="100" alt="프로필 사진"/>
						</th>
					</tr>
				</c:if>
				
				<c:if test="${empty profile}">
				
				</c:if>
			</table>
		</form>
	</c:if>
	
</body>
</html>