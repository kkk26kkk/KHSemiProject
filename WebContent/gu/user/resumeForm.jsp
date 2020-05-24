<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"
		   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>이력서 작성</title>
<link rel="stylesheet" href="css/resumeform.css">
<script src="js/jquery-3.0.0.js"></script>
<script>
  $(function(){
	  $('#STYPE').change(function(){
		  if($(this).val() == 5) {
			  $('#MAJOR').css('display', 'none');
			  $('#GRADE').css('display', 'none');
		  }
		  else{
			  $('#MAJOR').css('display', 'inline-block');
			  $('#GRADE').css('display', 'inline-block');
		  }
	  });
  });
  
  function goPopup(){
	var screenW = screen.availWidth;
	var screenH = screen.availHeight;
	var posL = (screenW - 570) / 2;
	var posT = (screenH - 420) / 2;
	
	var pop = window.open("jusoPopup.jsp","pop","width=570,height=420,top="+posT+",left="+posL+",scrollbars=yes, resizable=yes"); 
  }

  function jusoCallBack(roadFullAddr,roadAddrPart1,addrDetail,roadAddrPart2,engAddr, jibunAddr, zipNo, admCd, rnMgtSn, bdMgtSn,detBdNmList,bdNm,bdKdcd,siNm,sggNm,emdNm,liNm,rn,udrtYn,buldMnnm,buldSlno,mtYn,lnbrMnnm,lnbrSlno,emdNo){

	document.getElementById('inp_addr').value = roadFullAddr;
  }
</script>
</head>
<body>

<jsp:include page="../../header.jsp"></jsp:include>
<c:set var="gu" value="${gu }"/>
<div id="resumeWraper">
    <div class="resumeContainer">
    <form action="./resumeAdd.guuser" method="post">
      <input id="resumetitle" type="text" name="SUBJECT" placeholder="이력서 제목">
      
      <h2 class="t">인적사항</h2>
      <div class="form">
        <input class="input" type="text" name="NAME" placeholder="이름" value="${gu.NAME }">
        <input class="input" type="text" name="BIRTH" placeholder="생년월일">
        <select class="input inp_gender" name="GENDER">
          <option value="0">성별</option>
          <option value="남자">남자</option>
          <option value="여자">여자</option>
        </select>
        <input class="input inp_email" type="text" name="EMAIL" placeholder="이메일" value="${gu.EMAIL }">
<!--         <input class="input inp_file" type="file" name="PHOTO" placeholder="사진"> -->
        <input class="input" type="text" name="PHONE" placeholder="휴대폰번호" value="${gu.PHONE }">
        <input id="inp_addr" class="input inp_addr" type="text" name="ADDR" placeholder="주소">
      	<input class="input inp_adser" onClick="goPopup();" type="button" value="주소 검색">
      </div>

	 <h2 class="t">학력</h2>
     <div class="form">
       <select class="input inp_stype" id="STYPE" name="STYPE">
  		<option value="1">대학교 졸업(4년)</option>
  		<option value="2">대학교 졸업(2,3년)</option>
  		<option value="3">대학원 석사 졸업</option>
  		<option value="4">대학원 박사 졸업</option>
  		<option value="5">고등학교 졸업</option>
       </select>  
         <input class="input inp_sname" type="text" name="SNAME" placeholder="학교명">
         <input class="input inp_sdoa" type="text" name="SDOA" placeholder="입학년월">
         <input class="input inp_sdog" type="text" name="SDOG" placeholder="졸업년월">
         <input class="input inp_major" type="text" id="MAJOR" name="MAJOR" placeholder="전공명">
         <input class="input inp_grade" type="text" id="GRADE" name="GRADE" placeholder="학점">
     </div>
     
     <h2 class="t">경력</h2>
     <div class="form">
        <input class="input inp_ename" type="text" name="ENAME" placeholder="회사명">
		<input class="input inp_dept" type="text" name="DEPT" placeholder="부서명">
		<input class="input inp_doa" type="text" name="DOA" placeholder="입사년월">
		<input class="input inp_dog" type="text" name="DOG" placeholder="퇴사년월">
		<select class="input inp_rank" name="RANK">
		  <option value="0">직급</option>
		  <option value="1">사원</option>
		  <option value="2">주임/계장</option>
		  <option value="3">대리</option>
		  <option value="4">과장</option>
		  <option value="5">차장</option>
		  <option value="6">부장</option>
		  <option value="7">임원</option>
		  <option value="8">팀장</option>
		  <option value="9">매니저</option>
		  <option value="10">파트장</option>
		  <option value="11">실장</option>
		  <option value="12">지점장</option>
		  <option value="13">지사장</option>
		  <option value="14">원장</option>
		  <option value="15">국장</option>
		  <option value="16">본부장</option>
		  <option value="17">센터장</option>
		  <option value="18">공장장</option>
		  <option value="19">그룹장</option>
		</select>
     </div>
     
     <h2 class="t">자격증</h2>
     <div class="form">
       <input class="input inp_cen" type="text" name="CERTNAME" placeholder="자격증명">
       <input class="input inp_pub" type="text" name="PUBLISHER" placeholder="발행처">
	   <input class="input inp_cac" type="text" name="CACDATE" placeholder="취득년월">
     </div>
     
     <h2 class="t">어학</h2>
     <div class="form">
       <input class="input inp_lan" type="text" name="LANNAME" placeholder="공인시험명">
       <input class="input inp_rat" type="text" name="RATING" placeholder="급수/점수">
	   <input class="input inp_lac" type="text" name="LACDATE" placeholder="취득년월">
     </div>
     
     <h2 class="t">자기소개서</h2>
     <div class="form">
       <div id="divinp"><input class="input inp_prs" type="text" name="PRSUBJECT" placeholder="제목을 입력하세요"></div>
	   <div class="ta"><textarea class="prc" name="PRCONTENT" placeholder="내용을 입력하세요"></textarea></div>
     </div>
     
     <h2 class="t">희망근무조건</h2>
     <div class="form">
       <select class="input inp_jtype" name="JTYPE">
         <option value="0">고용 형태</option>
         <option value="1">정규직</option>
         <option value="2">계약직</option>
         <option value="3">인턴</option>
         <option value="4">파견직</option>
         <option value="5">프리랜서</option>
         <option value="6">연수생/교육생</option>
       </select>
       <select class="input inp_dessal" name="DESSAL">
        <option value="0">희망연봉</option>
        <option value="1">~2,000만원</option>
        <option value="2">2,000~2,500만원</option>
        <option value="3">2,500~3,000만원</option>
        <option value="4">3,000~3,500만원</option>
        <option value="5">3,500~4,000만원</option>
        <option value="6">4,000~4,500만원</option>
        <option value="7">5,000~5,000만원</option>
        <option value="8">5,000~6,000만원</option>
        <option value="9">6,000만원~</option>
       </select>
       <select class="input inp_region" name="REGION">
        <option value="0">희망근무지</option>
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
	   </select>
	   
	   <select class="input inp_duty" name="DUTY">
		<option value="0">희망 직무</option>
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
	   </select>
	   
	   <select class="input inp_industry" name="INDUSTRY">
		 <option value="0">희망 산업</option>
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
	  </select>
     </div>
    <input id="submitbtn" type="submit" value="등록">
    </form>
    </div>
  </div>
</body>
</html>