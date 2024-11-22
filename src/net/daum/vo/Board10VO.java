package net.daum.vo;

public class Board10VO { // 데이터 저장 빈 클래스 => 테이블 컬럼명, 해당 뷰 페이지 네임파라미터 이름, 빈 클래스 변수명은 일치시킨다.
   private int b_no;
   private String b_title;
   private String b_cont;
   private String b_date;
   private int b_hit;
   
   public int getB_no() { return b_no; }
   public void setB_no(int b_no) { this.b_no = b_no; }
   
   public String getB_title() { return b_title; }
   public void setB_title(String b_title) { this.b_title = b_title; }
   
   public String getB_cont() { return b_cont; }
   public void setB_cont(String b_cont) { this.b_cont = b_cont; }
   
   public String getB_date() { return b_date; }
   public void setB_date(String b_date) { this.b_date = b_date; }
   
   public int getB_hit() { return b_hit; }
   public void setB_hit(int b_hit) {	this.b_hit = b_hit; }
   
   
}
