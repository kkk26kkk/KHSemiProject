drop table recruit;
create table RECRUIT(
EID VARCHAR2(20),		-- 기업회원ID
SN NUMBER,				-- 일련번호
SUBJECT VARCHAR2(300),	-- 제목
ENAME VARCHAR2(60),		-- 회사명
CAREER VARCHAR2(4000),	-- 경력
EDU VARCHAR2(100),		-- 학력
JTYPE VARCHAR2(50),		-- 고용형태
DUTY VARCHAR2(50),		-- 직무
INDUSTRY VARCHAR2(50),	-- 산업
ENUM VARCHAR2(30),		-- 사원수
DOE VARCHAR2(50),		-- 설립년도
ETYPE VARCHAR2(20),		-- 기업형태
PAGEADDR VARCHAR2(300),	-- 홈페이지
REVENUE VARCHAR2(50),	-- 매출액
KIND VARCHAR2(80),		-- 모집분야
PAY VARCHAR2(50),		-- 급여
JOB VARCHAR2(500),		-- 담당업무
ELIGI VARCHAR2(500),	-- 자격요건
RECNUM VARCHAR2(20),	-- 모집인원
WTYPE VARCHAR2(500),	-- 근무형태
REGION VARCHAR2(200),	-- 지역
STARTDATE VARCHAR2(50),	-- 시작일
ENDDATE VARCHAR2(50),	-- 마감일
NOTICE VARCHAR2(2000),	-- 유의사항
EADDR VARCHAR2(200),	-- 회사주소
EADDR1 VARCHAR2(200),	-- 회사주소(도로명주소)
EADDR2 VARCHAR2(200),	-- 회사주소(상세주소)
WDAY VARCHAR2(200),		-- 근무요일
WTIME VARCHAR2(200),	-- 근무시간
LOGO VARCHAR2(100),		-- 회사로고
RGS_DTM DATE,			-- 등록일시
UPT_DTM DATE,			-- 수정일시
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