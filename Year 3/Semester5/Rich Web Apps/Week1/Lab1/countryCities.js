// when the page first loads call the function initForm
window.onload = initForm;

function initForm() 
{
	document.getElementById("country").selectedIndex = 0;
	document.getElementById("country").onchange = populateCities;
}

// Populates the options in the first combo box
function populateCities() 
{
	var country="City";
	var irelandCities=["Cork","Dublin","Galway"];
	var englandCities=["London","Manchester","Birmingham"];
	var franceCities=["Paris","Bordeaux","Cannes","Nimes"];
	var germanCities=["Berlin","Munich","Dortmund"];
	var spanishCities=["Madrid","Malaga","Valencia"];
	var countryStr = this.options[this.selectedIndex].value;	
	
// populates second combo box when value in first == Country
	if (countryStr == 0) 
	{					
		document.getElementById("city").options.length = 0;
		document.getElementById("city").options[0] = new Option(country);
	}

// populates second combo box when value in first == Ireland
	if (countryStr == 1) 
	{					
		document.getElementById("city").options.length = 0;
		for(var i=0; i<irelandCities.length; i++) 
		{
			document.getElementById("city").options[i] = new Option(irelandCities[i]);
		}
	}

// populates second combo box when value in first == England
	if (countryStr == 2) 
	{					
		document.getElementById("city").options.length = 0;
		for(var i=0; i<englandCities.length; i++) 
		{
			document.getElementById("city").options[i] = new Option(englandCities[i]);
		}
	}
	
// populates second combo box when value in first == France
	if (countryStr == 3) 
	{					
		document.getElementById("city").options.length = 0;
		for(var i=0; i<franceCities.length; i++) 
		{
			document.getElementById("city").options[i] = new Option(franceCities[i]);
		}
	}

// populates second combo box when value in first == Germany
	if (countryStr == 4) 
	{					
		document.getElementById("city").options.length = 0;
		for(var i=0; i<germanCities.length; i++) 
		{
			document.getElementById("city").options[i] = new Option(germanCities[i]);
		}
	}

// populates second combo box when value in first == Spain
	if (countryStr == 5) 
	{					
		document.getElementById("city").options.length = 0;
		for(var i=0; i<spanishCities.length; i++) 
		{
			document.getElementById("city").options[i] = new Option(spanishCities[i]);
			document.getElementById("city").options = new Option("City");
		}
	}
	
}
