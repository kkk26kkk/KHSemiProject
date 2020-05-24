<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>기업 회원가입 페이지</title>
<script src="js/jquery-3.0.0.js"></script>
<script src="js/eujoinform.js"></script>
<link href="css/eujoinForm.css" rel="stylesheet" type="text/css">
</head>
<body>
<form action="./joinProcess.eumain" method="post">
	<h1>기업 회원가입</h1>
	<hr>
	<table>
		<caption><strong>기업 정보</strong></caption>
		<tr>
			<td><input type="text" id="ename_co" name="ENAME" placeholder="회사명" required></td>	
		</tr>

		<tr>
			<td><input type="text" id="enum" name="ENUM" placeholder="사업자번호"
			  maxlength="12" required onKeyup="hypenenum(this);"></td>
		</tr>
			
		<tr>
			<td><input type="text" id="ownername" name="OWNERNAME" placeholder="대표자명"
			  maxlength="13" required></td>	
		</tr>
		
		<tr>
			<td><input type="text" id="eaddr" name="EADDR" placeholder="회사주소" required><input id="addrbtn"
			 type="button"onClick="goPopup();" value="주소검색"/></td>
		</tr>
			
<!-- 		<tr> -->
<!-- 			<td><input type="text" id="enumber" name="enumber" placeholder="대표 전화번호" -->
<!-- 				 maxlength="13" required onKeyup="hypenenumber(this);"></td> -->
<!-- 		</tr> -->
	</table>
	 <input type="hidden" id="eaddr1" name="EADDR1" placeholder="회사주소1">
	 <input type="hidden" id="eaddr2" name="EADDR2" placeholder="회사주소2">
  
 	 <table>
			<caption><strong>인사담당자 정보</strong></caption>
		<tr>
			<td><input type="text" id="ename" name="HRDNAME" placeholder="NAME" required></td>
		</tr>
			
		<tr>
			<td><input type="text" id="eid" name="EID" placeholder="ID" required>
			<input type="button" id = "idcheck" value="ID 중복검사" required><br>
			<span id = message></span>
		</tr>
			
		<tr>
			<td><input type="password" id="epw" name="PW" placeholder="PASSWORD" required></td>
		</tr>
			
		<tr>
			<td><input type="password" id="epass" name="epass" placeholder="Confirm Password" required></td>
		</tr>
			
		<tr>
			<td><input type="email" id="eemail" name="EMAIL" placeholder="EMAIL" required></td>
		</tr>
			
		<tr>
			<td><input type="text" id="ephone" name="PHONE" placeholder="PHONE"
				 	maxlength="13" required onKeyup="hypenephone(this);"></td>
		</tr>
	</table>
  
		<input type="submit" value="회원가입">
		<input type="reset" value="취소">
		
		<div>
			<section class="eulogin">
				<p class="eulogin_check">
					<b>이미 회원이세요?</b>
				<a href="join.eumain">로그인</a>
				</p>
			</section>
		</div>
</form>
</body>
</html>