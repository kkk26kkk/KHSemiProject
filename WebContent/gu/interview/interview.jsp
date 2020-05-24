<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
   uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>면접 후기 상세보기</title>
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


<div style="width: 100%; background-color:#ebeef3; padding-bottom:10px; padding-top:10px;">
<form >

<h1 Style="font-size:40px; text-align:center;">회사명: ${vo.ENAME}</h1>
<!-- 	<hr Style="height:2px; background:black;"><br><br> -->
	

<h2 Style="font-size:30px; color:#9e9e9e;">근무조건</h2>
<hr Style="height:2px;
	background: #ccc;"><br>



<div Style="font-size:20px;" >

<a id="b">◆</a>&emsp;직무
 &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;

<a id="b">◆</a>&emsp;산업
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;

<a id="b">◆</a>&emsp;고용형태
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
 
 </div>
	
	<div >
	<input type="text" value="${vo.DUTY}" Style="width:31%;"> &emsp; 
	<input type="text" value="${vo.INDUSTRY}" Style="width:31%;"> &emsp; 
	<input type="text" value="${vo.JTYPE}" Style="width:30%;">
	</div>
	
<div Style="font-size:20px;" >

<a id="b">◆</a>&emsp;경력/신입
 &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
&emsp;&emsp;
<a id="b">◆</a>&emsp;근무지역

</div>	
	
<div>
<input type="text" value="${vo.CAREER}" Style="width:48%;"> &emsp;
<input type="text" value="${vo.REGION }" Style="width:47%;">&emsp;
</div>	
	
	
	<%-- <div Style="font-size:20px;" ><a id="b">◆</a> &ensp;직무  <br><br>
	<input type="text" value="${vo.DUTY}"> </div><br>
	
	 <div Style="font-size:20px;" ><a id="b">◆</a> &ensp;산업  <br><br>
	<input type="text" value="${vo.INDUSTRY}"> </div><br>
	
	<div Style="font-size:20px;" ><a id="b">◆</a> &ensp;고용형태  <br><br>
	<input type="text" value="${vo.JTYPE}"> </div><br>
	
	<div Style="font-size:20px;" ><a id="b">◆</a> &ensp;경력/신입  <br><br>
	<input type="text" value="${vo.CAREER}"> </div><br>
	
	<div Style="font-size:20px;" ><a id="b">◆</a> &ensp;근무지역  <br><br>
	<input type="text" value="${vo.REGION }"> </div><br>
</div><br><br>

<div>
	--%>
	<h2 Style="font-size:30px; color:#9e9e9e;">면접정보</h2>
<hr Style="height:2px; 
	background: #ccc;"><br>
	
	<div Style="font-size:20px;" ><a id="a">★</a> &ensp;채용과정  <br><br>
	<input type="text" value="${vo.PROC}" Style="width:98%;"> </div><br>
	
	<div Style="font-size:20px;" ><a id="a">★</a> &ensp;면접일자  <br><br>
	<input type="text" value="${vo.INTDATE}" Style="width:98%;"> </div><br>

	<div Style="font-size:20px;" ><a id="a">★</a> &ensp;난이도  <br><br>
	<input type="text" value="${vo.DIFF}" Style="width:98%;"> </div><br>

	
	<div Style="font-size:20px;" ><a id="a">★</a> &ensp;면접경험  <br><br>
	<textarea rows="5" cols="90"> ${vo.EXP }</textarea> </div><br>
	
	<div Style="font-size:20px;" ><a id="a">★</a> &ensp;면접질문  <br><br>
	<textarea rows="5" cols="90">${vo.QUE }</textarea> </div><br>

	<div Style="font-size:20px;" ><a id="a">★</a> &ensp;면접답변  <br><br>
	<textarea rows="5" cols="90">${vo.ANS}</textarea> </div><br> 





</form>

</div>

<%-- 회사명:${vo.ENAME}


직무${vo.DUTY }	

산업${vo.INDUSTRY  }

고용형태${vo.JTYPE }	
  	
경력/신입${vo.CAREER }
근무지역${vo.REGION }

면접경험${vo.EXP }
채용과정${vo.PROC }	
면접질문${vo.QUE }	
답변${vo.ANS }	
난이도${vo.DIFF }	
면접일자${vo.INTDATE }	 --%>     
<!-- <tr>
<th colspan="2" style="text-align:right" >
 <a href="./home.guinterview"><input type="button" value="전체목록"></a></th></tr>
</tfoot>
</table> -->


</body>
</html>