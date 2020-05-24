$(function(){	
	var gid_check = -1;//아이디 중복 확인 버튼 클릭 유무를 확인하기 위한 변수
						//아이디가 존재하여 사용 불가능을 의미
	var sgid, sgidcheck;
		//gid 공백 유효성 검사
		$("#message").css('display','none');
		$("#idcheck").click(function() {
		 if($("#gid").val() == ''){
			 alert('아이디를 입력하세요.');
			 $("#gid").focus();
			 return false;
		 } 
		//ajax를 이용해 gid 중복 검사 + alert 팝업 창
		sgid = $("#gid").val();
		$.ajax({
			type : "POST",
			url : "IdcheckAjax.gumain",
			data : {
				"gid" : $("#gid").val()
		},
		success : function(result){
			gid_check = result;
			$("#message").empty();
			$("#message").show();
			
			if(result == 0){
				$("#message").append("사용 가능한 아이디 입니다.");
				$("#message").css('color', 'blue');
			}else{
				$("#message").append("중복된 아이디 입니다.");
				$("#message").css('color', 'red');
				$("#gid").val('');
				$("#gid").focus();
			}
		},
		error:function(){
			alert("오류");
		}
	});
})
	$('form').submit(function(){
		sgidcheck = $("#gid").val();//사용가능한 아이디인데 변경한 경우를 체크하기 위해 값을 저장
		
		if(gid_check == -1 || sgid != sgidcheck){//중복체크하지 않은 경우
			alert("아이디 중복 체크 하세요.");//중복체크 후 사용 가능한 아이디라고 메시지 나왔지만 아이디를 변경한 경우
			return false;
		
		}
		//pw패스워드 공백 유호성 검사
		//pw와 pass 일치
		var pw = $("#pw");
		var pass = $("#pass");
		if($("#pw").val() != $("#pass").val()){
			 alert("비밀번호가 일치하지 않습니다  다시 입력해주세요.");
			 $("#pw").val('');
			 $("#pass").val('');
			 $("#pw").focus();
			 return false;
			 
		}
		//아이디 패스워드 일치하면 안되는 유효성 검사
		if($("#gid").val() == $("#pw").val()){
			 alert("아이디를 비밀번호에 사용할 수 없습니다. 다시 입력해주세요");
			 	$("#pw").val('');
			 	$("#pass").val('');
			 	$("#pw").focus();
			    return false;
		} 
		//아이디  숫자,문자,특수문자로 8자리 구성하는 패턴 유효성 검사
		str1 = $("#gid").val();
		var pattern1 = /[0-9]/;	// 숫자  
			pattern2 = /[a-zA-Z]/;	// 문자  
		if(!pattern1.test(str1) || !pattern2.test(str1) || str1.length < 4) { 
			alert("아이디는 4자리 이상 문자, 숫자로  구성하여야 합니다.");
			$("#gid").val('');
			$("#gid").focus();
			return false; 
		
		}
		//비밀번호 숫자,문자,특수문자로 8자리 구성하는 패턴 유효성 검사
		str2 = $("#pw").val();
		var pattern1 = /[0-9]/;	// 숫자  
			pattern2 = /[a-zA-Z]/;	// 문자  
			pattern3 = /[~!@#$%^&*()_+|<>?:{}]/;	// 특수문자 
		if(!pattern1.test(str2) || !pattern2.test(str2) || !pattern3.test(str2) || str2.length < 8) { 
			alert("비밀번호는 8자리 이상 문자, 숫자, 특수문자로 구성하여야 합니다.");
			$("#pw").val('');
			$("#pw").focus();	
			return false; 
		
		}
		//이메일 패턴 유효성 검사
		str3 = $("#email").val();
		var pattern1 = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
		if(!pattern1.test(str3)) { 
			alert("올바른 이메일 형식이 아닙니다.");
			$("#email").val('');
			$("#email").focus();	
			return false; 
		}
		//핸드폰 번호 유효성 검사
		str4 = $("#phone").val();
		var pattern1 = /^\d{3}-\d{3,4}-\d{4}$/;
		if(!pattern1.test(str4)) { 
			alert("올바른 핸드폰 번호를 입력하세요.");
			$("#phone").val('');
			$("#phone").focus();	
			return false; 
		
		}
		//이름에 한글만 들어가는 유효성 검사
		str5 = $("#name").val();
		var pattern1 = /^[가-힣]+$/;
		if(!pattern1.test(str5)) { 
			alert("올바른 이름을 입력하세요.");
			$("#name").val('');
			$("#name").focus();	
			return false; 
		
		}else{
			alert("회원가입을 완료하셨습니다.");
		}
	});
});

//핸드폰 번호에 자동으로 하이픈 생성
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