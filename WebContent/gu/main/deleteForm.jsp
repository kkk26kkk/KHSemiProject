<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<title>ȸ�� Ż��</title>
<script src="js/jquery-3.0.0.js"></script>
</head>
<body>
	<form name="deleteForm" action="./deleteProcess.gumain"
		 method="post" onSubmit="return deletecheck()">
			<div>
			<h3>ȸ��Ż�� �� ������ ��й�ȣ�� �Է����ּ���.</h3>
				<p>���̵�</p>
				<input type="text" name="gid" id="gid"
					placeholder="���̵�" value="${gid}" readOnly>
			</div>
			
			<div>
				<p>�н����� Ȯ��</p>
				<input type="password" name="pw" id="pw"
					 placeholder="�н����� Ȯ��" required>
			</div>
		<input type="submit" value="ȸ��Ż��">
	</form>
<script>
function focus(){
	document.deleteForm.pw.focus();
}

function deletecheck(){
	if(!document.deletForm.pass.value){
		alert("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
		document.deleteForm.pass.focus();//�н����� Ȯ�ο� ��Ŀ�� ��
		return false;
	}
};
</script>
</body>
</html>