-- table 생성하기 : seoul_air
--	필드명 : 층정일시, 측정소명, 미세먼지, 초미세먼지, 오존, 통합대기환경등급

drop table seoul_air cascade constraint purge;

create table seoul_air(
sa_no number(5) primary key,
	sa_MSRDT date not null,
	sa_MSRDT_NM varchar2(10 char)not null,
	sa_PM10 number(3)not null,
	sa_PM25 number(3) not null,
	sa_O3 number(5,4) not null,
	sa_IDEX_NM varchar2(10 char) not null
)
create sequence seoul_air_seq;
-- table 생성했으면 : 확인용 값 넣기
insert into seoul_air values(seoul_air_seq.nextval, sysdate,'은평구',49,27,0.043,'보통');
-- table 값 들어간거 확인
select * from seoul_air;
-- 확인용 값 넣은거 지우기
truncate table seoul_air;
delete from seoul_air where sa_MSRDT_NM ='은평구';

select * from seoul_air order by sa_MSRDT 
