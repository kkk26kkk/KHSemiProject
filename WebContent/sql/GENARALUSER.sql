--�Ϲ� ȸ��

drop table GENERALUSER;
create table GENERALUSER(
GID VARCHAR2(20),	-- �Ϲ�ȸ��ID
NAME VARCHAR2(20),	-- �̸�
PW VARCHAR2(20),	-- ��й�ȣ
EMAIL VARCHAR2(50),	-- �̸���
PHONE VARCHAR2(20),	-- �޴�����ȣ
RGS_DTM date,		-- ����Ͻ�
UPT_DTM	date,		-- �����Ͻ�
primary key(GID)
);

select * from generaluser;