package net.daum.vo;

public class MemberVO {
	// 데이터 저장 Bean 클래스
	// 테이블 컬럼명, Bean클래스 변수명, 네임파라미터 이름은 같게 한다.
	
	private String mem_id;
	private String mem_pwd;
	private String mem_name;
	private String mem_phone;
	private String mem_email;
	private String mem_file;
	private String mem_date;
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_pwd() {
		return mem_pwd;
	}
	public void setMem_pwd(String mem_pwd) {
		this.mem_pwd = mem_pwd;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_phone() {
		return mem_phone;
	}
	public void setMem_phone(String mem_phone) {
		this.mem_phone = mem_phone;
	}
	public String getMem_email() {
		return mem_email;
	}
	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}
	public String getMem_file() {
		return mem_file;
	}
	public void setMem_file(String mem_file) {
		this.mem_file = mem_file;
	}
	public String getMem_date() {
		return mem_date;
	}
	public void setMem_date(String mem_date) {
		this.mem_date = mem_date;
	}
	
	
}
