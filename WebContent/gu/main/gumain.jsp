<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c"
		   uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<style>
  #gulogin, #eulogin{
  	border: 1px solid red;
  	width: 200px;
  }
</style>
<script src="js/jquery-3.0.0.js"></script>
<script>	
	$(function(){
		$('#re').click(function(){
			var result=confirm("정말 탈퇴하시겠습니까?");//예 선택시 result값이 true, 아니오 선택시 result값이 false
			if(result){	
				location.href="delete.gumain";
			}
			
		});
	});
</script>

<script>
	
</script>
</head>

<jsp:include page="../../header.jsp"/>


<body>
  ${gid}일반회원님이 로그인이 성공하셨습니다.
  <form id="loginform">
  <div>
  <c:if test="${empty gid}"><!-- 아이디가 없으면 넘어감 -->
         <a href="./join.gumain">회원가입</a>
  </c:if>
  <a href="./logout.gumain">로그아웃</a>
  <a href="./updateinfo.gumain">정보 수정</a>
  <c:if test="${!empty gid}"><!-- 아이디가 있으면 넘어감 -->
         <a href="#" id="re">탈퇴</a>
  </c:if>
  </div>
  </form>
  
  <form id="loginform">
  <div id="eulogin">
  <a href="./join.eumain">회원가입</a>
  <a href="./logout.eumain">로그아웃</a>
  <a href="./updateinfo.eumain">정보 수정</a>
  </div>
  </form>
</body>
</html>