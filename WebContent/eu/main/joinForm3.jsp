<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>기업회원 회원가입</title>
<script>
function goPopup(){
	// 주소검색을 수행할 팝업 페이지를 호출합니다.
	// 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(http://www.juso.go.kr/addrlink/addrLinkUrl.do)를 호출하게 됩니다.
	var pop = window.open("jusoPopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
	
	// 모바일 웹인 경우, 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(http://www.juso.go.kr/addrlink/addrMobileLinkUrl.do)를 호출하게 됩니다.
    //var pop = window.open("/popup/jusoPopup.jsp","pop","scrollbars=yes, resizable=yes"); 
}

function jusoCallBack(roadFullAddr,roadAddrPart1,addrDetail,roadAddrPart2,engAddr, jibunAddr, zipNo, admCd, rnMgtSn, bdMgtSn,detBdNmList,bdNm,bdKdcd,siNm,sggNm,emdNm,liNm,rn,udrtYn,buldMnnm,buldSlno,mtYn,lnbrMnnm,lnbrSlno,emdNo){
// 	// 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.
// 	document.form.roadFullAddr.value = roadFullAddr;
// 	document.form.roadAddrPart1.value = roadAddrPart1;
// 	document.form.roadAddrPart2.value = roadAddrPart2;
// 	document.form.addrDetail.value = addrDetail;
// 	document.form.engAddr.value = engAddr;
// 	document.form.jibunAddr.value = jibunAddr;
// 	document.form.zipNo.value = zipNo;
// 	document.form.admCd.value = admCd;
// 	document.form.rnMgtSn.value = rnMgtSn;
// 	document.form.bdMgtSn.value = bdMgtSn;
// 	document.form.detBdNmList.value = detBdNmList;
// 	/** 2017년 2월 추가제공 **/
// 	document.form.bdNm.value = bdNm;
// 	document.form.bdKdcd.value = bdKdcd;
// 	document.form.siNm.value = siNm;
// 	document.form.sggNm.value = sggNm;
// 	document.form.emdNm.value = emdNm;
// 	document.form.liNm.value = liNm;
// 	document.form.rn.value = rn;
// 	document.form.udrtYn.value = udrtYn;
// 	document.form.buldMnnm.value = buldMnnm;
// 	document.form.buldSlno.value = buldSlno;
// 	document.form.mtYn.value = mtYn;
// 	document.form.lnbrMnnm.value = lnbrMnnm;
// 	document.form.lnbrSlno.value = lnbrSlno;
// 	/** 2017년 3월 추가제공 **/
// 	document.form.emdNo.value = emdNo;

	// 여기
	document.getElementById('eaddr').value = roadFullAddr;
	document.getElementById('eaddr1').value = roadAddrPart1;
	document.getElementById('eaddr2').value = addrDetail;
}
</script>
<link href="css/eujoinform.css" rel="stylesheet" type="text/css">
</head>
<body>
기업 회원 가입 페이지입니다.
<form action="./joinProcess.eumain" method="post">
  <span>기업 정보</span><br>
  <input type="text" name="ENAME" placeholder="회사명"><br>
  <input type="text" name="ENUM" placeholder="사업자번호"><br>
  <input type="text" name="OWNERNAME" placeholder="대표자명"><br>
  <input type="text" id="eaddr" name="EADDR" style="width:500px;" placeholder="회사주소"><br>
  <input type="hidden" id="eaddr1" name="EADDR1" style="width:500px;" placeholder="회사주소1">
  <input type="hidden" id="eaddr2" name="EADDR2" style="width:500px;" placeholder="회사주소2"/>
  <input type="button" onClick="goPopup();" value="주소검색"/><br>
  <br>
  <span>인사담당자 정보</span><br>
  <input type="text" name="HRDNAME" placeholder="담당자명"><br>
  <input type="text" name="EID" placeholder="아이디"><br>
  <input type="password" name="PW" placeholder="비밀번호"><br>
  <input type="text" name="PHONE" placeholder="전화번호"><br>
  <input type="text" name="EMAIL" placeholder="이메일"><br>
<input type="submit" value="등록">
<input type="reset" value="취소">
</form>
</body>
</html>