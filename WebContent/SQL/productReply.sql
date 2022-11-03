--1. 상품 댓글 인덱스 시퀀스 생성
drop sequence product_reply_seq; 
create sequence product_reply_seq START WITH 1 MINVALUE 0; 

--2. 상품 댓글 테이블 생성 
drop table product_reply_table purge; 
create table product_reply_table(
	product_reply_idx       number not null,
	product_idx        number constraint product_reply_fk1 references product_table(product_idx) on delete cascade,   
	product_reply_content   varchar2(1000),
	product_replyer_id      varchar2(100) constraint product_reply_fk2 references panya_member_table(member_id) on delete cascade,
	regdate         date default sysdate,
	primary key(product_reply_idx)
);
commit;
select * from product_reply_table; 

--3. 상품 대댓글 인덱스 시퀀스 생성
drop sequence product_dubReply_seq; 
create sequence product_dubReply_seq START WITH 1 MINVALUE 0; 
--4. 상품 대댓글 테이블 생성
drop table product_dubReply_table purge; 
create table product_dubReply_table(
	product_dubReply_idx       number not null,
	product_idx        number constraint product_dubReply_fk1 references product_table(product_idx) on delete cascade, 
    product_reply_idx  number constraint product_dubReply_fk3 references product_reply_table(product_reply_idx), 
	product_dubReply_content   varchar2(1000),
	product_dubReply_id      varchar2(100) constraint product_dubReply_fk2 references panya_member_table(member_id) on delete cascade,
	regdate         date default sysdate,
	primary key(product_dubReply_idx)
);
commit;
select * from product_dubReply_table;  