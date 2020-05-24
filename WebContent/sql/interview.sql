
drop table interview;
create table interview(
GID varchar2(50),
SN  number,
ENAME varchar2(50),
DUTY varchar2(50),
INDUSTRY varchar2(50),
JTYPE varchar2(50),
CAREER varchar2(50),
REGION varchar2(50),
EXP varchar2(500),
PROC varchar2(500),
QUE varchar2(500),
ANS varchar2(500),
DIFF varchar2(500),
INTDATE varchar2(50),
RGS_DTM DATE,
UPT_DTM DATE,
primary key(GID, SN)
);



update interview set ename='SAMSUNG2' where gid='alsgh726' and sn=3
select*from interview;


select * from 
(select rownum rnum, GID, SN, ENAME, DUTY, DIFF, RGS_DTM from interview  order by rnum ) 
where rnum>=1 and rnum<=13 and gid='alsgh726'