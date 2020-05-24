<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c"
		   uri="http://java.sun.com/jsp/jstl/core" %>

<style>

  a{
    text-decoration: none;
  }

  #regapply{
    display: inline-block;
    border: 1px solid red;
    width: 200px;
  }
  
  #headerwrap{
  	position: relative;
    margin-bottom: 27px;
    border-bottom: 2px solid #edeff2;
    z-index: 10000;
  }
  
  #eunavbar{
    width: 100%;
    border-bottom: 1px solid #e1e5eb;
    background: #fff;
  }
  
  .inner{
    display: table;
    width: 1250px;
    margin: 0 auto;
  }
  
  .logo{
    display: table-cell;
    font-size: 20px;
    color: #333;
    font-weight: bold;
    width: 200px;
    padding: 0 0 3px 53px;
    box-sizing: border-box;
    vertical-align: middle;
    letter-spacing: -2px;
    position: relative;
    /* margin-left: 50px; */
    left: 50px;
  }
  
  .navMn{
    position: relatvie;
    left: 35px;
  }
  
  .navMn, .naveumenu{
    display: inline-block;
    box-sizing: border-box;
    vertical-align: middle;
  }
  
  .navMn > li, .naveumenu li{
        box-sizing: border-box;
    float: left;
    padding: 23px 22px 0 22px;
    display: list-item;
    height: 80px;
    position: relative;
    left: 100px;
  }
  
  .navMn li > a{
    width: 66px;
    background-position-x: 0;
    position: relative;
    background-position-y: 10px;
    line-height: 0;
    text-indent: -9999px;
    bottom: 10px;
    font-size: 1.2em;
    color: black;
    font-weight: bold;
    letter-spacing: -2px;
    vertical-align: middle;
    cursor: pointer;
    top: 5px;
  }
  
  ul, li{
    list-style: none;
    padding: 0;
    margin: 0;
  }
  
  #giuplogo{
    color: black;
  }
  
  .naveumenu{
    position: relative;
    left: 75px;
  }
  
  img{
    width: 35px;
    height: 35px;
  }
  
  #rogo{
    position: relative;
    right: 55px;
  }
  #rogo a{
    color: #3399ff;
  }
  
  #eucursoron{
    box-sizing: border-box;
    position: absolute;
    z-index: 2;
    background: #fff;
    margin: -1px 0 0 0;
    width: 180px;
    left: 1254px;
    display: none;
    border: 1px solid #666;
  }
  
  .iddiv{
    padding-top: 10px;
    text-align: center;
  }
  #eucursoron ul{
    margin-top: 0;
    margin-bottom: 0;
    padding: 10px 20px 20px 0;
  }
  #eucursoron ul li{
    width: 100%;
    padding: 10px;
  }
  #eucursoron ul li a{
    letter-spacing: -1px;
    font-size: 0.8em;
    color: #666; 
  }
  #eucursoron ul li:hover{
    background: #666;
  }
  
  #eulogin2{
    height: 70px;
    border-bottom: 1px solid #ebeef3;
  }
  #eulogin2 a{
    display: inline-block;
    padding: 10px;
  	font-size: 0.8em;
  }
  #euloginbtn2{
  	background: #3399ff;
  	color: #fff;
  	border: 1px solid #3399ff;
  	position: absolute;
    top: 15px;
    left: 18px;
  }
  #eujoinbtn2{
    border: 1px solid #666;
    color: #000;
    position: absolute;
    top: 15px;
    left: 90px;
  }
  #eulogin_n2{
    height: 85px;
    border-bottom: 1px solid #ebeef3;
  }  
  #eulogin_n2 span{
    position: absolute;
    top: 10px;
  }
  #eulogin_n2 a{
    padding: 3px;
  	font-size: 0.8em;
  	border: 1px solid #666;
  	color: #000;
  	font-weight: 500;
  }
  #euuptinfo2{
    position: absolute;
    top: 42px;
    left: 22px;
  }
  #eulogoutbtn2{
    position: absolute;
    top: 42px;
    left: 98px;
  }
</style>

<script src="js/jquery-3.0.0.js"></script>
<script>
  $(function(){
	 $('.navMn li')
	    .mouseenter(function(){
			$(this).css('border-bottom', '2px solid #3399ff'); 
	    })
	    .mouseleave(function(){
	    	$(this).css('border-bottom', 'none');
	    });
	 
	 $('#cursorul li')
	  .mouseenter(function(){
		  var index = $('#cursorul li').index(this);
		  $('#cursorul a').eq(index).css('color', '#fff');
	  })
	  .mouseleave(function(){
		  var index = $('#cursorul li').index(this);
		  $('#cursorul a').eq(index).css('color', '#666');
	  })
	  
	  $('#eucursoron, .naveumenu li')
	  .mouseenter(function(){
		  $('#eucursoron').css('display', 'block');
	  })
	  .mouseleave(function(){
		  $('#eucursoron').css('display', 'none');
	  }) 
  });
</script>

<div id="euheaderwrap">
  <div id="eunavbar">
    <div class="inner">
      <p class="logo"><a id="giuplogo" href="./main.eumain">기업회원</a></p><ul class="navMn"><li>
      	<a href="./regrecruit.eurecruit">공고 등록</a></li><li>
      	<a href="./recruitlist.eurecruit">공고 관리</a>
      	</li><li><a href="./applicantlist.eurecruit">지원자 관리</a>
      	</li><li><a href="./personlist.euperson">인재 검색</a>
      	</li><li><a href="./entinfo.eumain">기업 정보</a></li>
      </ul>
      
      <ul class="naveumenu"><li><img src="image/myicon.png"></li></ul>
      <p id="rogo" class="logo"><a href="./main.gumain">홈으로</a></p>
    </div>
  </div>
</div>

<div id="eucursoron">
  <c:if test="${empty eid}">
    <div id="eulogin2">
	  <a id="euloginbtn2" href="./login.eumain">로그인</a>
      <a id="eujoinbtn2" href="./join.eumain">회원가입</a>
    </div>
  </c:if>

  <c:if test="${!empty eid}">
    <div id="eulogin_n2">
  	  <div class="iddiv"><b>${eid }</b>님</div>
  	  <a id="euuptinfo2" href="./entinfo.eumain">정보 관리</a>
  	  <a id="eulogoutbtn2" href="./logout.eumain">로그아웃</a>
    </div>
  </c:if>

  <ul id="cursorul"><li><a href="./regrecruit.eurecruit">공고 등록</a></li><li>
  	<a href="./recruitlist.eurecruit">공고 관리</a></li><li>
  	<a href="./applicantlist.eurecruit">지원자 관리</a></li><li>
  	<a href="./personlist.euperson">인재 검색</a></li><li>
  	<a href="./entinfo.eumain">기업 정보</a></li><li>
  	<a href="./boardList.FA">문의사항</a></li></ul>
  	
</div>
