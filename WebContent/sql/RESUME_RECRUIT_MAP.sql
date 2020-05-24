drop table RES_REC_MAP;
create table RES_REC_MAP(
GID VARCHAR2(50),	-- 일반회원ID
GID_SN NUMBER,		-- 일반회원ID_일련번호
EID VARCHAR2(50),	-- 기업회원ID
EID_SN NUMBER		-- 기업회원ID_일련번호
);

select * from RES_REC_MAP;

select b.* 
from RES_REC_MAP a 
inner join RESUME b 
on a.GID = b.GID 
and a.GID_SN = b.SN 
where a.EID = 'kkk26kkk' and a.EID_SN = 1;
