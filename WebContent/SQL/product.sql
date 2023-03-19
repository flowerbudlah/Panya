--상품 테이블 
drop sequence product_seq; 
create sequence product_seq
start with 33
increment by 1
minvalue 0;

drop table product_table purge;
create table product_table(
    product_idx  number constraint product_pk primary key,
    product_name varchar2(100) not null,
    product_price number not null,
    category_idx number not null, 
    storage_method varchar2(100), 
    expiration_date varchar2(100), 
    product_img varchar2(100) 
);


insert into product_table values(1, '바게트', 2500, 1, '상온보관', '제조일로부터 10일', 'baguettes.png'); 
insert into product_table values(2, '쫄깃쫄깃 베이글', 2500, 1, '상온보관', '제조일로부터 10일', 'begel.png'); 
insert into product_table values(3, '밤식빵	', 4000, 1, '직사광선을 피하고 서늘한 곳 보관(하절기 냉장보관)', '제조일로부터 7일', 'chestnut.png');    
insert into product_table values(4, '아몬드 크림치즈', 1500, 1, '직사광선을 피하고 서늘한 곳 보관(하절기 냉장보관)', '제조일로부터 5일', 'cream_cheese_amond.png'); 
insert into product_table values(5, '애플 크림치즈', 1500, 1, '직사광선을 피하고 서늘한 곳 보관(하절기 냉장보관)', '제조일로부터 5일', 'cream_cheese_apple.png');  
insert into product_table values(6, '크로와상', 1000, 1, '상온보관', '제조일로부터 10일', 'croissant.png');   
insert into product_table values(7, '카레빵', 1000, 1, '냉장보관', '제조일로부터 3일', 'curry.png'); 
insert into product_table values(8, '마요에그', 1000, 1, '냉장보관', '제조일로부터 3일', 'mayo_egg.png'); 
insert into product_table values(9, '멜론빵', 1500, 1, '상온보관', '제조일로부터 10일', 'melon_basic.png'); 
insert into product_table values(10, '초코 멜론빵', 1500, 1, '상온보관', '제조일로부터 10일', 'melon_choco.png'); 
insert into product_table values(11, '맛차 멜론빵', 1500, 1, '상온보관', '제조일로부터 10일', 'melon_matcha.png'); 
insert into product_table values(12, '올리브 스틱', 2000, 1, '상온보관', '제조일로부터 10일', 'olive_stick.png');
insert into product_table values(13, '식빵', 2500, 1, '상온보관',  '제조일부터 10일', 'plain_bread.png');
insert into product_table values(14, '그린티 롤 케이크', 4000, 1, '직사광선을 피하고 서늘한 곳 보관(하절기 냉장보관)', '제조일로부터 5일', 'roll_greentea.png'); 
insert into product_table values(15, '라이스 롤 케이크', 4000, 1, '직사광선을 피하고 서늘한 곳 보관(하절기 냉장보관)', '제조일로부터 5일', 'roll_rice.png'); 
insert into product_table values(16, '롤 케이크 세트(5개/세트)', 10000, 1, '직사광선을 피하고 서늘한 곳 보관(하절기 냉장보관)', '제조일로부터 5일', 'roll_set.png');  
insert into product_table values(17, '참깨 만쥬', 1500, 1,'직사광선을 피하고 서늘한 곳 보관(하절기 냉장보관)', '제조일로부터 5일', 'sesame.png'); 
insert into product_table values(18, '시오빵', 1500, 1, '냉장보관', '제조일로부터 10일', 'sio.png'); 
insert into product_table values(19, '야끼소바빵', 3000, 1, '냉장보관', '제조일로부터 3일', 'soba.png');  
insert into product_table values(20, '단팥빵', 1500, 1, '직사광선을 피하고 서늘한 곳 보관(하절기 냉장보관)', '제조일로부터 10일', 'sweet_redbean.png');  
insert into product_table values(21, '바스크 치즈 케이크', 10000, 2, '냉장보관', '제조일로 부터 5일', 'bask_cheese_cake.png'); 
insert into product_table values(22, '진주를 먹은 초코 케이크', 35000, 2, '냉장보관', '제조일로 부터 5일', 'chocolet_cake.png'); 
insert into product_table values(23, '후르츠 크림 치즈 케이크', 35000, 2, '냉장보관', '제조일로 부터 5일', 'cream_cheese_cake.png');  
insert into product_table values(24, '망고 생크림 케이크', 30000, 2, '냉장보관', '제조일로 부터 5일', 'mango_cake.png'); 
insert into product_table values(25, '귀여운 말티즈' , 6000, 2, '냉장보관', '제조일로 부터 5일', 'puggy_cake.png'); 
insert into product_table values(26, '찰리와 친구들', 30000, 2, '냉장보관', '제조일로 부터 5일', 'snoopy_friends_cake.png');  
insert into product_table values(27, '스트로 베리 생크림 케이크', 30000, 2, '냉장보관', '제조일로 부터 5일', 'straw_cake.png'); 
insert into product_table values(28, '나비파이', 2000, 3, '상온보관', '제조일로부터 10일', 'butterfly_pie.png'); 
insert into product_table values(29, '유자 마카롱', 2500, 3, '상온보관', '제조일로부터 10일', 'macaron_citron.png'); 
insert into product_table values(30, '마카롱 세트(10개/세트)', 20000, 3, '상온보관', '제조일로부터 10일', 'macaron_set.png'); 
insert into product_table values(31, '스콘세트(2개/세트)', 4000, 3, '상온보관', '제조일로부터 10일', 'scone.png'); 
insert into product_table values(32, '아리가토 수제 비스킷 세트(10개/세트)', 6000, 3, '상온보관', '제조일로부터 10일', 'thanks.png');  

select * from product_table order by product_idx;
commit; 

--추천버튼(좋아요기능)
alter table product_table add likeButton int default 0; 
