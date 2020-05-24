<%--답변작성 폼 입니다 --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
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
width: 800px; height:300px; 
}
</style>
<script src="http://code.jquery.com/jquery-latest.js"></script>

</head>
<body>
	<jsp:include page="/header.jsp"></jsp:include>
	
	<p class="header">답변 게시판</p>
	<form action="./boardReply.FA" method="post" name="boardform">
		<input type="hidden" name="SN" value="${boarddata.SN }"> <input
			type="hidden" name="RE_REF" value="${boarddata.RE_REF }"> <input
			type="hidden" name="RE_LEV" value="${boarddata.RE_LEV }"> <input
			type="hidden" name="RE_SEQ" value="${boarddata.RE_SEQ }">

		<table width="900px" border="3" bordercolor="lightgray" align="center">
			<tr>
				<td><div>작성자</div></td>
				<td><input name="USERID" id="name" type="text" 
				value="${boarddata.USERID }" size="20" maxlength="100">
				</td>
			</tr>
			<tr>
				<td><div>제목</div></td>
				<td><input name="SUBJECT" id="subject" type="text"
					value="RE: ${boarddata.SUBJECT}"></td>
			</tr>
			<tr>
				<td><div>내용</div></td>
				<td><textarea name="CONTENT" id="content" type="text" cols="72"
						rows="20"></textarea>
			</tr>
			<tr>
				<td>
					<div>비밀번호</div>
				</td>
				<td><input name="PASS" id="pass" type="password"></td>
			</tr>
			<tr class="center">
				<td colspan="2" class="h30 lime"><input type=submit value="등록">
					<input type=button value="취소" onClick="history.go(-1)"></td>
			</tr>
		</table>
	</form>

</body>
</html>