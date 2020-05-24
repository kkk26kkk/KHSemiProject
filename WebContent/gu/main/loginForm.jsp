<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>일반회원 로그인</title>
<link rel="stylesheet" href="css/loginForm.css">
</head>
<body>
<form name="loginform" action="./loginProcess.gumain" method="post">
	<h1>일반회원 로그인</h1>
	<div>
		<input type="text" name="gid" id="gid"
		 required placeholder="아이디"><br>

		<input type="password" name="pw" id="pw"
		required placeholder="패스워드">
	</div>
	
	<input type="submit" value="로그인"><br>

	<div>
		<section class="gujoin">
			<p class="gujoin_check">
				회원가입을 아직 안하셨어요?
			<a href="join.gumain">회원가입</a>
			</p>
		</section>
	</div>
</form>
</body>
</html>