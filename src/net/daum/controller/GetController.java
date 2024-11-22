package net.daum.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * GetController 서블릿 클래스 특징
 * 	1. 서블릿 클래스는 온라인 상에서 누구나 다 접근 가능하게 public 접근지정자로 정의한다.
 * 	2. 서블릿 클래스는 HttpServlet클래스로 부터 상속을 받는다.
 * 	3. get으로 접근할 때는 doGet()메서드를 오버라이딩 해서 호출한다.
 * 	4. HttpServletRequest 서블릿은 사용자 폼 입력박스에서 입력한 값을 서버로 전달하는 역할을 한다.
 * 	5. HttpServletResponse 서블릿은 서버의 가공된 정보를 사용자 웹 브라우저에 응답하는 역할을 한다.
 */
@WebServlet("/get_start" )
// /get_start는 브라우저 주소창에서 실행되는 주소값인 URL매핑주소이다.
public class GetController extends HttpServlet {   

	/*	get으로 인식되는 경우 예)
	 * 		1. 폼태그에서 method=get방식이거나 생략하는 경우
	 * 		2. 하이퍼링크 방식으로 이동하는 경우
	 * 		3. 자바스크립트 location객체에 의해서 이동하는 경우
	 * 		4. JSP내장객체의 response.sendRedirect("이동할 주소 or 파일명")
	 * 		5. JSTL의 c:redirect에 의해서 이동하는 경우
	 * 		6. 스프링 컨트롤러에서 redirect:/문자열에 의해서 이동하는 경우
	 * 		7. 브라우저에서 직접 실행하거나 브라우저 주소창에서 직접 입력하여 실행하는 경우
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get으로 접근할 때는 doGet()메소드를 호출한다. post로 접근할 때는 doGet()메서드를 호출 못한다.
		
		response.setContentType("text/html;charset=UTF-8");
		// 웹 브라우저에 출력되는 문자와 HTML, 언어코딩 타입을 지정
		PrintWriter out = response.getWriter();
		// 출력스트림 out생성
		out.println("<h2>get방식 서블릿 실행</h2>");
		out.close();
	}

}
