--장바구니 테이블 시퀀스 생성
drop sequence cart_seq; 
CREATE SEQUENCE cart_seq 
START WiTH 1 
INCREMENT BY 1 minvalue 0;

DROP TABLE CART_TABLE PURGE; 
CREATE TABLE cart_table(
    cart_idx NUMBER PRIMARY KEY, --장바구니 번호
	member_id VARCHAR2(100),--회원 아이디
	product_idx number,--상품의 인덱스번호
    amount NUMBER, --상품갯수
	regDate DATE DEFAULT SYSDATE --생성일자
); 

ALTER TABLE cart_table ADD CONSTRAINT cart_fk_member_id FOREIGN KEY (member_id) REFERENCES panya_member_table(member_id) on delete cascade; 
ALTER TABLE cart_table ADD CONSTRAINT cart_fk_product_idx FOREIGN KEY (product_idx) REFERENCES product_table(product_idx) on delete cascade;