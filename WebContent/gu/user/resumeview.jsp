<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="vo.Resume" %>		   

<%
	Resume res = (Resume)request.getAttribute("res");
	
	String rank="", jtype="", dessal="", region="",
			duty="", industry="", stype="";
	
	if(res.getSTYPE().equals("1"))
		stype = "���б� ����(4��)";
	else if(res.getSTYPE().equals("2"))
		stype = "���б� ����(2,3��)";
	else if(res.getSTYPE().equals("3"))
		stype = "���п� ���� ����";
	else if(res.getSTYPE().equals("4"))
		stype = "���п� �ڻ� ����";
	else if(res.getSTYPE().equals("5"))
		stype = "����б� ����";
	
	if(res.getRANK().equals("1"))
		rank = "���";
	else if(res.getRANK().equals("2"))
		rank = "����/����";
	else if(res.getRANK().equals("3"))
		rank = "�븮";
	else if(res.getRANK().equals("4"))
		rank = "����";
	else if(res.getRANK().equals("5"))
		rank = "����";
	else if(res.getRANK().equals("6"))
		rank = "����";
	else if(res.getRANK().equals("7"))
		rank = "�ӿ�";
	else if(res.getRANK().equals("8"))
		rank = "����";
	else if(res.getRANK().equals("9"))
		rank = "�Ŵ���";
	else if(res.getRANK().equals("10"))
		rank = "��Ʈ��";
	else if(res.getRANK().equals("11"))
		rank = "����";
	else if(res.getRANK().equals("12"))
		rank = "������";
	else if(res.getRANK().equals("13"))
		rank = "������";
	else if(res.getRANK().equals("14"))
		rank = "����";
	else if(res.getRANK().equals("15"))
		rank = "����";
	else if(res.getRANK().equals("16"))
		rank = "������";
	else if(res.getRANK().equals("17"))
		rank = "������";
	else if(res.getRANK().equals("18"))
		rank = "������";
	else if(res.getRANK().equals("19"))
		rank = "�׷���";
	
	if(res.getJTYPE().equals("1"))
		jtype = "������";
	else if(res.getJTYPE().equals("2"))
		jtype = "�����";
	else if(res.getJTYPE().equals("3"))
		jtype = "����";
	else if(res.getJTYPE().equals("4"))
		jtype = "�İ�";
	else if(res.getJTYPE().equals("5"))
		jtype = "��������";
	else if(res.getJTYPE().equals("6"))
		jtype = "������/������";
	
	if(res.getDESSAL().equals("1"))
		dessal = "~2,000����";
	else if(res.getDESSAL().equals("2"))
		dessal = "2,000~2,500����";
	else if(res.getDESSAL().equals("3"))
		dessal = "2,500~3,000����";
	else if(res.getDESSAL().equals("4"))
		dessal = "3,000~3,500����";
	else if(res.getDESSAL().equals("5"))
		dessal = "3,500~4,000����";
	else if(res.getDESSAL().equals("6"))
		dessal = "4,000~4,500����";
	else if(res.getDESSAL().equals("7"))
		dessal = "5,000~5,000����";
	else if(res.getDESSAL().equals("8"))
		dessal = "5,000~6,000����";
	else if(res.getDESSAL().equals("9"))
		dessal = "6,000����~";
	
	if(res.getREGION().equals("1"))
		region = "����Ư����";
	else if(res.getREGION().equals("2"))
		region = "��⵵";
	else if(res.getREGION().equals("3"))
		region = "��õ������";
	else if(res.getREGION().equals("4"))
		region = "����������";
	else if(res.getREGION().equals("5"))
		region = "����Ư����ġ��";
	else if(res.getREGION().equals("6"))
		region = "��û����";
	else if(res.getREGION().equals("7"))
		region = "���ֱ�����";
	else if(res.getREGION().equals("8"))
		region = "���󳲵�";
	else if(res.getREGION().equals("9"))
		region = "����ϵ�";
	else if(res.getREGION().equals("10"))
		region = "�뱸������";
	else if(res.getREGION().equals("11"))
		region = "���ϵ�";
	else if(res.getREGION().equals("12"))
		region = "�λ걤����";
	else if(res.getREGION().equals("13"))
		region = "��걤����";
	else if(res.getREGION().equals("14"))
		region = "��󳲵�";
	else if(res.getREGION().equals("15"))
		region = "������";
	else if(res.getREGION().equals("16"))
		region = "����Ư����ġ��";
	
	if(res.getDUTY().equals("1"))
		duty = "�濵���繫";
	else if(res.getDUTY().equals("2"))
		duty = "�����á�����ȫ��";
	else if(res.getDUTY().equals("3"))
		duty = "IT�����ͳ�";
	else if(res.getDUTY().equals("4"))
		duty = "������";
	else if(res.getDUTY().equals("5"))
		duty = "����������";
	else if(res.getDUTY().equals("6"))
		duty = "�����������";
	else if(res.getDUTY().equals("7"))
		duty = "����";
	else if(res.getDUTY().equals("8"))
		duty = "�������ߡ�����";
	else if(res.getDUTY().equals("9"))
		duty = "���ꡤ����";
	else if(res.getDUTY().equals("10"))
		duty = "����";
	else if(res.getDUTY().equals("11"))
		duty = "�Ǽ�";
	else if(res.getDUTY().equals("12"))
		duty = "�Ƿ�";
	else if(res.getDUTY().equals("13"))
		duty = "�̵��";
	else if(res.getDUTY().equals("14"))
		duty = "������Ư����";
	
	if(res.getINDUSTRY().equals("1"))
		industry = "���񽺾�";
	else if(res.getINDUSTRY().equals("2"))
		industry = "�����������";
	else if(res.getINDUSTRY().equals("3"))
		industry = "IT��������ž�";
	else if(res.getINDUSTRY().equals("4"))
		industry = "�Ǹš������";
	else if(res.getINDUSTRY().equals("5"))
		industry = "���������ꡤȭ�о�";
	else if(res.getINDUSTRY().equals("6"))
		industry = "������";
	else if(res.getINDUSTRY().equals("7"))
		industry = "�Ƿᡤ�����";
	else if(res.getINDUSTRY().equals("8"))
		industry = "�̵������";
	else if(res.getINDUSTRY().equals("9"))
		industry = "��ȭ�������������ξ�";
	else if(res.getINDUSTRY().equals("10"))
		industry = "�������ȸ";
%>
<!DOCTYPE html>
<html>
<head>
<title><%=res.getSUBJECT() %></title>
<link rel="stylesheet" href="css/resumeview.css">
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>
	<c:set var="resumedata" value="${res}" />


	<div id="pviewwrap">
		<div id="pview">

			<h2 id="injeoktitle">��������</h2>
			<div id="injeok">
				<div>
					<a style="font-size: 25px; font-weight: bold;">${resumedata.NAME }</a>&nbsp;
					<a style="color: gray;">${resumedata.GENDER}&nbsp;${resumedata.BIRTH}</a>
				</div>
				<br>
				<div style="width: 500px; color: gray;">
					<span>�޴�����ȣ : ${resumedata.PHONE}</span>&nbsp; <a style="text-align: center;">�̸���:${resumedata.EMAIL}</a>
					<div style="width: 700px; color: gray;"><span>�ּ� : ${resumedata.ADDR}</span></div>
				</div>
			</div>

			<h2 id="hakryeoktitle">�з�</h2>
			<div id="hakryeok" style="font-size: 20px; color: gray;">
				<div><%=stype %>&nbsp;:&nbsp;${resumedata.MAJOR}</div>
				<div>���� &nbsp;:&nbsp; ${resumedata.GRADE}</div>
			</div>

			<h2 id="certnametitle">�ڰ���</h2>
			<div id="certname" style="font-size: 20px; color: gray;">
				<div>${resumedata.CACDATE}</div>
				<div>${resumedata.CERTNAME}
					&nbsp;<a style="font-size: 14px; color: gray;">${resumedata.PUBLISHER}</a>
				</div>
			</div>


			<h2 id="ranktitle">���</h2>
			<div id="rank" style="font-size: 20px; color: gray;">
				<div>�����:${resumedata.ENAME}&nbsp;&nbsp;�Ⱓ:${resumedata.DOA}~${resumedata.DOG}</div>
				<div><%=rank %>(��)��&nbsp;�ٹ��Ͽ����ϴ�.</div>
			</div>

			<h2 id="ratingtitle">����</h2>
			<div id="rating" style="font-size: 20px; color: gray;">
				<div>${resumedata.LANNAME}&nbsp;${resumedata.RATING}&nbsp;${resumedata.LACDATE}</div>
			</div>

			<h2 id="prsubjecttitle">�ڱ�Ұ���</h2>
			<div id="prsubject" style="font-size: 20px; color: gray;">
				<div>${resumedata.PRSUBJECT}</div>
				<br>
				<div>
					<pre>${resumedata.PRCONTENT}<pre>
				</div>
			</div>



			<h2 id="huimangtitle">����ٹ�����</h2>
			<div id="huimang">
				<table border="1">
					<tr>
						<td style="width: 133px;">�������</td>
						<td><%=jtype %></td>
					</tr>
					<tr>
						<td>����ٹ���</td>
						<td><%=region %></td>
					</tr>
					<tr>
						<td>�������</td>
						<td><%=dessal %></td>
					</tr>
					<tr>
						<td>����</td>
						<td><%=duty %></td>
					</tr>
					<tr>
						<td>������</td>
						<td><%=industry %></td>
					</tr>
				</table>
			</div>

			<div style="margin-top: 30px">
				<input type="button" id="but" value="���" onclick="history.back()">
			</div>

		</div>
	</div>

</body>
</html>