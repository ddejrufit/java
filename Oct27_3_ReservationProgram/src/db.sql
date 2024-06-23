-- 매장관련 테이블
-- 테이블명 	: oct27_restaurant
-- 컬럼명		: r_location(체인점 지점), r_owner(식당 주인), r_seat(좌석수)
-- PK 어디에?
create table oct27_restaurant(
	r_location varchar2(20 char) primary key,
	r_owner varchar2(20 char) not null,
	r_seat	number(3) not null
)

drop table oct27_restaurant cascade constraint purge;
-- insert 2개정도? test용으로
insert into oct27_restaurant values( '신논현점', '홍길동', 50);
insert into oct27_restaurant values( '언주점', '김길동', 65);

select*from oct27_restaurant oder ;

-- 예약테이블 : oct27_reservation
-- r_name(예약자이름), r_time(예약 시간), r_phone(예약자전화번호), r_location(예약지점)
-- FK필요없음!, PK 어디에?
--	insert 세개 정도
create table oct27_reservation(
	r_no number(4) primary key,
	r_name varchar2(10 char) not null,
	r_time date not null,
	r_phone varchar2(20 char) not null,
	r_location varchar2(10 char)not null 
)

create sequence oct27_reservation_seq;

insert into oct27_reservation values( oct27_reservation_seq.nextval, '전우치', to_date('2023-10-28 12:15','YYYY-MM-DD HH24:MI'), '010-6364-2654','신논현점');
insert into oct27_reservation values( oct27_reservation_seq.nextval, '김우치', to_date('2023-10-30 17:20','YYYY-MM-DD HH24:MI'), '010-6516-9515','언주점');
insert into oct27_reservation values( oct27_reservation_seq.nextval, '이우치', to_date('2023-10-29 19:00','YYYY-MM-DD HH24:MI'), '010-5919-1914','신논현점');

select * from oct27_reservation order by r_no;

-- 입력한 좌석 수 이상을 가지고 있는 매장, 지점명 오름차순
select*from oct27_restaurant where r_seat >= 50 order by r_location;
-- 예약자 이름으로 찾기, 예약 번호순으로 정렬
select * from oct27_reservation where r_name like '%우치%' order by r_no;
-- 예약자의 전화번호 수정하기
update oct27_reservation set r_phone ='010.0000.0000' where r_no = 5;



