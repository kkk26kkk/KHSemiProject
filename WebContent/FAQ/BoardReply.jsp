<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<script src="js/jquery-3.0.0.js"></script>
<script src="js/writeform.js" charset="UTF-8"></script>

<style>
body {
	margin: auto;
}

#resumeWraper {
	position: relative;
	width: 100%;
	height: 1200px;
	background: #ebeef3;
}

h1 {
	padding: 30px;
	text-align: center;
	color: #3399ff;
	text-shadow: 4px 4px 0px #bdbdbd;
	font-size: 68px;
}

.form {
	position: relative;
	width: 900px;
	height: 100px;
	margin: 0 auto;
	padding: 20px 20px 10px;
	background-color: #fff;
	border: 1px solid #dbe0e9;
	-webkit-box-sizing: border-box;
	box-sizing: border-box;
	padding: 20px 20px 10px;
}

.form1 {
	position: relative;
	width: 900px;
	height: 800px;
	margin: 0 auto;
	padding: 20px 20px 10px;
	background-color: #fff;
	border: 1px solid #dbe0e9;
	-webkit-box-sizing: border-box;
	box-sizing: border-box;
}

#but {
	margin: 0 auto;
	background-color: DodgerBlue;
	border: none;
	color: white;
	padding: 12px 30px;
	cursor: pointer;
	font-size: 20px;
	background-color: DodgerBlue;
	background-color: DodgerBlue;
}

.input {
	position: relative;
	display: inline-block;
	zoom: 1;
	*display: inline;
	width: 160px;
	height: 62px;
	margin-bottom: 10px;
	margin-right: 10px;
	border: 1px solid #ddd;
	-webkit-box-sizing: border-box;
	box-sizing: border-box;
	vertical-align: top;
	text-align: left;
	background-color: #fff;
	padding: 8px;
	letter-spacing: -1px;
	font-size: 15px;
}

#USERID {
	width: 232px;
	height: 50px;
	font-size: 30px;
}

#pass {
	width: 205px;
	height: 47px;
	border-right-width: 0px;
	font-size: 30px;
}

#subject {
	width: 850px;
	height: 41px;
}

#content {
	margin: 0px;
	width: 850px;
	height: 476px;
}

#upfile {
	width: 370px;
}

#button {
	margin: 0 auto;
	width: 250px;
	padding-top: 10px
}
</style>
</head>
<body>
	<jsp:include page="/header.jsp"></jsp:include>


	<div id="resumeWraper">
		<form action="./boardReply.FA" method="post" name="boardform">
			<input type="hidden" name="SN" value="${boarddata.SN }"> <input
				type="hidden" name="RE_REF" value="${boarddata.RE_REF }"> <input
				type="hidden" name="RE_LEV" value="${boarddata.RE_LEV }"> <input
				type="hidden" name="RE_SEQ" value="${boarddata.RE_SEQ }">

			<h1>답변 게시판</h1>
			<div class="form1">
				<h3>작성자</h3>
				<input name="USERID" id="USERID" type="text" size="20"
					maxlength="100" value="${boarddata.USERID}" readonly> <input
					type="password" name="PASS" id="pass">
				<h3>제목</h3>
				<div id="divinp">
					<input type="text" name="SUBJECT" id="subject"
						value="">
				</div>
				<h3>내용</h3>
				<div class="ta">
					<textarea id="content" name="CONTENT"></textarea>
				</div>
			</div>
			<div id="button">
				<input type=submit id="but" value="등록"> <input type="button"
					id="but" onclick="history.back();" value="취소">
			</div>
		</form>
	</div>


</body>
</html>