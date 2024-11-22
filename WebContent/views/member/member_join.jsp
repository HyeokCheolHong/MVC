<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>서블릿 MVC 회원가입폼</title>
	<%-- jQuery 라이브러리 CDN 방식으로 가져오기 --%>
	<script src="https://code.jquery.com/jquery-latest.min.js"></script>
	<%-- 유효성 검증 자바스크립트 --%>
	<script src="./js/member.js"></script>
</head>
<body>
	<%-- 
		파일 첨부해서 서버에 업로드하는 자료실 기능을 만들기 위해서는 form 태그 내에 enctype="multipart/form-data" 속성을 지정해야 한다. 
		그리고 method="post" 방식으로 지정해야 첨부한 파일을 서버에 업로드 할 수 있다. (GET 방식은 파일 첨부 불가)
		
		첨부한 파일을 서버에 업로드 하기 위해선 외부 라이브러리가 필요할 때가 있다.
		대표적으로 이진파일(binary mode 파일)을 업로드 하기 위한 라이브러리로 cos.jar가 있다.
		해당 파일을 WEB-INF/lib 폴더 안에 넣어줘서 자료실 기능을 만들어본다.
	--%>
	<form method="post" action="mem_join_ok.do" onsubmit="return join_check()" enctype="multipart/form-data">
		<table border="1">
			<tr>
				<th colspan="2">회원가입</th>
			</tr>
			
			<tr>
				<th>아이디</th>
				<td>
					<input id="mem_id" name="mem_id"  size="14" />
				</td>
			</tr>
			
			<tr>
				<th>비밀번호</th>
				<td>
					<input type="password" id="mem_pwd" name="mem_pwd" size="14" />
				</td>
			</tr>
			
			<tr>
				<th>비밀번호 확인</th>
				<td>
					<input type="password" id="pwd_chk" name="pwd_chK" size="14" />
				</td>
			</tr>
			
			<tr>
				<th>회원이름</th>
				<td>
					<input id="mem_name" name="mem_name" size="14" />
				</td>
			</tr>
			
			<tr>
				<th>폰번호</th>
				<td>
					<select name="phone01">
						<c:forEach var="p" items="${phone}" >
							<option value="${p}">${p}</option>
						</c:forEach>
					</select>
					-
					<input id="phone02" name="phone02" size="4" maxlength="4" />
					-
					<input id="phone03" name="phone03" size="4" maxlength="4" />
				</td>
			</tr>
			
			<tr>
				<th>이메일</th>
				<td>
					<input type="email" id="mem_email" name="mem_email" size="30" />
				</td>
			</tr>
			
			<tr>
				<th>프로필 사진</th>
				<td>
					<input type="file" name="mem_file" />
				</td>
			</tr>
			
			<tr>
				<th colspan="2">
					<input type="submit" value="가입" />
					<input type="reset" value="취소" />
				</th>
			</tr>
		</table>
	</form>
</body>
</html>





































