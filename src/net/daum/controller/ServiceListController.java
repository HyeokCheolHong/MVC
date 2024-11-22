package net.daum.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.daum.dao.Board10DAOImpl;
import net.daum.vo.Board10VO;

public class ServiceListController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Board10DAOImpl bdao = new Board10DAOImpl();
		List<Board10VO> blist = bdao.getBoardList();
		// 게시판 목록
		
		request.setAttribute("blist", blist);
		// blist 키이름에 blist목록 저장
		
		RequestDispatcher fList = request.getRequestDispatcher("./views/board/board_list.jsp");
		// 뷰페이지 경로 설정
		fList.forward(request, response);
		// 해당 뷰페이지로 포워딩
		
		/*
		 * request.setAttribute(키이름, 값) 특징
		 * 1. request.setAttribute()에 의해서 저장된 키이름 값을 유지하려면 반드시 RequestDispatcher 서블릿의 forward()로 이동시켜야 한다.
		 * 		이유는 기존 매핑주소를 유지한채 이동을 해야 키이름 값을 유지하기 때문에
		 * 2. 만약 response.sendRedirect()에 의해서 새로운 매핑주소로 이동하면 기존 키이름 값을 잃어 버린다.
		 * 
		 */
	}

}
