<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"
		   uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<title>기업 정보 등록</title>
<link rel="stylesheet" href="css/infoform.css">
<script src="js/jquery-3.0.0.js"></script>
<script>
  $(function(){
	  $('.onlynum').keyup(function(){
		 $(this).val($(this).val().replace(/[^0-9]/g, '')); 
	  });
  });
</script>
</head>
<body>
<jsp:include page="../euheader.jsp"/>
<div id="infoformwrap">
<div class="head"><h2>기업 정보</h2></div>
<div id="infoformcontainer">
<form method="post" enctype="multipart/form-data" action="./entinfoadd.eumain">
  <h2 id="h2e">${eu.ENAME}</h2><!-- 기업명 -->
  <h2 id="h2e">${eu.ENUM }</h2><!-- 사업자번호 -->
<%--   <c:set var="ep" value="${ep}"/> --%>
<%--   <input type="hidden" name="EID" value="${ep.EID }" class="button" required><!-- 기업명 넘김 --> --%>
  <hr style="border:solid 1px black;">
  <br>
  <span class="vital">*</span> 
  <label>대표자명</label>
  <input type="text" name="OWNERNAME" value="${eu.OWNERNAME }" placeholder="대표자명" class="button" required><br><!-- 대표자명 -->
  <br>
  <hr>
  <br>
  <span class="vital">*</span> 
  <label>설립일</label>
  <input type="text" name="DOE" class="button"  placeholder="설립일" required ><br>
  <br>
  <hr>
  <br>
  <span class="vital">*</span> 
  <label>기업형태</label>
   <select name="ETYPE" class="select">
    <option value="0">기업형태</option>
    <option value="1">대기업</option>
    <option value="2">중견기업</option>
    <option value="3">중소기업</option>
    <option value="4">강소기업</option>
    <option value="5">외국계기업</option>
    <option value="6">벤처기업</option>
    <option value="7">공공기관·공기업</option>
  </select><br>
  <br>
  <hr>
  <br>
 <span class="vital">*</span>
  <label>직무</label>
   <select name="DUTY" class="select">
    <option value="0">직무</option>
    <option value="1">경영·사무</option>
    <option value="2">마케팅·광고·홍보</option>
    <option value="3">IT·인터넷</option>
    <option value="4">디자인</option>
    <option value="5">무역·유통</option>
    <option value="6">영업·고객상담</option>
    <option value="7">서비스</option>
    <option value="8">연구개발·설계</option>
    <option value="9">생산·제조</option>
    <option value="10">교육</option>
    <option value="11">건설</option>
    <option value="12">의료</option>
    <option value="13">미디어</option>
    <option value="14">전문·특수직</option>       
  </select><br>
  <br>
  <hr>
  <br>
 <span class="vital">*</span>
  <label>산업</label>
   <select name="INDUSTRY" class="select">
    <option value="0">산업</option>
    <option value="1">서비스업</option>
    <option value="2">금융·은행업</option>
    <option value="3">IT·정보통신업</option>
    <option value="4">판매·유통업</option>
    <option value="5">제조·생산·화학업</option>
    <option value="6">교육업</option>
    <option value="7">건설업</option>
    <option value="8">의료·제약업</option>
    <option value="9">미디어·광고업</option>
    <option value="10">문화·예술·디자인업</option>
    <option value="11">기관·협회</option>
  </select><br>
  <br>
  <hr>
  <br>
  <span class="vital">*</span> 
  <label>사원수</label>
  <input type="text" class="onlynum button" name="ENUM" placeholder="사원수" required><br>
  <br>
  <hr>
  <br>
  <span class="vital">*</span>
  <label>회사주소</label>
  <input type="text" name="EADDR" value="${eu.EADDR}" class="button" placeholder="회사주소" required><br>
  <input type="hidden" name="EADDR1" value="${eu.EADDR1 }">
  <input type="hidden" name="EADDR2" value="${eu.EADDR2 }">
  <br>
  <hr>
  <br>
  <span class="vital">*</span> 
  <label>홈페이지</label>
  <input type="text" name="PAGEADDR" class="button" placeholder="홈페이지" required><br>
  <br>
  <hr>
  <br>
  <span class="vital">*</span> 
  <label>매출액</label>
  <input type="text" name="REVENUE" class="button" placeholder="매출액"><br>
  <br>
  <hr>
  <br>
  <span class="vital">*</span>
  <label>회사로고</label>
  <input type="file" name="LOGO" class="file"><br>
  <br>
  <hr>
  <br>
  <input type="submit" value="등록" class="a">
 </form>
</div>
</div>
</body>
</html>