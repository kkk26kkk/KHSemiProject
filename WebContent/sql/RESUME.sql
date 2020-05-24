drop table resume;
create table resume(
	GID 		VARCHAR2(300),	-- �Ϲ�ȸ��ID
	SN			NUMBER,			-- �Ϸù�ȣ
	SUBJECT		VARCHAR2(100),	-- ����
	NAME		VARCHAR2(300),	-- �̸�
	BIRTH		VARCHAR2(300),	-- �������
	GENDER		VARCHAR2(300),	-- ����
	EMAIL		VARCHAR2(300),	-- �̸���
	PHONE		VARCHAR2(300),	-- �޴�����ȣ
	ADDR		VARCHAR2(300),	-- �ּ�
	PHOTO		VARCHAR2(300),	-- ����
	STYPE		VARCHAR2(300),	-- �з�(�б�����)
	SNAME		VARCHAR2(300),  -- �з�(�б���)
	SDOA		VARCHAR2(300),	-- �з�(���г��)
	SDOG		VARCHAR2(300),	-- �з�(�������)
	MAJOR		VARCHAR2(300),	-- �з�(����)
	GRADE		VARCHAR2(20),	-- �з�(����)
	ENAME		VARCHAR2(300),	-- ���(ȸ���)
	DEPT		VARCHAR2(300),	-- ���(�μ���)
	DOA			VARCHAR2(300),	-- ���(�Ի���)
	DOG			VARCHAR2(300),	-- ���(�����)
	RANK		VARCHAR2(300),	-- ���(����)
	CERTNAME	VARCHAR2(300),	-- �ڰ���(�ڰ�����)
	PUBLISHER	VARCHAR2(300),	-- �ڰ���(����ó)
	CACDATE		VARCHAR2(300),	-- �ڰ���(�����)
	LANNAME		VARCHAR2(300),	-- ����(���ν����)
	RATING		VARCHAR2(300),	-- ����(�޼�/����)
	LACDATE		VARCHAR2(300),	-- ����(�����)
	PRSUBJECT	VARCHAR2(300),	-- �ڱ�Ұ���(����)
	PRCONTENT	VARCHAR2(300),	-- �ڱ�Ұ���(����)
	JTYPE		VARCHAR2(300),	-- ����ٹ�����(�������)
	DESSAL		VARCHAR2(300),	-- ����ٹ�����(�������)
	REGION		VARCHAR2(300),	-- ����ٹ�����(�ٹ�����)
	DUTY		VARCHAR2(300),	-- ����ٹ�����(����)
	INDUSTRY	VARCHAR2(300),	-- ����ٹ�����(���)
	RGS_DTM		DATE,			-- ����Ͻ�
	UPT_DTM		DATE,			-- �����Ͻ�
	primary key(gid, sn)
);

select * from resume;

update resume set subject='������ �ϰڽ��ϴ�.' where gid='kkk26kkk' and sn=1;

delete from resume;

select * 
from resume 
where gid='bbb' and sn=1;

select a.*, b.DCODE, c.ICODE, d.RCODE
from RESUME a 
inner join DUTY_CODE b 
on b.SN = a.DUTY 
inner join INDUSTRY_CODE c 
on c.SN = a.INDUSTRY 
inner join REGION_CODE d
on d.SN = a.REGION
where a.gid = 'bbb' and a.sn = 1;
