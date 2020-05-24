<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
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
width: 52px;
}

tbody tr td:nth-child(5){
 width: 55px;
}


tbody tr td:nth-child(2){
width: 118px;
}

tbody tr td:nth-child(1){
	
    width: 400px;

}


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
	 <script src="./js/list.js">    </script>
	  <script>
	  	$(function(){
	  		$("$viewcount").val("${limit}").prop("selected",true);
	  	});
	  </script>



</head>
<body>
<jsp:include page="../../header.jsp" />
<table>
<c:if test="${listcount > 0 }">
	<br><br>
		<h1>나의 연봉정보 게시판</h1><br><br><br>

	<thead>
	<tr>
	
	<th colspan="6"> 
	면접후기 게시판 <div Style="float:right">글 개수 : ${listcount }</div></th>
		
	</tr>
	<tr>
			
			<td Style="text-align:center">기업명</td>			
			<td>직무</td>		
			<td>연봉</td>		
			<td>최종등록날짜</td>		
			<td colspan="2">수정/삭제</td>	
	</tr>		
	</thead>
	
	<tbody>
	<c:set var="num" value="${listcount-(page-1)*limit}"/>	
	<c:forEach var="vo" items="${vo}">	
	<tr>
	 
	  		<%-- <td>
			<c:out value="${num+2}"/>num 출력		
			<c:set var="num" value="${num+1}"/>	num = num - 1 의미	
	  		</td> --%>

			<td>${vo.ENAME}</td>
			<td>${vo.DUTY}</td>
			<td>${vo.SAL}</td>
			<td>${vo.UPT_DTM}</td>
			<td><a href="./salaryInfo.gusalary?GID=${vo.GID}&SN=${vo.SN} ">
		<input type="submit" value="수정"></a></td>
		<td><a href="./salaryDelete.gusalary?GID=${vo.GID}&SN=${vo.SN}">
		<input type="submit" value="삭제"></a></td>	
	</tr>
	</c:forEach>
	</tbody>
	<tfoot>
	<tr class="h30 lime center btn">
		<td colspan="6">			
			<c:if test="${page <= 1 }">
				이전&nbsp;
			</c:if>
			<c:if test="${page > 1 }">			
				 <a href="./salarylist.guuser?page=${page-1}">이전</a>&nbsp;
			</c:if>
					
			<c:forEach var="a" begin="${startpage}" end="${endpage}">
				<c:if test="${a == page }">
					${a}
				</c:if>
				<c:if test="${a != page }">
					<a href="./salarylist.guuser?page=${a}">${a}</a>
				</c:if>
			</c:forEach>
			
			<c:if test="${page >= maxpage }">
				&nbsp;다음 
			</c:if>
			<c:if test="${page < maxpage }">
				<a href="./salarylist.guuser?page=${page+1}">&nbsp;다음</a>
			</c:if>
		</td>
	</tr>
 </tfoot>		
  </c:if>		
 </table> 		
 		<!--  <tr>
		<td colspan="5" style="text-align:right">
	   		<a href="./write.gusalary"><input type="button" value="연봉정보작성">
  		</a></td>
  		
  		 <td colspan="1" style="text-align:right">
  <a href="./home.gusalary" ><input type="button" value="전체목록">
  </a></td> 
  		
		</tr>  -->
 
 


  <c:if test="${listcount == 0 }">
<table>
	<!-- 레코드가 없으면 -->
	   <tr>
		<td colspan="4">연봉정보 게시판</td>
		<td style="text-align:right">
			<font size=2>등록된 글이 없습니다.</font>
		</td>
	  </tr>
	
</table>
	</c:if>

















<%-- <table>
	<tr>
		<td>기업명</td>
		<td>직무</td>
		<td>난이도</td>
		<td>등록날짜</td>
	</tr>
			<c:forEach var="vo" items="${vo}">	
		<tr>
		<td>${vo.ENAME}</td>
		<td>${vo.DUTY}</td>
		<td>${vo.DIFF}</td>
		<td>${vo.RGS_DTM}</td>
		<td><a href="./interviewinfo.guinterview?ENAME=${vo.ENAME}">
		<input type="submit" value="수정"></a></td>
		<td><a href="./interviewDelete.guinterview?ENAME=${vo.ENAME}">
		<input type="submit" value="삭제"></a></td>	
	
	</tr>

		</c:forEach>
</table>



 --%>




</body>
</html>