window.onload = initForm;

function initForm() {
	document.getElementById("country").selectedIndex = 0;
	document.getElementById("country").onchange = populateCities;
}

function populateCities() {
	var irelandCities=["Cork","Dublin","Galway"];
	var englandCities=["London","Manchester","Birmingham"];
	var franceCities=["Paris","Bordeux","Cannes","Nimes"];
	var germanCities=["Berlin","Munich","Dortmund"];
	var spanishCities=["Madrid","Malaga","Valencia"];
	var countryStr = this.options[this.selectedIndex].value;
	
	if (countryStr == 0) 
	{					
		document.getElementById("city").options.length = 0;
		for(var i=0; i<irelandCities.length; i++) 
		{
			document.getElementById("city").options[i] = new Option(irelandCities[i]);
		}
	}

	if (countryStr == 1) 
	{					
		document.getElementById("city").options.length = 0;
		for(var i=0; i<englandCities.length; i++) 
		{
			document.getElementById("city").options[i] = new Option(englandCities[i]);
		}
	}
	
	if (countryStr == 2) 
	{					
		document.getElementById("city").options.length = 0;
		for(var i=0; i<franceCities.length; i++) 
		{
			document.getElementById("city").options[i] = new Option(franceCities[i]);
		}
	}

	if (countryStr == 3) 
	{					
		document.getElementById("city").options.length = 0;
		for(var i=0; i<germanCities.length; i++) 
		{
			document.getElementById("city").options[i] = new Option(germanCities[i]);
		}
	}
	
	if (countryStr == 4) 
	{					
		document.getElementById("city").options.length = 0;
		for(var i=0; i<spanishCities.length; i++) 
		{
			document.getElementById("city").options[i] = new Option(spanishCities[i]);
		}
	}
}
