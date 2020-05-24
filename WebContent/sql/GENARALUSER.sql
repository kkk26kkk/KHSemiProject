--일반 회원

drop table GENERALUSER;
create table GENERALUSER(
GID VARCHAR2(20),	-- 일반회원ID
NAME VARCHAR2(20),	-- 이름
PW VARCHAR2(20),	-- 비밀번호
EMAIL VARCHAR2(50),	-- 이메일
PHONE VARCHAR2(20),	-- 휴대폰번호
RGS_DTM date,		-- 등록일시
UPT_DTM	date,		-- 수정일시
primary key(GID)
);

select * from generaluser;