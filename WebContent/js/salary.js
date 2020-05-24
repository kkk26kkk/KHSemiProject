$(document).ready(function(){
	$("form").submit(function(){
		if($.trim($("#ENAME").val())==""){
			alert("기업명을 입력하세요");
			$("#ENAME").focus();
			return false;
		}
		if($.trim($("#CF").val())==""){
			alert("현/전직장을 선택하세요");
			$("#CF").focus();
			return false;
		}
		
		if($.trim($("#DUTY").val())==""){
			alert("직무를 선택하세요");
			$("#DUTY").focus();
			return false;
		}
		if($.trim($("#INDUSTRY").val())==""){
			alert("산업을 선택하세요");
			$("#INDUSTRY").focus();
			return false;
		}
		
		
		
		if($("#JTYPE1").is(":checked")==false
				&& $("#JTYPE2").is(":checked")==false){
			alert("고용형태를 선택하세요");
			
			return false;
		}
		
		if($.trim($("#RANK").val())==""){
			alert("직급을 선택하세요");
			$("#RANK").focus();
			return false;
		}
		if($("#CAREER1").is(":checked")==false
				&& $("#CAREER2").is(":checked")==false){
			alert("경력을 선택하세요");
			
			return false;
		}
		
		
		if($.trim($("#REGION").val())==""){
			alert("근무지역을 선택하세요");
			$("#REGION").focus();
			return false;
		}
		
		
		
		if($.trim($("#SAL").val())==""){
			alert("연봉을입력하세요");
			$("#SAL").focus();
			return false;
		}
		if($.trim($("#INCENTIVE").val())==""){
			alert("성과급을 입력하세요");
			$("#INCENTIVE").focus();
			return false;
		}
		
		
		
		
		
		
		
		
	})
})