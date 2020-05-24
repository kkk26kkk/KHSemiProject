<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c"
		   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>채용 정보</title>
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
					output += "<td><a href='' onclick='goPopup("+q+");'><span>&#10003;</span>&nbsp;지원하기</a></td>";
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
<h2 id="searchtitle">채용공고 조건검색</h2>
  <div class="searchArea">
   <p class="searchheader"><strong>직무</strong></p><p class="searchheader"><strong>근무지역</strong>
   </p><p class="searchheader"><strong>경력</strong>
   </p><p class="searchheader"><strong>학력</strong>
   </p><p class="searchheader"><strong>기업형태</strong>
   </p><p class="searchheader"><strong>고용형태</strong></p><ul class="shsub">
       <li><input class="inp_chk" type="checkbox" name="DUTY" value="1" data-name="경영·사무">경영·사무</li>
       <li><input class="inp_chk" type="checkbox" name="DUTY" value="2" data-name="마케팅·광고·홍보">마케팅·광고·홍보</li>
       <li><input class="inp_chk" type="checkbox" name="DUTY" value="3" data-name="IT·인터넷">IT·인터넷</li>
       <li><input class="inp_chk" type="checkbox" name="DUTY" value="4" data-name="디자인">디자인</li>
       <li><input class="inp_chk" type="checkbox" name="DUTY" value="5" data-name="무역·유통">무역·유통</li>
       <li><input class="inp_chk" type="checkbox" name="DUTY" value="6" data-name="영업·고객상담">영업·고객상담</li>
       <li><input class="inp_chk" type="checkbox" name="DUTY" value="7" data-name="서비스">서비스</li>
       <li><input class="inp_chk" type="checkbox" name="DUTY" value="8" data-name="연구개발·설계">연구개발·설계</li>
       <li><input class="inp_chk" type="checkbox" name="DUTY" value="9" data-name="생산·제조">생산·제조</li>
       <li><input class="inp_chk" type="checkbox" name="DUTY" value="10" data-name="교육">교육</li>
       <li><input class="inp_chk" type="checkbox" name="DUTY" value="11" data-name="건설">건설</li>
       <li><input class="inp_chk" type="checkbox" name="DUTY" value="12" data-name="의료">의료</li>
       <li><input class="inp_chk" type="checkbox" name="DUTY" value="13" data-name="미디어">미디어</li>
       <li><input class="inp_chk" type="checkbox" name="DUTY" value="14" data-name="전문·특수직">전문·특수직</li>
   </ul><ul class="shsub">
       <li><input class="inp_chk" type="checkbox" name="REGION" value="1" data-name="서울특별시">서울특별시</li>
       <li><input class="inp_chk" type="checkbox" name="REGION" value="2" data-name="경기도">경기도</li>
       <li><input class="inp_chk" type="checkbox" name="REGION" value="3" data-name="인천광역시">인천광역시</li>
       <li><input class="inp_chk" type="checkbox" name="REGION" value="4" data-name="대전광역시">대전광역시</li>
       <li><input class="inp_chk" type="checkbox" name="REGION" value="5" data-name="세종특별자치시">세종특별자치시</li>
       <li><input class="inp_chk" type="checkbox" name="REGION" value="6" data-name="충청남도">충청남도</li>
       <li><input class="inp_chk" type="checkbox" name="REGION" value="7" data-name="광주광역시">광주광역시</li>
       <li><input class="inp_chk" type="checkbox" name="REGION" value="8" data-name="전라남도">전라남도</li>
       <li><input class="inp_chk" type="checkbox" name="REGION" value="9" data-name="전라북도">전라북도</li>
       <li><input class="inp_chk" type="checkbox" name="REGION" value="10" data-name="대구광역시">대구광역시</li>
       <li><input class="inp_chk" type="checkbox" name="REGION" value="11" data-name="경상북도">경상북도</li>
       <li><input class="inp_chk" type="checkbox" name="REGION" value="12" data-name="부산광역시">부산광역시</li>
       <li><input class="inp_chk" type="checkbox" name="REGION" value="13" data-name="울산광역시">울산광역시</li>
       <li><input class="inp_chk" type="checkbox" name="REGION" value="14" data-name="경상남도">경상남도</li>
       <li><input class="inp_chk" type="checkbox" name="REGION" value="15" data-name="강원도">강원도</li>
       <li><input class="inp_chk" type="checkbox" name="REGION" value="16" data-name="제주특별자치도">제주특별자치도</li>
   </ul><ul class="shsub">
       <li><input class="inp_chk" type="checkbox" name="CAREER" value="1" data-name="신입">신입</li>
       <li><input class="inp_chk" type="checkbox" name="CAREER" value="2" data-name="1~3년">1~3년</li>
       <li><input class="inp_chk" type="checkbox" name="CAREER" value="3" data-name="4~6년">4~6년</li>
       <li><input class="inp_chk" type="checkbox" name="CAREER" value="4" data-name="7~9년">7~9년</li>
       <li><input class="inp_chk" type="checkbox" name="CAREER" value="5" data-name="10~15년">10~15년</li>
       <li><input class="inp_chk" type="checkbox" name="CAREER" value="6" data-name="16~20년">16~20년</li>
       <li><input class="inp_chk" type="checkbox" name="CAREER" value="7" data-name="21년 이상">21년 이상</li>
       <li><input class="inp_chk" type="checkbox" name="CAREER" value="8" data-name="경력 무관">경력 무관</li>
   </ul><ul class="shsub">
       <li><input class="inp_chk" type="checkbox" name="EDU" value="1" data-name="대학교 졸업(4년)">대학교 졸업(4년)</li>
       <li><input class="inp_chk" type="checkbox" name="EDU" value="2" data-name="대학교 졸업(2,3년)">대학교 졸업(2,3년)</li>
       <li><input class="inp_chk" type="checkbox" name="EDU" value="3" data-name="대학원 석사 졸업">대학원 석사 졸업</li>
       <li><input class="inp_chk" type="checkbox" name="EDU" value="4" data-name="대학원 박사 졸업">대학교 박사 졸업</li>
       <li><input class="inp_chk" type="checkbox" name="EDU" value="5" data-name="고등학교 졸업">고등학교 졸업</li>
       <li><input class="inp_chk" type="checkbox" name="EDU" value="6" data-name="학력무관">학력무관</li>
   </ul><ul class="shsub">
       <li><input class="inp_chk" type="checkbox" name="ETYPE" value="1" data-name="대기업">대기업</li>
       <li><input class="inp_chk" type="checkbox" name="ETYPE" value="2" data-name="중견기업">중견기업</li>
       <li><input class="inp_chk" type="checkbox" name="ETYPE" value="3" data-name="중소기업">중소기업</li>       
       <li><input class="inp_chk" type="checkbox" name="ETYPE" value="4" data-name="강소기업">강소기업</li>       
       <li><input class="inp_chk" type="checkbox" name="ETYPE" value="5" data-name="외국계기업">외국계기업</li>       
       <li><input class="inp_chk" type="checkbox" name="ETYPE" value="6" data-name="벤처기업">벤처기업</li>       
       <li><input class="inp_chk" type="checkbox" name="ETYPE" value="7" data-name="공공기관·공기업">공공기관·공기업</li>       
   </ul><ul class="shsub">
       <li><input class="inp_chk" type="checkbox" name="JTYPE" value="1" data-name="정규직">정규직</li>
       <li><input class="inp_chk" type="checkbox" name="JTYPE" value="2" data-name="계약직">계약직</li>
       <li><input class="inp_chk" type="checkbox" name="JTYPE" value="3" data-name="인턴">인턴</li>
       <li><input class="inp_chk" type="checkbox" name="JTYPE" value="4" data-name="파견직">파견직</li>       
       <li><input class="inp_chk" type="checkbox" name="JTYPE" value="5" data-name="프리랜서">프리랜서</li>       
       <li><input class="inp_chk" type="checkbox" name="JTYPE" value="6" data-name="연수생/교육생">연수생/교육생</li>       
   </ul>
  
  <div id="resultset"><ul id="resultitems"></ul><button type="button" id="resetbtn">
  	&#9851;&nbsp;초기화</button><button type="button" id="filterbtn">선택된 조건 검색</button></div>
   
  </div>
  
  <div id="listwrap">
    <table id="reclist">
    <c:if test="${listcount > 0 }">
    <c:set var="num" value="${listcount-(page-1)*10 }"/>
    <tbody>
    <c:forEach var="r" items="${reclist }">
      <tr>
        <td>${r.ENAME }</td><td><a href="./recruitview.gurecruit?eid=${r.EID }&sn=${r.SN}">${r.SUBJECT }</a></td><td>
        <a href="" class="applybtn" onclick="goPopup('${r.EID}', '${r.SN }')"><span>&#10003;</span>&nbsp;지원하기</a></td>
      </tr>
    </c:forEach>
    </tbody>
    <tfoot>
    <tr>
      <td colspan=3>
        <c:if test="${page<=1 }">
        	이전&nbsp;
        </c:if>
        <c:if test="${page>1 }">
        	<a href="./home.gurecruit?page=${page-1 }">이전</a>&nbsp;
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
        	<a href="home.gurecruit?page=${page+1 }">&nbsp;다음</a>
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