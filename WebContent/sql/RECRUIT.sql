drop table recruit;
create table RECRUIT(
EID VARCHAR2(20),		-- ���ȸ��ID
SN NUMBER,				-- �Ϸù�ȣ
SUBJECT VARCHAR2(300),	-- ����
ENAME VARCHAR2(60),		-- ȸ���
CAREER VARCHAR2(4000),	-- ���
EDU VARCHAR2(100),		-- �з�
JTYPE VARCHAR2(50),		-- �������
DUTY VARCHAR2(50),		-- ����
INDUSTRY VARCHAR2(50),	-- ���
ENUM VARCHAR2(30),		-- �����
DOE VARCHAR2(50),		-- �����⵵
ETYPE VARCHAR2(20),		-- �������
PAGEADDR VARCHAR2(300),	-- Ȩ������
REVENUE VARCHAR2(50),	-- �����
KIND VARCHAR2(80),		-- �����о�
PAY VARCHAR2(50),		-- �޿�
JOB VARCHAR2(500),		-- ������
ELIGI VARCHAR2(500),	-- �ڰݿ��
RECNUM VARCHAR2(20),	-- �����ο�
WTYPE VARCHAR2(500),	-- �ٹ�����
REGION VARCHAR2(200),	-- ����
STARTDATE VARCHAR2(50),	-- ������
ENDDATE VARCHAR2(50),	-- ������
NOTICE VARCHAR2(2000),	-- ���ǻ���
EADDR VARCHAR2(200),	-- ȸ���ּ�
EADDR1 VARCHAR2(200),	-- ȸ���ּ�(���θ��ּ�)
EADDR2 VARCHAR2(200),	-- ȸ���ּ�(���ּ�)
WDAY VARCHAR2(200),		-- �ٹ�����
WTIME VARCHAR2(200),	-- �ٹ��ð�
LOGO VARCHAR2(100),		-- ȸ��ΰ�
RGS_DTM DATE,			-- ����Ͻ�
UPT_DTM DATE,			-- �����Ͻ�
PRIMARY KEY(EID, SN)
);

delete from recruit where eid='bae9176';

select * from recruit;

select * from recruit where eid='ccc';

select * from recruit where 1=1 and EDU='1';

select a.*, b.DCODE, c.ICODE, d.RCODE 
from RECRUIT a 
inner join DUTY_CODE b 
on b.SN = a.DUTY
inner join INDUSTRY_CODE c 
on c.SN = a.INDUSTRY 
inner join REGION_CODE d 
on d.SN = a.REGION 
where a.EID = 'bbb' and a.SN = 1;