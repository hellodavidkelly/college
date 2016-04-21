function slideSwitch() {
    var $active = $('#slideshow IMG.active');

    if ( $active.length == 0 ) $active = $('#slideshow IMG:last');

    var $next =  $active.next().length ? $active.next()
        : $('#slideshow IMG:first');

    $active.addClass('last-active');
        
    $next.css({opacity: 0.0})
        .addClass('active')
        .animate({opacity: 1.0}, 1000, function() {
            $active.removeClass('active last-active');
        });
}

$(function() {
    setInterval( "slideSwitch()", 5000 );
});

$(document).ready(function(){

	$('#slideshow').hover(function(){
		$('#tooltip').css('display','block');
	},function(){
			$('#tooltip').css('display','none');
	});
	
	$(document).mousemove(function(event){
			var mx = event.pageX;
			var my = event.pageY;
			
			$('#tooltip').css('left',mx+'px').css('top',my+'px');
	});
});

$(document).ready(function() {
  $('#incfont').click(function(){   
        curSize= parseInt($('#welcome').css('font-size')) + 2;
  if(curSize<=20)
        $('#welcome').css('font-size', curSize);
        }); 
  $('#decfont').click(function(){   
        curSize= parseInt($('#welcome').css('font-size')) - 2;
  if(curSize>=12)
        $('#welcome').css('font-size', curSize);
        });
 });
