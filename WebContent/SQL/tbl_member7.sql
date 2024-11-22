--tbl_member7 테이블 생성
create table tbl_member7(
    mem_id varchar2(50) constraint tbl_member7_memid_pk primary key, --아이디
    mem_pwd varchar2(50) constraint tbl_member7_mempwd_nn not null, -- 비밀번호
    mem_name varchar2(30) constraint tbl_member7_memname_nn not null, -- 회원이름
    mem_phone varchar2(20) constraint tbl_member7_memphone_nn not null, -- 전화번호
    mem_email varchar2(50) not null, -- 이메일
    mem_file varchar2(200), -- 회원 프로필 사진
    mem_date date -- 가입날짜
);

select * from tbl_member7 order by mem_id asc;