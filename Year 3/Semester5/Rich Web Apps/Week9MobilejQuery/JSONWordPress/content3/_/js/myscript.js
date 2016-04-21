function listPosts(data) {
console.log(data);
	var output='<ul data-role="listview" data-filter="true">';
	$.each(data.posts,function(key,val) {
	
		var tempDiv = document.createElement("tempDiv");
		tempDiv.innerHTML = val.excerpt;
		$("a",tempDiv).remove();
		var excerpt = tempDiv.innerHTML;	
	
		output += '<li>';
		output += '<a href="' +val.url + '">';
		output += '<h3>' + val.title + '</h3>';
		
		output += (val.thumbnail) ?
			'<img src="' + val.thumbnail + '" alt="' + val.title + '" />':
			'<img src="images/viewsourcelogo.png" alt="View Source Logo" />';
		output += '<p>' + excerpt + '</p>';
		output += '</a>';
		output += '</li>';
	}); // go through each post
	output+='</ul>';
	$('#postlist').html(output);
} // lists all the posts