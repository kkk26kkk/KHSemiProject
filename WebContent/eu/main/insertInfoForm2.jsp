<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"
		   uri="http://java.sun.com/jsp/jstl/core" %>
		   
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<title>기업 정보 등록</title>
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
<jsp:include page="../../eu/euheader.jsp"/>
<form action="./entinfoadd.eumain" method="post"
	  enctype="multipart/form-data">
  <span>${param.ENAME}</span><br><!-- 기업명 -->
  <span>${param.ENUM }</span><br><!-- 사업자번호 -->
  <input type="hidden" name="ENAME" value="${param.ENAME }" required><br><!-- 기업명 넘김 -->
  
 <h1>기본정보</h1> 
 <br>
 <hr style="border:solid 1px black;">
 <span class="vital">*</span> 
 <label>대표자명</label>
 <input type="text" name="OWNERNAME" value="${param.OWNERNAME }" required><br><!-- 대표자명 -->
 <span class="vital">*</span>  
  설립일<input type="text" name="DOE" required><br>
  기업형태 <select name="ETYPE">
    <option value="1">대기업</option>
    <option value="2">중견기업</option>
    <option value="3">중소기업</option>
    <option value="4">강소기업</option>
    <option value="5">외국계기업</option>
    <option value="6">벤처기업</option>
    <option value="7">공공기관·공기업</option>
  </select><br>
  직무 <select name="DUTY">
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
  산업 <select name="INDUSTRY">
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
  사원수 <input class="onlynum" type="text" name="ENUM" required><br>
  회사주소 <input type="text" name="EADDR" value="${param.EADDR }"><br>
  <input type="hidden" name="EADDR1" value="${param.EADDR1 }">
  <input type="hidden" name="EADDR2" value="${param.EADDR2 }">
  홈페이지 <input type="text" name="PAGEADDR" required><br>
  매출액 <input type="text" name="REVENUE"><br>
 회사로고 <input type="file" name="LOGO"><br>
 
 <input type="submit" value="제출">
 <input type="reset" value="다시작성">
 </form>
</body>
</html>