function goPopup(){
	var screenW = screen.availWidth;
	var screenH = screen.availHeight;
	var posL = (screenW - 570) / 2;
	var posT = (screenH - 420) / 2;
	
	var pop = window.open("jusoPopup.jsp","pop","width=570,height=420,top="+posT+",left="+posL+", scrollbars=yes, resizable=yes"); 
}

function jusoCallBack(roadFullAddr,roadAddrPart1,addrDetail,roadAddrPart2,engAddr, jibunAddr, zipNo, admCd, rnMgtSn, bdMgtSn,detBdNmList,bdNm,bdKdcd,siNm,sggNm,emdNm,liNm,rn,udrtYn,buldMnnm,buldSlno,mtYn,lnbrMnnm,lnbrSlno,emdNo){
	document.getElementById('eaddr').value = roadFullAddr;
	document.getElementById('eaddr1').value = roadAddrPart1;
	document.getElementById('eaddr2').value = addrDetail;
}

$(function(){	
	var eid_check = -1;//아이디 중복 확인 버튼 클릭 유무를 확인하기 위한 변수
						//아이디가 존재하여 사용 불가능을 의미
	var seid, seidcheck;
		//eid 공백 유효성 검사
		$("#message").css('display','none');
		$("#idcheck").click(function() {
		 if($("#eid").val() == ''){
			 alert('아이디를 입력하세요.');
			 $("#eid").focus();
			 return false;
		 } 
		//ajax를 이용해 eid 중복 검사 + alert 팝업 창
		seid = $("#eid").val();
		$.ajax({
			type : "POST",
			url : "EuIdcheckAjax.eumain",
			data : {
				"eid" : $("#eid").val()
		},
		success : function(result){
			eid_check = result;
			$("#message").empty();
			$("#message").show();
			
			if(result == 0){
				$("#message").append("사용 가능한 아이디 입니다.");
				$("#message").css('color', 'blue');
			}else{
				$("#message").append("중복된 아이디 입니다.");
				$("#message").css('color', 'red');
				$("#eid").val('');
				$("#eid").focus();
			}
		},
		error:function(){
			alert("오류");
		}
	});
})
	$('form').submit(function(){
		seidcheck = $("#eid").val();//사용가능한 아이디인데 변경한 경우를 체크하기 위해 값을 저장
		
		if(eid_check == -1 || seid != seidcheck){//중복체크하지 않은 경우
			alert("아이디 중복 체크 하세요.");//중복체크 후 사용 가능한 아이디라고 메시지 나왔지만 아이디를 변경한 경우
			return false;
		
		}
		//담당자 정보
		//담당자명에 한글만 들어가는 유효성 검사
		str1 = $("#ename").val();
		var pattern1 = /^[가-힣]+$/;	//한글만
		if(!pattern1.test(str1)) { 
			alert("올바른 이름을 입력하세요.");
			$("#ename").val('');
			$("#ename").focus();	
			return false;
			
		}
		
		//pw패스워드 공백 유호성 검사
		//pw와 pass 일치
		var epw = $("#epw");
		var epass = $("#epass");
		if($("#epw").val() != $("#epass").val()){
			 alert("비밀번호가 일치하지 않습니다  다시 입력해주세요.");
			 $("#epw").val('');
			 $("#epass").val('');
			 $("#epw").focus();
			 return false;
			 
		}
		//아이디 패스워드 일치하면 안되는 유효성 검사
		if($("#eid").val() == $("#epw").val()){
			 alert("아이디를 비밀번호에 사용할 수 없습니다. 다시 입력해주세요");
			 	$("#epw").val('');
			 	$("#epass").val('');
			 	$("#epw").focus();
			    return false;
		
		} 
		//아이디  숫자,영소문자,특수문자로 8자리 구성하는 패턴 유효성 검사
		str2 = $("#eid").val();
		var pattern1 = /[0-9]/;	// 숫자  
			pattern2 = /[a-z]/;	// 영소문자  
		if(!pattern1.test(str2) || !pattern2.test(str2) || str2.length < 4) { 
			alert("아이디는 4자리 이상 영소문자, 숫자로  구성하여야 합니다.");
			$("#eid").val('');
			$("#eid").focus();
			return false; 
		
		}
		//비밀번호 숫자,영대소문자,특수문자로 8자리 구성하는 패턴 유효성 검사
		str3 = $("#epw").val();
		var pattern1 = /[0-9]/;	// 숫자  
			pattern2 = /[a-zA-Z]/;	// 영대소문자  
			pattern3 = /[~!@#$%^&*()_+|<>?:{}]/;	// 특수문자 
		if(!pattern1.test(str3) || !pattern2.test(str3) || !pattern3.test(str3) || str3.length < 8) { 
			alert("비밀번호는 8자리 이상 영대소문자, 숫자, 특수문자로 구성하여야 합니다.");
			$("#epw").val('');
			$("#epw").focus();	
			return false; 
		
		}
		//이메일 패턴 유효성 검사
		str4 = $("#eemail").val();
		var pattern1 = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;	//이메일 정규식 패턴
		if(!pattern1.test(str4)) { 
			alert("올바른 이메일 형식이 아닙니다.");
			$("#eemail").val('');
			$("#eemail").focus();	
			return false; 
	
			
		//기업 정보
		}//기업명에 영대소문자와 한글만 들어가는 유효성 검사
//		str6 = $("#ename_co").val();
//		var pattern1 = /^[가-힣a-zA-Z]+$/;	//한글과 영문 
//		if(!pattern1.test(str6)) { 
//			alert("올바른 기업명을 입력하세요.");
//			$("#ename_co").val('');
//			$("#ename_co").focus();	
//			return false;
//
//		}
	//대표자명에 한글만 들어가는 유효성 검사
		str7 = $("#ownername").val();
		var pattern1 = /^[가-힣]+$/;	//한글만
		if(!pattern1.test(str7)) { 
			alert("올바른 대표자명을 입력하세요.");
			$("#ownername").val('');
			$("#ownername").focus();	
			return false;
		
		}else{
			alert("회원가입을 완료 하셨습니다.");
		}
	});
});

//담당자 핸드폰 번호에 자동으로 하이픈 생성
function hypenephone(obj){
	number = obj.value.replace(/[^0-9]/g, "");
	var tmp = "";
	if(number.length < 4){
		return number;	
	 } else if(number.length < 7) {
		 tmp += number.substr(0, 3);
		 tmp += "-";
		 tmp += number.substr(3);
	    } else if(number.length < 11) {
	    	tmp += number.substr(0, 3);
	    	tmp += "-";
	    	tmp += number.substr(3, 3);
	    	tmp += "-";
	    	tmp += number.substr(6);
	    } else {
	    	tmp += number.substr(0, 3);
	    	tmp += "-";
	    	tmp += number.substr(3, 4);
	    	tmp += "-";
	    	tmp += number.substr(7);
	    }
	    obj.value=tmp;
	};
	
//사업자 등록 번호에 자동으로 하이픈 생성
	function hypenenum(obj){
		number = obj.value.replace(/[^0-9]/g, "");
		var tmp = "";
		if(number.length < 4){
			return number;	
		 } else if(number.length < 7) {
			 tmp += number.substr(0, 3);
			 tmp += "-";
			 tmp += number.substr(3);
		    } else if(number.length < 11) {
		    	tmp += number.substr(0, 3);
		    	tmp += "-";
		    	tmp += number.substr(1,2);
		    	tmp += "-";
		    	tmp += number.substr(5);
		    } 
		    obj.value=tmp;
		};

//대표전화 번호 자동으로 하이픈 생성
function hypenenumber(obj){
	number = obj.value.replace(/[^0-9]/g, "");
	var tmp = "";
	if(number.length < 4){
		return number;	
	 } else if(number.length < 7) {
		 tmp += number.substr(0, 3);
		 tmp += "-";
		 tmp += number.substr(3);
	    } else if(number.length < 11) {
	    	tmp += number.substr(0, 3);
	    	tmp += "-";
	    	tmp += number.substr(3, 3);
	    	tmp += "-";
	    	tmp += number.substr(6);
	    } else {
	    	tmp += number.substr(0, 3);
	    	tmp += "-";
	    	tmp += number.substr(3, 4);
	    	tmp += "-";
	    	tmp += number.substr(7);
	    }
	    obj.value=tmp;
	};