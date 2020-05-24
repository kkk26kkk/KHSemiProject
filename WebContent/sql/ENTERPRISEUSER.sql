drop table enterpriseuser;
create table ENTERPRISEUSER(
EID VARCHAR2(20),		-- 기업회원ID
ENAME VARCHAR2(60),		-- 기업(회사)명
ENUM VARCHAR2(15),		-- 사업자번호
EADDR VARCHAR2(200),	-- 회사주소
EADDR1 VARCHAR2(200),	-- 회사주소(도로명주소)
EADDR2 VARCHAR2(200),	-- 회사주소(상세주소)
OWNERNAME VARCHAR2(20),	-- 대표자명
RGS_DTM DATE,			-- 등록일시
UPT_DTM DATE,			-- 수정일시
PRIMARY KEY(EID)
);

select * from enterpriseuser;