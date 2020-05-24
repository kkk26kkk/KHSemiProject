<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<!-- <script src="http://code.jquery.com/jquery-latest.js"></script> -->
<script src="js/jquery-3.0.0.js"></script>
<link href="css/memberinfo.css" rel="stylesheet" type="text/css">
</head>
<body>
	<form id="memberinfo" action="./memberinfoProcess.gumain" method="post">
		<h1>일반 회원정보 수정</h1>
		<hr>
		<table>
			<tr>
				<td><input type="text" id="gid" name="gid" placeholder="아이디" 
				readOnly value="${gu.GID}"></td>
			</tr>	
					
			<tr>
				<td><input type="text" id="name" name="name" placeholder="이름" 
				required value="${gu.NAME}"></td>
			</tr>
			
			<tr>
				<td><input type="password" id="pw" name="pw" placeholder="패스워드"
				 required value="${gu.PW}"  readOnly></td>
			</tr>
			
			<tr>
				<td><input type="password" id="pass" name="pass" placeholder="패스워드 확인"
				 required >
				 <span id="result"></span>
				 </td>
			</tr>
			
			<tr>
				<td><input type="email" id="email" name="email" placeholder="이메일"
				 required value="${gu.EMAIL}"></td>
			</tr>
			
			<tr>
				<td><input type="number" id="number" name="phone" placeholder="핸드폰"
				 required value="${gu.PHONE}"></td>
			</tr>
		</table>
	  <input type="submit" value="회원수정">
	  <input type="reset" value="취소">
	</form>
	
<script>
$('form').submit(function (){
	var pw = $("#pw").val;
	var pass = $("#pass").val;
	
	if($("#pw").val() != $("#pass").val()){
		alert("비밀번호가 일치하지않습니다.");
		$("#pass").val('');//값 지워줌
		$("#pass").focus();//패스워드 확인에 포커스 줌
	    return false;
	}
});
</script>
</body>
</html>