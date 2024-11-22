<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.sql.*,javax.naming.*,javax.sql.*" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title></title>
</head>
<body>
	<h2>JNDI 디렉터리 서비스로 DBCP 커넥션풀 방법으로 오라클 연결 테스트</h2>
	<%! 
	// 선언문
		Connection con = null;
		// 데이터 베이스 연결 con변수 선언
		DataSource ds = null;
		// 커넥션 풀 관리 ds 선언
	%>
	<%
		try{
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/xe");
			// JNDI 디렉터리 서비스로 디렉터리 안에 저장된 server.xml에 설정된 xe데이터 베이스를 찾아서 DBCP 커넥션 풀 관리해주는 ds생성
			con = ds.getConnection();
			// 커넥션 풀 관리 ds로 db연결 con생성
			out.println("DBCP 커넥션 풀 연결 성공");
		}catch(Exception e) {e.printStackTrace();}
		finally{
			try{
				if(con != null) con.close();
			} catch(Exception e) {e.printStackTrace();}
		}
	%>
</body>
</html>