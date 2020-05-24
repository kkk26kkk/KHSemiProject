<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>글 수정</title>

<style>
body {
margin: 50px;
}
form{
margin: 0px;
}
p {
	margin: 0px;
	padding: 20px 0px;
	text-align: center;
	text-transform: uppercase;
	font-family: "Arial Black", sans-serif;
	font-size: 60px;
	font-weight: bold;
}


.header {
	padding: 30px;
	text-align: center;
	color:#3399ff; 
	text-shadow: 4px 4px 0px #bdbdbd;
}


textarea{
width: 600px; height:300px; 
}
</style>
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>
	<p class="header">문의사항 수정</p>

	<form  action="./boardModify.FA" method="post" name="modifyform"
		 >

		<input type="hidden" name="num" value="${boarddata.SN}">
	
		<table width="1000px" border="3" bordercolor="lightgray" align="center">
			<tr>
				<td id="title">작성자</td>
				<td><input name="USERID" type="text" value="${boarddata.USERID}" readonly ></td>
			</tr>
			<tr>
				<td>제 목</td>
				<td><input name="SUBJECT" type="text" size="70" maxlength="100"
					value="${boarddata.SUBJECT}" /></td>
			</tr>
			<tr>
			<td>비밀번호</td>
			<td><input name="PASS" type="password"></td>
				
			</tr>
			<tr>
				<td>내 용</td>
				<td><textarea name="CONTENT" cols="72" rows="20">${boarddata.CONTENT}
                </textarea></td>
			</tr>


			<tr align="center" valign="middle">
				<td colspan="5"><input type="reset" value="작성취소">
				 <input
					type="submit" value="수정"> 
					<input type="button" value="목록" onclick="history.go(-1)"></td>
			</tr>
		</table>
	</form>

</body>
</html>



