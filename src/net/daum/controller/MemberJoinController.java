package net.daum.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberJoinController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String[] phone = { "010", "011" };
		request.setAttribute("phone", phone);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./views/member/member_join.jsp");
		
		return forward;
	}
	
}
