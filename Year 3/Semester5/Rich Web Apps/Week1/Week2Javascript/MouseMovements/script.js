document.onmousemove = moveHandler;

function moveHandler(evt) {
	if (!evt) {
		evt = window.event;
	}
	// call animateEyes and pass it the x and y position of where the mouse was before
	// it was moved
	animateEyes(evt.clientX,evt.clientY);
}

function animateEyes(xPos,yPos) {
        // get the elements by their ids
	var rightEye = document.getElementById("rEye");
	var leftEye = document.getElementById("lEye");
	var rightEyeball = document.getElementById("rDot").style;
	var leftEyeball = document.getElementById("lDot").style;
	
	// Need to set the left and top positions of both the left and right eyeball
	// Pass to function the x position of the mouse and how far the left eye is from the
	// documents edge
	leftEyeball.left = newEyeballPos(xPos,leftEye.offsetLeft);
	
	// Pass to function the y position of the mouse and how far the left eye is from the
	// documents top
	leftEyeball.top = newEyeballPos(yPos,leftEye.offsetTop);
	
	rightEyeball.left = newEyeballPos(xPos,rightEye.offsetLeft);
	rightEyeball.top = newEyeballPos(yPos,rightEye.offsetTop);

        // passing in the parameters - the current position of the mouse and how far
        // the eyball is from the documents edge or top.
	function newEyeballPos(currPos,eyePos) {
	
		// take max of currPos and eyePos + 3, take min of this and eyePos+17
		// returm 'px' so that it stays within the eyball area
		return Math.min(Math.max(currPos,eyePos+3),eyePos+17) + "px";
	}
}
