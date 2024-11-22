package net.daum.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/b_write")
	// b_write 매핑주소 등록
public class ServiceWriteController extends HttpServlet {
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get or post 방식이 실행될 때는 양쪽 다 가능한 service()메서드를 호출한다.
		
		RequestDispatcher bWriteForward = request.getRequestDispatcher("./views/board/board_wirte.jsp");
		//	뷰 페이지 경로 설정
		bWriteForward.forward(request, response);
		/*	WriteForward.forward() 메서드의 특징
		 * 		1.기존 매핑주소를 유지한 채 해당 뷰페이지로 이동한다.
		 * 		2. request.setAttribute(키이름, 값) 이나 session.setAttribute(세션키, 세션값)에 의해서 저장된 키이름 값을 유지한다.
		 */
	}

}
