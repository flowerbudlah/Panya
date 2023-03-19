drop sequence product_reply_seq; 
create sequence product_reply_seq START WITH 1 MINVALUE 0;

drop table product_reply_table purge; 
create table product_reply_table(
	product_reply_idx       number not null primary key,
	product_idx        number constraint reply_fk3 references product_table(product_idx) on delete cascade,   
	product_reply_content   varchar2(1000),
    product_replyer_id      varchar2(100) constraint reply_fk4 references panya_member_table(member_id) on delete cascade,
	regdate         date default sysdate
);
commit;
select * from product_reply_table; 
