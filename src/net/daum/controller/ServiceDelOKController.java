package net.daum.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.daum.dao.Board10DAOImpl;

/**
 * 서블릿 MVC 게시판 삭제완료 컨트롤러 클래스
 */
@WebServlet("/board_del")
public class ServiceDelOKController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		Board10DAOImpl bdao = new Board10DAOImpl();
		bdao.delBoard(bno);
		// 게시불 번호를 기준으로 삭제
		
		response.sendRedirect("board_list");
		//게시판 목록으로 이동
		
	}

}
