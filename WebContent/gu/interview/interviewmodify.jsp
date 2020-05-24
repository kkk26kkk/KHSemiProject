<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>면접 후기 수정</title>
<style>
/* body{

	width:100%;
	background:#ebeef3;
	heigth:1000px;
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
<script src="js/jquery-3.3.1.js"></script>
<script>
  /*  var radio1 = '${vo.JTYPE}';
	
   if(radio1 == '정규직'){
	 alert(radio1);
		 
   }else{

			 alert(radio1);
			 } */
 
$(document).ready(function(){
	
	 var radio = '${vo.CAREER}';  
	 if(radio == '신입') $('.CAREER1').attr('checked','checked');
	 else $('.CAREER2').attr('checked', 'checked');
	
	



})

				
 function onback(){
	alert("이전페이지로 돌아갑니다.");
	location.href="interviewlist.guuser";
}



</script>

</head>
<body>  <jsp:include page="../../header.jsp" /> 	
 
 
 
		<form action="./interviewUpdate.guinterview" method="post">
		
		 <h1 style="text-align:center; font-size:50px;"> 면접후기수정 </h1>
		
		<hr class="hr">
		<br>
		<br>
		<c:set var="vo" value="${vo}"/>	                       
  		
  		<input type="hidden" name="GID" value="${vo.GID }"><br> 
		<input type="hidden" name="SN" value="${vo.SN }"><br>  
	
	
 <label for="ENAME"><span id="a">★</span><span>기업명<br></span></label><br>
 <input type="text" name="ENAME" value="${vo.ENAME }" id="ENAME">
 
 <br>
	<br> 
<h1>근무당시 정보</h1>
   <hr class="hr">
<br>
	 
	 
	 <label><span id="b">●</span><b>직무</b><br></label><br>
   <div class="DUTY1">
   <select name="DUTY" id="DUTY">
		<option value="경영·사무" <c:if test="${vo.DUTY=='경영·사무'}">
	<c:out value="selected"/></c:if>>경영·사무</option>
	<option value="마케팅·광고·홍보" <c:if test="${vo.DUTY=='마케팅·광고·홍보'}">
	<c:out value="selected"/></c:if>>마케팅·광고·홍보</option>
	<option value="IT·인터넷" <c:if test="${vo.DUTY=='IT·인터넷'}">
	<c:out value="selected"/></c:if>>IT·인터넷</option>
	<option value="디자인" <c:if test="${vo.DUTY=='디자인'}">
	<c:out value="selected"/></c:if>>디자인</option>
	<option value="무역·유통"<c:if test="${vo.DUTY=='무역·유통'}">
	<c:out value="selected"/></c:if>>무역·유통</option>
 	<option value="영업·고객상담"<c:if test="${vo.DUTY=='영업·고객상담'}">
	<c:out value="selected"/></c:if>>영업·고객상담</option>
		<option value="서비스"<c:if test="${vo.DUTY=='서비스'}">
	<c:out value="selected"/></c:if>>서비스</option>
	<option value="연구개발·설계"<c:if test="${vo.DUTY=='연구개발·설계'}">
	<c:out value="selected"/></c:if>>연구개발·설계</option>
	<option value="생산·제조"><c:if test="${vo.DUTY=='생산·제조'}">
	<c:out value="selected"/></c:if>생산·제조</option>
	<option value="교육"><c:if test="${vo.DUTY=='교육'}">
	<c:out value="selected"/></c:if>교육</option>
	<option value="건설"><c:if test="${vo.DUTY=='건설'}">
	<c:out value="selected"/></c:if>건설</option>
	<option value="의료"><c:if test="${vo.DUTY=='의료'}">
	<c:out value="selected"/></c:if>의료</option>
		<option value="미디어"><c:if test="${vo.DUTY=='미디어'}">
	<c:out value="selected"/></c:if>미디어</option>
	<option value="전문·특수직"><c:if test="${vo.DUTY=='전문·특수직'}">
	<c:out value="selected"/></c:if>전문·특수직</option>
 	</select>
 	</div><br>
	   
 <label><span id="b" >●</span><b>산업</b><br></label><br>
   <div class="INDUSTRY1"><select name="INDUSTRY" id="INDUSTRY">
             
              <option value="서비스업"<c:if test="${vo.INDUSTRY=='서비스업'}">
	<c:out value="selected"/></c:if>>서비스업</option>
               <option value="금융·은행업"<c:if test="${vo.INDUSTRY=='금융·은행업'}">
	<c:out value="selected"/></c:if>>금융·은행업</option>
              <option value="IT·정보통신업"<c:if test="${vo.INDUSTRY=='IT·정보통신업'}">
	<c:out value="selected"/></c:if>>IT·정보통신업</option>
              <option value="판매·유통업"<c:if test="${vo.INDUSTRY=='판매·유통업'}">
	<c:out value="selected"/></c:if>>판매·유통업</option>
               <option value="제조·생산·화학업"<c:if test="${vo.INDUSTRY=='제조·생산·화학업'}">
	<c:out value="selected"/></c:if>>제조·생산·화학업</option>
                <option value="교육업"<c:if test="${vo.INDUSTRY=='교육업'}">
	<c:out value="selected"/></c:if>>교육업</option>
                <option value="건설업"<c:if test="${vo.INDUSTRY=='건설업'}">
	<c:out value="selected"/></c:if>>건설업</option>
                <option value="의료·제약업"<c:if test="${vo.DUTY=='의료·제약업'}">
	<c:out value="selected"/></c:if>>의료·제약업</option>
                <option value="미디어·광고업"<c:if test="${vo.DUTY=='미디어·광고업'}">
	<c:out value="selected"/></c:if>>미디어·광고업</option>
                <option value="문화·예술·디자인"<c:if test="${vo.DUTY=='문화·예술·디자인'}">
	<c:out value="selected"/></c:if>>문화·예술·디자인</option>
                <option value="기관·협회"<c:if test="${vo.DUTY=='기관·협회'}">
	<c:out value="selected"/></c:if>>기관·협회</option>
              
              </select>
              </div><br>
		       

 <label><span id="b" >●</span><b>고용형태</b><br></label><br>
   <div class="JTYPE3">
<input type="radio" name=JTYPE  value="비정규직 " class="JTYPE1" checked>비정규직   
<input type="radio" name=JTYPE  value="정규직" class="JTYPE2">정규직
</div> <br>


<label><span id="b">●</span><b>신입/경력</b><br></label><br>
   <div>
   <input type="radio" name=CAREER value="신입 " class="CAREER1"  checked><span>신입</span>  &emsp;&ensp;   
	<input type="radio" name=CAREER value="경력" class="CAREER2" ><span>경력</span>  
		</div><br>
		 
 <label><span id="b">●</span><b>근무지역</b><br></label><br>
   <div class="REGION2">
   <select name="REGION">
 <option value="서울특별시" <c:if test="${vo.REGION=='서울특별시'}">
	<c:out value="selected"/></c:if>>서울특별시</option>
<option value="경기도"<c:if test="${vo.REGION=='경기도'}">
	<c:out value="selected"/></c:if>>경기도</option>
<option value="인천광역시"<c:if test="${vo.REGION=='인천광역시'}">
	<c:out value="selected"/></c:if>>인천광역시</option>
<option value="대전광역시"<c:if test="${vo.REGION=='대전광역시'}">
	<c:out value="selected"/></c:if>>대전광역시</option>
<option value="세종특별자치시"<c:if test="${vo.REGION=='세종특별자치시'}">
	<c:out value="selected"/></c:if>>세종특별자치시</option>
<option value="충청남도"<c:if test="${vo.REGION=='충청남도'}">
	<c:out value="selected"/></c:if>>충청남도</option>
<option value="광주광역시"<c:if test="${vo.REGION=='광주광역시'}">
	<c:out value="selected"/></c:if>>광주광역시</option>
<option value="전라남도"<c:if test="${vo.REGION=='전라남도'}">
	<c:out value="selected"/></c:if>>전라남도</option>
<option value="전라북도"<c:if test="${vo.REGION=='전라북도'}">
	<c:out value="selected"/></c:if>>전라북도</option>
<option value="대구광역시"<c:if test="${vo.REGION=='대구광역시'}">
	<c:out value="selected"/></c:if>>대구광역시</option>
<option value="경상북도"<c:if test="${vo.REGION=='경상북도'}">
	<c:out value="selected"/></c:if>>경상북도</option>
<option value="부산광역시"<c:if test="${vo.REGION=='부산광역시'}">
	<c:out value="selected"/></c:if>>부산광역시</option>
<option value="울산광역시"<c:if test="${vo.REGION=='울산광역시'}">
	<c:out value="selected"/></c:if>>울산광역시</option>
<option value="경상남도"<c:if test="${vo.REGION=='경상남도'}">
	<c:out value="selected"/></c:if>>경상남도</option>
<option value="강원도"<c:if test="${vo.REGION=='강원도'}">
	<c:out value="selected"/></c:if>>강원도</option>
<option value="제주특별자치도"<c:if test="${vo.REGION=='제주특별자치도'}">
	<c:out value="selected"/></c:if>>제주특별자치도</option>
</select></div><br><br><br>
		 	 
	 <h1 >면접정보</h1>
     <hr class="hr">
      <br>
      <label><span id="a">★</span><b>난이도</b><br></Label><br>
     <div class="DIFF1">
     <select name="DIFF">
		 	<option value="상"<c:if test="${vo.REGION=='상'}">
	<c:out value="selected"/></c:if>>상</option>
		 	<option value="중"<c:if test="${vo.REGION=='중'}">
	<c:out value="selected"/></c:if>>중</option>
		 	<option value="하"<c:if test="${vo.REGION=='하'}">
	<c:out value="selected"/></c:if>>하</option>
		   </select></div><br>
	
	
	
	<label><span id="a">★</span><b>면접경험</b><br></Label><br>
     <div class="EXP1"><textarea name="EXP" rows="5" cols="45">${vo.EXP }</textarea></div><br>	 
	
	  <label><span id="a">★</span><b>면접질문</b><br></Label><br>
     <div class="QUE1"><textarea name="QUE" rows="5" cols="45">${vo.QUE}</textarea></div><br>
	 
	 <label><span id="a">★</span><b>면접답변</b><br></Label><br>
     <div class="ANS1"><br>
     
     <textarea name="ANS" rows="5" cols="45">${vo.ANS }</textarea></div><br>
	
	 <label><span id="a">★</span><b>채용과정</b><br></Label><br>
	 <input type="text" name="PROC" value="${vo.PROC }" ><br><br>
  
  <label><span id="a">★</span><b>면접날짜</b><br></Label><br>
  <input type="text" name="INTDATE" value="${vo.INTDATE}"><br><br>	 		 
		  
		 		 
		 
	
	
	
	
	  <hr class="hr">
	<input type="submit" value="수정" >
	<input type="reset" value="취소" onclick="onback()">
	

	</form>





</body>
</html>