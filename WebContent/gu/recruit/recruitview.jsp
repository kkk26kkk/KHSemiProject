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
		career = "����";
	else if(r.getCAREER().equals("2"))
		career = "1~3��";
	else if(r.getCAREER().equals("3"))
		career = "4~6��";
	else if(r.getCAREER().equals("4"))
		career = "7~9��";
	else if(r.getCAREER().equals("5"))
		career = "10~15��";
	else if(r.getCAREER().equals("6"))
		career = "16~20��";
	else if(r.getCAREER().equals("7"))
		career = "21�� �̻�";
	else if(r.getCAREER().equals("8"))
		career = "��¹���";
	
	if(r.getEDU().equals("1"))
		edu = "���б� ����(4��)";
	else if(r.getEDU().equals("2"))
		edu = "���б� ����(2,3��)";
	else if(r.getEDU().equals("3"))
		edu = "���п� ���� ����";
	else if(r.getEDU().equals("4"))
		edu = "���п� �ڻ� ����";
	else if(r.getEDU().equals("5"))
		edu = "����б� ����";
	else if(r.getEDU().equals("6"))
		edu = "�з¹���";
	
	if(r.getJTYPE().equals("1"))
		jtype = "������";
	else if(r.getJTYPE().equals("2"))
		jtype = "�����";
	else if(r.getJTYPE().equals("3"))
		jtype = "����";
	else if(r.getJTYPE().equals("4"))
		jtype = "�İ���";
	else if(r.getJTYPE().equals("5"))
		jtype = "��������";
	else if(r.getJTYPE().equals("6"))
		jtype = "������/������";
	
	if(r.getETYPE().equals("1"))
		etype = "����";
	else if(r.getETYPE().equals("2"))
		etype = "�߰߱��";
	else if(r.getETYPE().equals("3"))
		etype = "�߼ұ��";
	else if(r.getETYPE().equals("4"))
		etype = "���ұ��";
	else if(r.getETYPE().equals("5"))
		etype = "�ܱ�����";
	else if(r.getETYPE().equals("6"))
		etype = "��ó���";
	else if(r.getETYPE().equals("7"))
		etype = "��������������";
	
	if(r.getREGION().equals("1"))
		region = "����Ư����";
	else if(r.getREGION().equals("2"))
		region = "��⵵";
	else if(r.getREGION().equals("3"))
		region = "��õ������";
	else if(r.getREGION().equals("4"))
		region = "����������";
	else if(r.getREGION().equals("5"))
		region = "����Ư����ġ��";
	else if(r.getREGION().equals("6"))
		region = "��û����";
	else if(r.getREGION().equals("7"))
		region = "���ֱ�����";
	else if(r.getREGION().equals("8"))
		region = "���󳲵�";
	else if(r.getREGION().equals("9"))
		region = "����ϵ�";
	else if(r.getREGION().equals("10"))
		region = "�뱸������";
	else if(r.getREGION().equals("11"))
		region = "���ϵ�";
	else if(r.getREGION().equals("12"))
		region = "�λ걤����";
	else if(r.getREGION().equals("13"))
		region = "��걤����";
	else if(r.getREGION().equals("14"))
		region = "��󳲵�";
	else if(r.getREGION().equals("15"))
		region = "������";
	else if(r.getREGION().equals("16"))
		region = "����Ư����ġ��";
	
	if(r.getDUTY().equals("1"))
		duty = "�濵���繫";
	else if(r.getDUTY().equals("2"))
		duty = "�����á�����ȫ��";
	else if(r.getDUTY().equals("3"))
		duty = "IT�����ͳ�";
	else if(r.getDUTY().equals("4"))
		duty = "������";
	else if(r.getDUTY().equals("5"))
		duty = "����������";
	else if(r.getDUTY().equals("6"))
		duty = "�����������";
	else if(r.getDUTY().equals("7"))
		duty = "����";
	else if(r.getDUTY().equals("8"))
		duty = "�������ߡ�����";
	else if(r.getDUTY().equals("9"))
		duty = "���ꡤ����";
	else if(r.getDUTY().equals("10"))
		duty = "����";
	else if(r.getDUTY().equals("11"))
		duty = "�Ǽ�";
	else if(r.getDUTY().equals("12"))
		duty = "�Ƿ�";
	else if(r.getDUTY().equals("13"))
		duty = "�̵��";
	else if(r.getDUTY().equals("14"))
		duty = "������Ư����";
	
	if(r.getINDUSTRY().equals("1"))
		industry = "���񽺾�";
	else if(r.getINDUSTRY().equals("2"))
		industry = "�����������";
	else if(r.getINDUSTRY().equals("3"))
		industry = "IT��������ž�";
	else if(r.getINDUSTRY().equals("4"))
		industry = "�Ǹš������";
	else if(r.getINDUSTRY().equals("5"))
		industry = "���������ꡤȭ�о�";
	else if(r.getINDUSTRY().equals("6"))
		industry = "������";
	else if(r.getINDUSTRY().equals("7"))
		industry = "�Ƿᡤ�����";
	else if(r.getINDUSTRY().equals("8"))
		industry = "�̵������";
	else if(r.getINDUSTRY().equals("9"))
		industry = "��ȭ�������������ξ�";
	else if(r.getINDUSTRY().equals("10"))
		industry = "�������ȸ";
%>
<body>
<div id="viewmain">
<div id="viewwrap">
  <h2 id="viewtitle">ä�� ����</h2>
  <div id="info">
    <h3 class="ename">${r.ENAME }</h3>
    <h3 class="esubject">${r.SUBJECT }</h3>
    <div class="logo"><img src="logo/${r.LOGO }" width="100px" height="40px"></div>
    
    <div class="info2">
      <span class="jiwonja">�����ڰ�</span>
      <dl><dt>���</dt><dd><%=career %></dd></dl>
      <dl><dt>�з�</dt><dd><%=edu %></dd></dl>
      
      <div class="info3">
        <span class="geunmujogeon">�ٹ�����</span>
        <dl><dt>�������</dt><dd><%=jtype %></dd></dl>
        <dl><dt>�޿�</dt><dd>${r.PAY }</dd></dl>
        <dl><dt>����</dt><dd><%=region %></dd></dl>
        <dl><dt>�ٹ��ð�</dt><dd>${r.WDAY } ${r.WTIME }</dd></dl>
      </div>
      
      <div class="info4">
        <span class="giupjungbo">�������</span>
        <dl><dt>���</dt><dd><%=industry %></dd></dl>
        <dl><dt>�����</dt><dd>${r.ENUM }��</dd></dl>
        <dl><dt>�������</dt><dd><%=etype %></dd></dl>
        <dl><dt>Ȩ������</dt><dd>${r.PAGEADDR }</dd></dl>
        <dl><dt>�����</dt><dd>${r.PAY }</dd></dl>
      </div>
    </div>
  
  </div>
  
</div>

  <div id="applydiv">
	<a href="" class="applybtn" onclick="goPopup('${r.EID}', '${r.SN }');"><span>&#10003;</span>&nbsp;�����ϱ�</a>
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
  <h2 class="h2t">�����о� �� �ڰݿ��</h2>
  <ul class="ul2">
    <li>�����о� : ${r.KIND }</li>
    <li>������ : ${r.JOB }<br></li>
    <li>�ڰݿ��  : ${r.ELIGI }<br></li>
    <li>�����ο�  : ${r.RECNUM }<br></li>
  </ul>
  <h2 class="h2t">�ٹ�����</h2>
  <ul class="ul2">
    <li>�ٹ����� : ${r.WTYPE }</li>
    <li>�ٹ��� : <%=region %></li>
    <li>�ٹ����� : ${r.WDAY }</li>
    <li>�ٹ��ð� : ${r.WTIME }</li>
    <li>�޿� : ${r.REVENUE }</li>
  </ul>
  <h2 class="h2t">��������</h2>
  <ul class="ul2">
    <li>�������� > 1������ > �ӿ����� > �����հ� </li>
  </ul>
  <h2 class="h2t">�����Ⱓ</h2>
  <ul class="ul2">
    <li>${r.STARTDATE } ~ ${r.ENDDATE } </li>
  </ul>
  <h2 class="h2t">���⼭��</h2>
  <ul class="ul2"><li>�̷¼�, �ڱ�Ұ��� ����</li></ul>
  <h2 class="h2t">���ǻ���</h2>
  <ul class="ul2"><li>${r.NOTICE }</li></ul>
</div>

<div id="hwangyung">
<h2 class="h2t hwan">�ٹ�ȯ��</h2>
<strong><i class="material-icons" style="font-size:18px; line-height:0">place</i>${r.EADDR1 }</strong>

<div id="map"></div>
  
  <script>
  var mapContainer = document.getElementById('map'), // ������ ǥ���� div 
  mapOption = { 
      center: new kakao.maps.LatLng(33.450701, 126.570667), // ������ �߽���ǥ
      level: 3 // ������ Ȯ�� ����
  };

	var map = new kakao.maps.Map(mapContainer, mapOption); // ������ �����մϴ�
	
	//���� Ÿ�� ���� ��Ʈ���� �����Ѵ�
	var mapTypeControl = new kakao.maps.MapTypeControl();
	
	//������ ��� ������ ���� Ÿ�� ���� ��Ʈ���� �߰��Ѵ�
	map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);	
	
	//������ Ȯ�� ��� ��Ʈ���� �����Ѵ�
	var zoomControl = new kakao.maps.ZoomControl();
	
	//������ ������ Ȯ�� ��� ��Ʈ���� �߰��Ѵ�
	map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);
	
	// �ּ�-��ǥ ��ȯ ��ü�� �����մϴ�
	var geocoder = new kakao.maps.services.Geocoder();
	
	var eaddr1 = '${r.EADDR1}';
	var eaddr2 = '${r.EADDR2}';

	// �ּҷ� ��ǥ�� �˻��մϴ�
	geocoder.addressSearch(eaddr1, function(result, status) {
	
	    // ���������� �˻��� �Ϸ������ 
	     if (status === kakao.maps.services.Status.OK) {
	
	        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
	
	        // ��������� ���� ��ġ�� ��Ŀ�� ǥ���մϴ�
	        var marker = new kakao.maps.Marker({
	            map: map,
	            position: coords
	        });
	
	        // ����������� ��ҿ� ���� ������ ǥ���մϴ�
	        var infowindow = new kakao.maps.InfoWindow({
	            content: '<div style="width:150px;text-align:center;padding:6px 0; font-weight: bold;">'+eaddr2+'</div>'
	        });
	        infowindow.open(map, marker);
	
	        // ������ �߽��� ��������� ���� ��ġ�� �̵���ŵ�ϴ�
	        map.setCenter(coords);
	    } 
	});	
  </script>
  <span class="bokri">�����Ļ�</span><span class="bokri">���ݡ�����</span><span class="boheom">
  	���ο���, ��뺸��, ���纸��, �ǰ�����</span>
</div> <%-- map end --%>
</div>
</body>
</html>