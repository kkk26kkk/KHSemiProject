drop table enterprisehrd;
create table ENTERPRISEHRD(
EID VARCHAR2(20),		-- ���ȸ��ID
SN NUMBER,				-- �Ϸù�ȣ
PW VARCHAR2(20),		-- ��й�ȣ
HRDNAME VARCHAR2(20),	-- ����ڸ�
PHONE VARCHAR2(20),		-- �޴�����ȣ
EMAIL VARCHAR2(50),		-- �̸���
RGS_DTM DATE,			-- ����Ͻ�
UPT_DTM DATE,			-- �����Ͻ�
PRIMARY KEY(EID, SN)
);

select * from enterprisehrd;
select eid, pw from enterprisehrd where eid='staryoman1';

delete from enterprisehrd where eid='bae9176';

update enterprisehrd set hrdname='������' where eid='kkk26kkk' and sn=2;

select max(rownum) from enterpriseuser where ename='�Ｚ';