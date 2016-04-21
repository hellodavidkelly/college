
/*********************** google maps api ************************/
$(document).on('pageshow', '#map', function() {  
	
	var defaultLatLng = new google.maps.LatLng(51.50000, -0.1333);

    if ( navigator.geolocation ) 
    {
        function success(pos) 
        {
            //Successful location 
            defaultLatLng = new google.maps.LatLng(pos.coords.latitude, pos.coords.longitude);
            drawMap(defaultLatLng);
            calcRoute(defaultLatLng,itb_LatLng);
        }
        function fail(error) 
        {
            drawMap(defaultLatLng);  //Default map for failed location request
            calcRoute(defaultLatLng,itb_LatLng);
        }
        // Find the users location.  Cache for 5 minutes, timeout after 10 seconds
        navigator.geolocation.getCurrentPosition(success, fail, {maximumAge: 500000, enableHighAccuracy:true, timeout: 10000});
    } else {
        drawMap(defaultLatLng);  //No geolocation support use default location
    }

    function drawMap(latlng) 
    {

        var myOptions = {
            zoom: 10,
            center: latlng,
            mapTypeId: google.maps.MapTypeId.ROADMAP
        };

        var map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);
        var jk_LatLng = new google.maps.LatLng(51.535822, -0.05576);
        directionsDisplay = new google.maps.DirectionsRenderer();
	    directionsDisplay.setMap(map);
       
        var marker = new google.maps.Marker({
            position: latlng,
            map: map,
            title: "welcome"
        });

        var request = {
		  origin:latlng,
		  destination:jk_LatLng,
		  travelMode: google.maps.TravelMode.DRIVING
		};

		var directionsService = new google.maps.DirectionsService();
		directionsService.route(request, function(response, status, marker) {
			if (status == google.maps.DirectionsStatus.OK) {
			  directionsDisplay.setDirections(response);
			}
		});
    }
});

/*********************** wordperss json plugin api ************************/
var listPosts = function(data) {
	
	var html = '<ul data-role="listview">';
	$.each(data.posts, function(key,value){
		
		html += '<li>';
		html += '<a data-transition="slide" href="#blogpost" onclick="showPost(' + value.id + ')">';
		html += (value.thumbnail) ?
			'<img class="blog_thumb" src="' + value.thumbnail + '" alt="' + value.title + '" />':
			'<img class="blog_logo" src="images/wp_logo.jpg" alt="Our Blog Logo" />';
		html += '<h3>' + value.title + '</h3>' + value.excerpt;
		html += '</a>';
		html += '</li>';
	});
	
	html +=' </ul>';
	$('#postlist').empty().append(html);
};

var showPost = function(id) {
	
	$.getJSON('http://bronchaus.com/wordpress/?json=get_post&post_id=' + id + '&callback=?', function(data) {
		$('#mypost').empty().append('<h3>' + data.post.title + '</h3>' + data.post.content);
	}); 
};

/*********************** flickr api ************************/
var jsonFlickrFeed = function(data) {
	
	var html = "";
	
	$.each(data.items, function(i,image) {
		
		var blocktype =	((i % 2) === 1) ? 'b': 'a';
		var image = data.items[i];
		html += '<div class="ui-block-' + blocktype + '">';
		html += make_a_img('#showphoto', image.media.m, image.title);
		html += '</div>';
	});
	
	$('#photolist').empty().append(html);
	
	$("#photolist > div > a > img").on("vclick", function(event){
		
		event.preventDefault();
		var title = $(this).attr("alt");
		var src = $(this).attr("src");
		$('#showphoto > div > h1').empty().append(title);
		$('#myphoto').empty().append(make_a_img('#photos', src, title));
		$.mobile.navigate("#showphoto");
	});
};


var make_a_img = function(href, img_src, img_alt) {
	
	return '<a href="' + href + '" data-transition="fade"><img src="' + img_src + '" alt="' + img_alt + '" /></a>';
};

/*********************** YouTube api v2.0 ************************/
function listVideos(data) {
	
	var html = '';

	$.each(data.feed.entry, function(i,video){
		
		console.log(video);
		var video = data.feed.entry[i];
		var title = video.title.$t;
		var thumbnail = video.media$group.media$thumbnail[0].url;
		var video_link = video.link[1].href;
		var id = video.id.$t.substring(38);
		var description = video.media$group.media$description.$t;
						
		html += '<div>';
		html += '<a href="" data-transition="fade">';
		html += '<img src="' + thumbnail + '" alt="' + title + '" id="' + id + '"  description="' + description + '"/>';
		html += '</a>';
		html += '<h3 class="youtube_video_title">' + title + '</h3>';
		html += '</div>';
	});
	
	$('#videolist').append(html);

	$('#videolist > div > a > img').on('vclick', function(event) {

		event.preventDefault();
		var html = '<iframe src="http://www.youtube.com/embed/' + $(this).attr('id') + '?wmode=transparent&amp;HD=0&amp;rel=0&amp;showinfo=0&amp;controls=1&amp;autoplay=1" frameborder="0" allowfullscreen></iframe>';
		html += '<h3 class="youtube_video_title">' + $(this).attr('alt') + '</h3>';
		html += '<p class="youtube_video_description">' + $(this).attr('description') + '</p>';

		$('#videoplayer').empty().append(html);
		$.mobile.navigate('#video_player');
	});
};

/*********************** theme changer ************************/
$(document).ready(function() {

	var themes = ['a','b','c'];
	var index = 0;
	var old_theme;
	var current_theme="a";

	$( ".theme_changer" ).on( "vclick", function( event ) { 

		old_theme = current_theme;
		index = (index + 1) % 3;
		console.log(index);
		current_theme = themes[index];

		$.each($('div[data-role="page"]'), function(key,value){
			
			var $value = $(value);
			$value.removeClass('ui-page-theme-' + old_theme);
			$value.addClass('ui-page-theme-' + current_theme).attr("data-theme",current_theme);
		});
	});
});

/*********************** facebook like button ************************/
 var cache = $.ajaxSettings.cache; 
 $.ajaxSettings.cache = true;
   
 $.getScript('http://connect.facebook.net/en_EN/all.js', function() {
 	FB.init({
	 	appId: 'your_app_id-optional',
	 	status: true,
	 	cookie: true,
	 	xfbml: true
	});    
 });
  
$.ajaxSettings.cache = cache;
