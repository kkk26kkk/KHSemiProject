<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@ taglib prefix="c"
		   uri="http://java.sun.com/jsp/jstl/core" %>

<%
  String writeent=null, entlist=null, writesal=null, 
  sallist=null, writeinter=null, interlist=null,
  resumewrite=null, resumelist=null, applylist=null;

  String writerec=null, eureclist=null, applicantlist=null,
		  searchperson=null, eumain=null;
  
  String gid = (String)session.getAttribute("gid");
  
  if(gid != null) {
  	writeent = "./write.guentreview";
  	entlist = "./entreviewlist.guuser";
  	writesal = "./write.gusalary";
  	sallist = "./salarylist.guuser";
  	writeinter = "./write.guinterview";
  	interlist = "./interviewlist.guuser";
  	resumewrite = "./resumewrite.guuser";
  	resumelist = "./resumelist.guuser";
  	applylist = "./applylist.guuser";
  }
  else {
  	writeent = "./login.gumain";
  	entlist = "./login.gumain";
  	writesal = "./login.gumain";
  	sallist = "./login.gumain";
  	writeinter = "./login.gumain";
  	interlist = "./login.gumain";
  	resumewrite = "./login.gumain";
  	resumelist = "./login.gumain";
  	applylist = "./login.gumain";
  }	   
  
  String eid = (String)session.getAttribute("eid");
  
  if(eid != null) {
	  eumain = "./main.eumain";
	  writerec = "./regrecruit.eurecruit";
	  eureclist = "./recruitlist.eurecruit";
	  applicantlist = "./applicantlist.euperson";
	  searchperson = "./personlist.euperson";
  }
  else {
	  eumain = "./login.eumain";
	  writerec = "./login.eumain";
	  eureclist = "./login.eumain";
	  applicantlist = "./login.eumain";
	  searchperson = "./login.eumain";
  }
%>

<script src="js/jquery-3.0.0.js"></script>
<script src="js/header.js"></script>
<link rel="stylesheet" href="css/header.css"/>

<div id="header">
  <div id="logo">
    <a href="./main.gumain"><img src="logo.png" width="300px" height="100px"></a>
  </div>
  
  <div id="navbar">
    <div id="navinner">
	    <a href="./home.gurecruit" class="subject">채용 정보
	    </a><a href="./home.guentreview" class="subject">기업 리뷰
	    </a><a href="./home.gusalary" class="subject">연봉 정보
	    </a><a href="./home.guinterview" class="subject">면접 후기</a>
	    
	    <span id="mymenu"><img src="image/myicon.png"></span>
	    <a href="<%=eumain %>" id="eumenu">기업회원</a>
    </div>
        
  </div>
  
</div>

<div id="cursoron">
  <div id="cursorinner">
	 
	  <ul id="entreview">
	    <li><a href=<%=writeent %>>기업 리뷰 작성</a></li>
	    <li><a href=<%=entlist %>>작성 내역</a></li>
	  </ul>
	  
	  <ul id="salaryinfo">
	    <li><a href=<%=writesal %>>연봉 정보 작성</a></li>
	    <li><a href=<%=sallist %>>작성 내역</a></li>
	  </ul>
	  
	  <ul id="interview">
	    <li><a href=<%=writeinter %>>면접 후기 작성</a></li>
	    <li><a href=<%=interlist %>>작성 내역</a></li>
	  </ul>
  </div>
</div>

<div id="mynav">

  <c:if test="${empty gid}">
    <div id="gulogin">
	  <a id="guloginbtn" href="./login.gumain">로그인</a>
      <a id="gujoinbtn" href="./join.gumain">회원가입</a>
    </div>
  </c:if>
  
  <c:if test="${!empty gid}">
    <div id="gulogin_n">
  	  <div class="iddiv"><b>${gid }</b>님</div>
  	  <a id="guuptinfo" href="./updateinfo.gumain">정보 수정</a>
  	  <a id="gulogoutbtn" href="./logout.gumain">로그아웃</a>
    </div>
  </c:if>
 	  
  <ul>
    <li><a href=<%=resumewrite %>>이력서 등록</a></li>
    <li><a href=<%=resumelist %>>이력서 관리</a></li>
    <li><a href="./main.gumain">입사 지원 현황</a></li><%--<%=applylist %>--%>
	<li><a href="./boardList.FA">문의사항</a></li>
  </ul>
</div>

<div id="eunav">
  <c:if test="${empty eid}">
    <div id="eulogin">
	  <a id="euloginbtn" href="./login.eumain">로그인</a>
      <a id="eujoinbtn" href="./join.eumain">회원가입</a>
    </div>
  </c:if>

  <c:if test="${!empty eid}">
    <div id="eulogin_n">
  	  <div class="iddiv"><b>${eid }</b>님</div>
  	  <a id="euuptinfo" href="./entinfo.eumain">정보 관리</a>
  	  <a id="eulogoutbtn" href="./logout.eumain">로그아웃</a>
    </div>
  </c:if>

  <ul>
    <li><a href="<%=eumain %>">기업회원 홈</a></li>
    <li><a href="<%=writerec %>">채용공고 등록</a></li>
    <li><a href="<%=eureclist %>">공고 관리</a></li>
    <li><a href="<%=applicantlist %>">지원자 관리</a></li>
    <li><a href="<%=searchperson %>">인재 검색</a></li>
    <li><a href="./boardList.FA">문의사항</a></li>
  </ul>
</div>
