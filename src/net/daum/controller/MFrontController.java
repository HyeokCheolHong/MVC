package net.daum.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MFrontController extends HttpServlet {

	/*
	 * 서블릿 클래스 특징
	 * 	1. 서블릿 컨트롤러 클래스는 HttpServlet클래스로 부터 상속을 받는다.
	 * 	2. 온라인 웹상에서 누구나 다 접근 가능하게 public 접근 지정자로 선언한다.
	 * 	3. get방식으로 접근할 때는 doGet()메서드를 호출한다.
	 * 	4. post방식으로 접근할 때는 doPost()메서드를 호출한다.
	 * 	5. get or post 양쪽 방식 모두 지원되는 경우는 service()메서드 이다.
	 */
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		// MVC/*.do 경로를 구함
		String contextPath = request.getContextPath();
		// context 패스 경로인 /MVC를 구함
		String command = requestURI.substring(contextPath.length());
		// /*.do 를 구함
		
		ActionForward forward = null;
		Action action = null;
		
		Properties prop = new Properties();
		// key와 value 를 쌍으로 저장되는 컬렉션 자료 구조
		
		FileInputStream fis = new FileInputStream(request.getRealPath("WEB-INF/classes/daum.properties"));
		// STS 개발툴의 가상경로가 아닌 톰켓 WAS서버에 의해서 변경된 실제 프로젝트 경로로 부터 daum.properties파일을 읽어들임.
		prop.load(fis);
		// properties 파일 로드
		fis.close();
		
		String value = prop.getProperty(command);
		// 키에 대한 값을 구함. 키이름은 /*.do가 된다.
		// 값은 execute|net.daum.controller.LoginController 이다.
		
		if(value.substring(0,7).equals("execute")) {
			// 0이상 7미만 사이의 문자가 execute와 같다면
			
			try {
				StringTokenizer st = new StringTokenizer(value, "|");
				// |를 기준으로 문자를 분리한다
				String url_1 = st.nextToken();
				// 첫번째로 분리된 문자 execute를 저장
				String url_2 = st.nextToken();
				// 두번째로 분리된 문자 풀패키지 경로를 저장
				
				Class url = Class.forName(url_2);
				// 패키지에 있는 컨트롤러 클래스를 객채화
				
				action = (Action)url.newInstance();
				
				
				try {
					forward = action.execute(request, response);
					// overriding한 메서드를 호출
				} catch(Exception e) {e.printStackTrace();}
			} catch(ClassNotFoundException ce) {
				// 해당 클래스를 찾지 못했을 때 발생하는 예외 오류 처리
				ce.printStackTrace();
			} catch(InstantiationException ie) {
				// 추상 클래스나 인터페이스를 인스턴스 화 하고자 할 때
				ie.printStackTrace();
			} catch(IllegalAccessException ie) {
				// 클래스나 멤버(필드, 메서드등)에 대한 적절한 접근 권한이 없을 때
				ie.printStackTrace();
			}
		}
		
		if(forward != null) {
			if(forward.isRedirect()) {
				// == true가 생략
				response.sendRedirect(forward.getPath());
				/*
				 * 새로운 매핑주소로 이동한다.
				 * 이런 경우는 request.setAttribute("문자열 속성 키이름", 값)을 잃어버린다.
				 * 하지만 로그인 인증 처리를 하는 session.setAtribute("세션키이름", 값)은 유지한다.
				 */
			} else {
				RequestDispatcher urlForward = request.getRequestDispatcher(forward.getPath());
				urlForward.forward(request, response);
				/*
				 * 기존 매핑주소를 유지한다.
				 * 이런 경우는 request.setAttribute("문자열 속성 키이름", 값)을 잃어 버리지않는다.
				 * 또한 로그인 인증처리를 하는 session.setAttribute("키이름", 값)도 유지한다.
				 */
			}
		}
	}
}
