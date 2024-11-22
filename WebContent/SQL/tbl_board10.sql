--TBL_BOARD10 테이블 생성
create table tbl_board10 (
    b_no int primary key, -- 게시판 번호
    b_title varchar2(200) not null, -- 글제목
    b_cont varchar2(4000) not null, -- 글내용
    b_date date -- 등록날짜
);

select * from tbl_board10 order by b_no desc;

alter table tbl_board10 add b_hit Int;
--alter table tbl_board10 modify b_hit Int;
alter table tbl_board10 modify b_hit default 0;
update tbl_board10 set b_hit=0;
commit;

--board10_seq 시퀀스 생성
create sequence board10_seq
start with 1
INCREMENT by 1
nocache;

--시퀀스 번호값 확인
select board10_seq as "시퀀스 번호값" from dual;