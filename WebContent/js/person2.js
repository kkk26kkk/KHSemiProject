  $(function(){
	 $('li').click(function(){
		if($(this).children().prop('checked') == true) {
			$(this).children().prop('checked', false);
			$(this).css('color', '#000').css('font-weight', 'normal');
			$('#resultitems li[name="' + $(this).children().data('name') + '"]').remove();
		}
		else {
			$(this).children().prop('checked', true);
			$(this).css('color', '#3399ff').css('font-weight', 'bold');
			var btn = $('<button/>', {type: 'button', value: $(this).children().val(),
									  text: $(this).children().data('name')});
			$('<li/>', {name: $(this).children().data('name')}).append(btn).appendTo('#resultitems');
		}
	 });
	 
	 $('#filterbtn').click(function(){
// 		alert($('input[name=EDU]:checked').val());
		$('#reclist tbody').remove();
		$.ajax({
			type : "post",
			url : "personlistajax.euperson",
			data : {
				"DUTY" : $("input[name=DUTY]:checked").val(),
				"REGION" : $("input[name=REGION]:checked").val(),
				"CAREER" : $("input[name=CAREER]:checked").val(),
				"STYPE" : $("input[name=STYPE]:checked").val(),
				"RANK" : $("input[name=RANK]:checked").val(),
				"JTYPE" : $("input[name=JTYPE]:checked").val(),
				"INDUSTRY" : $("input[name=INDUSTRY]:checked").val(),
				"DESSAL" : $("input[name=DESSAL]:checked").val(),
			},
			dataType :"json",
			//cache : false,
			success : function(data){
				var output = '';
				$(data).each(function(index, item){
					output +='<tbody>';
					output += '<tr>';
					output += '<td>' + item.NAME + '</td>';
					output += '<td><div><span>'+item.RANK+'</span>';
					output += '<a href=./personview.euperson?gid='+item.GID+'&sn='+item.SN+'>'+item.SUBJECT+'</a></div>';
					output += '<div><span>'+item.STYPE+': ¡Û¡Û'+item.MAJOR+'</span></div>';
					output += '<div><span>'+item.REGION+'</span></div></td>';
					output += '<td>'+item.RGS_DTM+'</td></tr>';
					output +='</tbody>';
				});
				$("#reclist").append(output);
			},
			  error:function(request,status,error){
			        alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			       }

			
	
			
		});
	 });
  });