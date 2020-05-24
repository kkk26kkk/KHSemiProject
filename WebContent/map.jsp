<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
	request.setCharacterEncoding("UTF-8");  //한글깨지면 주석제거
	//request.setCharacterEncoding("EUC-KR");  //해당시스템의 인코딩타입이 EUC-KR일경우에
	String inputYn = request.getParameter("inputYn"); 
	String roadFullAddr = request.getParameter("roadFullAddr"); 
	String roadAddrPart1 = request.getParameter("roadAddrPart1"); 
	String roadAddrPart2 = request.getParameter("roadAddrPart2"); 
	String engAddr = request.getParameter("engAddr"); 
	String jibunAddr = request.getParameter("jibunAddr"); 
	String zipNo = request.getParameter("zipNo"); 
	String addrDetail = request.getParameter("addrDetail"); 
	String admCd    = request.getParameter("admCd");
	String rnMgtSn = request.getParameter("rnMgtSn");
	String bdMgtSn  = request.getParameter("bdMgtSn");
	String detBdNmList  = request.getParameter("detBdNmList");	
	/** 2017년 2월 추가제공 **/
	String bdNm  = request.getParameter("bdNm");
	String bdKdcd  = request.getParameter("bdKdcd");
	String siNm  = request.getParameter("siNm");
	String sggNm  = request.getParameter("sggNm");
	String emdNm  = request.getParameter("emdNm");
	String liNm  = request.getParameter("liNm");
	String rn  = request.getParameter("rn");
	String udrtYn  = request.getParameter("udrtYn");
	String buldMnnm  = request.getParameter("buldMnnm");
	String buldSlno  = request.getParameter("buldSlno");
	String mtYn  = request.getParameter("mtYn");
	String lnbrMnnm  = request.getParameter("lnbrMnnm");
	String lnbrSlno  = request.getParameter("lnbrSlno");
	/** 2017년 3월 추가제공 **/
	String emdNo  = request.getParameter("emdNo");

%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>주소로 장소 표시하기</title>
    <style>
      #map{
        margin: auto;
      }
    </style>
</head>
<body>
<p style="margin-top:-12px">
    <em class="link">
        <a href="javascript:void(0);" onclick="window.open('http://fiy.daum.net/fiy/map/CsGeneral.daum', '_blank', 'width=981, height=650')">
            혹시 주소 결과가 잘못 나오는 경우에는 여기에 제보해주세요.
        </a>
    </em>
</p>
<div id="map" style="width:600px; height:500px;"></div>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1204b42b11dd5237d404e35ef8f83e21"></script>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new daum.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };  

// 지도를 생성합니다    
var map = new daum.maps.Map(mapContainer, mapOption); 

//지도 타입 변경 컨트롤을 생성한다
var mapTypeControl = new daum.maps.MapTypeControl();

//지도의 상단 우측에 지도 타입 변경 컨트롤을 추가한다
map.addControl(mapTypeControl, daum.maps.ControlPosition.TOPRIGHT);	

//지도에 확대 축소 컨트롤을 생성한다
var zoomControl = new daum.maps.ZoomControl();

//지도의 우측에 확대 축소 컨트롤을 추가한다
map.addControl(zoomControl, daum.maps.ControlPosition.RIGHT);

// 주소-좌표 변환 객체를 생성합니다
var geocoder = new daum.maps.services.Geocoder();

// 주소로 좌표를 검색합니다
geocoder.addressSearch('서울특별시 서초구 효령로67길 48', function(result, status) {

    // 정상적으로 검색이 완료됐으면 
     if (status === daum.maps.services.Status.OK) {

        var coords = new daum.maps.LatLng(result[0].y, result[0].x);

        // 결과값으로 받은 위치를 마커로 표시합니다
        var marker = new daum.maps.Marker({
            map: map,
            position: coords
        });

        // 인포윈도우로 장소에 대한 설명을 표시합니다
        var infowindow = new daum.maps.InfoWindow({
            content: '<div style="width:150px;text-align:center;padding:6px 0;">한양아파트</div>'
        });
        infowindow.open(map, marker);

        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        map.setCenter(coords);
    } 
});

//opener관련 오류가 발생하는 경우 아래 주석을 해지하고, 사용자의 도메인정보를 입력합니다. ("팝업API 호출 소스"도 동일하게 적용시켜야 합니다.)
//document.domain = "abc.go.kr";

function goPopup(){
	// 주소검색을 수행할 팝업 페이지를 호출합니다.
	// 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(http://www.juso.go.kr/addrlink/addrLinkUrl.do)를 호출하게 됩니다.
	var pop = window.open("jusoPopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
	
	// 모바일 웹인 경우, 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(http://www.juso.go.kr/addrlink/addrMobileLinkUrl.do)를 호출하게 됩니다.
  //var pop = window.open("/popup/jusoPopup.jsp","pop","scrollbars=yes, resizable=yes"); 
}


function jusoCallBack(roadFullAddr,roadAddrPart1,addrDetail,roadAddrPart2,engAddr, jibunAddr, zipNo, admCd, rnMgtSn, bdMgtSn,detBdNmList,bdNm,bdKdcd,siNm,sggNm,emdNm,liNm,rn,udrtYn,buldMnnm,buldSlno,mtYn,lnbrMnnm,lnbrSlno,emdNo){
		// 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.
		document.form.roadFullAddr.value = roadFullAddr;
		document.form.roadAddrPart1.value = roadAddrPart1;
		document.form.roadAddrPart2.value = roadAddrPart2;
		document.form.addrDetail.value = addrDetail;
		document.form.engAddr.value = engAddr;
		document.form.jibunAddr.value = jibunAddr;
		document.form.zipNo.value = zipNo;
		document.form.admCd.value = admCd;
		document.form.rnMgtSn.value = rnMgtSn;
		document.form.bdMgtSn.value = bdMgtSn;
		document.form.detBdNmList.value = detBdNmList;
		/** 2017년 2월 추가제공 **/
		document.form.bdNm.value = bdNm;
		document.form.bdKdcd.value = bdKdcd;
		document.form.siNm.value = siNm;
		document.form.sggNm.value = sggNm;
		document.form.emdNm.value = emdNm;
		document.form.liNm.value = liNm;
		document.form.rn.value = rn;
		document.form.udrtYn.value = udrtYn;
		document.form.buldMnnm.value = buldMnnm;
		document.form.buldSlno.value = buldSlno;
		document.form.mtYn.value = mtYn;
		document.form.lnbrMnnm.value = lnbrMnnm;
		document.form.lnbrSlno.value = lnbrSlno;
		/** 2017년 3월 추가제공 **/
		document.form.emdNo.value = emdNo;
		
}

</script>

<hr>

<form name="form" id="form" method="post">

	<input type="button" onClick="goPopup();" value="팝업_domainChk"/>
	<div id="list"></div>
	<div id="callBackDiv">
		<table>
			<tr><td>도로명주소 전체(포멧)</td><td><input type="text"  style="width:500px;" id="roadFullAddr"  name="roadFullAddr" /></td></tr>
			<tr><td>도로명주소           </td><td><input type="text"  style="width:500px;" id="roadAddrPart1"  name="roadAddrPart1" /></td></tr>
			<tr><td>고객입력 상세주소    </td><td><input type="text"  style="width:500px;" id="addrDetail"  name="addrDetail" /></td></tr>
			<tr><td>참고주소             </td><td><input type="text"  style="width:500px;" id="roadAddrPart2"  name="roadAddrPart2" /></td></tr>
			<tr><td>영문 도로명주소      </td><td><input type="text"  style="width:500px;" id="engAddr"  name="engAddr" /></td></tr>
			<tr><td>지번                 </td><td><input type="text"  style="width:500px;" id="jibunAddr"  name="jibunAddr" /></td></tr>
			<tr><td>우편번호             </td><td><input type="text"  style="width:500px;" id="zipNo"  name="zipNo" /></td></tr>
			<tr><td>행정구역코드        </td><td><input type="text"  style="width:500px;" id="admCd"  name="admCd" /></td></tr>
			<tr><td>도로명코드          </td><td><input type="text"  style="width:500px;" id="rnMgtSn"  name="rnMgtSn" /></td></tr>
			<tr><td>건물관리번호        </td><td><input type="text"  style="width:500px;" id="bdMgtSn"  name="bdMgtSn" /></td></tr>
			<tr><td>상세번물명        	</td><td><input type="text"  style="width:500px;" id="detBdNmList"  name="detBdNmList" /></td></tr>
			<tr><td>건물명        		</td><td><input type="text"  style="width:500px;" id="bdNm"  name="bdNm" /></td></tr>
			<tr><td>공동주택여부       </td><td><input type="text"  style="width:500px;" id="bdKdcd"  name="bdKdcd" /></td></tr>
			<tr><td>시도명        		</td><td><input type="text"  style="width:500px;" id="siNm"  name="siNm" /></td></tr>
			<tr><td>시군구명        	</td><td><input type="text"  style="width:500px;" id="sggNm"  name="sggNm" /></td></tr>
			<tr><td>읍면동명        	</td><td><input type="text"  style="width:500px;" id="emdNm"  name="emdNm" /></td></tr>
			<tr><td>법정리명        	</td><td><input type="text"  style="width:500px;" id="liNm"  name="liNm" /></td></tr>
			<tr><td>도로명        		</td><td><input type="text"  style="width:500px;" id="rn"  name="rn" /></td></tr>
			<tr><td>지하여부        	</td><td><input type="text"  style="width:500px;" id="udrtYn"  name="udrtYn" /></td></tr>
			<tr><td>건물본번        	</td><td><input type="text"  style="width:500px;" id="buldMnnm"  name="buldMnnm" /></td></tr>
			<tr><td>건물부번        	</td><td><input type="text"  style="width:500px;" id="buldSlno"  name="buldSlno" /></td></tr>
			<tr><td>산여부        		</td><td><input type="text"  style="width:500px;" id="mtYn"  name="mtYn" /></td></tr>
			<tr><td>지번본번(번지)     </td><td><input type="text"  style="width:500px;" id="lnbrMnnm"  name="lnbrMnnm" /></td></tr>
			<tr><td>지번부번(호)       </td><td><input type="text"  style="width:500px;" id="lnbrSlno"  name="lnbrSlno" /></td></tr>
			<tr><td>읍면동일련번호       </td><td><input type="text"  style="width:500px;" id="emdNo"  name="emdNo" /></td></tr>
		</table>
	</div>

</form>
</body>
</html>