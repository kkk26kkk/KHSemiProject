<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c"
		   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>기업 정보 수정</title>
<script src="js/entinfo.js" charset="UTF-8"></script>
</head>
<body>
<jsp:include page="../euheader.jsp"/><br><br>
<h1>기업(회원)정보 수정페이지</h1>
<form method="post" enctype="multipart/form-data" action="./updateinfoProcess.eumain">
<!--<c:set var="eu" value="${einfo}"/>-->
  <span>${eu.ENAME}</span><br><!-- 기업명 -->
  <span>${eu.ENUM }</span><br><!-- 사업자번호 -->
  <c:set var="einfo" value="${einfo}"/>
  <input type="hidden" name="EID" value="${einfo.EID }" required><br><!-- 기업명 넘김 -->
  기본정보 <br>
  대표자명<input type="text" name="OWNERNAME" value="${einfo.OWNERNAME }" required><br><!-- 대표자명 -->
  설립일<input type="text" name="DOE"  required ><br>
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
  사원수 <input type="text" name="ENUM" value="${einfo.ENUM}" required><br>
  회사주소 <input type="text" name="EADDR" value="${einfo.EADDR}" required><br>
  홈페이지 <input type="text" name="PAGEADDR"  required><br>
  매출액 <input type="text" name="REVENUE" ><br>
 회사로고 <input type="file" name="LOGO" ><br>
 
  ep.setEID(rs.getString("EID"));

 
 <input type="submit" value="수정">
 
 <input type="reset" value="다시작성">
 </form>
</body>
</html>