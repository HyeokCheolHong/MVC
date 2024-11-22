package net.daum.controller;

import java.io.File;
import java.util.Calendar;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import net.daum.dao.MemberDAOImpl;
import net.daum.vo.MemberVO;

public class MemberJoinOkController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8"); // post 방식으로 전송되는 한글을 안 깨지게 한다.
		
		String saveFolder = request.getRealPath("upload"); // 이진파일 업로드 서버 실제 경로를 구함
		int fileSize = 5 * 1024 * 1024; // 이진파일 업로드 최대 크기 (5M)

		MultipartRequest multi = null; // cos.jar 라이브러리로부터 읽어들일 이진파일 업로드 api
		multi = new MultipartRequest(request, saveFolder, fileSize, "UTF-8"); // 이진파일 업로드 multi 생성
		
		MemberVO m = new MemberVO();
		
		String mem_id = multi.getParameter("mem_id");
		String mem_pwd = multi.getParameter("mem_pwd");
		String mem_name = multi.getParameter("mem_name");
		String phone01 = multi.getParameter("phone01");
		String phone02 = multi.getParameter("phone02");
		String phone03 = multi.getParameter("phone03");
		String mem_email = multi.getParameter("mem_email");
		
		File upFile = multi.getFile("mem_file"); // 업로드한 첨부파일을 객체로 생성
		
		if(upFile != null) {
			String fileName = upFile.getName(); // 첨부한 파일명
			int index = fileName.lastIndexOf("."); // 첨부 파일명의 경로 중 .를 맨 오른쪽부터 찾아서 가장 먼저 나오는 해당 문자의 인덱스 번호를 반환
			String fileExtension = fileName.substring(index + 1); // 마침표 이후부터 마지막 문자까지 추출. 즉 첨부파일의 확장자를 추출
			
			Calendar cal = Calendar.getInstance();
			int year = cal.get(Calendar.YEAR); // 년도값
			int month = cal.get(Calendar.MONTH) + 1; // 월값, 1월이 0으로 반환되기 때문에 +1
			int date = cal.get(Calendar.DATE); // 일값
			
			String homedir = saveFolder + "/" + year + "-" + month + "-" + date; // 오늘 날짜 폴더 경로 저장
			File path01 = new File(homedir);
			if(!path01.exists()) { // 오늘 날짜 폴더 경로가 존재하지 않으면
				path01.mkdir(); // 오늘 날짜 폴더 생성
			}
			
			Random r = new Random();
			int random = r.nextInt(1_000_000_000); // 0 ~ 1억 미만 사이의 정수난수가 발생
			
			String refileName = "member" + year + month + date + random + "." + fileExtension; // 새로운 첨부파일명을 정의
			String fileDBName = "/" + year + "-" + month + "-" + date + "/" + refileName; // 데이터베이스에 저장될 레코드 값
			
			upFile.renameTo(new File(homedir + "/" + refileName)); // 오늘 날짜로 새롭게 생성된 폴더 경로에 변경된 첨부파일로 실제 업로드
			m.setMem_file(fileDBName);
		}
		
		m.setMem_id(mem_id);
		m.setMem_pwd(mem_pwd);
		m.setMem_name(mem_name);
		String mem_phone = phone01 + "-" + phone02 + "-" + phone03;
		m.setMem_phone(mem_phone);
		m.setMem_email(mem_email);
		
		MemberDAOImpl mdao = new MemberDAOImpl();
		mdao.insertMember(m); // 회원 저장
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("login.do");
		
		return forward;
	}
	
}
