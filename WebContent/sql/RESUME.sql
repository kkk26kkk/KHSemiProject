drop table resume;
create table resume(
	GID 		VARCHAR2(300),	-- 일반회원ID
	SN			NUMBER,			-- 일련번호
	SUBJECT		VARCHAR2(100),	-- 제목
	NAME		VARCHAR2(300),	-- 이름
	BIRTH		VARCHAR2(300),	-- 생년월일
	GENDER		VARCHAR2(300),	-- 성별
	EMAIL		VARCHAR2(300),	-- 이메일
	PHONE		VARCHAR2(300),	-- 휴대폰번호
	ADDR		VARCHAR2(300),	-- 주소
	PHOTO		VARCHAR2(300),	-- 사진
	STYPE		VARCHAR2(300),	-- 학력(학교구분)
	SNAME		VARCHAR2(300),  -- 학력(학교명)
	SDOA		VARCHAR2(300),	-- 학력(입학년월)
	SDOG		VARCHAR2(300),	-- 학력(졸업년월)
	MAJOR		VARCHAR2(300),	-- 학력(전공)
	GRADE		VARCHAR2(20),	-- 학력(학점)
	ENAME		VARCHAR2(300),	-- 경력(회사명)
	DEPT		VARCHAR2(300),	-- 경력(부서명)
	DOA			VARCHAR2(300),	-- 경력(입사년월)
	DOG			VARCHAR2(300),	-- 경력(퇴사년월)
	RANK		VARCHAR2(300),	-- 경력(직급)
	CERTNAME	VARCHAR2(300),	-- 자격증(자격증명)
	PUBLISHER	VARCHAR2(300),	-- 자격증(발행처)
	CACDATE		VARCHAR2(300),	-- 자격증(취득년월)
	LANNAME		VARCHAR2(300),	-- 어학(공인시험명)
	RATING		VARCHAR2(300),	-- 어학(급수/점수)
	LACDATE		VARCHAR2(300),	-- 어학(취득년월)
	PRSUBJECT	VARCHAR2(300),	-- 자기소개서(제목)
	PRCONTENT	VARCHAR2(300),	-- 자기소개서(내용)
	JTYPE		VARCHAR2(300),	-- 희망근무조건(고용형태)
	DESSAL		VARCHAR2(300),	-- 희망근무조건(희망연봉)
	REGION		VARCHAR2(300),	-- 희망근무조건(근무지역)
	DUTY		VARCHAR2(300),	-- 희망근무조건(직무)
	INDUSTRY	VARCHAR2(300),	-- 희망근무조건(산업)
	RGS_DTM		DATE,			-- 등록일시
	UPT_DTM		DATE,			-- 수정일시
	primary key(gid, sn)
);

select * from resume;

update resume set subject='열심히 하겠습니다.' where gid='kkk26kkk' and sn=1;

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
