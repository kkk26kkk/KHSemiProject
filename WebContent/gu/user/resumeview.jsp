<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="vo.Resume" %>		   

<%
	Resume res = (Resume)request.getAttribute("res");
	
	String rank="", jtype="", dessal="", region="",
			duty="", industry="", stype="";
	
	if(res.getSTYPE().equals("1"))
		stype = "대학교 졸업(4년)";
	else if(res.getSTYPE().equals("2"))
		stype = "대학교 졸업(2,3년)";
	else if(res.getSTYPE().equals("3"))
		stype = "대학원 석사 졸업";
	else if(res.getSTYPE().equals("4"))
		stype = "대학원 박사 졸업";
	else if(res.getSTYPE().equals("5"))
		stype = "고등학교 졸업";
	
	if(res.getRANK().equals("1"))
		rank = "사원";
	else if(res.getRANK().equals("2"))
		rank = "주임/계장";
	else if(res.getRANK().equals("3"))
		rank = "대리";
	else if(res.getRANK().equals("4"))
		rank = "과장";
	else if(res.getRANK().equals("5"))
		rank = "차장";
	else if(res.getRANK().equals("6"))
		rank = "부장";
	else if(res.getRANK().equals("7"))
		rank = "임원";
	else if(res.getRANK().equals("8"))
		rank = "팀장";
	else if(res.getRANK().equals("9"))
		rank = "매니저";
	else if(res.getRANK().equals("10"))
		rank = "파트장";
	else if(res.getRANK().equals("11"))
		rank = "실장";
	else if(res.getRANK().equals("12"))
		rank = "지점장";
	else if(res.getRANK().equals("13"))
		rank = "지사장";
	else if(res.getRANK().equals("14"))
		rank = "원장";
	else if(res.getRANK().equals("15"))
		rank = "국장";
	else if(res.getRANK().equals("16"))
		rank = "본부장";
	else if(res.getRANK().equals("17"))
		rank = "센터장";
	else if(res.getRANK().equals("18"))
		rank = "공장장";
	else if(res.getRANK().equals("19"))
		rank = "그룹장";
	
	if(res.getJTYPE().equals("1"))
		jtype = "정규직";
	else if(res.getJTYPE().equals("2"))
		jtype = "계약직";
	else if(res.getJTYPE().equals("3"))
		jtype = "인턴";
	else if(res.getJTYPE().equals("4"))
		jtype = "파견";
	else if(res.getJTYPE().equals("5"))
		jtype = "프리랜서";
	else if(res.getJTYPE().equals("6"))
		jtype = "연수생/교육생";
	
	if(res.getDESSAL().equals("1"))
		dessal = "~2,000만원";
	else if(res.getDESSAL().equals("2"))
		dessal = "2,000~2,500만원";
	else if(res.getDESSAL().equals("3"))
		dessal = "2,500~3,000만원";
	else if(res.getDESSAL().equals("4"))
		dessal = "3,000~3,500만원";
	else if(res.getDESSAL().equals("5"))
		dessal = "3,500~4,000만원";
	else if(res.getDESSAL().equals("6"))
		dessal = "4,000~4,500만원";
	else if(res.getDESSAL().equals("7"))
		dessal = "5,000~5,000만원";
	else if(res.getDESSAL().equals("8"))
		dessal = "5,000~6,000만원";
	else if(res.getDESSAL().equals("9"))
		dessal = "6,000만원~";
	
	if(res.getREGION().equals("1"))
		region = "서울특별시";
	else if(res.getREGION().equals("2"))
		region = "경기도";
	else if(res.getREGION().equals("3"))
		region = "인천광역시";
	else if(res.getREGION().equals("4"))
		region = "대전광역시";
	else if(res.getREGION().equals("5"))
		region = "세종특별자치시";
	else if(res.getREGION().equals("6"))
		region = "충청남도";
	else if(res.getREGION().equals("7"))
		region = "광주광역시";
	else if(res.getREGION().equals("8"))
		region = "전라남도";
	else if(res.getREGION().equals("9"))
		region = "전라북도";
	else if(res.getREGION().equals("10"))
		region = "대구광역시";
	else if(res.getREGION().equals("11"))
		region = "경상북도";
	else if(res.getREGION().equals("12"))
		region = "부산광역시";
	else if(res.getREGION().equals("13"))
		region = "울산광역시";
	else if(res.getREGION().equals("14"))
		region = "경상남도";
	else if(res.getREGION().equals("15"))
		region = "강원도";
	else if(res.getREGION().equals("16"))
		region = "제주특별자치도";
	
	if(res.getDUTY().equals("1"))
		duty = "경영·사무";
	else if(res.getDUTY().equals("2"))
		duty = "마케팅·광고·홍보";
	else if(res.getDUTY().equals("3"))
		duty = "IT·인터넷";
	else if(res.getDUTY().equals("4"))
		duty = "디자인";
	else if(res.getDUTY().equals("5"))
		duty = "무역·유통";
	else if(res.getDUTY().equals("6"))
		duty = "영업·고객상담";
	else if(res.getDUTY().equals("7"))
		duty = "서비스";
	else if(res.getDUTY().equals("8"))
		duty = "연구개발·설계";
	else if(res.getDUTY().equals("9"))
		duty = "생산·제조";
	else if(res.getDUTY().equals("10"))
		duty = "교육";
	else if(res.getDUTY().equals("11"))
		duty = "건설";
	else if(res.getDUTY().equals("12"))
		duty = "의료";
	else if(res.getDUTY().equals("13"))
		duty = "미디어";
	else if(res.getDUTY().equals("14"))
		duty = "전문·특수직";
	
	if(res.getINDUSTRY().equals("1"))
		industry = "서비스업";
	else if(res.getINDUSTRY().equals("2"))
		industry = "금융·은행업";
	else if(res.getINDUSTRY().equals("3"))
		industry = "IT·정보통신업";
	else if(res.getINDUSTRY().equals("4"))
		industry = "판매·유통업";
	else if(res.getINDUSTRY().equals("5"))
		industry = "제조·생산·화학업";
	else if(res.getINDUSTRY().equals("6"))
		industry = "교육업";
	else if(res.getINDUSTRY().equals("7"))
		industry = "의료·제약업";
	else if(res.getINDUSTRY().equals("8"))
		industry = "미디어·광고업";
	else if(res.getINDUSTRY().equals("9"))
		industry = "문화·예술·디자인업";
	else if(res.getINDUSTRY().equals("10"))
		industry = "기관·협회";
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

			<h2 id="injeoktitle">인적사항</h2>
			<div id="injeok">
				<div>
					<a style="font-size: 25px; font-weight: bold;">${resumedata.NAME }</a>&nbsp;
					<a style="color: gray;">${resumedata.GENDER}&nbsp;${resumedata.BIRTH}</a>
				</div>
				<br>
				<div style="width: 500px; color: gray;">
					<span>휴대폰번호 : ${resumedata.PHONE}</span>&nbsp; <a style="text-align: center;">이메일:${resumedata.EMAIL}</a>
					<div style="width: 700px; color: gray;"><span>주소 : ${resumedata.ADDR}</span></div>
				</div>
			</div>

			<h2 id="hakryeoktitle">학력</h2>
			<div id="hakryeok" style="font-size: 20px; color: gray;">
				<div><%=stype %>&nbsp;:&nbsp;${resumedata.MAJOR}</div>
				<div>학점 &nbsp;:&nbsp; ${resumedata.GRADE}</div>
			</div>

			<h2 id="certnametitle">자격증</h2>
			<div id="certname" style="font-size: 20px; color: gray;">
				<div>${resumedata.CACDATE}</div>
				<div>${resumedata.CERTNAME}
					&nbsp;<a style="font-size: 14px; color: gray;">${resumedata.PUBLISHER}</a>
				</div>
			</div>


			<h2 id="ranktitle">경력</h2>
			<div id="rank" style="font-size: 20px; color: gray;">
				<div>기업명:${resumedata.ENAME}&nbsp;&nbsp;기간:${resumedata.DOA}~${resumedata.DOG}</div>
				<div><%=rank %>(으)로&nbsp;근무하였습니다.</div>
			</div>

			<h2 id="ratingtitle">어학</h2>
			<div id="rating" style="font-size: 20px; color: gray;">
				<div>${resumedata.LANNAME}&nbsp;${resumedata.RATING}&nbsp;${resumedata.LACDATE}</div>
			</div>

			<h2 id="prsubjecttitle">자기소개서</h2>
			<div id="prsubject" style="font-size: 20px; color: gray;">
				<div>${resumedata.PRSUBJECT}</div>
				<br>
				<div>
					<pre>${resumedata.PRCONTENT}<pre>
				</div>
			</div>



			<h2 id="huimangtitle">희망근무조건</h2>
			<div id="huimang">
				<table border="1">
					<tr>
						<td style="width: 133px;">고용형태</td>
						<td><%=jtype %></td>
					</tr>
					<tr>
						<td>희망근무지</td>
						<td><%=region %></td>
					</tr>
					<tr>
						<td>희망연봉</td>
						<td><%=dessal %></td>
					</tr>
					<tr>
						<td>직무</td>
						<td><%=duty %></td>
					</tr>
					<tr>
						<td>희망산업</td>
						<td><%=industry %></td>
					</tr>
				</table>
			</div>

			<div style="margin-top: 30px">
				<input type="button" id="but" value="목록" onclick="history.back()">
			</div>

		</div>
	</div>

</body>
</html>