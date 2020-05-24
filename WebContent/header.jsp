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
	    <a href="./home.gurecruit" class="subject">ä�� ����
	    </a><a href="./home.guentreview" class="subject">��� ����
	    </a><a href="./home.gusalary" class="subject">���� ����
	    </a><a href="./home.guinterview" class="subject">���� �ı�</a>
	    
	    <span id="mymenu"><img src="image/myicon.png"></span>
	    <a href="<%=eumain %>" id="eumenu">���ȸ��</a>
    </div>
        
  </div>
  
</div>

<div id="cursoron">
  <div id="cursorinner">
	 
	  <ul id="entreview">
	    <li><a href=<%=writeent %>>��� ���� �ۼ�</a></li>
	    <li><a href=<%=entlist %>>�ۼ� ����</a></li>
	  </ul>
	  
	  <ul id="salaryinfo">
	    <li><a href=<%=writesal %>>���� ���� �ۼ�</a></li>
	    <li><a href=<%=sallist %>>�ۼ� ����</a></li>
	  </ul>
	  
	  <ul id="interview">
	    <li><a href=<%=writeinter %>>���� �ı� �ۼ�</a></li>
	    <li><a href=<%=interlist %>>�ۼ� ����</a></li>
	  </ul>
  </div>
</div>

<div id="mynav">

  <c:if test="${empty gid}">
    <div id="gulogin">
	  <a id="guloginbtn" href="./login.gumain">�α���</a>
      <a id="gujoinbtn" href="./join.gumain">ȸ������</a>
    </div>
  </c:if>
  
  <c:if test="${!empty gid}">
    <div id="gulogin_n">
  	  <div class="iddiv"><b>${gid }</b>��</div>
  	  <a id="guuptinfo" href="./updateinfo.gumain">���� ����</a>
  	  <a id="gulogoutbtn" href="./logout.gumain">�α׾ƿ�</a>
    </div>
  </c:if>
 	  
  <ul>
    <li><a href=<%=resumewrite %>>�̷¼� ���</a></li>
    <li><a href=<%=resumelist %>>�̷¼� ����</a></li>
    <li><a href="./main.gumain">�Ի� ���� ��Ȳ</a></li><%--<%=applylist %>--%>
	<li><a href="./boardList.FA">���ǻ���</a></li>
  </ul>
</div>

<div id="eunav">
  <c:if test="${empty eid}">
    <div id="eulogin">
	  <a id="euloginbtn" href="./login.eumain">�α���</a>
      <a id="eujoinbtn" href="./join.eumain">ȸ������</a>
    </div>
  </c:if>

  <c:if test="${!empty eid}">
    <div id="eulogin_n">
  	  <div class="iddiv"><b>${eid }</b>��</div>
  	  <a id="euuptinfo" href="./entinfo.eumain">���� ����</a>
  	  <a id="eulogoutbtn" href="./logout.eumain">�α׾ƿ�</a>
    </div>
  </c:if>

  <ul>
    <li><a href="<%=eumain %>">���ȸ�� Ȩ</a></li>
    <li><a href="<%=writerec %>">ä����� ���</a></li>
    <li><a href="<%=eureclist %>">���� ����</a></li>
    <li><a href="<%=applicantlist %>">������ ����</a></li>
    <li><a href="<%=searchperson %>">���� �˻�</a></li>
    <li><a href="./boardList.FA">���ǻ���</a></li>
  </ul>
</div>
