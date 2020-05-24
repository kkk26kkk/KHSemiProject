$(document).ready(function(){
	$("#ENAMESELECT").click(function(){
		 var senddata = $(this).prev().val();
		 $.ajax({
			 type : "POST",
	         data : {"ENAME" : senddata},
	         url : "entreviewSelect.guentreview",
	         dataType : 'json',
	         success : function(rdata){
	             var output = '';
	         $(rdata).each(function(index,item){
	        	    output += '<tr>';
	                output += '   <td>' + item.ENAME + "</td>";
	                output += '<td>' + item.DUTY + '</td>';
	                output += '<td>' + item.REGION + '</td>';
	                output += '<td>' + item.UPT_DTM + '</td>';
	                
	                output += '</tr>';

	         })    		
	         $('table:last tbody').append(output);

	        	 
	         }
			 
			 
			 
			 
		 })
		 
		
		
		
		
	})
})

