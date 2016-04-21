function slideSwitch() {
    var $active = $('#slideshow IMG.active');

    if ( $active.length == 0 ) $active = $('#slideshow IMG:last');

    var $next =  $active.next().length ? $active.next()
        : $('#slideshow IMG:first');

    $active.addClass('last-active');
        
    $next.css({opacity: 0.0})
        .addClass('active')
        .animate({opacity: 1.0}, 500, function() {
            $active.removeClass('active last-active');
        });
}

$(function() {
    setInterval( "slideSwitch()", 2500 );
});
 
 $(document).ready(function() {
  $('#incfont').click(function(){   
        curSize= parseInt($("#content, .date, .info, .project").css('font-size')) + 2;
  if(curSize<=15)
        $("#content, .date, .info, .project").css('font-size', curSize);
        }); 
  $('#decfont').click(function(){   
        curSize= parseInt($("#content, .date, .info, .project").css('font-size')) - 2;
  if(curSize>=12)
        $("#content, .date, .info, .project").css('font-size', curSize);
        });
 });
