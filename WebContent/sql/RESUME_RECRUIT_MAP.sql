drop table RES_REC_MAP;
create table RES_REC_MAP(
GID VARCHAR2(50),	-- �Ϲ�ȸ��ID
GID_SN NUMBER,		-- �Ϲ�ȸ��ID_�Ϸù�ȣ
EID VARCHAR2(50),	-- ���ȸ��ID
EID_SN NUMBER		-- ���ȸ��ID_�Ϸù�ȣ
);

select * from RES_REC_MAP;

select b.* 
from RES_REC_MAP a 
inner join RESUME b 
on a.GID = b.GID 
and a.GID_SN = b.SN 
where a.EID = 'kkk26kkk' and a.EID_SN = 1;
