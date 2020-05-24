<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"
		   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>기업 정보 관리</title>
<style>
  body{
    margin: 0 auto;
  }
</style>
</head>
<body>
<jsp:include page="../../eu/euheader.jsp"/>
<h1>기업 정보 관리</h1>
 ${eu.EID} 님의 취업사이트 회원정보
<hr>
기업이름	${eu.ENAME}<br>
사업자 번호 ${eu.ENUM}<br>
		
<hr>
<c:if test="${empty ep.EID}">

 <form action="./insertinfoform.eumain" method="post">
 	<input type="hidden" name="ENAME" value="${eu.ENAME }">
 	<input type="hidden" name="ENUM" value="${eu.ENUM }">
 	<input type="hidden" name="OWNERNAME" value="${eu.OWNERNAME }">
 	<input type="hidden" name="EADDR" value="${eu.EADDR }">
 	<input type="hidden" name="EADDR1" value="${eu.EADDR1 }">
 	<input type="hidden" name="EADDR2" value="${eu.EADDR2 }">
 	<input type="submit" value="등록">
 </form>
 </c:if>
 <c:if test="${not empty ep.EID }">
 
 <input type="button" value="수정" onClick="location.href='eu/main/updateinfoForm.jsp'"> 
</c:if> 
<%--  <c:if test="${ep.EADDR !empty}">
<input type=button value="취소" onClick="javascript:history.back();"> 
</c:if> --%>
</body>
</html>