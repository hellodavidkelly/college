 var cache = $.ajaxSettings.cache; 
 $.ajaxSettings.cache = true;
   
 $.getScript('http://connect.facebook.net/en_EN/all.js', function() {
 	FB.init({
	 	appId: 'your_app_id-optional',
	 	status: true,
	 	cookie: true,
	 	xfbml: true}
 	);    
  });
  
$.ajaxSettings.cache = cache;