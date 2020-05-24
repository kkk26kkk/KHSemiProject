<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>MVC 게시판</title>
  	
	<script src="js/jquery-3.3.1.js"></script>	
	
</head>
<body>

<script>
confirm('삭제하시겠습니까?');
</script>

<form name="deleteForm" 
      action="./boardDeleteAction.FA" method="post">
<input type="hidden" name="num" value="${param.num}">
<table border="1">
<tr>
	<td colspan=2 class="h30 center lime">
	
		<input type=submit value="삭제">
		<input type=button value="취소" onClick="history.go(-1)">
	</td>
</tr>
</table>
</form>
</body>
</html>