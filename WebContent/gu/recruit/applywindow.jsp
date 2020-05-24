<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c"
		   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>입사 지원</title>
<style>

  #titlejiwon{
    letter-spacing: -1px;
    margin: 0 0 20px 0;
    font-size: 22px;
    border-bottom: 1px solid #666;
  }
  #jiwondiv{
    border: 1px solid #666;
  }
  #jiwone{
    letter-spacing: -1px;
    margin: 0 0 20px 0;
    padding: 10px 10px 10px 15px;
    font-size: 15px;
    border-bottom: 1px solid #666;
    background: #3399ff;
    color: white;
  }
  .jemok{
    letter-spacing: -1px;
    color: #666;
    padding: 10px 10px 10px 15px;
  }
  .jiwonspan{
    letter-spacing: -1px;
    font-size: 13px;
    padding: 17px 17px 12px 16px;
    margin: 0;
    display: inline-block;
  }
  
  .jiwonbtn{
    border: none;
    background: #ff7e00;
    color: #fff;
    padding: 5px;
    font-weight: bold;
    letter-spacing: -1px;
  }
  
  hr{
    border: 0.5px solid black;
  }
  
  .ap{
    padding-top: 0px;
    padding-right: 5px;
    font-size: 16px;
  }
</style>
</head>
<body>	
  <h2 id="titlejiwon">입사 지원</h2>
	
  <c:forEach var="res" items="${reslist }">
	<div id="jiwondiv">
	  <h3 id="jiwone">지원 이력서</h3>
	  
	  <span class="jemok">${res.SUBJECT }</span><br>
	  
	  <span class="jiwonspan">이메일 ${res.EMAIL }</span>
	  <span class="jiwonspan">휴대폰 번호 ${res.PHONE }</span>
<%-- 	GID: ${res.GID } GID_SN: ${res.SN } EID: ${eid } EID_SN: ${eid_sn } --%>
	
	<hr>
	<form action="./applyProcess.gurecruit" method="post">
	  <input type="hidden" name="GID" value="${res.GID }">
	  <input type="hidden" name="GID_SN" value="${res.SN }">
	  <input type="hidden" name="EID" value="${eid }">
	  <input type="hidden" name="EID_SN" value="${eid_sn }">
	  <span class="jiwonspan ap">해당 이력서로</span> <button class="jiwonbtn" type="submit">✓ 지원하기</button>
	</form>
	
	</div>
  </c:forEach>
</body>
</html>