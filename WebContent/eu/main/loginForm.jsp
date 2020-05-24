<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>기업회원 로그인</title>
<link rel="stylesheet" href="css/euloginForm.css">
</head>
<body>
<form action="./loginProcess.eumain" method="post">
  <h1>기업회원 로그인</h1>
	<div>
		<input type="text" name="EID" id="EID"
		 required placeholder="아이디"><br>

		<input type="password" name="PW" id="PW"
		required placeholder="패스워드">
	</div>
  
 	<input type="submit" value="로그인">
 
 	<div>
		<section class="eujoin">
			<p class="eujoin_check">
				회원가입을 아직 안하셨어요?
			<a href="join.eumain">회원가입</a>
			</p>
		</section>
	</div>
</form>
</body>
</html>