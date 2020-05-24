<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c"
		   uri="http://java.sun.com/jsp/jstl/core" %>
		   
<!DOCTYPE html>
<html>
<head>
<title>취업하JOB</title>
<link rel="stylesheet" href="css/gumain_main.css">
<script src="js/jquery-3.0.0.js"></script>
<style>
  table{
    width: 900px;
  }
</style>
<script>	
$(function(){
	$('#re').click(function(){
		var result=confirm("정말 탈퇴하시겠습니까?");//예 선택시 result값이 true, 아니오 선택시 result값이 false
		if(result){	
			location.href="delete.gumain";
		}
	});
});
</script>

</head>

<jsp:include page="../../header.jsp"/>

<body>
<div id="main">
  <div class="searchArea">
   <p class="searchheader"><strong>직무</strong></p>
   <p class="searchheader"><strong>근무지역</strong></p>
   <p class="searchheader"><strong>경력</strong></p>
   <p class="searchheader"><strong>학력</strong></p>
   <p class="searchheader"><strong>기업형태</strong></p>
   <p class="searchheader"><strong>고용형태</strong></p>
   
   <ul class="shsub">
       <li>경영·사무</li>
       <li>마케팅·광고·홍보</li>
       <li>IT·인터넷</li>
       <li>디자인</li>
       <li>무역·유통</li>
       <li>영업·고객상담</li>
       <li>서비스</li>
       <li>연구개발·설계</li>
       <li>생산·제조</li>
       <li>교육</li>
       <li>건설</li>
       <li>의료</li>
       <li>미디어</li>
       <li>전문·특수직</li>
   </ul>
   
   <ul class="shsub">
       <li>서울특별시</li>
       <li>경기도</li>
       <li>인천광역시</li>
       <li>대전광역시</li>
       <li>세종특별자치시</li>
       <li>충청남도</li>
       <li>광주광역시</li>
       <li>전라남도</li>
       <li>전라북도</li>
       <li>대구광역시</li>
       <li>경상북도</li>
       <li>부산광역시</li>
       <li>울산광역시</li>
       <li>경상남도</li>
       <li>강원도</li>
       <li>제주특별자치도</li>
   </ul>
   
   <ul class="shsub">
       <li>신입</li>
       <li>1~3년</li>
       <li>4~6년</li>
       <li>7~9년</li>
       <li>10~15년</li>
       <li>16~20년</li>
       <li>21년 이상</li>
       <li>경력 무관</li>
   </ul>
   
   <ul class="shsub">
       <li>대학교졸업(4년)</li>
       <li>대학졸업(2,3년)</li>
       <li>고등학교 졸업</li>
       <li>학력무관</li>
   </ul>
   
   <ul class="shsub">
       <li>대기업</li>
       <li>중견기업</li>
       <li>중소기업</li>       
   </ul>
   
   <ul class="shsub">
       <li>정규직</li>
       <li>계약직</li>
       <li>인턴</li>
       <li>파견직</li>       
   </ul>
  </div>
      
  <table border="1">
  <c:forEach var="r" items="${reclist }">
    <tr>
      <td>${r.ENAME }</td>
      <td><a href="./recruitview.gurecruit?eid=${r.EID }&sn=${r.SN}">${r.SUBJECT }</a></td>
      
	  <td>EID: ${r.EID }</td>
	  <td><a href="" 
	  	onclick="window.open('./recruitapply.gurecruit?gid=${gid}&eid=${r.EID}&sn=${r.SN}', 'post', 'width=500, height=500')">
	  	지원하기</a></td>
    </tr>
  </c:forEach>
  </table>
  
  <c:if test="${empty gid }">
    <script>
      $(function(){
          $('#guwrap').css('display', 'block');
          $('#loginuser').css('display', 'none');
      });
	</script>
  </c:if>
  <c:if test="${!empty gid }">
    <script>
      $(function(){
    	  $('#guwrap').css('display', 'none');
          $('#loginuser').css('display', 'block');
      });
    </script>
  </c:if>
  
  <div id="guwrap">
	  <a href="./login.gumain">일반회원 로그인</a>
	
	  <br><br><br>
	  <c:if test="${empty gid}"><!-- 아이디가 없으면 넘어감 -->
         <a href="./join.gumain">회원가입</a>
  	  </c:if>
	  
	  <c:if test="${!empty gid}"><!-- 아이디가 있으면 넘어감 -->
         <a href="#" id="re">탈퇴</a>
 	  </c:if>
  </div>
  
  <div id="logingu">
    ${gid }님 환영합니다.
    <a href="./updateinfo.gumain">정보 수정</a>
	<a href="./logout.gumain">로그아웃</a>
  </div>
  
  <br><br><br>
  
  <div id="euwrap">
      <a href="./login.eumain">기업회원 로그인</a>
      
      <br><br><br>
      <a href="./main.eumain">기업 메인</a>
	  <a href="./join.eumain">회원가입</a>
	  <a href="./updateinfo.eumain">정보 수정</a>
  </div>
  
  <div id="logineu">
    ${eid }님 환영합니다.
    <a href="./logout.eumain">로그아웃</a>
  </div>
</div>

</body>
</html>