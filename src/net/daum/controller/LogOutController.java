package net.daum.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// 로그아웃 컨트롤러 클래스
public class LogOutController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		// 출력 스트림 out 생성
		HttpSession session = request.getSession();
		// 세션 객체 생성
		session.invalidate();
		// 세션 만료 => 로그아웃
		
		out.println("<script>");
		out.println("alert('로그아웃 되었습니다!');");
		out.println("location='login.do';");
		out.println("</script>");
		return null;
	}

}
