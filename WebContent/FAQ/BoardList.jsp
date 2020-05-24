<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>문의사항</title>

<script src="js/jquery-3.3.1.js"></script>
<script src="js/list.js"></script>
<link rel="stylesheet" href="./css/boardlist.css" />



<script>
   $(function() {
      $("#viewcount").val("${limit}").prop("selected", true);
   });

   function writeForm() {
      var b = "<%=(String) session.getAttribute("eid")%>";
      var a = "<%=(String) session.getAttribute("gid")%>";
      if (b != "null"|| a != "null") {
         location.href = "boardwrite.FA";
      } else {
         alert("로그인하세요");
         location.href = "main.gumain";
      }
      
   }
</script>

</head>
<c:if test="${gid }">
<%@ include file="/header.jsp"%>
</c:if>
<c:if test="${eid }">
<jsp:include page="../../eu/euheader.jsp"/>
</c:if>
<body>

	<!-- 게시판 리스트 -->

	<!-- 레코드가 있으면 -->
	<!-- core 라이브러리 사용 -->
		<p class="s1">문의사항</p>
		<table id="bList" width="800" border="3" bordercolor="lightgray" table
			table-hover>
			<c:if test="${listcount > 0 }">

				<tr>
					<th width="8%"><div>번호</div></th>
					<th width="50%"><div>제목</div></th>
					<th width="14%"><div>작성자</div></th>
					<th width="17%"><div>날짜</div></th>
					<th width="11%"><div>조회수</div></th>
				</tr>
				<c:set var="num" value="${listcount-(page-1)*limit}" />
				<c:forEach var="b" items="${boardlist}">
					<tr>
						<td><c:out value="${num}" /> <%-- num 출력 --%> <c:set
								var="num" value="${num-1}" /> <%-- num = num - 1 의미--%></td>
						<td>
							<div>
								<%-- 답변글 제목앞에 여백 처리 부분 
			      BOARD_RE_LEV, BOARD_RE_LEV, BOARD_NUM, 
			      BOARD_SUBJECT, BOARD_NAME, BOARD_DATE, 
			      BOARD_READCOUNT : property 이름 --%>
								<c:if test="${b.RE_LEV != 0}">
									<!--  답글인 경우 -->
									<c:forEach var="a" begin="0" end="${b.RE_LEV*2}" step="1">
				&nbsp; 	
				</c:forEach>			
			RE:
			</c:if>

								<c:if test="${b.RE_LEV == 0}">
									<!-- 원문인 경우 -->
				&nbsp;
			</c:if>

								<a class="a1" href="./boardDetail.FA?num=${b.SN}">
									${b.SUBJECT} </a>
							</div>
						</td>
						<td>
							<div>${b.USERID}</div>
						</td>
						<td>
							<div>${b.RGS_DTM}</div>
						</td>
						<td>
							<div>${b.READCOUNT}</div>
						</td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
		<br>

		<dl class="pagination">

			<dt colspan=5>
				<c:if test="${page <= 1 }">

					<a>이전&nbsp;</a>
				</c:if>
				<c:if test="${page > 1 }">
					<a href="./boardList.FA?page=${page-1}">이전</a>&nbsp;
			</c:if>
				<c:forEach var="a" begin="${startpage}" end="${endpage}">
					<c:if test="${a == page }">
						<a>${a}</a>
					</c:if>
					<c:if test="${a != page }">
						<a href="./boardList.FA?page=${a}">${a}</a>
					</c:if>
				</c:forEach>
				<c:if test="${page >= maxpage }">
					<a>&nbsp;다음</a>
				</c:if>
				<c:if test="${page < maxpage }">
					<a href="./boardList.FA?page=${page+1}">&nbsp;다음</a>
				</c:if>
			</dt>

		</dl>


		<table>
			<c:if test="${listcount == 0 }">
				<!-- 레코드가 없으면 -->
				<tr>
					<td colspan="3">문의사항</td>
					<td style="text-align: right"><font size=2>등록된 글이 없습니다.</font>
					</td>
				</tr>
			</c:if>
			<br>
		</table>
		<div id="topForm" style="width: 1250px; margin: auto;">

			<input type="button" id="but" value="글쓰기" onclick="writeForm()">

		</div>
</body>
</html>