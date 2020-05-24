drop table faqadmin;

create table FAQADMIN(
 sn  			number,
 userid			varchar2(20),
 name			varchar2(100),
 pass			varchar2(200),
 subject		varchar2(1000),
 content		varchar2(4000),
 fa_file		varchar2(50),
 re_ref			number,
 re_lev			number,
 re_seq			number,
 readcount		number,
 rgs_dtm		Date
 );

select * from faqadmin;


insert into faqadmin
values(2,'id','김무수','2222','제목입니다','내용입니다','asdf',2,2,2,2,'18/12/07');

select * from (select rownum rnum,SN,USERID, NAME,
        PASS,SUBJECT,CONTENT,RE_REF,RE_LEV, RE_SEQ, READCOUNT,RGS_DTM from
        (select * from faqadmin order by RE_REF desc,RE_SEQ asc)) ;
        
        
        
        
        
        
drop table login;

create table login(
 sn  			number,
 userid			varchar2(20),
 pass			varchar2(20)
);


select * from login; 

insert into login
values(2,'admin','1234');      
        
        




        
        
        
        
        
        
        
        
        
        