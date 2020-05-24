<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>���ǻ���</title>

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
         alert("�α����ϼ���");
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

	<!-- �Խ��� ����Ʈ -->

	<!-- ���ڵ尡 ������ -->
	<!-- core ���̺귯�� ��� -->
		<p class="s1">���ǻ���</p>
		<table id="bList" width="800" border="3" bordercolor="lightgray" table
			table-hover>
			<c:if test="${listcount > 0 }">

				<tr>
					<th width="8%"><div>��ȣ</div></th>
					<th width="50%"><div>����</div></th>
					<th width="14%"><div>�ۼ���</div></th>
					<th width="17%"><div>��¥</div></th>
					<th width="11%"><div>��ȸ��</div></th>
				</tr>
				<c:set var="num" value="${listcount-(page-1)*limit}" />
				<c:forEach var="b" items="${boardlist}">
					<tr>
						<td><c:out value="${num}" /> <%-- num ��� --%> <c:set
								var="num" value="${num-1}" /> <%-- num = num - 1 �ǹ�--%></td>
						<td>
							<div>
								<%-- �亯�� ����տ� ���� ó�� �κ� 
			      BOARD_RE_LEV, BOARD_RE_LEV, BOARD_NUM, 
			      BOARD_SUBJECT, BOARD_NAME, BOARD_DATE, 
			      BOARD_READCOUNT : property �̸� --%>
								<c:if test="${b.RE_LEV != 0}">
									<!--  ����� ��� -->
									<c:forEach var="a" begin="0" end="${b.RE_LEV*2}" step="1">
				&nbsp; 	
				</c:forEach>			
			RE:
			</c:if>

								<c:if test="${b.RE_LEV == 0}">
									<!-- ������ ��� -->
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

					<a>����&nbsp;</a>
				</c:if>
				<c:if test="${page > 1 }">
					<a href="./boardList.FA?page=${page-1}">����</a>&nbsp;
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
					<a>&nbsp;����</a>
				</c:if>
				<c:if test="${page < maxpage }">
					<a href="./boardList.FA?page=${page+1}">&nbsp;����</a>
				</c:if>
			</dt>

		</dl>


		<table>
			<c:if test="${listcount == 0 }">
				<!-- ���ڵ尡 ������ -->
				<tr>
					<td colspan="3">���ǻ���</td>
					<td style="text-align: right"><font size=2>��ϵ� ���� �����ϴ�.</font>
					</td>
				</tr>
			</c:if>
			<br>
		</table>
		<div id="topForm" style="width: 1250px; margin: auto;">

			<input type="button" id="but" value="�۾���" onclick="writeForm()">

		</div>
</body>
</html>