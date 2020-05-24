<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>공고 상세보기</title>
<link rel="stylesheet" href="css/recruitlist.css">
</head>
<jsp:include page="../../eu/euheader.jsp"/>
<body>
	<h1>공고 자세히 보기</h1>
	<c:set var="r" value="${rec }"/>
	<table border=1>
		<tr>
			<td>
				<div>${r.ENAME}</div>
			</td>
			<td>
				<div>${r.SUBJECT}</div>
			</td>
		</tr>
	</table>
</body>
</html>