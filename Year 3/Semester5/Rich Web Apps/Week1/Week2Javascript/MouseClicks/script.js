// when the page first loads call the function initImages
window.onload = initImages;

// this loops through all the images on the page and if an image is double-clicked
// the newWindow function is called
function initImages() {
	for (var i=0; i<document.images.length; i++) {
		document.images[i].ondblclick = newWindow;
	}
}

function newWindow() {
	// this sets up the image name
	var imgName = "images/" + this.id + ".jpg";
	
	// open a new window and pass it the image name, the name of the window, width and height
	var imgWindow = window.open(imgName, "imgWin", "width=320,height=240,scrollbars=no");
}
