<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<title>회원 탈퇴</title>
<script src="js/jquery-3.0.0.js"></script>
</head>
<body>
	<form name="deleteForm" action="./deleteProcess.gumain"
		 method="post" onSubmit="return deletecheck()">
			<div>
			<h3>회원탈퇴 시 기존의 비밀번호를 입력해주세요.</h3>
				<p>아이디</p>
				<input type="text" name="gid" id="gid"
					placeholder="아이디" value="${gid}" readOnly>
			</div>
			
			<div>
				<p>패스워드 확인</p>
				<input type="password" name="pw" id="pw"
					 placeholder="패스워드 확인" required>
			</div>
		<input type="submit" value="회원탈퇴">
	</form>
<script>
function focus(){
	document.deleteForm.pw.focus();
}

function deletecheck(){
	if(!document.deletForm.pass.value){
		alert("비밀번호가 일치하지 않습니다.");
		document.deleteForm.pass.focus();//패스워드 확인에 포커스 줌
		return false;
	}
};
</script>
</body>
</html>