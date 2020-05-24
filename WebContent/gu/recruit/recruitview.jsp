<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="vo.Recruit" %>
<%@ taglib prefix="c"
		   uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="r" value="${rec }"/>
<!DOCTYPE html>
<html>
<head>
<title>${rec.SUBJECT }</title>
<link rel="stylesheet" href="css/recruitview.css"/>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1204b42b11dd5237d404e35ef8f83e21&libraries=services"></script>

</head>
<jsp:include page="../../header.jsp"/>
<%
	Recruit r = new Recruit();
	r = (Recruit)request.getAttribute("rec");
	String career = "", edu = "", jtype = "", etype = "", 
			region = "", duty = "", industry = "";
	
	if(r.getCAREER().equals("1"))
		career = "신입";
	else if(r.getCAREER().equals("2"))
		career = "1~3년";
	else if(r.getCAREER().equals("3"))
		career = "4~6년";
	else if(r.getCAREER().equals("4"))
		career = "7~9년";
	else if(r.getCAREER().equals("5"))
		career = "10~15년";
	else if(r.getCAREER().equals("6"))
		career = "16~20년";
	else if(r.getCAREER().equals("7"))
		career = "21년 이상";
	else if(r.getCAREER().equals("8"))
		career = "경력무관";
	
	if(r.getEDU().equals("1"))
		edu = "대학교 졸업(4년)";
	else if(r.getEDU().equals("2"))
		edu = "대학교 졸업(2,3년)";
	else if(r.getEDU().equals("3"))
		edu = "대학원 석사 졸업";
	else if(r.getEDU().equals("4"))
		edu = "대학원 박사 졸업";
	else if(r.getEDU().equals("5"))
		edu = "고등학교 졸업";
	else if(r.getEDU().equals("6"))
		edu = "학력무관";
	
	if(r.getJTYPE().equals("1"))
		jtype = "정규직";
	else if(r.getJTYPE().equals("2"))
		jtype = "계약직";
	else if(r.getJTYPE().equals("3"))
		jtype = "인턴";
	else if(r.getJTYPE().equals("4"))
		jtype = "파견직";
	else if(r.getJTYPE().equals("5"))
		jtype = "프리랜서";
	else if(r.getJTYPE().equals("6"))
		jtype = "연수생/교육생";
	
	if(r.getETYPE().equals("1"))
		etype = "대기업";
	else if(r.getETYPE().equals("2"))
		etype = "중견기업";
	else if(r.getETYPE().equals("3"))
		etype = "중소기업";
	else if(r.getETYPE().equals("4"))
		etype = "강소기업";
	else if(r.getETYPE().equals("5"))
		etype = "외국계기업";
	else if(r.getETYPE().equals("6"))
		etype = "벤처기업";
	else if(r.getETYPE().equals("7"))
		etype = "공공기관·공기업";
	
	if(r.getREGION().equals("1"))
		region = "서울특별시";
	else if(r.getREGION().equals("2"))
		region = "경기도";
	else if(r.getREGION().equals("3"))
		region = "인천광역시";
	else if(r.getREGION().equals("4"))
		region = "대전광역시";
	else if(r.getREGION().equals("5"))
		region = "세종특별자치시";
	else if(r.getREGION().equals("6"))
		region = "충청남도";
	else if(r.getREGION().equals("7"))
		region = "광주광역시";
	else if(r.getREGION().equals("8"))
		region = "전라남도";
	else if(r.getREGION().equals("9"))
		region = "전라북도";
	else if(r.getREGION().equals("10"))
		region = "대구광역시";
	else if(r.getREGION().equals("11"))
		region = "경상북도";
	else if(r.getREGION().equals("12"))
		region = "부산광역시";
	else if(r.getREGION().equals("13"))
		region = "울산광역시";
	else if(r.getREGION().equals("14"))
		region = "경상남도";
	else if(r.getREGION().equals("15"))
		region = "강원도";
	else if(r.getREGION().equals("16"))
		region = "제주특별자치도";
	
	if(r.getDUTY().equals("1"))
		duty = "경영·사무";
	else if(r.getDUTY().equals("2"))
		duty = "마케팅·광고·홍보";
	else if(r.getDUTY().equals("3"))
		duty = "IT·인터넷";
	else if(r.getDUTY().equals("4"))
		duty = "디자인";
	else if(r.getDUTY().equals("5"))
		duty = "무역·유통";
	else if(r.getDUTY().equals("6"))
		duty = "영업·고객상담";
	else if(r.getDUTY().equals("7"))
		duty = "서비스";
	else if(r.getDUTY().equals("8"))
		duty = "연구개발·설계";
	else if(r.getDUTY().equals("9"))
		duty = "생산·제조";
	else if(r.getDUTY().equals("10"))
		duty = "교육";
	else if(r.getDUTY().equals("11"))
		duty = "건설";
	else if(r.getDUTY().equals("12"))
		duty = "의료";
	else if(r.getDUTY().equals("13"))
		duty = "미디어";
	else if(r.getDUTY().equals("14"))
		duty = "전문·특수직";
	
	if(r.getINDUSTRY().equals("1"))
		industry = "서비스업";
	else if(r.getINDUSTRY().equals("2"))
		industry = "금융·은행업";
	else if(r.getINDUSTRY().equals("3"))
		industry = "IT·정보통신업";
	else if(r.getINDUSTRY().equals("4"))
		industry = "판매·유통업";
	else if(r.getINDUSTRY().equals("5"))
		industry = "제조·생산·화학업";
	else if(r.getINDUSTRY().equals("6"))
		industry = "교육업";
	else if(r.getINDUSTRY().equals("7"))
		industry = "의료·제약업";
	else if(r.getINDUSTRY().equals("8"))
		industry = "미디어·광고업";
	else if(r.getINDUSTRY().equals("9"))
		industry = "문화·예술·디자인업";
	else if(r.getINDUSTRY().equals("10"))
		industry = "기관·협회";
%>
<body>
<div id="viewmain">
<div id="viewwrap">
  <h2 id="viewtitle">채용 정보</h2>
  <div id="info">
    <h3 class="ename">${r.ENAME }</h3>
    <h3 class="esubject">${r.SUBJECT }</h3>
    <div class="logo"><img src="logo/${r.LOGO }" width="100px" height="40px"></div>
    
    <div class="info2">
      <span class="jiwonja">지원자격</span>
      <dl><dt>경력</dt><dd><%=career %></dd></dl>
      <dl><dt>학력</dt><dd><%=edu %></dd></dl>
      
      <div class="info3">
        <span class="geunmujogeon">근무조건</span>
        <dl><dt>고용형태</dt><dd><%=jtype %></dd></dl>
        <dl><dt>급여</dt><dd>${r.PAY }</dd></dl>
        <dl><dt>지역</dt><dd><%=region %></dd></dl>
        <dl><dt>근무시간</dt><dd>${r.WDAY } ${r.WTIME }</dd></dl>
      </div>
      
      <div class="info4">
        <span class="giupjungbo">기업정보</span>
        <dl><dt>산업</dt><dd><%=industry %></dd></dl>
        <dl><dt>사원수</dt><dd>${r.ENUM }명</dd></dl>
        <dl><dt>기업형태</dt><dd><%=etype %></dd></dl>
        <dl><dt>홈페이지</dt><dd>${r.PAGEADDR }</dd></dl>
        <dl><dt>매출액</dt><dd>${r.PAY }</dd></dl>
      </div>
    </div>
  
  </div>
  
</div>

  <div id="applydiv">
	<a href="" class="applybtn" onclick="goPopup('${r.EID}', '${r.SN }');"><span>&#10003;</span>&nbsp;지원하기</a>
  </div>

<script>
function goPopup(eid, sn){
	var screenW = screen.availWidth;
	var screenH = screen.availHeight;
	var posL = (screenW - 570) / 2;
	var posT = (screenH - 420) / 2;
	var q = "gid=${gid}&eid="+eid+"&sn="+sn;
	
	var pop = window.open('./recruitapply.gurecruit?'+q,
			'post', 'width=500, height=500, top='+posT+',left='+posL);
}
</script>
<div id="infocontent">
  <h2 class="h2t">모집분야 및 자격요건</h2>
  <ul class="ul2">
    <li>모집분야 : ${r.KIND }</li>
    <li>담당업무 : ${r.JOB }<br></li>
    <li>자격요건  : ${r.ELIGI }<br></li>
    <li>모집인원  : ${r.RECNUM }<br></li>
  </ul>
  <h2 class="h2t">근무조건</h2>
  <ul class="ul2">
    <li>근무형태 : ${r.WTYPE }</li>
    <li>근무지 : <%=region %></li>
    <li>근무요일 : ${r.WDAY }</li>
    <li>근무시간 : ${r.WTIME }</li>
    <li>급여 : ${r.REVENUE }</li>
  </ul>
  <h2 class="h2t">전형절차</h2>
  <ul class="ul2">
    <li>서류전형 > 1차면접 > 임원면접 > 최종합격 </li>
  </ul>
  <h2 class="h2t">접수기간</h2>
  <ul class="ul2">
    <li>${r.STARTDATE } ~ ${r.ENDDATE } </li>
  </ul>
  <h2 class="h2t">제출서류</h2>
  <ul class="ul2"><li>이력서, 자기소개서 제출</li></ul>
  <h2 class="h2t">유의사항</h2>
  <ul class="ul2"><li>${r.NOTICE }</li></ul>
</div>

<div id="hwangyung">
<h2 class="h2t hwan">근무환경</h2>
<strong><i class="material-icons" style="font-size:18px; line-height:0">place</i>${r.EADDR1 }</strong>

<div id="map"></div>
  
  <script>
  var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
  mapOption = { 
      center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
      level: 3 // 지도의 확대 레벨
  };

	var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
	
	//지도 타입 변경 컨트롤을 생성한다
	var mapTypeControl = new kakao.maps.MapTypeControl();
	
	//지도의 상단 우측에 지도 타입 변경 컨트롤을 추가한다
	map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);	
	
	//지도에 확대 축소 컨트롤을 생성한다
	var zoomControl = new kakao.maps.ZoomControl();
	
	//지도의 우측에 확대 축소 컨트롤을 추가한다
	map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);
	
	// 주소-좌표 변환 객체를 생성합니다
	var geocoder = new kakao.maps.services.Geocoder();
	
	var eaddr1 = '${r.EADDR1}';
	var eaddr2 = '${r.EADDR2}';

	// 주소로 좌표를 검색합니다
	geocoder.addressSearch(eaddr1, function(result, status) {
	
	    // 정상적으로 검색이 완료됐으면 
	     if (status === kakao.maps.services.Status.OK) {
	
	        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
	
	        // 결과값으로 받은 위치를 마커로 표시합니다
	        var marker = new kakao.maps.Marker({
	            map: map,
	            position: coords
	        });
	
	        // 인포윈도우로 장소에 대한 설명을 표시합니다
	        var infowindow = new kakao.maps.InfoWindow({
	            content: '<div style="width:150px;text-align:center;padding:6px 0; font-weight: bold;">'+eaddr2+'</div>'
	        });
	        infowindow.open(map, marker);
	
	        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
	        map.setCenter(coords);
	    } 
	});	
  </script>
  <span class="bokri">복리후생</span><span class="bokri">연금·보험</span><span class="boheom">
  	국민연금, 고용보험, 산재보험, 건강보험</span>
</div> <%-- map end --%>
</div>
</body>
</html>