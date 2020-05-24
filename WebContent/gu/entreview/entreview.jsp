<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>기업 리뷰 상세보기</title>
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
  
  기업 리뷰 상세보기 페이지<br>
 
<c:set var="vo" value="${vo}"/>
<div style="width: 100%; background-color:#ebeef3; padding-bottom:10px; padding-top:10px;">
<form >
<h1 Style="font-size:40px; text-align:center;">회사명: ${vo.ENAME}</h1>
<h2 Style="font-size:30px; color:#9e9e9e;">근무조건</h2>
<hr Style="height:2px;
	background: #ccc;"><br>

<div Style="font-size:20px;">
<a id="b">◆</a>&emsp;현/전직장
 &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;

<a id="b">◆</a>&emsp;직무
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;

<a id="b">◆</a>&emsp;산업
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;

</div>

<div >
<input type="text" value="${vo.CF}" Style="width:31%;"> &emsp; 
<input type="text" value="${vo.DUTY}" Style="width:31%;"> &emsp; 
<input type="text" value="${vo.INDUSTRY}" Style="width:31%;"> &emsp; 
</div>

<div Style="font-size:20px;" >

<a id="b">◆</a>&emsp;고용형태
 &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;

<a id="b">◆</a>&emsp;신입/경력
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;

<a id="b">◆</a>&emsp;지역
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;

</div>

<div >
	<input type="text" value="${vo.JTYPE}" Style="width:31%;"> &emsp; 
	<input type="text" value="${vo.CAREER}" Style="width:31%;"> &emsp; 
	<input type="text" value="${vo.REGION}" Style="width:30%;">
</div>

<h2 Style="font-size:30px; color:#9e9e9e;">기업리뷰정보</h2>
<hr Style="height:2px;
	background: #ccc;"><br>

<div Style="font-size:20px;" ><a id="a">★</a> &ensp;한줄평  <br><br>
	<input type="text" value="${vo.THINK}" Style="width:98%;"> </div><br>


<div Style="font-size:20px;" ><a id="a">★</a> &ensp;장점  <br><br>
	<input type="text" value="${vo.ADV}" Style="width:98%;"> </div><br>
	
<div Style="font-size:20px;" ><a id="a">★</a> &ensp;단점 <br><br>
	<input type="text" value="${vo.DADV}" Style="width:98%;"> </div><br>	



<div Style="font-size:20px;" ><a id="a">★</a> &ensp;별점 <br><br>
	<input type="text" value="${vo.POINT}점" Style="width:98%;"> </div><br>	

	<div Style="font-size:20px;" ><a id="a">★</a> &ensp;못다한이야기  <br><br>
	<textarea rows="5" cols="90">${vo.STORY}</textarea> </div><br> 
</form>


</div>
<%-- <table>
<thead>
<tr><th colspan="2">회사명${vo.ENAME }</tr>
</thead>
<tbody>
<tr><td>현/전직장</td><td>${vo.CF}</td></tr>
<tr><td>직무</td><td>${vo.DUTY}</td></tr>
<tr><td>산업</td><td>${vo.INDUSTRY}</td></tr>
<tr><td>고용형태</td><td>${vo.JTYPE}</td></tr>
<tr><td>경력</td><td>${vo.CAREER}</td></tr>
<tr><td>지역</td><td>${vo.REGION }</td></tr>

<tr><td>한줄평</td><td>${vo.THINK }</td></tr>
<tr><td>장점</td><td>${vo.ADV}</td></tr>
<tr><td>단점</td><td>${vo.DADV }</td></tr>
<tr><td>별점</td><td>${vo.POINT }</td></tr>
<tr><td>못다한 이야기</td><td>${vo.STORY }</td></tr>
<tr><td>수정일시</td><td>${vo.UPT_DTM }</td></tr>
</tbody>	 --%>


</body>
</html>