function listPosts(data) {
	console.log(data);
	var output='<ul data-role="listview" data-filter="true">';
	$.each(data.posts,function(key,val) {
		output+='<li>';
		output+='<h3>' + val.title + '</h3>';
		output+='<p>' + val.excerpt + '</p>';
		output+='</li>';
	}); // go through each post
	output+='</ul>';
	$('#postlist').html(output);
} // lists all the posts