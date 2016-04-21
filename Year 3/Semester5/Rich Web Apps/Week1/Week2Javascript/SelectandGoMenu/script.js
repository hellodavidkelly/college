// onload is triggered when the page finishes loading
window.onload = initForm;
// onunload is triggered when the page is leaving eg user presses "back" button
// need to set it to do something so that initForm is called again
window.onunload = function() {};

function initForm() {
// when page loads want to ensure that we are on the 1st element
	document.getElementById("newLocation").selectedIndex = 0;
	
// set the onchange eventhandler to jumpPage. ie
// call fumction jumpPage when a new location is selected
	document.getElementById("newLocation").onchange = jumpPage;
}

function jumpPage() {
	var newLoc = document.getElementById("newLocation");
	// gets the value of the selected location, eg if hawaii is selected
	// newPage has a value of "hawaii.html"
	var newPage = newLoc.options[newLoc.selectedIndex].value;


	// if user has selected a destination, eg hawaii then load this new page, eg hawaii.html
	if (newPage != "") {
		window.location = newPage;
	}
}
