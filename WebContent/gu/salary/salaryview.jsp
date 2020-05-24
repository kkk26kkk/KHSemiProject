<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
   uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>연봉 정보 상세보기</title>
<style>
	form {
    background-color: #fefefe;
    margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
 /*  border: 1px solid #888;  */
    width:950px; /* Could be more or less, depending on screen size */
    padding: 16px ;
	
}

input[type="text"]{
   
	font-size:20px;
	background:#ebeef3;
	border:0px;
	height:57px;
}
textarea{
 width:98%;
	font-size:20px;
background:#ebeef3;
border:0px;
}

#a{
color:orange;
}

#b{
color:#3399ff;
font-size: 12px;
}




</style>


</head>
<body>
<jsp:include page="../../header.jsp" /> 
<c:set var="vo" value="${vo}"/>	
연봉 정보 상세 보기 페이지<br>

<div style="width: 100%; background-color:#ebeef3; padding-bottom:10px; padding-top:10px;">

<form>

<h1 Style="font-size:40px; text-align:center;">회사명: ${vo.ENAME}</h1>
<h2 Style="font-size:30px; color:#9e9e9e;">근무조건</h2>
<hr Style="height:2px;
	background: #ccc;"><br>

<div Style="font-size:20px;" >

<a id="b">◆</a>&emsp;현/전직장
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;

<a id="b">◆</a>&emsp;직무
 &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;

<a id="b">◆</a>&emsp;산업
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;

</div><br><br>

<div >
	<input type="text" value="${vo.CF}" Style="width:30%;">
	<input type="text" value="${vo.DUTY}" Style="width:31%;"> &emsp; 
	<input type="text" value="${vo.INDUSTRY}" Style="width:31%;"> &emsp; 
	</div><br><br>


	
<div Style="font-size:20px;" >

<a id="b">◆</a>&emsp;고용형태
 &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
&emsp;&emsp;

<a id="b">◆</a>&emsp;직급<br><br>

</div>		

<div>
<input type="text" value="${vo.JTYPE }" Style="width:48%;"> &emsp;
<input type="text" value="${vo.RANK }" Style="width:47%;">&emsp;
</div><br><br>	

<div Style="font-size:20px;" >

<a id="b">◆</a>&emsp;경력/신입
 &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
&emsp;&emsp;

<a id="b">◆</a>&emsp;근무지역<br><br>

</div>	

<div>
<input type="text" value="${vo.CAREER }" Style="width:48%;"> &emsp;
<input type="text" value="${vo.REGION }" Style="width:47%;">&emsp;
</div><br><br>	

<h2 Style="font-size:30px; color:#9e9e9e;">연봉정보</h2>
<hr Style="height:2px; 
	background: #ccc;"><br>

<div Style="font-size:20px;" >

<a id="b">◆</a>&emsp;연봉
 &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
&emsp;&emsp;

<a id="b">◆</a>&emsp;성과급<br><br>

</div>		

<div>
<input type="text" value="${vo.SAL }만원" Style="width:48%;"> &emsp;
<input type="text" value="${vo.INCENTIVE }만원" Style="width:47%;">&emsp;
</div><br><br>

</form>
</div>	
	
	
	
	
	
	
	
	
	<%-- <table>
	 <thead>
	 <tr><th colspan="2">회사명:${vo.ENAME}</th></tr>
 </thead>
 <tbody>
 <tr><td>현/전직장</td><td>${vo.CF }</td></tr>
	 <tr><td>직무</td><td>${vo.DUTY }</td></tr>	
     <tr><td>산업</td><td>${vo.INDUSTRY  }</td></tr>	
      
      <tr><td>고용형태</td><td>${vo.JTYPE }</td></tr>	
        <tr><td>직급</td><td>${vo.RANK }</td></tr>	
      <tr><td>경력/신입</td><td>${vo.CAREER }</td></tr>	
      <tr><td>근무지역</td><td>${vo.REGION }</td></tr>	
     <tr><td>연봉</td><td>${vo.SAL }</td></tr>	
		 <tr><td>성과급</td><td>${vo.INCENTIVE }</td></tr>	
	</tbody>
<tfoot>
<tr>
<th colspan="2" style="text-align:right" >
 <a href="./home.gusalary"><input type="button" value="전체목록"></a></th></tr>
</tfoot>
</table>	
 --%>







</body>
</html>