<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<title>기업회원 로그인</title>
</head>
<body>
	<form action = "">
		<table>
			<caption>기업회원 로그인</caption>
			<tr>
				<td>아이디</td>
				<td><input type="text" id="id" name="id" placeholder="아이디" required></td>
			</tr>
			
			<tr>
				<td>비밀번호</td>
				<td><input type="password" id="password" name="password" placeholder="패스워드" required></td>
			</tr>
		</table>
		 <input type="submit" value="로그인"><br>
		 <a href = "">아이디/비밀번호 찾기</a>
		 <a href = "">회원가입</a>
	</form>
</body>
</html>