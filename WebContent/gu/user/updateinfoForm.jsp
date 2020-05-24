<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"
		   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>이력서 작성</title>
<link rel="stylesheet" href="css/resumeform2.css">
<script src="js/jquery-3.0.0.js"></script>
<script src="js/resume.js" charset="EUC-KR"></script>
<script>
  $(function(){
	  $('#STYPE').change(function(){
		  if($(this).val() == 5) {
			  $('#MAJOR').remove();
			  $('#GRADE').remove();
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
<c:set var="gu" value="${vo}"/>
<div id="resumeWraper">
    <div class="resumeContainer">
    <form action="./resumeupdateAction.guuser" method="post">
     <input type="hidden" name="num" value="${gu.SN}">
     <input type="hidden" name="GID" value="${gu.GID}">
      <input id="resumetitle" type="text" name="SUBJECT" placeholder="이력서 제목" value="${gu.SUBJECT}">
      
      <h2 class="t">인적사항</h2>
      <div class="form">
        <input class="input" type="text" name="NAME" placeholder="이름" value="${gu.NAME }">
        <input class="input" type="text" name="BIRTH" placeholder="생년월일" value="${gu.BIRTH}">
        <select class="input inp_gender" name="GENDER">
          <option value="0">성별</option>
          <option value="남자">남자</option>
          <option value="여자">여자</option>
        </select>
        <input class="input inp_email" type="text" name="EMAIL" placeholder="이메일" value="${gu.EMAIL }">
<!--         <input class="input inp_file" type="file" name="PHOTO" placeholder="사진"> -->
        <input class="input" type="text" name="PHONE" placeholder="휴대폰번호" value="${gu.PHONE }">
        <input id="inp_addr" class="input inp_addr" type="text" name="ADDR" placeholder="주소" value="${gu.ADDR }">
      	<input class="input inp_adser" onClick="goPopup();" type="button" value="주소검색">
      </div>

	 <h2 class="t">학력</h2>
     <div class="form">
       <select class="input inp_stype" name="STYPE">
  		<option value="1"<c:if test="${gu.STYPE== 1}">selected</c:if>>대학교 졸업(4년)</option>
  		<option value="2"<c:if test="${gu.STYPE== 2}">selected</c:if>>대학교 졸업(2,3년)</option>
  		<option value="3"<c:if test="${gu.STYPE== 3}">selected</c:if>>대학원 석사 졸업</option>
  		<option value="4"<c:if test="${gu.STYPE== 4}">selected</c:if>>대학원 박사 졸업</option>
  		<option value="5"<c:if test="${gu.STYPE== 5}">selected</c:if>>고등학교 졸업</option>
  		
       </select>  
         <input class="input inp_sname" type="text" name="SNAME" placeholder="학교명" value="${gu.SNAME}">
         <input class="input inp_sdoa" type="text" name="SDOA" placeholder="입학년월" value="${gu.SDOA}">
         <input class="input inp_sdog" type="text" name="SDOG" placeholder="졸업년월" value="${gu.SDOG}">
         <input class="input inp_major" type="text" name="MAJOR" placeholder="전공명" value="${gu.MAJOR}">
         <input class="input inp_grade" type="text" name="GRADE" placeholder="학점" value="${gu.GRADE}">
     </div>
     
     <h2 class="t">경력</h2>
     <div class="form">
        <input class="input inp_ename" type="text" name="ENAME" placeholder="회사명" value="${gu.ENAME}">
		<input class="input inp_dept" type="text" name="DEPT" placeholder="부서명" value="${gu.DEPT}">
		<input class="input inp_doa" type="text" name="DOA" placeholder="입사년월" value="${gu.DOA}">
		<input class="input inp_dog" type="text" name="DOG" placeholder="퇴사년월" value="${gu.DOG}">
		<select class="input inp_rank" name="RANK">
		  <option value="0"<c:if test="${gu.RANK == 0}">selected</c:if>>직급</option>
		  <option value="1"<c:if test="${gu.RANK == 1}">selected</c:if>>사원</option>
		  <option value="2"<c:if test="${gu.RANK == 2}">selected</c:if>>주임/계장</option>
		  <option value="3"<c:if test="${gu.RANK == 3}">selected</c:if>>대리</option>
		  <option value="4"<c:if test="${gu.RANK == 4}">selected</c:if>>과장</option>
		  <option value="5"<c:if test="${gu.RANK == 5}">selected</c:if>>차장</option>
		  <option value="6"<c:if test="${gu.RANK == 6}">selected</c:if>>부장</option>
		  <option value="7"<c:if test="${gu.RANK == 7}">selected</c:if>>임원</option>
		  <option value="8"<c:if test="${gu.RANK == 8}">selected</c:if>>팀장</option>
		  <option value="9"<c:if test="${gu.RANK == 9}">selected</c:if>>매니저</option>
		  <option value="10"<c:if test="${gu.RANK == 10}">selected</c:if>>파트장</option>
		  <option value="11"<c:if test="${gu.RANK == 11}">selected</c:if>>실장</option>
		  <option value="12"<c:if test="${gu.RANK == 12}">selected</c:if>>지점장</option>
		  <option value="13"<c:if test="${gu.RANK == 13}">selected</c:if>>지사장</option>
		  <option value="14"<c:if test="${gu.RANK == 14}">selected</c:if>>원장</option>
		  <option value="15"<c:if test="${gu.RANK == 15}">selected</c:if>>국장</option>
		  <option value="16"<c:if test="${gu.RANK == 16}">selected</c:if>>본부장</option>
		  <option value="17"<c:if test="${gu.RANK == 17}">selected</c:if>>센터장</option>
		  <option value="18"<c:if test="${gu.RANK == 18}">selected</c:if>>공장장</option>
		  <option value="19"<c:if test="${gu.RANK == 19}">selected</c:if>>그룹장</option>
		</select>
     </div>
     
     <h2 class="t">자격증</h2>
     <div class="form">
       <input class="input inp_cen" type="text" name="CERTNAME" placeholder="자격증명" value="${gu.CERTNAME}">
       <input class="input inp_pub" type="text" name="PUBLISHER" placeholder="발행처" value="${gu.PUBLISHER}">
	   <input class="input inp_cac" type="text" name="CACDATE" placeholder="취득년월" value="${gu.CACDATE}">
     </div>
     
     <h2 class="t">어학</h2>
     <div class="form">
       <input class="input inp_lan" type="text" name="LANNAME" placeholder="공인시험명" value="${gu.LANNAME}">
       <input class="input inp_rat" type="text" name="RATING" placeholder="급수/점수" value="${gu.RATING}">
	   <input class="input inp_lac" type="text" name="LACDATE" placeholder="취득년월" value="${gu.LACDATE}">
     </div>
     
     <h2 class="t">자기소개서</h2>
     <div class="form">
       <div id="divinp"><input class="input inp_prs" type="text" name="PRSUBJECT" value="${gu.PRSUBJECT}"></div>
	   <div class="ta"><textarea class="prc" name="PRCONTENT"> ${gu.PRCONTENT}</textarea></div>
     </div>
     
     <h2 class="t">희망근무조건</h2>
     <div class="form">
       <select class="input inp_jtype" name="JTYPE">
         <option value="0"<c:if test="${gu.JTYPE == 0}">selected</c:if>>고용 형태</option>
         <option value="1"<c:if test="${gu.JTYPE == 1}">selected</c:if>>정규직</option>
         <option value="2"<c:if test="${gu.JTYPE == 2}">selected</c:if>>계약직</option>
         <option value="3"<c:if test="${gu.JTYPE == 3}">selected</c:if>>인턴</option>
         <option value="4"<c:if test="${gu.JTYPE == 4}">selected</c:if>>파견직</option>
         <option value="5"<c:if test="${gu.JTYPE == 5}">selected</c:if>>프리랜서</option>
         <option value="6"<c:if test="${gu.JTYPE == 6}">selected</c:if>>연수생/교육생</option>
       </select>
       <select class="input inp_dessal" name="DESSAL">
        <option value="0"<c:if test="${gu.DESSAL == 0}">selected</c:if>>희망연봉</option>
        <option value="1"<c:if test="${gu.DESSAL == 1}">selected</c:if>>~2,000만원</option>
        <option value="2"<c:if test="${gu.DESSAL == 2}">selected</c:if>>2,000~2,500만원</option>
        <option value="3"<c:if test="${gu.DESSAL == 3}">selected</c:if>>2,500~3,000만원</option>
        <option value="4"<c:if test="${gu.DESSAL == 4}">selected</c:if>>3,000~3,500만원</option>
        <option value="5"<c:if test="${gu.DESSAL == 5}">selected</c:if>>3,500~4,000만원</option>
        <option value="6"<c:if test="${gu.DESSAL == 6}">selected</c:if>>4,000~4,500만원</option>
        <option value="7"<c:if test="${gu.DESSAL == 7}">selected</c:if>>5,000~5,000만원</option>
        <option value="8"<c:if test="${gu.DESSAL == 8}">selected</c:if>>5,000~6,000만원</option>
        <option value="9"<c:if test="${gu.DESSAL == 9}">selected</c:if>>6,000만원~</option>
       </select>
       <select class="input inp_region" name="REGION">
        <option value="0"<c:if test="${gu.REGION == 0}">selected</c:if>>희망근무지</option>
	  	<option value="1"<c:if test="${gu.REGION == 1}">selected</c:if>>서울특별시</option>
	  	<option value="2"<c:if test="${gu.REGION == 2}">selected</c:if>>경기도</option>
	  	<option value="3"<c:if test="${gu.REGION == 3}">selected</c:if>>인천광역시</option>
	  	<option value="4"<c:if test="${gu.REGION == 4}">selected</c:if>>대전광역시</option>
	  	<option value="5"<c:if test="${gu.REGION == 5}">selected</c:if>>세종특별자치시</option>
	  	<option value="6"<c:if test="${gu.REGION == 6}">selected</c:if>>충청남도</option>
	  	<option value="7"<c:if test="${gu.REGION == 7}">selected</c:if>>광주광역시</option>
	  	<option value="8"<c:if test="${gu.REGION == 8}">selected</c:if>>전라남도</option>
	  	<option value="9"<c:if test="${gu.REGION == 9}">selected</c:if>>전라북도</option>
	  	<option value="10"<c:if test="${gu.REGION == 10}">selected</c:if>>대구광역시</option>
	  	<option value="11"<c:if test="${gu.REGION == 11}">selected</c:if>>경상북도</option>
	  	<option value="12"<c:if test="${gu.REGION == 12}">selected</c:if>>부산광역시</option>
	  	<option value="13"<c:if test="${gu.REGION == 13}">selected</c:if>>울산광역시</option>
	  	<option value="14"<c:if test="${gu.REGION == 14}">selected</c:if>>경상남도</option>
	  	<option value="15"<c:if test="${gu.REGION == 15}">selected</c:if>>강원도</option>
	  	<option value="16"<c:if test="${gu.REGION == 16}">selected</c:if>>제주특별자치도</option>
	   </select>
	   
	   <select class="input inp_duty" name="DUTY">
		<option value="0"<c:if test="${gu.DUTY == 0}">selected</c:if>>희망 직무</option>
	 	<option value="1"<c:if test="${gu.DUTY == 1}">selected</c:if>>경영·사무</option>
	 	<option value="2"<c:if test="${gu.DUTY == 2}">selected</c:if>>마케팅·광고·홍보</option>
	 	<option value="3"<c:if test="${gu.DUTY == 3}">selected</c:if>>IT·인터넷</option>
	 	<option value="4"<c:if test="${gu.DUTY == 4}">selected</c:if>>디자인</option>
	 	<option value="5"<c:if test="${gu.DUTY == 5}">selected</c:if>>무역·유통</option>
	 	<option value="6"<c:if test="${gu.DUTY == 6}">selected</c:if>>영업·고객상담</option>
	 	<option value="7"<c:if test="${gu.DUTY == 7}">selected</c:if>>서비스</option>
	 	<option value="8"<c:if test="${gu.DUTY == 8}">selected</c:if>>연구개발·설계</option>
	 	<option value="9"<c:if test="${gu.DUTY == 9}">selected</c:if>>생산·제조</option>
	 	<option value="10"<c:if test="${gu.DUTY == 10}">selected</c:if>>교육</option>
	 	<option value="11"<c:if test="${gu.DUTY == 11}">selected</c:if>>건설</option>
	 	<option value="12"<c:if test="${gu.DUTY == 12}">selected</c:if>>의료</option>
	 	<option value="13"<c:if test="${gu.DUTY == 13}">selected</c:if>>미디어</option>
	 	<option value="14"<c:if test="${gu.DUTY == 14}">selected</c:if>>전문·특수직</option>
	   </select>
	   
	   <select class="input inp_industry" name="INDUSTRY">
		 <option value="0"<c:if test="${gu.INDUSTRY == 0}">selected</c:if>>희망 산업</option>
		 <option value="1"<c:if test="${gu.INDUSTRY == 1}">selected</c:if>>서비스업</option>
		 <option value="2"<c:if test="${gu.INDUSTRY == 2}">selected</c:if>>금융·은행업</option>
		 <option value="3"<c:if test="${gu.INDUSTRY == 3}">selected</c:if>>IT·정보통신업</option>
		 <option value="4"<c:if test="${gu.INDUSTRY == 4}">selected</c:if>>판매·유통업</option>
		 <option value="5"<c:if test="${gu.INDUSTRY == 5}">selected</c:if>>제조·생산·화학업</option>
		 <option value="6"<c:if test="${gu.INDUSTRY == 6}">selected</c:if>>교육업</option>
		 <option value="7"<c:if test="${gu.INDUSTRY == 7}">selected</c:if>>의료·제약업</option>
		 <option value="8"<c:if test="${gu.INDUSTRY == 8}">selected</c:if>>미디어·광고업</option>
		 <option value="9"<c:if test="${gu.INDUSTRY == 9}">selected</c:if>>문화·예술·디자인업</option>
		 <option value="10"<c:if test="${gu.INDUSTRY == 10}">selected</c:if>>기관·협회</option>
	  </select>
     </div>
    <input id="submitbtn" type="submit" value="수정">
    <input id="submitbtn" type="submit" value="삭제" onclick="history.back()">
    
    </form>
    </div>
  </div>
</body>
</html>