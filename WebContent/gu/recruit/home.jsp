<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c"
		   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>ä�� ����</title>
<link rel="stylesheet" href="css/gurecruit_home.css">
<script src="js/jquery-3.0.0.js"></script>
<script>
  $(function(){
	 $('.shsub > li').click(function(){
		if($(this).children().prop('checked') == true) {
			$(this).children().prop('checked', false);
			$(this).css('color', '#000').css('font-weight', 'normal');
			$('#resultitems li[name="' + $(this).children().data('name') + '"]').remove();
		}
		else {
			$(this).children().prop('checked', true);
			$(this).css('color', '#3399ff').css('font-weight', 'bold');
			var btn = $('<button/>', {type: 'button', value: $(this).children().val(),
									  text: $(this).children().data('name')});
			$('<li/>', {name: $(this).children().data('name')}).append(btn).appendTo('#resultitems');
		}
	 });
	 
	 $('#filterbtn').click(function(){
		$('#reclist:last tbody').empty();
		$.ajax({
			type : "GET",
			url : "recruitlistajax.gurecruit",
			data : {
				"DUTY" : $("input[name=DUTY]:checked").val(),
				"REGION" : $("input[name=REGION]:checked").val(),
				"CAREER" : $("input[name=CAREER]:checked").val(),
				"EDU" : $("input[name=EDU]:checked").val(),
				"ETYPE" : $("input[name=ETYPE]:checked").val(),
				"JTYPE": $("input[name=JTYPE]:checked").val()
			},
			dataType : 'json',
// 			cache : false,
			success : function(rdata){
				var output = '';
				$(rdata).each(function(index, item){
					var q = '"'+item.EID+'","'+item.SN+'"';
					
					output += '<tr>';
					output += '<td>' + item.ENAME + '</td>';
					output += '<td><a href=./recruitview.gurecruit?eid='+item.EID+'&sn='+item.SN+'>'+item.SUBJECT+'</a></td>';
					output += "<td><a href='' onclick='goPopup("+q+");'><span>&#10003;</span>&nbsp;�����ϱ�</a></td>";
					output += '</tr>';
				});
				$('#reclist:last tbody').append(output);
			},
			error : function(){
				alert('error');
			}
		}); // ajax end
	 }); // function end
	 
	 $('#resetbtn').click(function(){
		$('.inp_chk').prop('checked', false);
		$('.shsub > li').css('color', '#000').css('font-weight', 'normal');
		$('#resultitems > li').remove();
	 })
  });
  
function goPopup(eid, sn){
	var screenW = screen.availWidth;
	var screenH = screen.availHeight;
	var posL = (screenW - 570) / 2;
	var posT = (screenH - 420) / 2;
	var q = "gid=${gid}&eid="+eid+"&sn="+sn;
	var pop = window.open('./recruitapply.gurecruit?'+ q,
			'post', 'width=500, height=500, top='+posT+',left='+posL);
}
</script>
</head>
<jsp:include page="../../header.jsp"/>
<body>
<div id="searchwrap">
<h2 id="searchtitle">ä����� ���ǰ˻�</h2>
  <div class="searchArea">
   <p class="searchheader"><strong>����</strong></p><p class="searchheader"><strong>�ٹ�����</strong>
   </p><p class="searchheader"><strong>���</strong>
   </p><p class="searchheader"><strong>�з�</strong>
   </p><p class="searchheader"><strong>�������</strong>
   </p><p class="searchheader"><strong>�������</strong></p><ul class="shsub">
       <li><input class="inp_chk" type="checkbox" name="DUTY" value="1" data-name="�濵���繫">�濵���繫</li>
       <li><input class="inp_chk" type="checkbox" name="DUTY" value="2" data-name="�����á�����ȫ��">�����á�����ȫ��</li>
       <li><input class="inp_chk" type="checkbox" name="DUTY" value="3" data-name="IT�����ͳ�">IT�����ͳ�</li>
       <li><input class="inp_chk" type="checkbox" name="DUTY" value="4" data-name="������">������</li>
       <li><input class="inp_chk" type="checkbox" name="DUTY" value="5" data-name="����������">����������</li>
       <li><input class="inp_chk" type="checkbox" name="DUTY" value="6" data-name="�����������">�����������</li>
       <li><input class="inp_chk" type="checkbox" name="DUTY" value="7" data-name="����">����</li>
       <li><input class="inp_chk" type="checkbox" name="DUTY" value="8" data-name="�������ߡ�����">�������ߡ�����</li>
       <li><input class="inp_chk" type="checkbox" name="DUTY" value="9" data-name="���ꡤ����">���ꡤ����</li>
       <li><input class="inp_chk" type="checkbox" name="DUTY" value="10" data-name="����">����</li>
       <li><input class="inp_chk" type="checkbox" name="DUTY" value="11" data-name="�Ǽ�">�Ǽ�</li>
       <li><input class="inp_chk" type="checkbox" name="DUTY" value="12" data-name="�Ƿ�">�Ƿ�</li>
       <li><input class="inp_chk" type="checkbox" name="DUTY" value="13" data-name="�̵��">�̵��</li>
       <li><input class="inp_chk" type="checkbox" name="DUTY" value="14" data-name="������Ư����">������Ư����</li>
   </ul><ul class="shsub">
       <li><input class="inp_chk" type="checkbox" name="REGION" value="1" data-name="����Ư����">����Ư����</li>
       <li><input class="inp_chk" type="checkbox" name="REGION" value="2" data-name="��⵵">��⵵</li>
       <li><input class="inp_chk" type="checkbox" name="REGION" value="3" data-name="��õ������">��õ������</li>
       <li><input class="inp_chk" type="checkbox" name="REGION" value="4" data-name="����������">����������</li>
       <li><input class="inp_chk" type="checkbox" name="REGION" value="5" data-name="����Ư����ġ��">����Ư����ġ��</li>
       <li><input class="inp_chk" type="checkbox" name="REGION" value="6" data-name="��û����">��û����</li>
       <li><input class="inp_chk" type="checkbox" name="REGION" value="7" data-name="���ֱ�����">���ֱ�����</li>
       <li><input class="inp_chk" type="checkbox" name="REGION" value="8" data-name="���󳲵�">���󳲵�</li>
       <li><input class="inp_chk" type="checkbox" name="REGION" value="9" data-name="����ϵ�">����ϵ�</li>
       <li><input class="inp_chk" type="checkbox" name="REGION" value="10" data-name="�뱸������">�뱸������</li>
       <li><input class="inp_chk" type="checkbox" name="REGION" value="11" data-name="���ϵ�">���ϵ�</li>
       <li><input class="inp_chk" type="checkbox" name="REGION" value="12" data-name="�λ걤����">�λ걤����</li>
       <li><input class="inp_chk" type="checkbox" name="REGION" value="13" data-name="��걤����">��걤����</li>
       <li><input class="inp_chk" type="checkbox" name="REGION" value="14" data-name="��󳲵�">��󳲵�</li>
       <li><input class="inp_chk" type="checkbox" name="REGION" value="15" data-name="������">������</li>
       <li><input class="inp_chk" type="checkbox" name="REGION" value="16" data-name="����Ư����ġ��">����Ư����ġ��</li>
   </ul><ul class="shsub">
       <li><input class="inp_chk" type="checkbox" name="CAREER" value="1" data-name="����">����</li>
       <li><input class="inp_chk" type="checkbox" name="CAREER" value="2" data-name="1~3��">1~3��</li>
       <li><input class="inp_chk" type="checkbox" name="CAREER" value="3" data-name="4~6��">4~6��</li>
       <li><input class="inp_chk" type="checkbox" name="CAREER" value="4" data-name="7~9��">7~9��</li>
       <li><input class="inp_chk" type="checkbox" name="CAREER" value="5" data-name="10~15��">10~15��</li>
       <li><input class="inp_chk" type="checkbox" name="CAREER" value="6" data-name="16~20��">16~20��</li>
       <li><input class="inp_chk" type="checkbox" name="CAREER" value="7" data-name="21�� �̻�">21�� �̻�</li>
       <li><input class="inp_chk" type="checkbox" name="CAREER" value="8" data-name="��� ����">��� ����</li>
   </ul><ul class="shsub">
       <li><input class="inp_chk" type="checkbox" name="EDU" value="1" data-name="���б� ����(4��)">���б� ����(4��)</li>
       <li><input class="inp_chk" type="checkbox" name="EDU" value="2" data-name="���б� ����(2,3��)">���б� ����(2,3��)</li>
       <li><input class="inp_chk" type="checkbox" name="EDU" value="3" data-name="���п� ���� ����">���п� ���� ����</li>
       <li><input class="inp_chk" type="checkbox" name="EDU" value="4" data-name="���п� �ڻ� ����">���б� �ڻ� ����</li>
       <li><input class="inp_chk" type="checkbox" name="EDU" value="5" data-name="����б� ����">����б� ����</li>
       <li><input class="inp_chk" type="checkbox" name="EDU" value="6" data-name="�з¹���">�з¹���</li>
   </ul><ul class="shsub">
       <li><input class="inp_chk" type="checkbox" name="ETYPE" value="1" data-name="����">����</li>
       <li><input class="inp_chk" type="checkbox" name="ETYPE" value="2" data-name="�߰߱��">�߰߱��</li>
       <li><input class="inp_chk" type="checkbox" name="ETYPE" value="3" data-name="�߼ұ��">�߼ұ��</li>       
       <li><input class="inp_chk" type="checkbox" name="ETYPE" value="4" data-name="���ұ��">���ұ��</li>       
       <li><input class="inp_chk" type="checkbox" name="ETYPE" value="5" data-name="�ܱ�����">�ܱ�����</li>       
       <li><input class="inp_chk" type="checkbox" name="ETYPE" value="6" data-name="��ó���">��ó���</li>       
       <li><input class="inp_chk" type="checkbox" name="ETYPE" value="7" data-name="��������������">��������������</li>       
   </ul><ul class="shsub">
       <li><input class="inp_chk" type="checkbox" name="JTYPE" value="1" data-name="������">������</li>
       <li><input class="inp_chk" type="checkbox" name="JTYPE" value="2" data-name="�����">�����</li>
       <li><input class="inp_chk" type="checkbox" name="JTYPE" value="3" data-name="����">����</li>
       <li><input class="inp_chk" type="checkbox" name="JTYPE" value="4" data-name="�İ���">�İ���</li>       
       <li><input class="inp_chk" type="checkbox" name="JTYPE" value="5" data-name="��������">��������</li>       
       <li><input class="inp_chk" type="checkbox" name="JTYPE" value="6" data-name="������/������">������/������</li>       
   </ul>
  
  <div id="resultset"><ul id="resultitems"></ul><button type="button" id="resetbtn">
  	&#9851;&nbsp;�ʱ�ȭ</button><button type="button" id="filterbtn">���õ� ���� �˻�</button></div>
   
  </div>
  
  <div id="listwrap">
    <table id="reclist">
    <c:if test="${listcount > 0 }">
    <c:set var="num" value="${listcount-(page-1)*10 }"/>
    <tbody>
    <c:forEach var="r" items="${reclist }">
      <tr>
        <td>${r.ENAME }</td><td><a href="./recruitview.gurecruit?eid=${r.EID }&sn=${r.SN}">${r.SUBJECT }</a></td><td>
        <a href="" class="applybtn" onclick="goPopup('${r.EID}', '${r.SN }')"><span>&#10003;</span>&nbsp;�����ϱ�</a></td>
      </tr>
    </c:forEach>
    </tbody>
    <tfoot>
    <tr>
      <td colspan=3>
        <c:if test="${page<=1 }">
        	����&nbsp;
        </c:if>
        <c:if test="${page>1 }">
        	<a href="./home.gurecruit?page=${page-1 }">����</a>&nbsp;
        </c:if>
        
        <c:forEach var="a" begin="${startpage }" end="${endpage }">
        	<c:if test="${a==page }">
        		${a }
        	</c:if>
        	<c:if test="${a!=page }">
        		<a href="./home.gurecruit?page=${a }">${a }</a>
        	</c:if>
        </c:forEach>
        
        <c:if test="${page>=maxpage }">
        	&nbsp;
        </c:if>
        <c:if test="${page<maxpage }">
        	<a href="home.gurecruit?page=${page+1 }">&nbsp;����</a>
        </c:if>
      </td>
    </tr>
    </tfoot>
    </c:if>
    </table>
  </div>
</div>   
  
</body>
</html>