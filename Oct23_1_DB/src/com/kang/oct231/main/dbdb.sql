-- 주석
-- DBA(데이터베이스관리자)의 기능은 불가능 (DBA(데이터베이스개발자)쪽 기능만 가능)
-- java : ctrl + f11 실행 -> 주석 제외 모든 코드가 다 실행!!
-- sql 연습장 : 원하는 명령어 코드만 골라서 실행

--SQL
--		Structured Query Language
--		관계형 데이터베이스 관리 시스템(DBMS)의 데이터를 관리하기 위해 설계된
--		특수 목적의 프로그래밍 언어

-- 왜 sql을 쓰나요?
--		데이터를 저장할 때 일반적으로 사용하는 .hwp, .txt,... 과 같은 문서보다
--		server라는 공간에 저장함으로 보안성이 훨씬 높아짐
--		+ 보안성 측면에서 개발자가 아닌 다른 사람들은 쉽게 접근할 수 없다
------------------------------------------------------------------------
--sql 문법 : DDL,DML,DCL
--DDL(Data Definition Language)
--		데이터 정의어 : create,drop,alter,truncate,...
--		테이블과 인덱스 구조를 관리

--DML (Data Manipulation Language)
--		데이터 조작어 : CRUD(insert,select,update,delete)
--		데이터를 생성,수정,삭제,검색, ...

--DCL(Data Control Language)
--		데이터 제어어 -grant,revoke,commit,rollback
--		데이터에 대한 접근을 제한하기 위한 데이터베이스 언어
------------------------------------------------------------------------
-- ** 용어 정리
--		테이블(표)
--		행(row),레코드(record)
--		열(column),필드(field),속성(attribute)
------------------------------------------------------------------------
-- 사실상 한줄이지만 가독성 때문에 줄을 바꿔놨음
--	여러줄 실행 : 마우스로 다 덮어서 -> alt + x
create table coffe(
	name char,
	price number
);
-- 한줄 실행 : 해당하는 줄 아무데나 놓고 alt + s   
select * from coffee;

drop table coffee cascade constraint purge;
------------------------------------------------------------------------
-- SQL이라는 언어로 DB를 제어
--		DB메이커가 달라도 SQL은 거의 비슷
--		대/소문자 구분 안함(공식적으로는 대문자만 사용)
--		cat/Age 같은 낙타체가 안톤함!! -> cat_age(sql언어 사용할땐 무조건 뱀체만!!)
--		하지만 데이터는 대/소문자 구분함!!
--		java : 창의성, 절대적 분량 많음
--		sql : 정해진대로,CRUD만
------------------------------------------------------------------------
-- 테이블만들기
-- java : int age;
-- sql : age int;
create table[테이블명](
	필드명 자료형(숫자) 옵션,
	필드명 자료형,
	필드명 자료형,
	...
	필드명 자료형
);
------------------------------------------------------------------------
create table oct23_coffee(
	c_name varchar2(10 char),
	c_price number(5),
	c_kcal number(6,3),
	c_start date
);
-- 덮어서 alt + x

select * from oct23_coffee;

drop table oct23_coffee cascade constraint purge;
-- 자료형(Oracle DB)
--		글자
--			char(숫자)
--				무조건 괄호 안의 숫자의 용량으로 저장 (용량이 다 채워지지 않으면 띄어 쓰기로 채움)
--				varchar2 보다 일을 덜 하기 때문에 빠름
--				글자수가 정해져있다면 char 활용 ex) 성별, 주민번호,...
--			varchar2(숫자 char)
--				정해진 용량만큼 데이터를 넣지 않으면 
--				알아서 용량 조절해서 저장 << 주력으로 사용할 수 밖에 없음
--				느리다는 단점이 있지만 사람이 체감하기는 힘들다
--		숫자
--			number(용량)
--			number(5) -> 정수 다섯자리까지 (0 ~ 99999 까지 가능)
--			number(6,3) -> 실수 (총 여섯개 글자, 콤마 뒤가 소수점 자릿수)
--						-> 123.456, 12.123
--		날짜
--			date
--		옵션
--			기본적으로 어떤 필드에 값 안넣는 것이 가능 -> 비추임, 별로임
--			제약조건(Constraint)
--				데이터 무결성을 보장하기 위한 용도로 사용
--				데이터 무결성 : DB에 저장되ㅐㄴ 데이터의 일관성과 정확성을 지키는 것
--					도메인 무결성(Domain Constraint)
--						데이터타입(type), null(null, notnull), default, check 등을 지정하여 사용할 수 있음 

--					개체 무결성 
--					참조 무결성
--			1.not null : 반드시 값을 넣게(Null을 허용하지 않는다) ** 가장 많이 사용
--				도메인 무결성
--		★제약조건 명을 따로 부여하지 않음(Oracle이 자동으로 부여)
create table ex1(
	col1 varchar2(10 char)not null
);
--		제약조건명을 부여하고 싶다(제약조건명 : col1_notnull)
create table ex2(
	col1 varchar2(10 char) contratint col1_notnull not null
);

--			2. UNIQUE : 해당 열에 들어가는 값이 테이블 전체에서 유일해야 한다는 의미
--				ㄴNOT NULL과 함께 사용 가능은 하나 UNIQUE 자체가 많이 사용되지는 않음!
create table ex3(
	col1 varchar2(10 char) unique,
	col2 varchar2(10 char) unique not null, /*NOT NULL과 함께 부여*/
	col3 varchar2(10 char) constraint col3_unique unique(col3)
);

--			3. PRIMARY KEY(기본키) : NULL을 허용하지 않고 중복된 데이터가 없도록
--				primary key = not null + unique
--				데이터의 특정 조건 검색이나 수정 등의 작업에 필요한 기본키 구분
--				★1개의 테이블에는 1개의 기본키가 필수적으로 있는 것이 일반적!
--				primary key가 테이블에 없으면 안되고, 두개부터는 비추
create table ex4(
	col1 varchar2(10 char) primary key,
	col2 number(4) not null
);
/*여러 컬럼을 묶을 땐 constraint 키워드 사용 + BUT!! primaty key는 하나였으면*/
-- 하나의 테이블에 primary key 두개는 비추 -> 두개 묶어서 primary key 하나로 만들 때
create table ex5(
	col1 varchar2(10 char),
	col2 number(3),
	constaraint pk_ex5 primary key(col1,col2)
);
-------------------------------------------------------------------
-- ★★★★★진짜 어려움!! << 오늘은 일단 필기하고 넘어갔으면!!/ PK/NN에 집중!!
--			4.★ FOREIGN KEY(외래키)
--				다른 테이블의 특정 컬럼을 조회해서 동일한 데이터가 있는 경우에 입력이 허용
--				참조하는 테이블은 primary key로 지정된 컬럼만을 foreign key로
--				지정할수 있다
--				외래키 설정을 위해서는 참조받는 컬럼이 먼저 생성되어야 하고
--				외래키를 심은 테이블이 이후에 생성되어야 한다

-- 외래키를 심을(참조 하는) 테이블 형식
create table 테이블명(
	컬럼명 자료형 옵션,
	contraint pk명 foreign key(컬럼명)
		references 대상 테이블명(대상테이블의기본키 컬럼명)
		on delete set null || on delete cascade
		-- 참조 받는 테이블을 지웠을 때
		-- 이 테이블에 대해서 NULL값을 먹일지
		--	아니면 같이 지울지 에 대한 옵션
);
---------------------------------------------------------------
-- 커피 테이블
create table oct23_coffee(
	c_name varchar2(10 char) primary key,
	c_price number(5) not null,
	c_kcal number(5,2) not null,
	c_start date not null
);
-- * 만약에 내가 생각한 스키마 중에서 primary key를 줄만한 컬럼이 없을땐?
--		자동으로 번호를 줘서 pk를 먹이는 것도 방법!!
--		>> autoincrement<< oracle엔 없음~!!
insert into 테이블명 values(값, 값, ... 값);
insert into oct23_coffee values('아메리카노', 2500, 10.7, sysdate);
insert into oct23_coffee values('카페라떼', 3200, 12.7, sysdate);

--테이블 속 값 (data)확인
select * from oct23_coffee;