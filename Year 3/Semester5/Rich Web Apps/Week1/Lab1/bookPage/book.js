// when the page first loads call the function initSummary
window.onload = initSummary;

// this loops through all the images on the page and if an image is double-clicked
// the newWindow function is called
function initSummary() 
{
	for (var i=0; i<document.images.length; i++) 
	{
		document.images[i].ondblclick = newWindow;
	}
}

function newWindow() 
{
	// this sets up the summary name
	var sumName = this.id + ".html";
	
	// open a new window and pass it the summary name, the name of the window, width and height
	var summaryWindow = window.open(sumName, "sumWin", "width=320,height=400,scrollbars=no");
}
