
function first(){
  //creates a popup window with the text which was
  // entered into the text field
  alert("The value of the textfield is: " +
	document.myForm.myText.value);
}
function second(){
  //this function checks the state of the checkbox
var myString="The checkbox is ";
if(document.myForm.myCheckbox.checked)myString+="checked"
  else myString+="not checked";
alert(myString);
}

document.write("The background colour is: ");
document.write(document.bgColor + "<br>");
document.write("The text on the first button is: ");
document.write(document.myForm.button1.value);
