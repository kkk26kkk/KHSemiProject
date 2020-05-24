<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"
		   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>공고 등록</title>
<link rel="stylesheet" href="css/recruitform.css">

</head>
<body>
<jsp:include page="../../eu/euheader.jsp"/>
<c:set var="eu" value="${eu }"/>

<div id="recwrap">
<div id="rectitle"><h1>공고 등록</h1></div>
<div id="recContainer">
<form method="post" action="./recruitadd.eurecruit">
  <div>
  <h1>모집 내용</h1>
  <hr>
    <span class="vital">*</span>
	<label>공고제목</label><br>
	<input type="text" placeholder="공고제목" id="SUBJECT" name="SUBJECT" class="button"><br>
	
	<span class="vital">*</span>
	<label>기업명</label><br>
	<input type="text" placeholder="기업명" id="ENAME" name="ENAME" value="${eu.ENAME }" class="button"><br>
	
	<span class="vital">*</span>
	<label>산업</label><br>
	<select name="INDUSTRY" class="select">
		 <option value="1">서비스업</option>
		 <option value="2">금융·은행업</option>
		 <option value="3">IT·정보통신업</option>
		 <option value="4">판매·유통업</option>
		 <option value="5">제조·생산·화학업</option>
		 <option value="6">교육업</option>
		 <option value="7">의료·제약업</option>
		 <option value="8">미디어·광고업</option>
		 <option value="9">문화·예술·디자인업</option>
		 <option value="10">기관·협회</option>
	</select><br>
	
	<span class="vital">*</span>
	<label>직무</label><br>
	<select name="DUTY" class="select">
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
	
	<span class="vital">*</span>
	<label>모집인원</label><br>
	<input type="text" placeholder="모집인원" id="RECNUM" name="RECNUM" class="button"><br>
  </div>
  
  <div>
  <h1>지원 자격</h1>
  <hr>
	
	<span class="vital">*</span>
	<label>경력</label><br>
	<select name="CAREER" class="select">
	    <option value="1">신입</option>
		<option value="2">1~3년</option>
		<option value="3">4~6년</option>
		<option value="4">7~9년</option>
		<option value="5">10~15년</option>
		<option value="6">16~20년</option>
		<option value="7">21년 이상</option>
		<option value="8">경력무관</option>
	</select>
		
	<span class="vital">*</span>
	<label>학력</label><br>
	<select name="EDU" class="select">
		<option value="1">대학교 졸업(4년)</option>
		<option value="2">대학교 졸업(2,3년)</option>
		<option value="3">대학원 석사 졸업</option>
		<option value="4">대학원 박사 졸업</option>
		<option value="5">고등학교 졸업</option>
		<option value="6">학력무관</option>
	</select><br>
  </div>
  
  <div>
  <h1>근무 조건</h1>
  <hr>
  	<span class="vital">*</span>
  	<label>고용형태</label><br>
	<input type="checkbox" name="JTYPE" value="1">정규직
	<input type="checkbox" name="JTYPE" value="2">계약직
	<input type="checkbox" name="JTYPE" value="3">인턴
	<input type="checkbox" name="JTYPE" value="4">파견직
	<input type="checkbox" name="JTYPE" value="5">프리랜서
	<input type="checkbox" name="JTYPE" value="6">연수생/교육생
	<br>
	
	<span class="vital">*</span>
	<label>근무 요일</label>
	<input type="radio" id="WDAY1" name="WDAY" value="월~금" >월~금
	<input type="radio" id="WDAY2" name="WDAY" value="월~토" >월~토
	<input type="radio" id="WDAY3" name="WDAY" value="월~일" >월~일
	<br>
	
	<span class="vital">*</span>
	<label>근무 시간</label><br>
	<input type="text" id="WTIME" name="WTIME" placeholder="근무시간" class="button"><br>
  
  	<span class="vital">*</span>
	<label>급여</label><br>
	<input type="text" id="PAY" name="PAY" placeholder="급여" class="button"><br>
	
	<span class="vital">*</span>
	<label>지역</label><br>
	<select name="REGION" class="select">
	  <option value="1">서울특별시</option>
	  <option value="2">경기도</option>
	  <option value="3">인천광역시</option>
	  <option value="4">대전광역시</option>
	  <option value="5">세종특별자치시</option>
	  <option value="6">충청남도</option>
	  <option value="7">광주광역시</option>
	  <option value="8">전라남도</option>
	  <option value="9">전라북도</option>
	  <option value="10">대구광역시</option>
	  <option value="11">경상북도</option>
	  <option value="12">부산광역시</option>
	  <option value="13">울산광역시</option>
	  <option value="14">경상남도</option>
	  <option value="15">강원도</option>
	  <option value="16">제주특별자치도</option>
	</select><br>
  </div>
  
  <div>
  <h1>모집 부문</h1>
  <hr>
  	<span class="vital">*</span>
	<label>모집분야</label><br>
	<input type="text" placeholder="모집분야" id="KIND" name="KIND" class="button"><br>
	
	<span class="vital">*</span>
	<label>자격요건</label><br>
	<input type="text" placeholder="자격요건" id="ELIGI" name="ELIGI" class="button"><br>
	
	<span class="vital">*</span>
	<label>담당업무</label><br>
	<input type="text" placeholder="담당업무" id="JOB" name="JOB" class="button"><br>
	
	<span class="vital">*</span>
	<label>근무형태</label><br>
	<input type="text" placeholder="근무형태" id="WTYPE" name="WTYPE" class="button"><br>
  </div>
	
  <div>
  <h1>접수 기간</h1>
  <hr>
  	<span class="vital">*</span>
	<label>접수시작일</label><br>
	<input type="date" placeholder="접수시작일" id="STARTDATE" name="STARTDATE" class="button"><br>
	
	<span class="vital">*</span>
	<label>접수종료일</label><br>
	<input type="date" placeholder="접수종료일" id="ENDDATE" name="ENDDATE" class="button"><br>
  </div>
  
  	<span class="vital">*</span>
	<label>유의사항</label><br>
	<textarea id="NOTICE" name="NOTICE" class="button"></textarea>
	<br>

<!-- 	<input type="button" value="취소" onClick="javascript:history.back();"> -->
	<input id="submitbtn" type="submit" value="등록" class="a">
</form>
</div>
</div>
</body>
</html>