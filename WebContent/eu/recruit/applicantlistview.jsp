<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="a" value="${res}"/>
<!DOCTYPE html>
<html>
<head>
<title>${a.SUBJECT}</title>
</head>
<jsp:include page="../../eu/euheader.jsp"/>
<body>
	<h1>지원자 이력서 자세히 보기</h1>
	
	<h3>${a.NAME} 의 이력서</h3>
	<hr>
	<span>이력서 제목 : ${a.SUBJECT}</span>
	<br>
	<span>이력서 이름 : ${a.NAME}</span>
	<br>
	<span>${a.BIRTH}</span>
	<br>
	${a.GENDER}
	<br>
	${a.EMAIL}
	<br>
	${a.PHONE}
	<br>
	${a.ADDR}
	<br>
	${a.PHOTO}
	<br>
	${a.STYPE}
	<br>
	${a.SDOA}
	<br>
	${a.SDOG}
	<br>
	${a.MAJOR}
	<br>
	${a.GRADE}
	<br>
	${a.ENAME}>
	<br>
	${a.DEPT}
	<br>
	${a.DOA}
	<br>
	${a.DOG}
	<br>
	${a.RANK}
	<br>
	${a.JTYPE}
	<br>
	${a.DESSAL}
	<br>
	${a.REGION}
	<br>
	${a.DUTY}
	<br>
	${a.INDUSTRY}
	<br>
		<input type=button value="취소" onClick="javascript:history.back();">
</body>
</html>