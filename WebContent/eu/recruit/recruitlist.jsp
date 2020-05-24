<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>공고 관리</title>
<link rel="stylesheet" href="css/recruitlist.css">
</head>
<body>
<jsp:include page="../../eu/euheader.jsp"/>
<div id="reclistwrap">
<div class="head"><h2>공고 관리</h2></div>
<div id="reclistcontainer">
<table>
	<c:if test="${listcount > 0}">
	<tr>
		<th colspan="3">공고관리 리스트</th>
		<th colspan="2">
<%-- 			<font size=2>글 개수 : ${listcount}</font> --%>
	</tr>
	<tr>
		<td><span><strong>공고 제목</strong></span></td>
		<td><span><strong>모집 분야</strong></span></td>
		<td><span><strong>담당 업무</strong></span></td>
		<td><span><strong>등록 날짜</strong></span></td>
		<td><span><strong>상세 보기</strong></span></td>
	</tr>
	
	<c:set var="num" value="${listcount-(page-1)*10}"/>
	<c:forEach var="r" items="${reclist}">
		<tr>
			<td>${r.SUBJECT}</td>
			<td>${r.KIND}</td>
			<td>${r.JOB}</td>
			<td>${r.RGS_DTM}</td>
			<td><input id="detbtn" type="button" value="상세 보기" onClick="location.href='./recruitview.gurecruit?eid=${r.EID }&sn=${r.SN}'"></td>	
		</tr>
	</c:forEach>
		<tr>
		<td colspan=5 class="td5">			
			<c:if test="${page <= 1 }">
				이전&nbsp;
			</c:if>
			<c:if test="${page > 1 }">			
				 <a href="./recruitlist.eurecruit?page=${page-1}">이전</a>&nbsp;
			</c:if>
					
			<c:forEach var="a" begin="${startpage}" end="${endpage}">
				<c:if test="${a == page }">
					${a}
				</c:if>
				<c:if test="${a != page }">
					<a href="./recruitlist.eurecruit?page=${a}">${a}</a>
				</c:if>
			</c:forEach>
			
			<c:if test="${page >= maxpage }">
				&nbsp;다음 
			</c:if>
			<c:if test="${page < maxpage }">
				<a href="./recruitlist.eurecruit?page=${page+1}">&nbsp;다음</a>
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
	  <tr>
		<td colspan="5" style="text-align:right">
	   		<a href="./recruitwrite.eurecruit" class="abtn">공고 등록</a>
		</td>
	</tr>
</table>
</div>
</div>
</body>
</html>