function price()
{
	
	if(document.getElementById("adult").checked == true)
	{
		document.getElementById("studentRateA").innerHTML = "(€9.99)";
		document.getElementById("studentRateB").innerHTML = "(€19.99)";
	}
	
	if(document.getElementById("other").checked == true)
	{
		document.getElementById("studentRateA").innerHTML = "(€4.99)";
		document.getElementById("studentRateB").innerHTML = "(€9.99)";
	}
	
	if(document.getElementById("student").checked == true)
	{
		document.getElementById("studentRateA").innerHTML = "(FREE)";
		document.getElementById("studentRateB").innerHTML = "(€4.99)";
	}
}