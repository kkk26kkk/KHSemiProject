<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<title>인재 검색</title>
<link rel="stylesheet" href="css/eurecruit_home.css">
<script src="js/jquery-3.0.0.js"></script>
<script src="js/person.js"></script>
<!-- <script src="js/list.js"></script> -->
<script>
	$(function() {
		$("#viewcount").val("${limit}").prop("selected", true);
	});

</script>


</head>
<body>
<jsp:include page="../../eu/euheader.jsp"/>
	<div id="searchwrap">
		<div class="searchArea" style="width: 1157px; height: 283px;">
			<p class="searchheader">
				<strong>직무</strong>
			</p>
			<p class="searchheader">
				<strong>근무지역</strong>
			<p class="searchheader">
				<strong>학력</strong>
			</p>
			<p class="searchheader">
				<strong>직급/직책</strong>
			</p>
			<p class="searchheader">
				<strong>고용형태</strong>
			</p>
			<p class="searchheader">
				<strong>산업</strong>
			</p>
			<p class="searchheader">
				<strong>희망연봉</strong>
			</p>

			<ul class="shsub">
				<li><input class="inp_chk" type="checkbox" name="DUTY"
					value="1" data-name="경영·사무">경영·사무</li>
				<li><input class="inp_chk" type="checkbox" name="DUTY"
					value="2" data-name="마케팅·광고·홍보">마케팅·광고·홍보</li>
				<li><input class="inp_chk" type="checkbox" name="DUTY"
					value="3" data-name="IT·인터넷">IT·인터넷</li>
				<li><input class="inp_chk" type="checkbox" name="DUTY"
					value="4" data-name="디자인">디자인</li>
				<li><input class="inp_chk" type="checkbox" name="DUTY"
					value="5" data-name="무역·유통">무역·유통</li>
				<li><input class="inp_chk" type="checkbox" name="DUTY"
					value="6" data-name="영업·고객상담">영업·고객상담</li>
				<li><input class="inp_chk" type="checkbox" name="DUTY"
					value="7" data-name="서비스">서비스</li>
				<li><input class="inp_chk" type="checkbox" name="DUTY"
					value="8" data-name="연구개발·설계">연구개발·설계</li>
				<li><input class="inp_chk" type="checkbox" name="DUTY"
					value="9" data-name="생산·제조">생산·제조</li>
				<li><input class="inp_chk" type="checkbox" name="DUTY"
					value="10" data-name="교육">교육</li>
				<li><input class="inp_chk" type="checkbox" name="DUTY"
					value="11" data-name="건설">건설</li>
				<li><input class="inp_chk" type="checkbox" name="DUTY"
					value="12" data-name="의료">의료</li>
				<li><input class="inp_chk" type="checkbox" name="DUTY"
					value="13" data-name="미디어">미디어</li>
				<li><input class="inp_chk" type="checkbox" name="DUTY"
					value="14" data-name="전문·특수직">전문·특수직</li>
			</ul>

			<ul class="shsub">
				<li><input class="inp_chk" type="checkbox" name="REGION"
					value="1" data-name="서울특별시">서울특별시</li>
				<li><input class="inp_chk" type="checkbox" name="REGION"
					value="2" data-name="경기도">경기도</li>
				<li><input class="inp_chk" type="checkbox" name="REGION"
					value="3" data-name="인천광역시">인천광역시</li>
				<li><input class="inp_chk" type="checkbox" name="REGION"
					value="4" data-name="대전광역시">대전광역시</li>
				<li><input class="inp_chk" type="checkbox" name="REGION"
					value="5" data-name="세종특별자치시">세종특별자치시</li>
				<li><input class="inp_chk" type="checkbox" name="REGION"
					value="6" data-name="충청남도">충청남도</li>
				<li><input class="inp_chk" type="checkbox" name="REGION"
					value="7" data-name="광주광역시">광주광역시</li>
				<li><input class="inp_chk" type="checkbox" name="REGION"
					value="8" data-name="전라남도">전라남도</li>
				<li><input class="inp_chk" type="checkbox" name="REGION"
					value="9" data-name="전라북도">전라북도</li>
				<li><input class="inp_chk" type="checkbox" name="REGION"
					value="10" data-name="대구광역시">대구광역시</li>
				<li><input class="inp_chk" type="checkbox" name="REGION"
					value="11" data-name="경상북도">경상북도</li>
				<li><input class="inp_chk" type="checkbox" name="REGION"
					value="12" data-name="부산광역시">부산광역시</li>
				<li><input class="inp_chk" type="checkbox" name="REGION"
					value="13" data-name="울산광역시">울산광역시</li>
				<li><input class="inp_chk" type="checkbox" name="REGION"
					value="14" data-name="경상남도">경상남도</li>
				<li><input class="inp_chk" type="checkbox" name="REGION"
					value="15" data-name="강원도">강원도</li>
				<li><input class="inp_chk" type="checkbox" name="REGION"
					value="16" data-name="제주특별자치도">제주특별자치도</li>
			</ul>

			<ul class="shsub">
				<li><input class="inp_chk" type="checkbox" name="STYPE"
					value="1" data-name="대학교 졸업(4년)">대학교 졸업(4년)</li>
				<li><input class="inp_chk" type="checkbox" name="STYPE"
					value="2" data-name="대학교 졸업(2,3년)">대학교 졸업(2,3년)</li>
				<li><input class="inp_chk" type="checkbox" name="STYPE"
					value="3" data-name="대학원 석사 졸업">대학원 석사 졸업</li>
				<li><input class="inp_chk" type="checkbox" name="STYPE"
					value="4" data-name="대학원 박사 졸업">대학원 박사 졸업</li>
				<li><input class="inp_chk" type="checkbox" name="STYPE"
					value="5" data-name="고등학교 졸업">고등학교 졸업</li>
				<li><input class="inp_chk" type="checkbox" name="STYPE"
					value="6" data-name="학력무관">학력무관</li>
			</ul>

			<div class="shsub">
				<ul
					style="float: left; display: block; padding-left: 0px; margin-bottom: 0px; margin-top: 0px; width: 50px;&gt;">
					<li><input class="inp_chk" type="checkbox" name="RANK"
						value="1" data-name="사원">사원</li>
					<li><input class="inp_chk" type="checkbox" name="RANK"
						value="2" data-name="주임/계장">주임/계장</li>
					<li><input class="inp_chk" type="checkbox" name="RANK"
						value="3" data-name="대리">대리</li>
					<li><input class="inp_chk" type="checkbox" name="RANK"
						value="4" data-name="과장">과장</li>
					<li><input class="inp_chk" type="checkbox" name="RANK"
						value="5" data-name="대리">대리</li>
					<li><input class="inp_chk" type="checkbox" name="RANK"
						value="6" data-name="차장">차장</li>
					<li><input class="inp_chk" type="checkbox" name="RANK"
						value="7" data-name="부장">부장</li>
					<li><input class="inp_chk" type="checkbox" name="RANK"
						value="8" data-name="임원">임원</li>
				</ul>
				<ul
					style="float: right; display: block; white: 20px; padding-left: 0px; margin-bottom: 0px; margin-top: 0px; height: 164px; width: 80px;">
					<li><input class="inp_chk" type="checkbox" name="RANK"
						value="9" data-name="팀장">팀장</li>
					<li><input class="inp_chk" type="checkbox" name="RANK"
						value="10" data-name="매니져">매니져</li>
					<li><input class="inp_chk" type="checkbox" name="RANK"
						value="11" data-name="파트장">파트장</li>
					<li><input class="inp_chk" type="checkbox" name="RANK"
						value="12" data-name="실장">실장</li>
					<li><input class="inp_chk" type="checkbox" name="RANK"
						value="13" data-name="점장">점장</li>
					<li><input class="inp_chk" type="checkbox" name="RANK"
						value="14" data-name="원장">원장</li>
					<li><input class="inp_chk" type="checkbox" name="RANK"
						value="15" data-name="국장">국장</li>
					<li><input class="inp_chk" type="checkbox" name="RANK"
						value="16" data-name="본부장">본부장</li>
					<li><input class="inp_chk" type="checkbox" name="RANK"
						value="17" data-name="센터장">센터장</li>
					<li><input class="inp_chk" type="checkbox" name="RANK"
						value="18" data-name="공장장">공장장</li>
					<li><input class="inp_chk" type="checkbox" name="RANK"
						value="19" data-name="그룹장">그룹장</li>
				</ul>
			</div>

			<ul class="shsub">
				<li><input class="inp_chk" type="checkbox" name="JTYPE"
					value="1" data-name="정규직">정규직</li>
				<li><input class="inp_chk" type="checkbox" name="JTYPE"
					value="2" data-name="계약직">계약직</li>
				<li><input class="inp_chk" type="checkbox" name="JTYPE"
					value="3" data-name="인턴">인턴</li>
				<li><input class="inp_chk" type="checkbox" name="JTYPE"
					value="4" data-name="파견직">파견직</li>
				<li><input class="inp_chk" type="checkbox" name="JTYPE"
					value="5" data-name="프리랜서">프리랜서</li>
				<li><input class="inp_chk" type="checkbox" name="JTYPE"
					value="6" data-name="연수생/교육생">연수생/교육생</li>
			</ul>
			<ul class="shsub">
				<li><input class="inp_chk" type="checkbox" name="INDUSTRY"
					value="1" data-name="서비스업">서비스업</li>
				<li><input class="inp_chk" type="checkbox" name="INDUSTRY"
					value="2" data-name="금융·은행업">금융·은행업</li>
				<li><input class="inp_chk" type="checkbox" name="INDUSTRY"
					value="3" data-name="IT·정보통신업">IT·정보통신업</li>
				<li><input class="inp_chk" type="checkbox" name="INDUSTRY"
					value="4" data-name="판매·유통업">판매·유통업</li>
				<li><input class="inp_chk" type="checkbox" name="INDUSTRY"
					value="5" data-name="제조·생산·화학업">제조·생산·화학업</li>
				<li><input class="inp_chk" type="checkbox" name="INDUSTRY"
					value="6" data-name="교육업">교육업</li>
				<li><input class="inp_chk" type="checkbox" name="INDUSTRY"
					value="7" data-name="건설업">건설업</li>
				<li><input class="inp_chk" type="checkbox" name="INDUSTRY"
					value="8" data-name="의료·제약업">의료·제약업</li>
				<li><input class="inp_chk" type="checkbox" name="INDUSTRY"
					value="9" data-name="문화·예술·디자인업">문화·예술·디자인업</li>
				<li><input class="inp_chk" type="checkbox" name="INDUSTRY"
					value="10" data-name="미디어·광고업">미디어·광고업</li>
			</ul>
			<ul class="shsub">
				<li><input class="inp_chk" type="checkbox" name="DESSAL"
					value="1" data-name="~2000만원">~2000만원</li>
				<li><input class="inp_chk" type="checkbox" name="DESSAL"
					value="2" data-name="2,000~2,500만원">2,000~2,500만원</li>
				<li><input class="inp_chk" type="checkbox" name="DESSAL"
					value="3" data-name="2,500~3,000만원">2,500~3,000만원</li>
				<li><input class="inp_chk" type="checkbox" name="DESSAL"
					value="4" data-name="3,000~3,500만원">3,000~3,500만원</li>
				<li><input class="inp_chk" type="checkbox" name="DESSAL" value="5"
					data-name="3,500~4,000만원">3,500~4,000만원</li>
				<li><input class="inp_chk" type="checkbox" name="DESSAL"
					value="6" data-name="4,000~4,500만원">4,000~4,500만원</li>
				<li><input class="inp_chk" type="checkbox" name="DESSAL" value="7"
					data-name="4,500~5,000만원">4,500~5,000만원</li>
				<li><input class="inp_chk" type="checkbox" name="DESSAL"
					value="8" data-name="5,000~6,000만원">5,000~6,000만원</li>
				<li><input class="inp_chk" type="checkbox" name="DESSAL"
					value="9" data-name="6,000만원~">6,000만원~</li>
			</ul>
			<div id="resultset">
				<ul id="resultitems"></ul>

			</div>
			<button type="button" id="filterbtn">선택된 조건 검색</button>
		</div>
	</div>

	<table id="reclist" style="width:1157px;">
		<c:if test="${listcount > 0 }">
			<c:set var="num" value="listcount" />
			<thead>
				<tr>
					<th>이름</th>
					<th>이력서요약</th>
					<th>등록일</th>
				</tr>

			</thead>

			<c:set var="num" value="${listcount-(page-1)*limit}" />
			<c:forEach var="r" items="${resumelist }">

				<tr>
					<td>${r.NAME }</td>
					<td>
						<a style="color: #666" href="./personview.euperson?gid=${r.GID}&sn=${r.SN}"><span>${r.SUBJECT }</span></a>
			
						<div><span>전공 : ${r.MAJOR}</span></div>
					</td>
					<td>${fn:substring(r.RGS_DTM, 0, 10)}</td>
				</tr>

			</c:forEach>
		</c:if>

	</table>
	<dl class="pagination">

		<dt colspan=5>
			<c:if test="${page <= 1 }">

				<a>이전&nbsp;</a>
			</c:if>
			<c:if test="${page > 1 }">
				<a href="./personlist.euperson?page=${page-1}">이전</a>&nbsp;
			</c:if>
			<c:forEach var="a" begin="${startpage}" end="${endpage}">
				<c:if test="${a == page }">
					<a>${a}</a>
				</c:if>
				<c:if test="${a != page }">
					<a href="./personlist.euperson?page=${a}">${a}</a>
				</c:if>
			</c:forEach>
			<c:if test="${page >= maxpage }">
				<a>&nbsp;다음</a>
			</c:if>
			<c:if test="${page < maxpage }">
				<a href="./personlist.euperson?page=${page+1}">&nbsp;다음</a>
			</c:if>
		</dt>

	</dl>
</body>
</html>