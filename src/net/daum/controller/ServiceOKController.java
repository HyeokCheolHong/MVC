package net.daum.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.daum.dao.Board10DAOImpl;
import net.daum.vo.Board10VO;

@WebServlet("/b_write_ok")
public class ServiceOKController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// post방식으로 접근할 때는 doPost() 메서드를 호출한다.
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		request.setCharacterEncoding("UTF-8");
//		Post 방식으로 전송되는 한글을 안깨지게 한다.
		
		String title = request.getParameter("b_title");
		String content = request.getParameter("b_cont");
		
		out.println("제목 : <strong>" + title + "</strong><br/>");
		out.println("내용 : <strong>" + content + "</strong><br/>");
		
		Board10VO b = new Board10VO();
		b.setB_title(title);
		b.setB_cont(content);
		
		Board10DAOImpl bdao = new Board10DAOImpl();
		
		int re = bdao.insertBoard(b);
		// 게시판 저장
		
		if(re == 1) {
			out.println("<script>");
			out.println("alert('게시판 저장에 성공했습니다.');");
			out.println("location='board_list';");
			out.println("</script>");
		}
	}

}
