<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>���ȸ�� ����</title>
<link rel="stylesheet" href="css/eumain2.css">
<script src="js/jquery-3.0.0.js"></script>
<script>
$(document).ready(function() {
	$(".list tr").click(function(){
		//���� ������ tr ������ value�� �����ɴϴ�.
		$('table:last tbody').empty();
		var senddata = $(this).prev().val();
		$.ajax({
			type : "POST",
			data : {"eid_sn" : senddata},
			url : "updateinfo.eurecruit",
			dataType : 'json',
			success : function(rdata){
				
				var output = '';
				$(rdata).each(function (index, item){
					output += '<tr>';
					output += '<td><a style="color: #000;" href=./personview.euperson?gid='+item.GID+'&sn='+item.SN+'>' + item.SUBJECT + "</td>";
					output += '<td>' + item.NAME + '</td>';
					output += '</tr>';
				})
				$('table:last tbody').append(output);
			}
		
		})
		
	})
	
})
</script>
</head>
<body>
<jsp:include page="../euheader.jsp"/><br><br><br>
<div id="eumainwrap">
<div class="emhead"><h2 id="title">���� ����</h2></div>
  <div id="eumaincontainer">
  <table class="list">  
 	<tr>
 		<th colspan="3">���� ���</th>
 	</tr>
    <tr>
      <td><span><strong>��������</strong></span></td>
      <td><span><strong>�����</strong></span></td>
      <td><span><strong>��ϳ�¥</strong></span></td>
    </tr>
    <c:forEach var="m" items="${reclist}">
    <input type=hidden name="eid_sn" value="${m.SN}">
<%--     <c:set target = "${m}" property = "rec"/> --%>
    <tr>
			<td><a href="./recruitview.gurecruit?eid=${m.EID}&sn=${m.SN }">${m.SUBJECT}</a></td>
			<td>${m.ENAME}</td>
			<td>${m.RGS_DTM}</td>	
	</tr>
	</c:forEach>
  </table>
   </div>
  <br><br>
  <div class="emhead"><h2 id="title">������ ����</h2></div>
  <div id="eumaincontainer2">
  <table class="list">
  <thead>
 	 <tr>
 		<th colspan="2">������ ���</th>
 	</tr>
    <tr>
      <td><span><strong>�̷¼� ����</strong></span></td>
      <td><span><strong>������ �̸�</strong></span></td>
   	</tr>
   </thead>
   <tbody>
   
   </tbody>	
   
    </table>
    </div>

</div>
</body>
</html>