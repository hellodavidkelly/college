var xmlHttp = createXmlHttpRequest();

//create Object
function createXmlHttpRequest();
{
	var xmlHttp;
	if(window.XMLHttpRequest)
	{
		xmlHttp = new XMLHttpRequest();
	}
	else
	{
		xmlHttp = new ActiveXObject("Microsoft.XMLHttp");
	}
	return xmlHttp;
}

//called onload
function process()
{
	if(xmlHttp)
	{
		try
		{
			xmlHttp.open("GET", "invoice.xml", false);
			xmlHttp.onreadystatechange = handleStateChange;
			xmlHttp.send(null);
		}
		catch (e)
		{
			alert(e.toString());
		}
	}
}

// when state changes this function handles the state change
function handleStateChange()
{
	if(xmlHttp.readyState==4)
	{
		if(xmlHttp.status==200)
		{
			try
			{
				handleResponse();
			}
			catch(e)
			{
				alert(e.toString());
			}
		}
		else
		{
			alert(xmlHttp.statusText);
		}
	}
}


// handle the response from the server
function handleResponse()
{
	var xmlResponse = xmlHttp.responseXML;
//	root = xmlResponse.documentElement;
//	destination = root.getElementByTagName("destination");
//	passanger = root.getElementByTagName("passanger");
	
	
	var data = xhr.responseText;
/*	
	for(int i=0; i<destination.length; i++)
	{
		data = destination.item(i).firstChild.data;
	}
*/	
//	here = document.getElementById("here");
//	here.innerHTML = data;
	document.getElementById("here").innerHTML = here;
}