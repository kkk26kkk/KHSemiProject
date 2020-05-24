drop table enterprisehrd;
create table ENTERPRISEHRD(
EID VARCHAR2(20),		-- 기업회원ID
SN NUMBER,				-- 일련번호
PW VARCHAR2(20),		-- 비밀번호
HRDNAME VARCHAR2(20),	-- 담당자명
PHONE VARCHAR2(20),		-- 휴대폰번호
EMAIL VARCHAR2(50),		-- 이메일
RGS_DTM DATE,			-- 등록일시
UPT_DTM DATE,			-- 수정일시
PRIMARY KEY(EID, SN)
);

select * from enterprisehrd;
select eid, pw from enterprisehrd where eid='staryoman1';

delete from enterprisehrd where eid='bae9176';

update enterprisehrd set hrdname='박주형' where eid='kkk26kkk' and sn=2;

select max(rownum) from enterpriseuser where ename='삼성';