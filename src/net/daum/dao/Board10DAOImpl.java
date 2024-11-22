package net.daum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;



import net.daum.vo.Board10VO;

public class Board10DAOImpl {
  // DBCP 커넥션 풀 방법으로 데이터 베이스 연결

  Connection con = null;
  // 데이터베이스 연결 con
  PreparedStatement pstmt = null;
  // 쿼리문 수행
  Statement stmt = null;
  // 쿼리문 수행
  ResultSet rs = null;
  // 검색결과 레코드를 저장할 rs
  DataSource ds = null;
  // 커넥션 풀 관리 ds
  String sql = null;
  // 쿼리문 저장 변수

  public Board10DAOImpl() {
    try {
      Context ctx = new InitialContext();
      ds = (DataSource) ctx.lookup("java:comp/env/jdbc/xe");
      // server.xml로 부터 xe데이터베이스를 찾아서 커텍션 풀 관리 ds를 생성
    } catch (Exception e) {
      e.printStackTrace();
    }
  } // 기본 생성자 정의

  // 게시물 저장
  public int insertBoard(Board10VO b) {
    int re = -1;
    // 저장 실패시 반환값

    try {
      con = ds.getConnection();
      // 커넥션 풀 관리 ds로 DB연결 con생성
      sql = "insert into tbl_board10 values(board10_seq.nextval,?,?,sysdate,?)";
      pstmt = con.prepareStatement(sql);
      // 쿼리문을 미리 컴파일 하여 수행할 pstmt를 생성
      pstmt.setString(1, b.getB_title());
      // 쿼리문의 첫번째 물음표에 문자열로 저장할 글제목을 할당
      pstmt.setString(2, b.getB_cont());
      pstmt.setInt(3, b.getB_hit());

      re = pstmt.executeUpdate();
      // 저장 쿼리문 수행 후 성공한 레코드 행의 개수를 반환
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if (pstmt != null) pstmt.close();
        if (con != null) con.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return re;
  } // insertBoard()
  
  
  // 게시물 목록
  public List<Board10VO> getBoardList() {
	  List<Board10VO> blist = new ArrayList<>();
	  
	  try {
	      con = ds.getConnection();
	      // 커넥션 풀 관리 ds로 DB연결 con생성
	      sql = "select * from tbl_board10 order by b_no desc";
	      pstmt = con.prepareStatement(sql);
	      // 쿼리문을 미리 컴파일 하여 수행할 pstmt를 생성
	      rs = pstmt.executeQuery();
	      // 검색 쿼리문 수행 후 결과 레코드를 저장
	      while(rs.next()) {
	    	  Board10VO b = new Board10VO();
	    	  b.setB_no(rs.getInt("b_no"));
	    	  // b_no 컬럼으로부터 정수 숫자로 번호값을 가져와서 setter()에 저장
	    	  b.setB_title(rs.getNString("b_title"));
	    	  b.setB_cont(rs.getNString("b_cont"));
	    	  b.setB_date(rs.getNString("b_date"));
	    	  b.setB_hit(rs.getInt("b_hit"));
	    	  
	    	  blist.add(b);
	    	  // 컬렉션에 추가
	      }
	    } catch (Exception e) {
	      e.printStackTrace();
	    } finally {
	      try {
	    	if (rs != null) rs.close();  
	        if (pstmt != null) pstmt.close();
	        if (con != null) con.close();
	      } catch (Exception e) {
	        e.printStackTrace();
	      }
	    }
	    return blist;
  }
  
  // 조회수 확인
  public void updateHit(int bno) {
	
	try {
      con = ds.getConnection();
      // 커넥션 풀 관리 ds로 DB연결 con생성
      stmt = con.createStatement();
      // 쿼리문을 수행할 stmt 생성
      sql = "update tbl_board10 set b_hit = b_hit + 1 where b_no ="+bno;
      stmt.executeUpdate(sql);
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
    	if (rs != null) rs.close();  
        if (pstmt != null) pstmt.close();
        if (con != null) con.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  // 내용 보기 메서드
  public Board10VO getBoardCont(int bno) {
	  Board10VO bc = null;
	  
	  try {
	      con = ds.getConnection();
	      // 커넥션 풀 관리 ds로 DB연결 con생성
	      sql = "select * from tbl_board10 where b_no=?";
	      pstmt = con.prepareStatement(sql);
	      pstmt.setInt(1, bno);
	      rs = pstmt.executeQuery();
	      if(rs.next()) {
	    	  bc = new Board10VO();
	    	  bc.setB_no(rs.getInt("b_no"));
	    	  bc.setB_title(rs.getNString("b_title"));
	    	  bc.setB_cont(rs.getNString("b_cont"));
	    	  bc.setB_date(rs.getNString("b_date"));
	    	  bc.setB_hit(rs.getInt("b_hit"));
	      }
	      
	    } catch (Exception e) {
	      e.printStackTrace();
	    } finally {
	      try {
	    	if (rs != null) rs.close();  
	        if (pstmt != null) pstmt.close();
	        if (con != null) con.close();
	      } catch (Exception e) {
	        e.printStackTrace();
	      }
	    }
	  
	  return bc;
  }

	public void updateBoard(Board10VO eb) {
		  
		try {
		    con = ds.getConnection();
		    // 커넥션 풀 관리 ds로 DB연결 con생성
		    stmt = con.createStatement();
		    sql="update tbl_board10 set b_title = '"+eb.getB_title()+"', b_cont = '"+ eb.getB_cont()+"' where b_no= "+ eb.getB_no();
		    stmt.executeUpdate(sql);
		     		      
	    } catch (Exception e) {
	    	e.printStackTrace();
	    } finally {
	    	try {
		        if (stmt != null) stmt.close();
		        if (con != null) con.close();
	    } catch (Exception e) {
		        e.printStackTrace();
		    }
	    }
	}

	// MVC 게시판 삭제완료
	public void delBoard(int bno) {
		try {
		    con = ds.getConnection();
		    // 커넥션 풀 관리 ds로 DB연결 con생성
		    sql="delete from tbl_board10 where b_no=?";
		    pstmt = con.prepareStatement(sql);
		    pstmt.setInt(1, bno);		    
		    pstmt.executeUpdate();
		    // 삭제 쿼리문 수행
		     		      
	    } catch (Exception e) {
	    	e.printStackTrace();
	    } finally {
	    	try {
		        if (pstmt != null) pstmt.close();
		        if (con != null) con.close();
	    } catch (Exception e) {
		        e.printStackTrace();
		    }
	    }
	
	}	
}
