select * from oct23_snack;
------------------------------------
-- 관계연산자 : and, or, NOT, BETWEEN, IN

--	가격이 1000원 이상 3000원 이하인 과자의 전체정보 조회
select * from oct23_snack where s_price <= 1000 and s_price >=3000;
-- between 이용
select * from OCT23_SNACK where s_price between 1000 and 3000;

-- and 와 between 뭐가 다른가? between이 더 편한거 아닌가?
--		* between : 이상/ 이하 조건 범위 안에서는 편함!
--		초과 or 미만 이 범위에 들어가는 경우에는 between 사용이 애매

-- 가격이 1500원, 2000원, 3000원 인 과자의 전체정보 조회
select * from oct23_snack where s_price = 1000 or s_price = 2000 or s_price = 3000; 
-- IN : 연속되지 않은 값들을 받아오고 싶을 때
select * from oct23_snack where s_price in (1500,2000,3000);

-- NOT : 결과에 반대되는 결과값을 얻고 싶을 때
--		어디에 사용? IN앞에 : NOT IN
select * from oct23_snack where s_price not in (1500,2000,3000);
--------------------------------------------------------------------------
-- 커피테이블 (oct25_coffee)
--		커피이름(10글자), 가격(5), 칼로리(소수점1자리), 만든날짜(date) : null값 없이

drop table 테이블명 cascade constraint purege;-- 테이블 지우기

create table oct25_coffee(
	c_name varchar2(10 char) primary key,
	c_price number(5)not null,
	c_kcal number (5,1)not null, 
	c_make date not null	
);

insert into oct25_coffee values('아메리카노',3000,20.1,sysdate);
insert into oct25_coffee values('카페라떼',4000,70.3,sysdate);
insert into oct25_coffee values('자바칩프라페',8000,252.4,sysdate);
insert into oct25_coffee values('청포도에이드',4500,120.2,sysdate);
insert into oct25_coffee values('요거트스무디',5500,54.7,sysdate);

select * from oct25_coffee;

-- DDL(데이터 정의어)의 drop, alter, truncate

-- 테이블 내의 내용 지우기 : truncate
--		테이블 안에 있는 데이터는 모두 삭제했지만, 테이블 구조 자체는 그대로 남아있음!
truncate table [테이블명]ㅣ
truncate table oct25_coffee;

-- 데이터 타입, 컬럼 크기, 용량, 원래대로 돌려놓기, ... : alter
-- ** 주의사항!!
--		데이터 타입 변경할 때는 해당 컬럼의 값을 모두 지운 상태여야 변경이 가능!
--		컬럼의 용량을 줄일 경우, 해당 컬럼의 용량을 조회해서 변경할 길이보다
--		큰 값이 있는지 먼저 확인 하고 -> 컬럼 용량 변경
alter table [테이블명] modify [컬럼명] [데이터타입(용량)];

-- 커피테이블 c_name 부분을 세자리 숫자로 변경
--		ㄴ 테이블 안에 값이 있는 상태면 데이터 타입 변경 불가능!
alter table oct25_coffee modify c_name number(3);


-- 테이블 구조 확인 
-- 층 -> sqlpluss ID/PW@ID주소1521/xe	(sqlplus chan/1@localhodst:1521/xe)
-- 앞부분이 'sql>'로 바뀌면
-- desec 테이블 명;

alter table oct25_coffee modify c_name varchar2(10,char);
-- c_name의 용량을 10자리 -> 5자리
alter table oct25_coffee modify c_name varchar2(5,char);

-- 컬럼명 변경
alter table[테이블명] rename colum [기존 컬럼명] to [바꿀컬럼명];
alter table oct25_coffee modify rename colum c_name to c_name2;

-- 컬럼 추가(비추), 차라리 테이블을 다 지우고 다시 만드는 것을 추천!!
alter table [테이블명] add [추가할 컬럼명][데이터타입][제약조건(생략가능)];
-- ** 기존에 테이블 속 데이터가 없어야 제약조건에 not null 넣을 수 있음
alter table oct25_coffee add c_taste varchar2(10 char)not null;

-- 컬럼 삭제
alter table [테이블명] drop column [컬럼명];
alter atble oct25_coffee dorp column c_taste;

------------------------------------------------------------
-- 테이블 완저 삭제 (휴지통 넣기 + 휴지통 비우기)
drop table [테이블명] cascade constraint purge;

-- 테이블 삭제(휴지통 넣기)
drop table [테이블명] cascade constraint;

-- (휴지통에 있는) 테이블 복원
flashback table [테이블명] to before drop;

-- 휴지통 비우기
purge recyclebin;

-- 휴지통에 있는 것들 보이게
show recyclebin;
-----------------------------------------------------------
--1. 음료 테이블과 카페 테이블
-- 음료테이블(oct25_drink) : 음료이름,가격,판매하는 카페의이름
-- 카페(oct25_cafe) : 카페이름, 지역, 좌석수
-- [조건1] : 각 테이블에서 음료이름, 카페이름은 고유한 값을 갖는다
-- [조건2 : A카페는 서울에 위치 좌석 100석
--			(아메리카노 2000원, 라떼 3000원, 녹차 2500원) 판매
--			B카페는 독도에 위치, 좌석 80석
--			(홍차 2500원, 스무디 3000원, 에스프레소 4000원) 판매

-- 테이블 만들고 각각 값 넣기 까지!
create table oct25_drink(
	d_name varchar2(10 char) primary key,
	d_price number(5)not null, 
	d_cafe varchar2(10 char) not null	
);

create table oct25_cafe(
	c_name varchar2(10 char) primary key,
	c_location varchar2(10 char)not null,
	c_sit number (5,1)not null
);
insert into oct25_drink values('아메리카노',2000,'A');
insert into oct25_drink values('라떼',3000,'A');
insert into oct25_drink values('녹차',2500,'A');

insert into oct25_drink values('홍차',2500,'B');
insert into oct25_drink values('스무디',3000,'B');
insert into oct25_drink values('에스프레소',4000,'B');

insert into oct25_cafe values('A','서울',100);
insert into oct25_cafe values('B','독도',80);

select * from oct25_drink;
select * from oct25_cafe;
--------------------------------------------------------
--전체 음료 평균가 보다 비싼 음료 몇 종류?
select count(*)from oct25_drink where d_price>(select avg(d_price)from oct25_drink); 
-- 제일 싼 음료를 파는 카페 이름?
select d_cafe from oct25_drink where d_price = (select min(d_price)from oct25_drink);
-- 서울에 있는 카페에서 만든 음료의 평균가는
select avg(d_price) from oct25_drink where d_cafe = (select c_name from oct25_cafe where c_location ='서울');
--좌석이 90석 이상인 카페에서 파는 음료의 이름?
select d_name from oct25_drink where d_cafe = (select c_name from oct25_cafe where c_sit >= 90);
-- 전체 음료 평균가보다 저렴한 음료 이름?
select d_name from oct25_drink where d_price < (select avg(d_price) from oct25_drink);
--가장 비싼 음료 파는 카페가 위치한 곳?
select c_location from oct25_cafe where c_name = (select d_cafe from oct25_drink where d_price = (select max(d_price)from oct25_drink));
---------------------------------------------------------------------------------------------------------------------------------------------------
-- 요식업 프랜차이즈
-- 외래키 X
-- 하나의 테이블에서 다른 두개 테이블 무리해서 연결할 필요 X
create table oct25_restaurant(
	r_no number(4) primary key,
	r_name varchar2(10 char) not null,
	r_location varchar2(10 char)not null, 
	r_owner number(3) not null,
	r_seat number(3) not null
);
create sequence oct25_restaurant_seq;

-- 홍콩반점 강남점은 홍길동(1)이 운영하고 100석
-- 홍콩반점 종로점은 김길동(2)이 운영하고 80석
-- 한신포차 강서점은 홍길동(3)이 운영하고 150석
-- 잠실포차 잠실점은 최길동(4)이 운영하고 130석
insert into oct25_restaurant values(oct25_restaurant_seq.nextval,'홍콩반점','강남점',1,100);
insert into oct25_restaurant values(oct25_restaurant_seq.nextval,'홍콩반점','종로점',2,80);
insert into oct25_restaurant values(oct25_restaurant_seq.nextval,'한신포차','강서점',3,150);
insert into oct25_restaurant values(oct25_restaurant_seq.nextval,'잠실포차','잠실점',4,130);



create table oct25_owner(
	o_no number(4) primary key,
	o_name varchar2(10 char) not null,
	o_birth date not null, 
	o_gender varchar2(2 char) not null
);

-- 홍길동, 1990-03-01일생, 남자
-- 김길동, 1992-02-01일생, 여자
-- 홍길동, 1991-12-12일생, 여자
-- 최길동, 1989-10-25일생, 남자
create sequence oct25_owner_seq;
drop sequence oct25_owner_seq;
truncate table oct25_owner;
insert into oct25_owner values(oct25_owner_seq.nextval,'홍길동',to_date('1990-03-01','YYYY-MM-DD'),'남자');
insert into oct25_owner values(oct25_owner_seq.nextval,'김길동',to_date('1992-02-01','YYYY-MM-DD'),'여자');
insert into oct25_owner values(oct25_owner_seq.nextval,'홍길동',to_date('1991-12-12','YYYY-MM-DD'),'여자');
insert into oct25_owner values(oct25_owner_seq.nextval,'최길동',to_date('1989-10-25','YYYY-MM-DD'),'남자');

select * from oct25_owner;
create table oct25_menu(
	m_no number(4)primary key,
	m_name varchar2(10 char) not null,
	m_price number(5)not null, 
	m_r_no number(3) not null
);
drop table oct25_menu cascade constraint purge;


select r_no from oct25_restaurant;
create sequence oct25_menu_seq;
-- 매장당 메뉴 5개정도 입력
-- 짜장면, 5000원, 홍콩반점 강남점
-- 불닭발, 18000원, 한신포차 강서점

insert into oct25_menu values(oct25_menu_seq.nextval,'짜장면',5000,1);
insert into oct25_menu values(oct25_menu_seq.nextval,'군만두',5000,1);
insert into oct25_menu values(oct25_menu_seq.nextval,'멘보샤',5000,1);
insert into oct25_menu values(oct25_menu_seq.nextval,'고추짜장',5500,1);
insert into oct25_menu values(oct25_menu_seq.nextval,'고추짬뽕',5500,1);

insert into oct25_menu values(oct25_menu_seq.nextval,'차돌짬뽕',9000,2);
insert into oct25_menu values(oct25_menu_seq.nextval,'짬뽕',5000,2);
insert into oct25_menu values(oct25_menu_seq.nextval,'고추짬뽕',5500,2);
insert into oct25_menu values(oct25_menu_seq.nextval,'고추짜장',5500,2);
insert into oct25_menu values(oct25_menu_seq.nextval,'탕수육',15000,2);

insert into oct25_menu values(oct25_menu_seq.nextval,'불닭발',18000,3);
insert into oct25_menu values(oct25_menu_seq.nextval,'계란말이',12000,3);
insert into oct25_menu values(oct25_menu_seq.nextval,'오뎅탕',15000,3);
insert into oct25_menu values(oct25_menu_seq.nextval,'먹태',10000,3);
insert into oct25_menu values(oct25_menu_seq.nextval,'떡볶이',8000,3);

insert into oct25_menu values(oct25_menu_seq.nextval,'탕수육',15000,4);
insert into oct25_menu values(oct25_menu_seq.nextval,'계란말이',12000,4);
insert into oct25_menu values(oct25_menu_seq.nextval,'알탕',18000,4);
insert into oct25_menu values(oct25_menu_seq.nextval,'삼겹말이',25000,4);
insert into oct25_menu values(oct25_menu_seq.nextval,'매운오뎅탕',16000,4);

truncate table oct25_menu;

select * from oct25_restaurant;
select * from oct25_owner;
select * from oct25_menu;
--------------------------------------------------------------------------------------
-- 좌석수 제일 많은 식당 운영하는 사람의 전체정보
select *from oct25_owner where o_no = (select r_owner from oct25_restaurant where r_seat = (select max(r_seat) from oct25_restaurant));

-- 프렌차이즈 메뉴 전체의 이름, 가격을 오름차순, 가격이 같은 메뉴는 메뉴명을 가나다 역순 정렬
-- 가격을 오름차순으로 보고 싶다면 -- order by (asc)생략가능 컬럼명 -- 내림차순으로 order by desc, 컬럼명
select m_name, m_price from oct25_menu order by m_price , m_name desc;

-- 전체 사장님들 이름, 생일 조회
select o_name, o_birth from oct25_owner;
-- 프랜차이즈 식당이 몇개 있는지 조회
select count(*) from oct25_restaurant;
-- 프랜차이즈 메뉴 평균가 조회
select avg(m_price) from oct25_menu;
-----------------------------------------------------------------------------------------
--제일 비싼 메뉴의 이름, 가격 조회
select m_name, m_price from oct25_menu where m_price in (select max(m_price) from oct25_menu);
-- 최연장자 사장님의 이름, 생일 조회
select o_name, o_birth from oct25_owner where o_birth in (select min(o_birth)from oct25_owner);
-- 좌석 수 제일 적은 식당의 이름, 지점명, 좌석수
select r_name, r_location, r_seat from oct25_restaurant where r_seat in (select min(r_seat)from oct25_restaurant);
-- 홍콩반점 강남점 운영하는 사람의 이름, 생일 조회
select o_name, o_birth from oct25_owner where o_no in (select r_owner from oct25_restaurant where r_name = '홍콩반점' and r_location = '강남점' );
--'짜장'이 들어간 음식은 어디가면 먹을 수 있나요?(짜장이 들어간 음식을 파는 식당이름,지점명)
select r_name, r_location from oct25_restaurant where r_no in (select m_r_no from oct25_menu where m_name like '%짜장%');
-- 최연소 사장님의 가게 메뉴이름, 가격
select m_name, m_price from oct25_menu where m_r_no in (select r_no from oct25_restaurant where r_owner = (select o_no from oct25_owner where o_birth=(select max(o_birth) from oct25_owner)));
------------------------------------------------------------------------------------------
-- JOIN : 테이블 여러개 엮는다~
--			테이블 여러개를 붙여서 RAM에 잠깐 넣어놓는

select * from oct25_restaurant, oct25_owner;
-- 나올 수 있는 모든 경우의 수가 다 나옴 (테이블이 합쳐짐)
-- 조건식을 이용해서 진짜 맞는 데이터가 나올 수 있도록
select * from oct25_restaurant, oct25_owner where r_owner = o_no;

-- 전체 메뉴명,가격,식당이름,지점명 조회
select m_name, m_price, r_name, r_location from oct25_menu, oct25_restaurant where r_no = m_r_no;

-- 전체 식당이름,지점명,사장님이름,사장님생일 조회
select r_name, r_location, o_name, o_birth from oct25_restaurant, oct25_owner where r_owner = o_no;

--좌석 수가 100석 이상인 식당의 메뉴명, 가격, 식당이름, 지점명, 좌석수 조회
select m_name, m_price, r_name, r_location, r_seat from oct25_restaurant, oct25_menu where r_no = m_r_no and r_seat >= 100;

-- 규모가 제일 큰 식당의 메뉴명, 가격, 식당이름, 지점명, 좌석수 조회
select m_name, m_price, r_name, r_location, r_seat from oct25_restaurant, oct25_menu where r_no = m_r_no and r_seat = (select max(r_seat) from oct25_restaurant); 

-- 최연장자 사장님네 전체 메뉴명, 가격, 식당이름, 지점명, 사장님 이름, 사장님 생일
--을 메뉴명 가나다순 -> 식당이름 가나다순
select m_name, m_price, r_name, r_location, o_name, o_birth from oct25_restaurant, oct25_menu, oct25_owner  where  r_no = m_r_no and r_owner = o_no and o_birth =(select min(o_birth) from oct25_owner)order by m_name, r_name;
-------------------------------------------------------------------------------------------
-- 메뉴가 10000개 이상 들어있다고 가정해봅시다
--	메뉴데이터를 갯수 나눠서 페이지로 보여주고 싶음
--	메뉴테이블에 m_no가 있음(Primary key)
--	Sequence로 처리!
--		단점) sequence는 insert 실패해도 counting이 됨...
--	3번 메뉴 삭제 : PK가 3번인거 삭제 => m_no가 정확하게 1,2,3,...10000가 아님
-------------------------------------------------------------------------------------
--	가상필드(Rownum) **************
--		select 할 때마다 자동으로 부여됨
--		select *<< *와는 함께 사용이 불가능
--		order by보다 먼저 부여
--		무조건 1번부터 조회해야 함!

--	메뉴 이름을 가나다순으로 정렬해서 메뉴의 전체정보를 조회
select rownum, m_no, m_name, m_price, m_r_no from oct25_menu order by m_name;
--	order by 하기 전에 rownum이 먼저 생성

-- 메뉴 이름을 가나다순으로 정렬해서 메뉴의 전체정보를 조회해서 1~3번 데이터 까지만 보고 싶음
-- 이름순으로 정렬된 뒤에 그 후에 번호값(rownum)을 주길 원했음
select rownum, m_no, m_name, m_r_no from(-- 2. 그 후 rownum 부여
--1. 이부분을 테이블 처럼 활용(데이터 먼저 정렬한 후에) : Inline view(인라인 뷰)
select m_no, m_name, m_price, m_r_no from oct25_menu order by m_name)
where rownum >= 1 and rownum <= 3;
-- 메뉴 이름을 가나다순으로 정렬해서 메뉴의 전체정보를 조회해서 5~11번 데이터 까지만 보고 싶음
select rownum, m_no, m_name, m_r_no from(
select m_no, m_name, m_price, m_r_no from oct25_menu order by m_name)
where rownum >= 5 and rownum <= 11; -- 무조건 1번부터 조회해야 하므로 안나옴

-- 가장 바깥에 select문 하나 더 씌워주면 됨!
-- select문을 rownum 겉으로 씌우면서 기존 rownum은 숫자만 부여하고 효력을 잃어버림
-- rownum에 별칭붙이는 걸 필수!!
		select *
		from (
			select rownum rn, m_no, m_name, m_r_no from(
			select m_no, m_name, m_price, m_r_no from oct25_menu order by m_name
		)
	)
where rn >= 5 and rn <= 11;

-- ~길동이라는 이름을 가진 사장님네
--		메뉴명,가격,식당명,지점명,사장님이름
--		가격 내림차순 -> 메뉴명 가나다순 정렬 후
--		3번째 ~ 8번째까지 정보 조회

select *
	from(
		select rownum rn, m_name, m_price, r_name, r_location, o_name  
			from(
				select m_name, m_price, r_name, r_location, o_name
				from  oct25_menu, oct25_restaurant, oct25_owner
				where m_r_no = r_no and r_owner = o_no  
				and o_name like '%길동'
				order by  m_price desc, m_name 
			)
	)
where rn between 3 and 8;

-- 김씨 성을 가진 사장님네 메뉴명, 가격, 사장님 이름 사장님성별
-- 가격 오름차순 정렬 -> 2~3번째 자료만
select*
	from(
		select rownum rn, m_name, m_price, o_name, o_gender
			from(
				select m_name, m_price, o_name, o_gender 
				from oct25_menu, oct25_owner,oct25_restaurant
				where m_r_no = r_no and r_owner = o_no
				and o_name like'김%'
				order by m_price
		)
	)
where rn between 2 and 3;
-------------------------------------------------------------------------------
-- JOIN
--		하나의 명령문에 의해 여러 테이블에 저장된 데이터를 한번에 조회할 수 있는 기능
--		마치 하나의 테이블인 것처럼 보여짐

create table tb1(name varchar2(10 char), age number(3));
create table tb2(name varchar2(10 char), age number(3));

insert into tb1 values('김길동', 30);
insert into tb1 values('박길동', 35);
insert into tb1 values('최길동', 40);
insert into tb1 values('오길동', 40);

insert into tb2 values('김길동', 30);
insert into tb2 values('정길동', 50);
insert into tb2 values('이길동', 55);

select * from tb1;
select * from tb2;
------------------------------------------------------------------------------
-- cross foin : 별도의 조건 없이 두 테이블 간의 가능한 모든 결과르 조회(모든 경우의 수)
--	사실상 안씀
select * from tb1, tb2;
select * from tb1 cross join tb2;

--inner join : 조건에 해당하는 값만 나옴
select * from tb1 inner join tb2 on tb1.name = tb2.name;
select * from tb1 A, tb2 B where A.name = B.name; -- 동등조인(EQUI조인)
select * from tb1 join tb2 using (name);
select * from tb1 natural join tb2;
		-- ㄴ 자연조인(natural join) : 조건절 없이 양 테이블의 같은 이름을 가진 동일한 컬럼만 조회

-- outer join : 기준 테이블의 데이터가 모두 조회(누락 없이) 되고,
--				대상 테이블에 데이터가 있는 경우 해당 컬럼의 값을 가져오기 위해

-- *left outer join : 왼쪽 테이블에 값이 있을 때 오른쪽 테이블이 조건에 맞지 않아도 나옴
--						(조건에 맞지 않는 부분은 null처리)
select * from tb1 left outer join tb2 on tb1.name = tb2.name;
select * from tb1, tb2 where tb1.name = tb2.name(+);
--	right outer join : 오른쪽 테이블에 값이 있을 때 왼쪽 테이블이 조건에 맞지 않아도 나옴
--						(조건에 맞지 않는 부분은 null처리)
select * from tb1 right outer join tb2 on tb1.name = tb2.name;
select * from tb1, tb2 where tb1.name(+) = tb2.name;

--	full outer join : 한쪽 테이블에 값이 있으면, 다른쪽 테이블이 조건에 맞지 않아도 나옴
select * from tb1 full outer join tb2 on tb1.name = tb2.name;

-- self join ** 헷갈림
--	하나의 테이블 안에 있는 컬럼끼리 연결하는 조인이 필요한 경우
--	단어 뜻 그대로 스스로 JOIN한다는 뜻!

-- 한 사이트에 회원이 5명이 있고, 관리자가 2명
-- 회원 이름은 각각 회원1 ~ 회원 5, 관리자 이름은 관리자1 ~ 관리자2
-- 회원 아이디는 각각 member1 ~ member5, 관리자 아이디는 각각 manager1, manager2
-- 회원1 ~ 회원3 까지 관리자1이 관리, 나머지는 관리자2가 관리

-- 테이블 하나 : oct26_member
--	컬럼명 : m_id, m_name, m_manager

create table	oct26_member(
	m_id varchar2(10 char) primary key, 
	m_name varchar2(10 char) not null, 
	m_manager varchar2(10 char) -- 관리자들은 관리를 받지 않으므로 제약조건 X
);
				
insert into oct26_member values('member1','회원1','manager1' );
insert into oct26_member values('member2','회원2','manager1' );
insert into oct26_member values('member3','회원3','manager1' );
insert into oct26_member values('member4','회원4','manager2' );
insert into oct26_member values('member5','회원5','manager2' );

insert into oct26_member values('manager1','관리자1',null );
insert into oct26_member values('manager2','관리자2',null );

select * from oct26_member;
				
-- 각 관리자가 어떤 회원을 관리하는지 알고 싶음
--select * from oct26_member A join oct26_member B on A.m_id = B.m_id;
select A.m_id, A.m_name,B.m_id
	-- 똑같은 table 이지만 self join을 하기 위해 테이블 별로 별칭을 넣어서 구분
	from oct26_member A join oct26_member B 
	-- 계정 ID와 관리자 계정이 같은 값들을 연결해서
	-- 관리하는 회원 ID값을 가져올 수 있도록
	on A.m_id = B.m_manager;
	-- B테이블 m_manager에서 관리자< 라는 이름을 가진 사람
--		= A테이블 m_id에서 관리자< 라는 id를 가진 사람
----------------------------------------------------------------------------
-- 배추, 3000g, 10000원, 홈플러스, 강남점, 1000평, 주차장 500석
-- 무, 500g, 5000원, 홈플러스, 강서점, 500평, 주차장 300석
-- 배추, 2000g, 5000원, 이마트, 서초점, 800평, 주차장 800석
----------------------------------------------------------------------------
drop table oct26_vegetable cascade constraint purge;


create table	oct26_market(
	m_no number(3)primary key,
	m_name varchar2(10 char) not null, 
	m_location varchar2(10 char)not null,
	m_scale number(4) not null,
	m_parking number(4) not null
);

create table	oct26_vegetable(
	v_no number(3) primary key,
	v_name varchar2(10 char) not null, 
	v_weight number(4) not null, 
	v_price number(5)not null,
	v_m_no number(3) not null,
	constraint fk_oct26_vegetable foreign key(v_m_no)
		references oct26_market(m_no)
		on delete cascade
);

create sequence oct26_market_seq;

insert into oct26_market values(oct26_market_seq.nextval,'홈플러스','강남점',1000,500);
insert into oct26_market values(oct26_market_seq.nextval,'홈플러스','강서점',500,300);
insert into oct26_market values(oct26_market_seq.nextval,'이마트','서초점',800,800);

select *from oct26_market;

truncate table oct26_vegetable;

create sequence oct26_vegetable_seq;
drop sequence oct26_vegetable_seq;
insert into oct26_vegetable values(oct26_vegetable_seq.nextval,'배추',3000,10000,1);
insert into oct26_vegetable values(oct26_vegetable_seq.nextval,'무',500,5000,2);
insert into oct26_vegetable values(oct26_vegetable_seq.nextval,'배추',2000,5000,3);

select * from oct26_vegetable order by v_name;

-- create table, drop table, create sequence, drop sequence : DBA

-- CRUD
--		C(create) 	: INSERT
--			SEQUENCE사용, 날짜 집어넣고 값넣고, ...
--		R(Read)		: SELECT
--			거의 대부분의 시간을 할애함
--		U(Update)	: UPDATE
--			값 수정

update 테이블명
	set 컬럼명 = 값; 컬럼명 = 값 , ... -- 바꿀내용
	where 조건;

-- 무를 공짜로
update oct26_vegetable
	set v_price = 5000
	where v_name = '무';
	
-- 배추를 [김장용배추]로 수정

update oct26_vegetable
	set v_name = '김장용배추'
	where v_name = '배추';
	
-- 모든 마트의 주차장 30% 줄이기
update oct26_market
	set m_parking  = m_parking * 7/ 10;
	
	
-- 홈플러스 강서점의 상품 가격 10% 할인
update oct26_vegetable
	set v_price  = v_price * 9/10;
		where v_m_no =(
		select m_no 
		from oct26_market
		where m_name = '홈플러스' and m_location = '강서점'
)
-- 제일 비싼 상품 10% 할인
update oct26_vegetable
	set v_price = v_price * 9/10
	where v_price in ( -- max 가격이 하나 이상일 수 있음으로 = 보단 in 채용
	select max(v_price) from oct26_vegetable
	)
----------------------------------------------------------
-- CRUD
--		D(delete) : DELETE	

DELETE FROM 테이블명 WHERE 조건;

-- '무' 삭제
delete from oct26_vegetable where p_name ='무';

-- 가장 좁은 매장의 상품 다 삭제
delete from oct26_vegetable 
		where v_m_no in (
			select m_no 
			from oct26_market 
			where m_scale =
			(
		select min(scale)
		from oct23_market
	)
)


select *from oct26_vegetable;
select *from oct26_market;
-----------------------------------------------------------------------------
-- 1. OracleDB 서버에 다음 데이터를 표현할 수 있는 DB자료구조를 만드는 SQL문을 작성하세요

-- 컴퓨터 이름 : 컴퓨터1
-- 운영체제 : Windows 10 pro
-- 포맷날짜 : 2023-10-26
-- 무게 : 5.12kg
-- cpu : i5-1234

-- 컴퓨터 이름 : 컴퓨터2
-- 운영체제 : Windows 11 pro
-- 포맷날짜 : 2023-09-06
-- 무게 : 5.23kg
-- cpu : i7-5678
drop table oct26_computer cascade constraint purge;

create table oct26_computer(
	c_no number(3) primary key,
	c_name varchar2(10 char) not null, 
	c_os varchar2(20 char) not null,
	c_format date not null,
	c_weight number(3,2) not null,
	c_cpu varchar2(10 char) not null
);

create sequence oct26_computer_seq;

insert into oct26_computer values(oct26_computer_seq.nextval,'컴퓨터1','Windows 10 pro', to_date('2023-10-26','YYYY-MM-DD'),5.12,'i5-1234');
insert into oct26_computer values(oct26_computer_seq.nextval,'컴퓨터2','Windows 11 pro', to_date('2023-09-06','YYYY-MM-DD'),5.23,'i7-5678');


-- 2. 1번에서 만든 테이블에 다음 데이터를 추가하는 sql문을 작성해주세요(1번보기 데이터도 추가)

-- 컴퓨터 이름 : 컴퓨터3
-- 운영체제 : Windows 10 pro
-- 포맷날짜 : 2023-07-11
-- 무게 : 3.22kg
-- cpu : i7-1234
insert into oct26_computer values(oct26_computer_seq.nextval,'컴퓨터3','Windows 10 pro', to_date('2023-07-11','YYYY-MM-DD'),3.22,'i7-1234');

select * from oct26_computer;
-- 3. 1번에서 만든 테이블에서 포맷한지 가장 오래된 컴퓨터의 날짜와 총 컴퓨터 수를 조회하는 SQL문을 작성해주세요

select min(c_format), count(*) from oct26_computer;
-- 4. 1번에서 만든 테이블에서, 가장 최근에 포맷한 컴퓨터의 이름을 조회하는 SQL문을 작성해주세요
select c_name from oct26_computer where c_format =(select max(c_format)from oct26_computer);
-- 5. 1번에서 만든 테이블에서 2번째로 가벼운 컴퓨터~3번째로 가벼운 컴퓨터의 전체 정보를 조회하는 SQL문을 만들어주세요
select * 
	from (
		select rownum rn, c_name, c_os, c_format, c_weight, c_cpu 
			from (select * 
			from oct26_computer  order by c_weight
		)
	)
where rn between 2 and 3;

