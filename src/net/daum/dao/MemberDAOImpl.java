package net.daum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import net.daum.vo.MemberVO;

public class MemberDAOImpl {
	Connection con = null; // DB 연결 객체
	PreparedStatement pstmt = null; // 쿼리문 수행 객체
	ResultSet rs = null; // 검색 결과 레코드를 저장할 객체
	DataSource ds = null; // 커넥션 풀 관리 객체
	String sql = null; // 쿼리문 저장 변수
	
	// 기본 생성자
	public MemberDAOImpl() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/xe"); // 커넥션 풀 관리 ds 생성 
		}catch(Exception e) { e.printStackTrace(); }
	}
	
	// 회원 저장
	public void insertMember(MemberVO m) {
		try {
			con = ds.getConnection();
			
			sql = "insert into tbl_member7 values(?, ?, ?, ?, ?, ?, sysdate)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, m.getMem_id());
			pstmt.setString(2, m.getMem_pwd());
			pstmt.setString(3, m.getMem_name());
			pstmt.setString(4, m.getMem_phone());
			pstmt.setString(5, m.getMem_email());
			pstmt.setString(6, m.getMem_file());
			
			pstmt.executeUpdate(); // 쿼리문 실행
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e) { e.printStackTrace(); }
		}
	}
	
	// 로그인 인증
	public MemberVO loginCheck(String login_id) {
		MemberVO dm = null;
		
		try {
			con = ds.getConnection(); // 커넥션 풀 관리 ds로 db 연결 con 객체 생성
			
			sql = "select * from tbl_member7 where mem_id = ?";
			pstmt = con.prepareStatement(sql); // 쿼리문을 미리 컴파일 해서 수행할 pstmt 생성
			
			pstmt.setNString(1, login_id);
			
			rs = pstmt.executeQuery();
			if(rs.next()) { // 다음 레코드가 존재하면 true
				dm = new MemberVO();
				dm.setMem_pwd(rs.getString("mem_pwd"));
				dm.setMem_file(rs.getString("mem_file"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e) { e.printStackTrace(); }
		}
		
		return dm;
	}
	
	
	
}













































