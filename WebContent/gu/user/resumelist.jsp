<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<link rel="stylesheet" href="./css/list2.css" />

<script>
	function Delete() {
		var b = confirm('삭제하시겠습니까?');
		
		if (b == true) {
			
			 location.href = "resumedelete.guuser?gid=${res.GID}&sn=${res.SN}"; 

		} else
			history.go(0);
	}
</script>
</head>
<jsp:include page="../../header.jsp"></jsp:include>
<body>

	<div id="resumeWraper">
	<div id="titlediv"><h2 id="restitle">이력서 관리</h2></div>
		<div id="form">
			<table>
				<thead>
					<tr>
						<th style="width: 793px;">이력서 제목</th>
						<th colspan="2">이력서 관리</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="res" items="${reslist }">
						<tr>
							<td><a
								href="./resumeview.guuser?gid=${res.GID }&sn=${res.SN }">${res.SUBJECT }</a></td>
							<td><a
								href="./resumeupdate.guuser?gid=${res.GID }&sn=${res.SN }" class="button">수정</a></td>
							<td><a 
							href="./resumedelete.guuser?gid=${res.GID}&sn=${res.SN}" class="button">삭제</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>