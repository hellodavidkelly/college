// when the page first loads call the function newCard
window.onload = newCard;

function newCard() 
{
// for loop to iterate through the function setSquare
	for (var i=0; i<6; i++) 
	{
// set square passes the parameter for each index value
		setSquare(i);
	}
// compares all the numbers in the squares
	//compare();
}

// setSquare function create's a random number for each square from 1-45
function setSquare(thisSquare) 
{
	var currSquare = "square" + thisSquare;
	var newNum = Math.floor(Math.random() * 45) + 1;
	document.getElementById(currSquare).innerHTML = newNum;
}

// 
/*function compare()
{
	for(int i=0; i<5; i++)
	{
		var currSquare = "square" + i;

		for(int j=i+1; j<6; j++)
		{
			var compSquare = "square" + j;
			if(document.getElementById(currSquare).innerHTML==document.getElementById(compSquare).innerHTML)
			{
				document.getElementById(compSquare).innerHTML = document.getElementById(compSquare).innerHTML +1;
			}
		}
	}
}*/