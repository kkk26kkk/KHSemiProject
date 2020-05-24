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
		
		
		
		if($.trim($("#THINK").val())==""){
			alert("한줄평을 입력하세요");
			$("#THINK").focus();
			return false;
		}
		if($.trim($("#ADV").val())==""){
			alert("장점을 입력하세요");
			$("#ADV").focus();
			return false;
		}
		if($.trim($("#DADV").val())==""){
			alert("단점을 입력하세요");
			$("#DADV").focus();
			return false;
		}
		
		
		if($.trim($("#POINT").val())==""){
			alert("별점을 입력하세요");
			$("#POINT").focus();
			return false;
		}
		
		if($.trim($("#STORY").val())==""){
			alert("못다한이야기를입력하세요");
			$("#STORY").focus();
			return false;
		}
	
		
		
		
		
		
		
		
		
	})
})