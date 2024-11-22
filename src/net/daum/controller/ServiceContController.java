package net.daum.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.daum.dao.Board10DAOImpl;
import net.daum.vo.Board10VO;

// 서블릿 MVC 게시판 내용보기와 조회수 증가 컨트롤러 클래스이다.

@WebServlet("/board_cont")
// board_cont 매핑주소 등록
public class ServiceContController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 하이퍼링크로 이동하는 경우는 get방식이다. get방식일 때는 doGet()메서드를 호출한다
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		// get으로 전달된 번호값을 받아서 정수 숫자로 변경해서 저장
		
		Board10DAOImpl bdao = new Board10DAOImpl();
		bdao.updateHit(bno);
		// 조회수 증가
		/*
		 * 문제) 조회수가 증가되는 updateHit(bno)메서드를 작성해보자. b_hit 컬럼을 alter table로 추가해서 만들어 본다.
		 */
		Board10VO bc = bdao.getBoardCont(bno);
		// 번호에 해당하는 레코드 가져오기
		
		request.setAttribute("bc", bc);
		
		RequestDispatcher bcForward = request.getRequestDispatcher("./views/board/board_cont.jsp");
		bcForward.forward(request, response);
		
		
	}


}
