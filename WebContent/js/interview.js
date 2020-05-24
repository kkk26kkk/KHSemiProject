$(document).ready(function(){
	$("form").submit(function(){
		if($.trim($("#ENAME").val())==""){
			alert("기업명을 입력하세요");
			$("#ENAME").focus();
			return false;
		}
		if($.trim($("#DUTY").val())==""){
			alert("직무를 입력하세요");
			$("#DUTY").focus();
			return false;
		}
		if($.trim($("#INDUSTRY").val())==""){
			alert("산업을 입력하세요");
			$("#INDUSTRY").focus();
			return false;
		}
		
		
		
		if($("#JTYPE1").is(":checked")==false
				&& $("#JTYPE2").is(":checked")==false){
			alert("고용형태를 체크가하세요");
			
			return false;
		}
		
		if($("#CAREER1").is(":checked")==false
				&& $("#CAREER2").is(":checked")==false){
			alert("고용형태를 체크하세요");
			
			return false;
		}
		if($.trim($("#REGION").val())==""){
			alert("지역을 선택하세요");
			$("#CAREER1").focus();
			return false;
		}
		
		
		
		if($.trim($("#EXP").val())==""){
			alert("면접경험을 입력하세요");
			$("#EXP").focus();
			return false;
		}
		if($.trim($("#PROC").val())==""){
			alert("채용과정을 입력하세요");
			$("#PROC").focus();
			return false;
		}
		
		if($.trim($("#QUE").val())==""){
			alert("면접질문을 입력하세요");
			$("#QUE").focus();
			return false;
		}
		
		if($.trim($("#ANS").val())==""){
			alert("면접답변을 입력하세요");
			$("#ANS").focus();
			return false;
		}
	
		if($.trim($("#DIFF").val())==""){
			alert("난이도를 입력하세요");
			$("#DIFF").focus();
			return false;
		}
		
		if($.trim($("#INTDATE").val())==""){
			alert("면접날짜를 입력하세요");
			$("#INTDATE").focus();
			return false;
		}
		
		
		
		
		
		
		
	})
})