<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>지원자 관리</title>
<link rel="stylesheet" href="css/list.css">
</head>
<body>
<jsp:include page="../../eu/euheader.jsp"/>
<div id="applistwrap">
<div class="head"><h2>지원자 관리</h2></div>
<div id="applistcontainer">
 <table>
	<c:if test="${listcount > 0}">
 		<tr> 
 			<th colspan="3">지원자 관리 리스트</th> 
 			<th colspan="2"> 
<%-- 				<font size=2>글 개수 : ${listcount}</font> --%>
 		</tr> 
 		<tr>  
 			<td><span><strong>공고 제목</strong></span></td> 
 			<td><span><strong>지원자명</strong></span></td> 
 			<td><span><strong>이력서</strong></span></td> 
 			<td><span><strong>등록날짜</strong></span></td> 
 			<td><span><strong>자세히 보기</strong></span></td> 
 		</tr> 
		<c:set var="num" value="${listcount-(page-1)*10}"/>
		<c:forEach var="a" items="${applicantlist}">
 			<tr> 
				<td>${a.SUBJECT}</td>
				<td>${a.NAME}</td>
				<td>${a.DUTY}</td>
				<td>${a.RGS_DTM}</td>
				<td><input type="button" value="자세히 보기" onClick="location.href='./personview.euperson?gid=${a.GID}&sn=${a.SN}'"></td>
 			</tr> 
		</c:forEach>
 			<tr> 
 				<td colspan=5>			 
					<c:if test="${page <= 1 }">
 					이전&nbsp; 
		</c:if>
			<c:if test="${page > 1 }">			
				 <a href="./applicantlist.eurecruit?page=${page-1}">이전</a>&nbsp;
			</c:if>
					
			<c:forEach var="a" begin="${startpage}" end="${endpage}">
				<c:if test="${a == page }">
					${a}
				</c:if>
				<c:if test="${a != page }">
					<a href="./applicantlist.eurecruit?page=${a}">${a}</a>
				</c:if>
			</c:forEach>
		
			<c:if test="${page >= maxpage }">
 				&nbsp;다음  
			</c:if>
			<c:if test="${page < maxpage }">
				<a href="./applicantlist.eurecruit?page=${page+1}">&nbsp;다음</a>
			</c:if>
 		</td> 
	</tr> 
</c:if>

<c:if test="${listcount == 0 }">
    <tr> 
 		<td colspan="4">공고관리 리스트</td> 
 		<td style="text-align:right"> 
 		<font size=2>등록된 글이 없습니다.</font> 
 		</td> 
   	</tr> 
</c:if>
 </table>
</div>
</div>
</body>
</html>