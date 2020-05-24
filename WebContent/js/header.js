$(function(){
  $('.subject, #cursoron')
  .mouseenter(function(){
	 $('#cursoron').css('display', 'block'); 
  })
  .mouseleave(function(){
	  $('#cursoron').css('display', 'none');
  });
  
  $('#mymenu, #mynav')
  .mouseenter(function(){
	  $('#mynav').css('display', 'block');
  })
  .mouseleave(function(){
	  $('#mynav').css('display', 'none');
  })  
  

  $('#mynav ul li')
  .mouseenter(function(){
	  var index = $('#mynav ul li').index(this);
	  $('#mynav ul li a').eq(index).css('color', '#fff');
  })
  .mouseleave(function(){
	  var index = $('#mynav ul li').index(this);
	  $('#mynav ul li a').eq(index).css('color', '#666');
  })
  
  $('#eumenu, #eunav')
  .mouseenter(function(){
	  $('#eunav').css('display', 'block');
  })
  .mouseleave(function(){
	  $('#eunav').css('display', 'none');
  })  
  
  $('#eunav ul li')
  .mouseenter(function(){
	  var index = $('#eunav ul li').index(this);
	  $('#eunav ul li a').eq(index).css('color', '#fff');
  })
  .mouseleave(function(){
	  var index = $('#eunav ul li').index(this);
	  $('#eunav ul li a').eq(index).css('color', '#666');
  })
});