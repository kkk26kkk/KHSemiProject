<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>MVC 게시판 - view</title>
<link href="css/form.css" rel="stylesheet">
<style>
textarea {
	width: 730px;
	height: 300px;
}

.me {
	margin: 0px;
	padding: 20px 0px;
	text-align: center;
	text-transform: uppercase;
	font-family: "Arial Black", sans-serif;
	font-size: 60px;
	font-weight: bold;
	padding: 30px;
	text-align: center;
	color: #3399ff;
	text-shadow: 3px 3px 2px #bdbdbd;
}

dl {
	margin: 0 auto;
	text-align: left;
	width: 739px;
	height: 532px;
}

section {
	margin: 0 auto;
	text-align: left;
	width: 739px;
	height: 532px;
}

#p1 {
	height: 81px;
	margin: 0 auto;
	background-color: white;
	font-size: 40px;
}

}
p:nth-child(1) {
	background-color: white;
	height: 26px;
	font-size: 40px;
}

p:nth-child(2) {
	margin-top:20;
	border-bottom-style: groove;
	padding: 10px;
}

pre {
	border-bottom-style: groove;
	padding: 10px;
}

#but {
	margin: 0 auto;
	background-color: DodgerBlue;
	border: none;
	color: white;
	padding: 12px 30px;
	cursor: pointer;
	font-size: 20px;
	background-color: DodgerBlue;
	background-color: DodgerBlue;
}
</style>
<script>
	function Delete() {
		var b = confirm('삭제하시겠습니까?');
		if (b == true) {
			location.href = "boardDelete.FA?num=${boarddata.SN}";
		} else
			history.go(0);
	}
	function Modify() {
		location.href = "boardModifyView.FA?num=${boarddata.SN}";
	}
	function Reply() {
		location.href = "boardReplyView.FA?num=${boarddata.SN}";
	}
	function List() {
		location.href = "boardList.FA";
	}
</script>
</head>
<body>
	<jsp:include page="/header.jsp" />

	<header>
		<p class="me">문의사항 상세페이지</p>
	</header>



	<section>
		<article>
			<div id="p1">
				<p>&nbsp;${boarddata.SUBJECT}</p>
			</div>
			<p>글쓴이 : &nbsp;${boarddata.USERID}&nbsp; 작성일:&nbsp;${ boarddata.RGS_DTM}&emsp;조회수:&nbsp;${boarddata.READCOUNT}
			</p>
			<pre style="height: 300px;">${boarddata.CONTENT}</pre>

			<dl>
				<c:if test="${!empty boarddata.FA_FILE}">
					<dt>
						첨부파일 =<img src="image/down.png" width="10px"> <a
							href="./boardFileDown.FA?filename=${boarddata.FA_FILE}">
							${boarddata.FA_FILE}</a>
					</dt>
				</c:if>
			</dl>



		</article>

	</section>

	<dl>
		<dt>
			<input type="submit" id="but" class="reliy" onclick="Reply()"
				value="답변">&nbsp;&nbsp;
			<c:if
				test="${boarddata.USERID == gid || gid == 'admin1'||boarddata.USERID == eid || eid == 'admin1'}">

				<input type="submit" id="but" class="modfy" onclick="Modify()"
					value="수정">&nbsp;&nbsp;
			<input type="submit" id="but" class="delete" onclick="Delete()"
					value="삭제">&nbsp;&nbsp;
		   </c:if>
			<input type="submit" id="but" class="list" onclick="List()"
				value="목록">&nbsp;&nbsp;
		</dt>
	</dl>


	<!-- 게시판 수정 -->
</body>
</html>