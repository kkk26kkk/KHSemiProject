drop table review;
create table review(
GID varchar2(50), 
SN number,
ENAME varchar2(50),
CF varchar2(50),
DUTY varchar2(50),
INDUSTRY varchar2(50),
JTYPE varchar2(50),
CAREER varchar2(50),
REGION varchar2(50),
THINK varchar2(500),
ADV varchar2(500),
DADV varchar2(500),
POINT number,
STORY varchar2(500),
RGS_DTM DATE,
UPT_DTM DATE,
primary key(gid, sn)
);

select*from review;

select point from review where ename='DF'