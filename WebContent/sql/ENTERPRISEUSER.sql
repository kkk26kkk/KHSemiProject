drop table enterpriseuser;
create table ENTERPRISEUSER(
EID VARCHAR2(20),		-- ���ȸ��ID
ENAME VARCHAR2(60),		-- ���(ȸ��)��
ENUM VARCHAR2(15),		-- ����ڹ�ȣ
EADDR VARCHAR2(200),	-- ȸ���ּ�
EADDR1 VARCHAR2(200),	-- ȸ���ּ�(���θ��ּ�)
EADDR2 VARCHAR2(200),	-- ȸ���ּ�(���ּ�)
OWNERNAME VARCHAR2(20),	-- ��ǥ�ڸ�
RGS_DTM DATE,			-- ����Ͻ�
UPT_DTM DATE,			-- �����Ͻ�
PRIMARY KEY(EID)
);

select * from enterpriseuser;