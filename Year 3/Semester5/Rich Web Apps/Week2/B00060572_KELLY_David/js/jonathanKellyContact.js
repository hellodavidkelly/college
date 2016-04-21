/*function initialize() {
  var myLatlng = new google.maps.LatLng(51.535822, -0.05576);
  var mapOptions = {
    zoom: 8,
    center: myLatlng
  };

  var map = new google.maps.Map(document.getElementById('map_canvas'), mapOptions);

  var contentString = '<div id="map_content">'+
      '<div id="map_information">'+
      '</div>'+
      '<div id="body_content">'+
      '<p></p>'+
      '<p>Jonathan Kelly | Graphic Designer<br>Mare st.<br>Hackney E9 7NB<br>London<br>T. (0044) 123 1234 123<br> E. jonathan@jk.com</p>'+
      '</div>'+
      '</div>';

  var infowindow = new google.maps.InfoWindow({
      content: contentString
  });

  var marker = new google.maps.Marker({
      position: myLatlng,
      map: map,
      title: 'Jonathan Kelly'
  });
  google.maps.event.addListener(marker, 'click', function() {
    infowindow.open(map,marker);
  });
}

google.maps.event.addDomListener(window, 'load', initialize);
*/
/*///////////////////////OLD GOOGLE MAPS NO DIRECTIONS//////////////////////////////*/

var directionsDisplay;
var directionsService = new google.maps.DirectionsService();
var map;

function initialize() {
  directionsDisplay = new google.maps.DirectionsRenderer();
  var mare = new google.maps.LatLng(51.535822, -0.05576);
  var mapOptions = {
    zoom:8,
    center: mare
  };
  
  map = new google.maps.Map(document.getElementById('map_canvas'), mapOptions);
  
		var contentString = '<div id="map_content">'+
			'<div id="map_information">'+
			'</div>'+
			'<div id="body_content">'+
			'<p></p>'+
			'<p>Jonathan Kelly | Graphic Designer<br>Mare st.<br>Hackney E9 7NB<br>London<br>T. (0044) 123 1234 123<br> E. jonathan@jk.com</p>'+
			'</div>'+
			'</div>';

		var infowindow = new google.maps.InfoWindow({
		content: contentString
		});

		var marker = new google.maps.Marker({
		position: mare,
		map: map,
		title: 'Jonathan Kelly'
		});
  
  google.maps.event.addListener(marker, 'click', function() {
    infowindow.open(map,marker);
  });
  
  directionsDisplay.setMap(map);
}

function calcRoute() {
  var start = document.getElementById('start').value;
  var end = document.getElementById('end').value;
  var request = {
      origin:start,
      destination:end,
      travelMode: google.maps.TravelMode.DRIVING
  };
  
  directionsService.route(request, function(response, status) {
    if (status == google.maps.DirectionsStatus.OK) {
      directionsDisplay.setDirections(response);
    }
  });

}

google.maps.event.addDomListener(window, 'load', initialize);

/*///////////////////////END GOOGLE MAPS//////////////////////////////////////*/
$(document).ready(function(){

	$('#contact_img').click(function(){
		$('#large_image').css('display','block');
	});

});

$(document).ready(function(){

	$('#large_image').click(function(){
		$('#large_image').css('display','none');
	});

});