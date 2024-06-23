-- CRUD.sql
-- DB
--		(Relational DB - 테이블간의 관계를 중심으로)
--		RDB계통 : Oralcle유, MySQL, MariaDB, MSSQL, ...
--		NoSQL계통 : MongoDB, ElasricSearch, ...
------------------------------------------------------------
-- 초코파이(오리온,롯데)
-- table 하나 당 pk 하나는 있었으면...
-- 내가 생각한 모든 스키마에 중복값이 있을 가능성이 있으면
-- 번호 부여할 만한 열이름 하나 더 만들어서 PK먹이기!!
create table oct23_snack(
	s_no number(4) primary key,
	s_name varchar2(10 char)not null,
	s_maker varchar2(10 char)not null,
	s_price varchar2(4)not null,
	s_exp date not null
);

-- 테이블 지우기(실행 X)
drop table oct23_snack cascade constraint purge;
--------------------------------------------------------------
--CRUD(Create Read Update Delete)
--C(create table 아님!!)
-- data 만들기 용 : C(insert)
insert into 테이블명(필드명, 필드명, ...) values(값, 값, ...);

insert into oct23_snack(s_no, s_name, s_price) values (1,'초코파이',5000);

-- 필드 순서 바꿔서 넣기?
insert into oct23_snack(s_price, s_no, s_name) values(3500, 2 '포카칩');

-- 진짜 값 넣기
insert into oct23_snack values(1, '초코파이', '오리온', 5000, sysdate);
insert into oct23_snack values(2, '초코파이', '롯데', 5000, sysdate);
insert into oct23_snack values(3, '마이쮸', '해태', 500, sysdate);
insert into oct23_snack values(4, '엄마손파이', '오리온', 3500, sysdate);
insert into oct23_snack values(5, '포카칩', '롯데', 3500, sysdate);

-- 값 확인
select * from oct23_snack;
------------------------------------------------------------------------
-- 자동으로 번호가 부여되게(계산되게)
-- factory pattern
--		MySQL : autoincrement 계산]
--		Oracle : sequence
--				intset 실패해도 counting
--				table과는 무관(별개)
--				1, 2, ... 차례대로 하는게 아님
--				primary key 어떻게든 먹이려고!

-- sequence생성(테이블과는 무관한)
create sequence 시퀀스명;
create sequence oct23_snack_seq;

-- table과는 무관하기 때문에 table 지울 때 이것도 같이 지워야 - 삭제
drop sequence 시퀀스명;
drop sequence oct23_snack_seq;

-- 기존에 넣은 데이터 지우기 (테이블은 가만히 냅두고 안의 데이터만지우는 방법)
-- 실행하고 select 문 다시 실행해보면 데이터 다 지워져 있음
truncate table oct23_snack;

-- sequence 사용 : 시퀀스명.nextval
insert into oct23_snack values(oct23_snack_seq.nextval, '초코파이', '오리온', 5000, sysdate);
insert into oct23_snack values(oct23_snack_seq.nextval, '초코파이', '롯데', 5000, sysdate);
insert into oct23_snack values(oct23_snack_seq.nextval, '마이쮸', '해태', 500, sysdate);
insert into oct23_snack values(oct23_snack_seq.nextval, '엄마손파이', '오리온', 3500, sysdate);
insert into oct23_snack values(oct23_snack_seq.nextval, '포카칩', '롯데', 3500, sysdate);
---------------------------------------------------------------------------
-- 시간/ 날짜
--		sysdate : 현재 시간/ 날짜

-- 특정시간/ 날짜
--		내장함수 - to_date('값','패턴')
--		패턴(대문자) : YYYY, MM, DD, AM/PM, HH, HH24(추천), MI, SS
insert into oct23_snack values(oct23_snack_seq.nextval,'포카칩','롯데',3500,to_date('2023-10-24 13','YYYY-MM-DD HH24'));
insert into oct23_snack values(oct23_snack_seq.nextval,'포카칩','롯데',3500,to_date('2023-10-24 오후 02:00','YYYY-MM-DD HH24'));
insert into oct23_snack values(oct23_snack_seq.nextval, '초코파이', '오리온', 5000,  to_date('2028-09-15 20','YYYY-MM-DD HH24'));
insert into oct23_snack values(oct23_snack_seq.nextval, '초코파이', '롯데', 5000,  to_date('2024-05-24 18','YYYY-MM-DD HH24'));
insert into oct23_snack values(oct23_snack_seq.nextval, '마이쮸', '해태', 500,  to_date('2023-02-04 13','YYYY-MM-DD HH24'));
insert into oct23_snack values(oct23_snack_seq.nextval, '엄마손파이', '오리온', 3500,  to_date('2023-01-21 01','YYYY-MM-DD HH24'));
insert into oct23_snack values(oct23_snack_seq.nextval, '포카칩', '롯데', 3500, to_date('2025-10-20 05','YYYY-MM-DD HH24'));
------------------------------------------------------------------------------
-- CRUD
--		R(Read)
--		select 필드명, 필드명 as 별명, 연산자, 통계함수, ...
--		from 테이블명
--		where 조건;

--	과자테이블 전체 조회
select * from OCT23_SNACK;

-- 모든 과자이름, 가격 조회
select s_name, s_price from OCT23_SNACK;

-- 모든 과자이름, 가격, 부가세(0.1) 조회
select s_name, s_price, s_price * 0.1 from OCT23_SNACK;
select s_name, s_price, s_price * 0.1 as vat from OCT23_SNACK;

-- 모든 과자이름, 가격, 판매가(10%할인) -> selling_price 조회
select s_name, s_price, s_price * 0.9 as selling_price from oct23_snack;

-- 통계함수 : sum(필드명), avg, max, min, count

-- 모든 과자의 평균가
select avg (s_price) from oct23_snack;

-- 모든 과자의 최고가, 최저가, 총 과자 개수
select max (s_price) as max, min (s_price) as min, count (s_name) from oct23_snack;

-- 2000원 이상인 과자의 전체정보
select * from oct23_snack where s_price >= 2000;

-- 1500원 이상인 과자의 이름,가격,판매가(10%)
select s_name, s_price, s_price * 0.9 from oct23_snack where s_price >= 1500;

-- 1000원 짜리 과자 몇 개
select count (s_no) from where s_price = 1000;

-- 포카칩 가격
select  s_price from where s_name = "포카칩";

-- 올해안에 먹어야 하는 과자 이름, 가격, 유통기한
select s_name, s_price, s_exp from where s_exp ('YYYY') < to_date('2024-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS');
-- insert <<
-- 새콤달콤포도맛, 새콤달콤딸기맛, ... 여러개(5개 이상)
-- 몽쉘카카오, 몽쉘티라미수, ... 여러개(5개 이상)
insert into oct23_snack values(oct23_snack_seq.nextval, '새콤달콤 포도맛', '오리온', 2700, to_date('2028-01-15 05','YYYY-MM-DD HH24'));
insert into oct23_snack values(oct23_snack_seq.nextval, '새콤달콤 딸기맛', '삼성', 3000, to_date('2024-04-15 03','YYYY-MM-DD HH24'));
insert into oct23_snack values(oct23_snack_seq.nextval, '새콤달콤 탕후루맛', '삼성', 4000, to_date('2025-03-15 15','YYYY-MM-DD HH24'));
insert into oct23_snack values(oct23_snack_seq.nextval, '새콤달콤 초코맛', '애플', 500, to_date('2026-05-15 17','YYYY-MM-DD HH24'));
insert into oct23_snack values(oct23_snack_seq.nextval, '새콤달콤 곶감맛', '대우전자', 700, to_date('2027-07-15 11','YYYY-MM-DD HH24'));
insert into oct23_snack values(oct23_snack_seq.nextval, '몽쉘 카카오', '삼성', 5000, to_date('2028-09-05 21','YYYY-MM-DD HH24'));
insert into oct23_snack values(oct23_snack_seq.nextval, '몽쉘 티라미수', '삼성', 5000, to_date('2027-09-06 10','YYYY-MM-DD HH24'));
insert into oct23_snack values(oct23_snack_seq.nextval, '몽쉘 카이막', '오리온', 5000, to_date('2024-08-15 13','YYYY-MM-DD HH24'));
insert into oct23_snack values(oct23_snack_seq.nextval, '몽쉘 바클라마', '대우전자', 5000, to_date('2023-12-24 20','YYYY-MM-DD HH24'));
insert into oct23_snack values(oct23_snack_seq.nextval, '몽쉘 젤라또', '애플', 5000, to_date('2026-09-14 15','YYYY-MM-DD HH24'));
-- 삼성에서 만든 모든 과자 정보 조회
select * from oct23_snack where s_maker ='삼성';

-- 문자열 포함 검색 : like '패턴'
--		%
--		'%온' : 온으로 끝나는 것
--		'오%' : 오로 시작하는 것
--		'%해%': 해가 포합되는 것 << (내 마음이 편하려고) 가장 많이 사용

-- 새콤달콤이 들어가는 과자의 평균가
select avg(s_price) from oct23_snack where s_name like'%새콤달콤%';

-- 몽쉘이 들어가는 과자의 이름, 제조사, 가격
select s_name, s_maker, s_price from OCT23_SNACK where s_name like '%몽쉘%';
-- 오리온 과자거나 몽쉘~~인 것 이름, 가격 >> or
select s_name, s_price from OCT23_SNACK where s_name like '%몽쉘%' or s_maker = '오리온';
-- 가격이 1000원 이상이면서 5000원 이하인 것 이름, 가격 >> and
select s_name, s_price from oct23_snack where s_price >= 1000 and s_price <= 5000;

------------------------------------------------------------------------------------------
-- 통계함수는 select과 from 사이에만 존재 가능
-- subquery ** : query문 안에 query문이 하나 더

-- 최고가 조회
select max(s_price) from OCT23_SNACK;

-- 가장 비싼 과자 이름, 제조사, 가격
select s_name, s_maker, s_price from OCT23_SNACK where max(s_price);--x
select s_name, s_maker, s_price from OCT23_SNACK where s_price = (select max(s_price) from OCT23_SNACK);
-- 가장 싼 과자 만드는 곳 조회
select s_maker from OCT23_SNACK where s_price = (select min(s_price) from OCT23_SNACK);
-- 평균가보다 비싼 과자 몇 종류?
select s_name from OCT23_SNACK where s_price > (select avg(s_price) from OCT23_SNACK);

-- 단일 서브쿼리의 경우(서브쿼리가 하나만 쓰였을 경우)
--	서브쿼리에서 얻어지는 결과가 하나만 나와야 (row 행이 하나)
------------------------------------------------------------------------------------------------

