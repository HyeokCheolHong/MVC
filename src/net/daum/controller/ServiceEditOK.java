package net.daum.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.daum.dao.Board10DAOImpl;
import net.daum.vo.Board10VO;

/**
 * 
 */
@WebServlet("/board_edit_ok") // 수정완료 매핑주소 /board_edit_ok 등록
public class ServiceEditOK extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// post 방식으로 전송되는 한글을 안 깨지게 한다.
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		// get방식으로 전송된 번호값을 가져와서 정수숫자로 변경해서 저장
		String b_title = request.getParameter("b_title");
		// post방식으로 전송된 수정 제목을 저장
		String b_cont = request.getParameter("b_cont");
		
		Board10VO eb = new Board10VO();
		eb.setB_no(bno);
		eb.setB_title(b_title);
		eb.setB_cont(b_cont);
		
		Board10DAOImpl bdao = new Board10DAOImpl();
		bdao.updateBoard(eb);
		// 번호를 기준으로 글제목과 내용을 수정
		
		response.sendRedirect("board_cont?bno="+bno);
		// 내용보기로 이동하여 수정한 값을 확인
		
	}

}
