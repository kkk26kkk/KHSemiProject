$(document).ready(function(){
	$("#viewcount").change(function(){
		var limit=$('#viewcount option:selected').val();
		$.ajax({
			type:"POST",
			data:{"limit":limit,"state":"ajax"},
			url:"./salarylist.guuser",
			cache:false,
			success:function(data){
				$("table:first").empty().prepend(data);
			},
			error:function(){
				alert("에러");
			}
			
			
			
		})
	
	
	})
	
	
})