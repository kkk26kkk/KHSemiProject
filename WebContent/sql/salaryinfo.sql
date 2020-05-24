drop table salary;
create table salary(
GID varchar2(50), 
SN number(20),
ENAME varchar2(50),
CF varchar2(50),
DUTY varchar2(50),
INDUSTRY varchar2(50),
JTYPE varchar2(50),
RANK varchar2(50),
CAREER varchar2(50),
REGION varchar2(50),
SAL number,
INCENTIVE number,
RGS_DTM DATE,
UPT_DTM DATE,
primary key(GID, SN)
);

select*from salary;
