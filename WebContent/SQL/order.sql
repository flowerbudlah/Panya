--주문 테이블 
drop table order_table purge;
create table order_table(
    order_idx       varchar2(50) constraint order_pk primary key, --주문결제번호 인덱스
    member_id       varchar2(100) constraint order_fk3 references panya_member_table(member_id), --주문자 아이디
    paymentPrice    number, --배송비제외한 총금액 
    sender_name     varchar2(50),  
    sender_address  varchar2(100), 
    sender_postcode number, 
    sender_tel      varchar2(50),
    recipient_name  varchar2(50),
    recipient_address varchar2(100), 
    recipient_postcode number,
    recipient_tel   varchar2(50), 
    order_date      date, 
    memo            varchar2(500), 
    payment_method	varchar2(50)
);

ALTER TABLE order_table ADD circumstance VARCHAR(50) DEFAULT '결제완료(배송준비 전)'; 

--주문상세테이블의 인덱스의 시퀀스 
drop sequence order_detail_seq; 
create sequence order_detail_seq start with 1 increment by 1 minvalue 0;
--주문상세 테이블
drop table order_detail_table purge;
create table order_detail_table(
    order_detail_idx	number constraint detail_pk primary key,
    order_idx			varchar2(50) not null constraint detail_fk references order_table(order_idx) on delete cascade,
    product_idx 		number,
    amount 				number
);

select * from order_table; 
select * from order_detail_table; 

