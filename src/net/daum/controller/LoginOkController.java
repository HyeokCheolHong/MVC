package net.daum.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.daum.dao.MemberDAOImpl;
import net.daum.vo.MemberVO;

public class LoginOkController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8"); // 브라우저에 출력되는 문자와 태그, 언어코딩 타입을 지정
		PrintWriter out = response.getWriter(); // 출력스트림 객체 생성
		
		String login_id = request.getParameter("login_id");
		String login_pwd = request.getParameter("login_pwd");
		
		MemberDAOImpl mdao = new MemberDAOImpl();
		MemberVO dm = mdao.loginCheck(login_id); // 로그인 인증 => 유일 아이디에 해당하는 회원정보 검색
		if(dm == null) {
			out.println("<script>");
			out.println("alert('유효하지 않은 ID 입니다.");
			out.println("history.back()");
			out.println("</script>");
		}else {
			if(!dm.getMem_pwd().equals(login_pwd)) {
				out.println("<script>");
				out.println("alert('비밀번호가 일치하지 않습니다.");
				out.println("history.go(-1)"); // 자바스크립트의 back()이나 go(-1)은 이전 주소로 이동. 즉 뒤로가기 기능이다.
				out.println("</script>");
			}else {
				HttpSession session = request.getSession();
				session.setAttribute("id", login_id); // 세션 id 키에 아이디 저장
				session.setAttribute("profile", dm.getMem_file()); // profile 문자열이 키에 첨부파일 경로와 파일명을 저장
				
				ActionForward forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("login.do");
				
				return forward;
			}
		}
		
		return null;
	}

}
