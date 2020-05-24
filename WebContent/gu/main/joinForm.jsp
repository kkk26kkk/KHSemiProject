<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>일반회원 가입</title>
<script src="js/jquery-3.0.0.js"></script>
<script src="js/gujoinform.js"></script>
<link href="css/joinForm.css" rel="stylesheet" type="text/css">
</head>
<body>
	<form name="joinForm" action="./joinProcess.gumain" method="post">
		<h1>일반 회원가입</h1>
		<hr>
		<table>
			<tr>
				<td>
				<input type="text" id="name" name="name" placeholder="Name" required>
				</td>
			</tr>
			
			<tr>
				<td>
				<input type="text" id="gid" name="gid" placeholder="ID" required>
				<input type="button" id = "idcheck" value="ID 중복검사" required><br>
				<span id = message></span>
				</td>
			</tr>
			
			<tr>
				<td>
				<input type="password" id="pw" name="pw" placeholder="PASSWORD" required>
				</td>
			</tr>
			
			<tr>
				<td><input type="password" id="pass" name="pass" placeholder="Confirm Password" required></td>
			</tr>
			
			<tr>
				<td>
				<input type="email" id="email" name="email" placeholder="EMAIL" required>
				</td>
			</tr>
			
			<tr>
				<td>
				<input type="text" id="phone" name="phone" placeholder="PHONE" required onKeyup="hypenephone(this);">
				</td>
			</tr>
		</table>	  
				<input type="submit" value="회원가입">
				<input type="reset" value="취소">
	</form>
				<a href="javascript:history.back();">뒤로가기</a>
</body>
</html>