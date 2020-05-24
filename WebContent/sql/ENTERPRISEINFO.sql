drop table ENTERPRISEINFO;
create table ENTERPRISEINFO(
EID VARCHAR2(20),		-- 기업회원ID
ENAME VARCHAR2(60),		-- 기업(회사)명
OWNERNAME VARCHAR2(20),	-- 대표자명
DOE VARCHAR2(30),		-- 설립년도
ETYPE VARCHAR2(30),		-- 기업형태
DUTY VARCHAR2(50),		-- 직무
INDUSTRY VARCHAR2(50),	-- 산업
ENUM VARCHAR2(30),		-- 사원수
EADDR VARCHAR2(200),	-- 회사주소
EADDR1 VARCHAR2(200),	-- 회사주소(도로명주소)
EADDR2 VARCHAR2(200),	-- 회사주소(상세주소)
PAGEADDR VARCHAR2(300),	-- 홈페이지
REVENUE VARCHAR2(100),	-- 매출액
LOGO VARCHAR2(300),		-- 회사로고
RGS_DTM DATE,			-- 등록일시
UPT_DTM DATE,			-- 수정일시
PRIMARY KEY(EID)
);

select * from enterpriseinfo;

delete from enterpriseinfo where eid='bae9176';