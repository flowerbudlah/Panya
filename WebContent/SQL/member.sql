--회원가입관련 로그인관련 테이블 
drop sequence panya_member_seq; 
create sequence panya_member_seq
start with 3
increment by 1
minvalue 0;

drop table panya_member_table purge;
create table panya_member_table(
	member_idx   number  constraint member_pk primary key,
	member_name  varchar2(50) not null,
	member_id    varchar2(100) unique not null,
	member_pw    varchar2(100) not null, 
	member_email  varchar2(100) unique not null,
	member_tel varchar2(50) not null,
	member_address varchar2(100) not null, 
	postcode number not null, 
	question varchar2(500) not null, 
	answer varchar2(500) not null, 
	registerDate date
);

--어드민 회원가입
insert into panya_member_table values(1, '관리자', 'admin', 1111, 'flowerbudlah_project@naver.com', '010-5824-9508', '경기도 성남시 분당구 판교로 야탑동', 111111,'애완견이름은?', '러키', sysdate);
insert into panya_member_table values(2, '이아현', 'flowerbudlah', 1111, 'flowerbudlah@nate.com', '010-5824-9508', '인천광역시 서곶로12, 한신 그랜드 힐 빌리지 22동 507호', 111111,'애완견이름은?', '러키', sysdate);
