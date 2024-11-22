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

/**
 * 서블릿 MVC 게시판 수정폼 컨트롤러 클래스
 */
@WebServlet("/board_edit")
// board_edit 매핑주소 등록
public class ServiceEditController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		Board10DAOImpl bdao = new Board10DAOImpl();
		Board10VO eb = bdao.getBoardCont(bno);
		
		request.setAttribute("eb", eb);
		
		RequestDispatcher ebForward = request.getRequestDispatcher("./views/board/board_edit.jsp");
		ebForward.forward(request, response);
	}

}
