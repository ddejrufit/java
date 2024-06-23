select * from OCT23_SNACK;
--s_no, s_name, s_maker, s_price, s_exp

-- (s_maker의 회사정보)
-- table명 : oct24_maker
-- 필드명 : m_name, m_address, m_employee
-- sequence가 필요한지, 필요하다면 뭐라고 써야할지

drop table oct24_maker cascade constraint purge;

create table oct24_maker(
	m_name varchar2(10 char)primary key,
	m_address varchar2(10 char)not null,
	m_employee varchar2(3)not null
);
-- 내가 과자 테이블에서 어떤 회사 입력했는지 확인
select s_maker from oct23_snack;

insert into oct24_maker values('대우전자','서울',250);
insert into oct24_maker values('삼성','인천',850);
insert into oct24_maker values('애플','광주',680);
insert into oct24_maker values('오리온','부산',374);

select * from oct24_maker;
-- 직원 수 제일 적은 회사에서 만드는 과자 이름,가격
select min(m_employee) from oct24_maker;

select s_name, s_price from oct23_snack where s_maker = (select min(m_employee) from oct24_maker); -- x

-- oct23_snack테이블의 s_maker = oct24_maker테이블의 m_name
-- 직원수가 가장 적은 회사 이름 조회
select m_name from oct24_maker where m_employee =(select min(m_employee) from oct24_maker);

-- 직원 수가 가장 적은 회사가 파는 과자의 이름,가격 조회
select s_name, s_price, s_maker from oct23_snack where s_maker in (select m_name from oct24_maker where m_employee = (select min(m_employee) from oct24_maker));

-- ** 다중 서브쿼리 : 결과값이 여러개 나올 수 있음! 등호(=) 대신 in 사용!

-- 제일 비싼 과자를 만드는 회사는 어디에 있는지 조회
select m_address from oct24_maker where m_name in(select s_maker from OCT23_SNACK where s_price = (select max(s_price)from oct23_snack));
-- 광주에 있는 회사에서 만드는 과자 평균가
select avg(s_price)from oct23_snack where s_maker in(select m_name from oct24_maker where m_address ='광주');
-- 평균가 이상의 과자를 만드는 회사이름, 위치
select m_name, m_address from oct24_maker where m_name in(select s_maker from oct23_snack where s_price >= (select avg(s_price) from oct23_snack));
---------------------------------------------------------------------------------------------------------------
select [distinct] [컬럼명], [컬럼명 as 별명 || 컬럼명 별명], [연산자], [통계함수],...
from [테이블명]
where [조건식]
group by [그룹대상]
having [함수 포함 조건]
order by [정렬대상 asc/desc]
----------------------------------------------------------------------------------------------------------------
-- 산술연산자
--		Dual테이블
--			1. Oracle 자체에서 제공해주는 더미테이블(테스트용)
--			2. 간단하게 함수 이용해서 계산한 결과값을 확인할 때 주로 사용

select 2 + 5 from dual;
select 1 + '4' from dual;
-- 대부분의 언어들은 [문자우선] -> 14
-- 오라클 반대로 [숫자우선] -> 5
--		cf) 오라클 내에서는 연산자가 숫자[만] 연산 해줌!
select 1 + 'a' from dual; -- ORA-01722: invalid number >> 숫자로 못바꾼다~!

-- 문자도 더해주는 연산자: ||
select 1 || 'a' from dual;
----------------------------------------------------------------------------------------------------------------
-- 날짜/ 시간 함수
-- YYYY : 4자리 연도
-- YYY, YY, Y : 각각 4자리 연도의 마지막 3자리, 2자리, 1자리
-- MM : 월
-- DD : 일
-- DAY : 요일( 월요일 ~ 일요일 )
-- DY : 요일( 월 ~ 일 )
-- HH, HH12 : 12시간제 / AM or PM : 오전 or 오후
-- HH24 : 24시간제
-- MI : 분
-- SS : 초
-- sysdate : 현재날짜 , 시간 변환

-- to_date(문자열, 패턴) : 문자형 데이터를 날짜형으로 반환
select to_date('2023-10-24 오후 03:03:03','YYYY-MM-DD PM HH:MI:SS')
	from dual;
	
-- to_char(date, 패턴) : 날짜형 데이터를 문자형으로 반환
select to_char(sysdate,'YYYY.MM.DD') as now from dual;

-- 특정 날짜 값 받아오고 싶으면?
select to_char(to_date('2023-10-23','YYYY-MM-DD'),
	'YYYY.MM.DD') as yesterday from dual;
	
-- 오늘날짜 기준 연도 조회(컬럼명 : 연도 / 컬럼(데이터) : 2023년 이라고 나오게)
	select to_char(sysdate, 'YYYY') || '년' 연도 from dual;
	
-- 오늘날짜 기준 월, 일 조회(컬럼명 : 월,일 / 컬럼 : 10월, 24일)
select to_char(sysdate,'MM') ||'월' 월 to_char(sysdate, 'DD') || '일' 일 from dual;
-- 현재시간 기준 시, 분 조회(컬럼명 : 시,분 / 컬럼 : 15시, 10분)
	select to_char(sysdate, 'HH24') || '시' 시 to_char(sysdate, 'MI') || '분' 분 from dual;
	
-- 지금이 오전인지 오후인지 조회 (컬럼명 : 오전/오후)
-- 	벌명에 띄어쓰기, 특수문자가 들어가는 경우 : 별명부분을 큰따옴표로
select to_char(sysdate, 'AM') "오전/오후" from dual;
----------------------------------------------------------
-- ** NULL 관련 함수
--		보통 제약 조건에 NOT NULL로 설정해서 무조건 데이터 입력하게 해놨음!
--		NULL : 확인되지 않은 값이나 아직 적용되지 않은 값 / 0이나 공란은 아님!!

-- NVL 함수 : NULL 인 경우에 지정한 값으로 대치하는 함수
-- NVL(값,NULL일 때 대치값)
select NVL(NULL,'-')from 테이블명;

--NVL2 함수 : NULL의 여부에 따라 지정한 값으로 대치하는 함수
-- NVL2(값, 값이 있을 때 대치값, NULL일 때 대치값)
select NVL2(NULL,'A','B') from 테이블명;


-- Foreign key(외래키)
-- 		다른 테이블의 특정 컬럼을 조회해서
--		동일한 데이터가 있는 경우에만 적용이 허용
--		참조하는 테이블(FK가 존재하는 테이블)은 PK,Unique로 지정된 컬럼만 FK로 지정이 가능하다
--		외래키 설정을 위해서는 참조 받는 테이블이 먼저 생성되어야만 하고
--		외래키를 심을(참조하는 테이블)이 그 이후에 생성 되어야 함!
--		** 주의사항 : 외래키 이름은 중복될 수 없음!

-- 외래키를 참조하는 테이블 형식
create table 테이블명(
	컬럼명 자료형 옵션, -- 쉼표 빼먹지 않기!!
	constraint FK명 foreign key(컬럼명)
	references 대상테이블명(대상테이블의 기본키(or고유키) 컬럼명)
	on delete cascade || on delete set null
	-- 참조 받는 table에서 해당 행이 지워졌을 때
	-- 같이 지울지, null값을 먹일지 둘중 하나만 쓰기
);

create table example1(
	ex1_id varchar2(10 char) primary key
);

insert into example1 values('10');
insert into example1 values('20');
insert into example1 values('30');

select * from example1;

-- 외래키를 참조 하는 테이블
create table example2(
	ex2_id varchar2(10 char) primary key,
	constraint fk_ex2 foreign key(ex2_id)
		references example1(ex1_id)
			on delete cascade
);

insert into example2 values('10');
insert into example2 values('20');
insert into example2 values('30');
insert into example2 values('40'); -- 안들어가짐(example1에는 '40' 값이 없음)

select * from example2;

--ex1_id가 '10'인 칼럼을 지우면 어떻게 될까?
delete from 테이블명 where 조건;
delete from example1 where ex1_id ='10';
----------------------------------------------------------------------
-- 학과 테이블과 이 테이블을 참조하는 학생테이블

-- 학과테이블 : oct24_major
--			m_code(학과코드-4자리 숫자), m_name(학과이름-10글자 이내)
create table oct24_major(
	m_code number(4)primary key,
	m_name varchar2(10 char) not null
);
drop table oct24_major cascade constraint purge;
insert into oct24_major values(1001,'컴퓨터공학과');
insert into oct24_major values(2001,'경영학과');
insert into oct24_major values(3001,'법학과');
insert into oct24_major values(4001,'정보통신학과');
insert into oct24_major values(5001,'경찰행정학과');

-- 학과테이블 값
--		1001 컴퓨터공학과
--		2001 경영학과
--		3001 법학과
--		4001 정보통신과
--		5001 경찰행정학과

-- 학과테이블 값 확인
select * from oct24_major;

-- 학생테이블 : oct24_student
--		s_no(3자리 숫자), s_name(학생이름), s_code(학생이 소속된 학과 코드)
--		학과가 없어지면 해당하는 학과의 학생정보도 함께 지워지게
drop table oct24_student cascade constraint purge;

create table oct24_student(
	s_no number(3)primary key,
	s_name varchar2(10 char)not null,
	s_code number(4)not null,
	constraint fk_student foreign key(s_code)
	references oct24_major(m_code)
	on delete cascade
);
-- 학생 데이터 5개 정도 넣고
insert into oct24_student values(001,'홍길동',1001);
insert into oct24_student values(002,'김길동',2001);
insert into oct24_student values(003,'이길동',3001);
insert into oct24_student values(004,'박길동',4001);
insert into oct24_student values(005,'나길동',5001); -- 업ㄱ는 학과 등록 x


-- 학생테이블 데이터 확인
select * from oct24_student;

-- 학과코드(M_CODE)가 2001인 학과가 없어진다면? - 해당 학과에 소속된 학생들도 함께 사라짐
DELETE FROM OCT24_MAjor where m_code = 2001;
----------------------------------------------------------
-- 웹사이트에서 게시판에 대한 테이블과 이를 [참조하는] 게시판 댓글 테이블을 만들려고 함
-- 게시판 테이블 (oct24_board) : 작성자, 게시판 글내용, 작성시간

-- 테이블 구조 파악해서 게시판 테이블 만들기
-- PK를 어디에?
-- 작성자 PK? : 한 사람이 게시글 한 번만 쓸거라는 보장 X
-- 내용 PK? : 글이 똑같을 수도... X
-- 작성시간 PK? : 정말로 만에하나 같은 시간에 작성할 수도 -> x

drop table oct24_board cascade constraint purge;

create table oct24_board(
	b_no number(3) primary key,
	b_owner varchar2(10 char) not null,
	b_txt varchar2(10 char) not null,
	b_when date not null
);

create sequence oct24_board_seq;

select * from oct

-- 댓글 테이블 (oct24_board_reply) : 작성자, 댓글 내용, 작성시간
-- 조건) 참조 받는 테이블의 글 내용이 삭제되면 관련 댓글도 삭제가 되도록
drop table oct24_board_reply cascade constraint purge;

create table oct24_board_reply(
	br_no number(3) primary key,
	br_b_no number(3) not null,
	br_owner varchar2(10 char) not null,
	br_txt varchar2(10 char) not null,
	br_when date not null,
	constraint fk_oct24board_reply foreign key(br_b_no)
		references oct24_board(b_no)
		on delete cascade
);
	
create sequence oct24_board_reply_seq;

drop sequence oct24_board_reply_seq;
drop sequence oct24_board_seq;
-- 굴내용 짧게 해서 게시판테이블에 값 2개 넣고, 각 게시글 마다 댓글 2개씩 달기!
insert into oct24_board values(oct24_board_seq.nextval,'홀길동','하잉!',sysdate);
insert into oct24_board values(oct24_board_seq.nextval,'hong','안녕!',sysdate);

select * from oct24_board;

insert into oct24_board_reply values(oct24_board_reply_seq.nextval,2,'김','으악!',sysdate);

insert into oct24_board_reply values(oct24_board_reply_seq.nextval,1,'이','악으!',sysdate);

insert into oct24_board_reply values(oct24_board_reply_seq.nextval,1,'박','하이!',sysdate);

insert into oct24_board_reply values(oct24_board_reply_seq.nextval,2,'나','하하!',sysdate);

select * from oct24_board_reply;
-- 게시글 둘 중 하나 지웠을 때 댓글도 지워지는지 확인
delete from oct24_board where b_no = 1;