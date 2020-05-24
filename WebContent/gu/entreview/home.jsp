<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>기업 리뷰</title>
<style>
	#books {
		boarder-collapse:collapse; width:500px; margin: 0 auto; text-align:center;
	}

  body{
    text-align: center;
  }
  table{
    margin: auto;
 border:0px;
  width: 925px;
 border-collapse:collapse;
    
  }
thead,tfoot{
background-color:#CEECF5;  
}
tbody {
/* background-color:#F2F2F2; */
}

thead tr td:nth-child(1){
width: 60px;
text-align:center;
}
thead tr td{
text-align:left;
}
tbody tr td:nth-child(1){
width: 60px;
text-align:center;
}

tbody tr td{
	border-collapse:seperate;
text-align:left;
}

thead tr{
border-top: 1px solid #F2F2F2;
border-bottom: 1px solid #F2F2F2;
}


tbody tr td:nth-child(6){
width: 77px;
}

tbody tr td:nth-child(5){
width: 140px;
}

tbody tr td:nth-child(4){
width:79px;
}
tbody tr td:nth-child(3){
width:137px;
}
/* tbody tr td:nth-child(1){
width:374px;
} */

tbody tr td{

   height:72px;

}

tbody :hover{
background:#ebeef3;
}

input[type="submit"]{
background-color:#3399ff;   
   height:34px;
color:white;
border:0px;
}
input[type="submit"]:hover{
	background-color:#3399ffa3; 
}

</style>
<script src="./js/jquery-3.3.1.js"></script>
<!-- <script src="./js/list.js"></script> -->
<script src="./js/entreview_json.js"></script>
<!-- <style>
table, th, td {
 
 	text-align:center;
 	margin:0 auto;
 	padding: 10px;
 	
 }
tr:nth-child(odd) {background-color: #f2f2f2;}
th, td {
  padding: 8px;
  text-align: left;
  border-bottom: 1px solid black;
}
table {
   border-collapse: collapse;
 }
</style> -->

<script>
$(document).ready(function(){
	$("#button2").click(function(){
		 var senddata = $("#ENAME").val();	
		

		
		 $.ajax({
			 type : "POST",
	         data : {"ename" : senddata},
	         url : "entreviewSelect.guentreview",
	         dataType : 'json',
	         success : function(rdata){
	        	 
	             var output = '';
	         $(rdata).each(function(index,item){
	        	    output += '<tr>';
	                output += ' <td>' + item.ENAME + "</td>";
	                output += '<td>' + item.DUTY + '</td>';
	                output += '<td>' + item.REGION + '</td>';
	                output += '<td>' + item.UPT_DTM + '</td>';
	               
	               
 /* output += '<td>' +'<a href="./entreviewDetail2.guentreview?ENAME='
		+item.ENAME+'&REGION='+item.REGION+'">'+'상세보기'+'</a>'+'</td>';  */
		
		
	                
	                
	                
	                /* output +='<td><a href="./entreviewDetail2.guentreview?ENAME='+item.ENAME+'>'+기업명+'</a></td>';	    */
	            	output += '</tr>'

	         })    		
	         $('#output').empty();
	         $('.list').remove();
	         $('#output').append(output);

	        	 '기업명'
	         }
			 
			 
	       
			 
		
		 
		 
		 
		 })
		 
		
		
		
		
	})
})

/* $(document).ready(function(){
	$("#button2").click(function(){
		 var senddata = $("#ENAME").val();	
		 alert(senddata);

		
		 $.ajax({
			 type : "POST",
	         data : {"ename" : senddata},
	         url : "entreviewSelect.guentreview",
	         dataType : 'json',
	         success : function(rdata){
	        	 
	             var output = '';
	         $(rdata).each(function(index,item){
	        	    output += '<tr>';
	                output += ' <td>' + item.ENAME + "</td>";
	                output += '<td>' + item.DUTY + '</td>';
	                output += '<td>' + item.REGION + '</td>';
	                output += '<td>' + item.UPT_DTM + '</td>';
	                output += '</tr>'

	         })    		
	         $('#output').empty();
	         $('#output').append(output);

	        	 
	         }
			 
			 
			 
			 
		 })
		 
		
		
		
		
	})
}) */


</script>








</head>
<body>
<jsp:include page="../../header.jsp" /> 
<input type="text" name="ENAME" value="SAMSUNG1" id="ENAME" >
	<input type="button" id="button2" value="검색" >

<table class="list">
<c:if test="${listcount > 0 }">
	<br><br>
		<h1>기업 리뷰 게시판</h1><br><br><br>
	
	
	
	
	
	
	<thead>
	
	<tr>
		<th colspan="6">기업리뷰 게시판 <div Style="float:right">글 개수 : ${listcount }</div></th>
		
	</tr>
	
	<tr>
			
			<td>번호</td>	
			<td>기업명</td>		
			<td>직무</td>		
			<td>지역</td>		
			<td>등록날짜</td>		
			<td colspan="2">상세보기</td>	
	</tr>		
	</thead>
	
	<tbody>
	<c:set var="num" value="${listcount-(page-1)*limit}"/>	
	<c:forEach var="vo" items="${vo}">	
	<tr>
	  <td>
		<c:out value="${num}"/><%-- num 출력 --%>		
		<c:set var="num" value="${num-1}"/>	<%-- num = num - 1 의미--%>	
	  
	  </td>
	 		<td>${vo.ENAME}</td>
			 <td>${vo.DUTY}</td>
			<td>${vo.REGION}</td>
			<td>${vo.UPT_DTM}</td> 
			<td><a href="./entreviewDetail.guentreview?GID=${vo.GID}&SN=${vo.SN}">
		<input type="submit" value="상세보기"></a></td>
		
	</tr>
	</c:forEach>
		

	<tr class="h30 lime center btn">
		<td colspan=6>			
			<c:if test="${page <= 1 }">
				이전&nbsp;
			</c:if>
			<c:if test="${page > 1 }">			
				 <a href="./home.guentreview?page=${page-1}">이전</a>&nbsp;
			</c:if>
					
			<c:forEach var="a" begin="${startpage}" end="${endpage}">
				<c:if test="${a == page }">
					${a}
				</c:if>
				<c:if test="${a != page }">
					<a href="./home.guentreview?page=${a}">${a}</a>
				</c:if>
			</c:forEach>
			
			<c:if test="${page >= maxpage }">
				&nbsp;다음 
			</c:if>
			<c:if test="${page < maxpage }">
				<a href="./home.guentreview?page=${page+1}">&nbsp;다음</a>
			</c:if>
		</td>
	</tr>
 </tbody>
 </c:if>
  
  </table>
  
  
  <table>
  		<thead>
  		<tr>
  		<th colspan="4">기업별</th>
  			</tr>
  		<tr>
  			<td>기업명</td>
  			<td>직무</td>
  			<td>지역</td>
  			<td>최종수정날짜</td>
  		</tr>
  		
  		
  		</thead>
  		<c:set var="vo" value="${vo}"/>
  		<tbody id="output">
  		
  		
  
  		<%-- <tr><td><a href="./entreviewDetail.guentreview?GID=${vo.GID}&SN=${vo.SN}">
		<input type="submit" value="상세보기"></a></td></tr> --%>
  		</tbody>
  		
  
  
  </table>
  
  
  
  
  
  
  <!-- table>
		<thead><tr><th>기업리뷰</th></tr>
		</thead>
		
		<tbody>
		<tr><td>
	   		
		  <select id="ENAMESELECT">
	   		   
	   		   <option value="카카오" selected>카카오</option>
	   		<option value="삼성">삼성</option>
	   		   <option value="두산">두산</option>
	   		   <option value="LG">LG</option>
	   		   <option value="SKT">SKT</option>
	   		  </select>
		
		</td></tr>
	   	</tbody>	  
		<tfoot>
		
		
		</tfoot>
</table> -->

<!-- <form action="home.guentreview" method="post">
<table>
<tr><td><input type="text" name="ENAME" >
<input type="button" value="검색" id="ENAMESELECT"></td></tr>
</table>
</form> -->

<table>

</table>


  <c:if test="${listcount == 0 }">
<table>
	<!-- 레코드가 없으면 -->
	   <tr>
		<td colspan="4">기업리뷰 게시판</td>
		<td style="text-align:right">
			<font size=2>등록된 글이 없습니다.</font>
		</td>
	  </tr>
</table>
	</c:if>
	 

		


</body>
</html>