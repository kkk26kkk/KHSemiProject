drop table ENTERPRISEINFO;
create table ENTERPRISEINFO(
EID VARCHAR2(20),		-- ���ȸ��ID
ENAME VARCHAR2(60),		-- ���(ȸ��)��
OWNERNAME VARCHAR2(20),	-- ��ǥ�ڸ�
DOE VARCHAR2(30),		-- �����⵵
ETYPE VARCHAR2(30),		-- �������
DUTY VARCHAR2(50),		-- ����
INDUSTRY VARCHAR2(50),	-- ���
ENUM VARCHAR2(30),		-- �����
EADDR VARCHAR2(200),	-- ȸ���ּ�
EADDR1 VARCHAR2(200),	-- ȸ���ּ�(���θ��ּ�)
EADDR2 VARCHAR2(200),	-- ȸ���ּ�(���ּ�)
PAGEADDR VARCHAR2(300),	-- Ȩ������
REVENUE VARCHAR2(100),	-- �����
LOGO VARCHAR2(300),		-- ȸ��ΰ�
RGS_DTM DATE,			-- ����Ͻ�
UPT_DTM DATE,			-- �����Ͻ�
PRIMARY KEY(EID)
);

select * from enterpriseinfo;

delete from enterpriseinfo where eid='bae9176';