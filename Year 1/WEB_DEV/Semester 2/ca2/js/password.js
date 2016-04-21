function compare()
{
	var a = document.getElementById("password").value;
	var b = document.getElementById("confirmpassword").value;
					
	if(a!=b)
	{
		alert("your password did not match, please try again.");
		document.getElementById("confirmpassword").focus();
	}
}