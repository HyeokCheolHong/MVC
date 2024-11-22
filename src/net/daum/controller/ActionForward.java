package net.daum.controller;

public class ActionForward {
	private boolean isRedirect;
	// 매핑주소를 어떤 방식으로 이동시킬 건지를 판단하는 분기변수
	private String path;
	// 이동할 매핑 주소 또는 뷰페이지 경로
	
	public boolean isRedirect() {
		// 값 반환 getter() 메서드
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	
}
