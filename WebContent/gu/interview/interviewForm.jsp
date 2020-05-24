<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>면접 후기 작성</title>
<style>
/* body{

	width:100%;
	background:#ebeef3;
} */

form {
    background-color: #fefefe;
    margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
 /*  border: 1px solid #888;  */
    width: 50%; /* Could be more or less, depending on screen size */
    padding: 16px ;
	
}
	textarea{
	border: 2px solid #fefefe;
    background:#ebeef3 ;
	width:99%;
	}
  input[type="text"]{
     width: 99%;
     border: 2px solid #fefefe; 
    height: 48px;
    background: #ebeef3 ;
	
}
 
 input[type="submit"]{
width:49%;
 height: 56px;
 background: #ffe2008f;
    padding: 0px;
    border: 0px;
 }
  input[type="reset"]{
 	width:49%;
	height: 56px;
 	 
    background-color: #ffa2006b;
    padding: 0px;
    border: 0px;
 }
  
select{
width: 99%;
    height: 45px;
background: #9e9e9e40 ;
}

option{
	font-size:15px;
}

#a{
 position: relative;
    top: 3px;
    left: -4px;
    color: #ff6633;
    font-size: 17px;
    font-weight: bold;
    display: inline-block;
}

#b{

font-size: 12px;
}
.hr{
	height:2px;
	background: #ccc;

}


</style>

<!-- <link href="css/interviewform.css" rel="stylesheet" type="text/css" > -->
<script src="js/jquery-3.3.1.js" ></script>
<script src="js/interview.js" charset="UTF-8"></script> 



</head>
<body>
  <jsp:include page="../../header.jsp" />  
      
   
   <form action="interviewApply.guinterview" method="post">
<%--    일반회원 ID<input type="text" name="GID" value="${gid }" readonly><br> --%>
  
 <!--  <fieldset>폼양식을 그룹핑하는 범위를 지정		

   <legend style="font-size:30px; text-align:center">
  면접후기 작성
   </legend> -->

  
   
   <input type="hidden" name="GID" value="${gid }">
  
  
  <h1 style="text-align:center; font-size:50px;"> 면접후기작성 </h1>
  
 <hr class="hr">
	<br>
	<br>
   <label for="ENAME" ><span id="a">★</span><span>기업명<br></span></label><br>
 <input type="text" name="ENAME" id="ENAME" placeholder="기업명을 입력하세요">
 
 <br>
   <br>
   <h1>근무 조건</h1>
   <hr class="hr">
<br>
	
   <label><span id="b">●</span><b>직무</b><br></label><br>
   <div class="DUTY1">
   <select name="DUTY" id="DUTY">
    <option value="">직무를 선택하세요</option>
              <option value="경영·사무">경영·사무</option>
               <option value="마케팅·광고·홍보">마케팅·광고·홍보</option>
              <option value="IT·인터넷">IT·인터넷</option>
              <option value="디자인">디자인</option>
              <option value="무역·유통">무역·유통</option>
              <option value="영업·고객상담">영업·고객상담</option>
                <option value="서비스">서비스</option>
                <option value="연구개발·설계">서비스</option>
                <option value="생산·제조">생산·제조</option>
                <option value="교육">교육</option>
                <option value="건설">건설</option>
                <option value="의료">의료</option>
                <option value="미디어">미디어</option>
                <option value="전문·특수직">전문·특수직</option>
              </select>
		 	</div><br>	 
		    
	 <label><span id="b" >●</span><b>산업</b><br></label><br>
   <div class="INDUSTRY1"><select name="INDUSTRY" id="INDUSTRY">
           <option value="">산업을 선택하세요</option>
              <option value="서비스업">서비스업</option>
               <option value="금융·은행업">금융·은행업</option>
              <option value="IT·정보통신업">IT·정보통신업</option>
              <option value="판매·유통업">판매·유통업</option>
               <option value="제조·생산·화학업">제조·생산·화학업</option>
                <option value="교육업">교육업</option>
                <option value="건설업">건설업</option>
                <option value="의료·제약업">의료·제약업</option>
                <option value="미디어·광고업">미디어·광고업</option>
                <option value="문화·예술·디자인업">문화·예술·디자인업</option>
                <option value="기관·협회">기관·협회</option>
              
              </select>
             </div><br>

         
    <label><span id="b" >●</span><b>고용형태</b><br></label><br>
   <div class="JTYPE3">
<input type="radio" name=JTYPE id="JTYPE1" value="비정규직" >비정규직 
 <input type="radio" name=JTYPE id="JTYPE2" value="정규직">정규직
       </div><br>
    
    <label><span id="b">●</span><b>신입/경력</b><br></label><br>
   <div class="CAREER3">
    <input type="radio" name=CAREER id="CAREER1" value="신입" checked>신입    &emsp;&ensp;
        <input type="radio" name=CAREER   id="CAREER2" value="경력">경력
    </div><br>
    
  <label><span id="b">●</span><b>근무지역</b><br></label><br>
   <div class="REGION2">
   <select name="REGION" id="REGION">
                <option value="">지역을 선택하세요</option>
                <option value="서울특별시">서울특별시</option>
                <option value="경기도">경기도</option>
                <option value="인천광역시">인천광역시</option>
                <option value="대전광역시">대전광역시</option>
                <option value="세종특별자치시">세종특별자치시</option>
                <option value="충청남도">충청남도</option>
                <option value="광주광역시">광주광역시</option>
                <option value="전라남도">전라남도</option>
                <option value="전라북도">전라북도</option>
                <option value="대구광역시">대구광역시</option>
                <option value="경상북도">경상북도</option>
                <option value="부산광역시">부산광역시</option>
                <option value="울산광역시">울산광역시</option>
                <option value="경상남도">부산</option>
                <option value="강원도">강원도</option>
                <option value="제주특별자치도">제주특별자치도</option>
           </select>
     </div><br><br><br>
     
     <h1 >면접정보</h1>
     <hr class="hr">
      <br>
      <label><span id="a">★</span><b>난이도</b><br></Label><br>
     <div class="DIFF1">
     <select name="DIFF" id="DIFF">
              <option value="">난이도를 선택하세요</option>
              <option value="상">상</option>
               <option value="중">중</option>
              <option value="하">하</option>
         </select>
   </div><br>  
   
    <label><span id="a">★</span><b>면접경험</b><br></Label><br>
     <div class="EXP1">
    <textarea name="EXP" rows="5" cols="90" id="EXP" ></textarea>
   	</div><br>
    
  
    <label><span id="a">★</span><b>면접질문</b><br></Label><br>
     <div class="QUE1"><textarea name="QUE" rows="5" cols="90" id="QUE"></textarea>
   	</div><br>
  <label><span id="a">★</span><b>면접답변</b><br></Label><br>
     <div class="ANS1">
     <textarea name="ANS" rows="5" cols="90" id="ANS"></textarea>
   	</div><br>
  <label><span id="a">★</span><b>채용과정</b><br></Label><br>
    <input type="text" name="PROC"  id="PROC"><br><br>
  
  <label><span id="a">★</span><b>면접날짜</b><br></Label><br>
  <input type="text" name="INTDATE" id="INTDATE"><br><br>  
       
     <hr class="hr">
 	<input type="submit" value="제출">
   <input type="reset" value="취소">


   </form>

</body>
</html>