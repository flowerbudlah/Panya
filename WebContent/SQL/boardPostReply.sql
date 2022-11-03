--게시판정보
drop table board_table purge;
create table board_table(
  board_idx   number  constraint board_info_pk primary key,
  board_name  varchar2(500) not null
);
insert into board_table values(1, '공지사항');
insert into board_table(board_idx, board_name) values(2, '고객센터');
select * from board_table;
commit;

--게시물 테이블 
drop sequence post_seq; 
create sequence post_seq start with 1 increment by 1 minvalue 0;
drop table post_table purge;
create table post_table(
    post_idx        number constraint post_pk primary key,
    post_subject    varchar2(500) not null,
    post_text        varchar2(4000) not null,
    post_file       varchar2(500),
    post_writer_idx number not null,
    post_board_idx  number constraint post_fk2 references board_table(board_idx),
    post_date       date not null
);
alter table post_table add constraint post_fk1 foreign key(post_writer_idx) references panya_member_table(member_idx) on delete cascade; 
--게시물 조회수 증가 관련 
ALTER TABLE post_table ADD(post_read_count NUMBER DEFAULT 0);
select * from post_table;
COMMIT;

--댓글 시퀀스 생성
drop sequence reply_seq; 
create sequence reply_seq 
START WITH 1 
MINVALUE 0;
--댓글 테이블 생성
drop table reply_table purge; 
create table reply_table(
	reply_idx       number not null,
	post_idx        number constraint reply_fk1 references post_table(post_idx) on delete cascade,   
	reply_content   varchar2(1000),
	replyer_id      varchar2(100) constraint reply_fk2 references panya_member_table(member_id) on delete cascade,
	regdate         date default sysdate,
	primary key(reply_idx)
);
commit;
select * from reply_table; 
