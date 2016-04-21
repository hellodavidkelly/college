<?php

	
	require_once("Include/db_connect.php");

 

	


?>


<html>

 <head>
  <title>About</title>
 </head>

 <body>
 <hr>

 <br>
 
 <hr>

<html>
<head><title>Game Inventory</title>
<link rel="stylesheet" type="text/css" href="Css/style.css">
</head>
<body>
<h1>About</h1>

	<form action="<?php echo $_SERVER['PHP_SELF']; ?>" method="post">
		<p><a href="home.php"><img src="Images/home.png"  width="258" height="75"></a>
		<a href="catalog.php"><img src="Images/catalogue.png" alt="HTML tutorial" width="258" height="75"></a>
		<a href="cart.php"><img src="Images/cart.png"  width="258" height="75"></a>
		<a href="checkout.php"><img src="Images/checkout.png"  width="258" height="75"></a>
		<a href="about.php"><img src="Images/about.png"  width="258" height="75"></a></p>
		<a href="search.php"><img src="Images/search.png"  width="258" height="75"></a></br></br></br>
		<a href="admin.php"><img src="Images/admin.png"  width="258" height="75"></a><br></br></br>
		<a href="enter.php"><img src="Images/enter.png"  width="258" height="75"></a>
		
		</form>

<div id = "about">
	<p> This PHP project is a shopping cart for a games company with database behind it.<br>
	There is an admin section and a section for normal users. In the admin section the admin can update or remove records<br>
	as well as search the database. In the user section it acts like a real life website allowing the user to buy items <br>
    after adding them to his cart and then confirming the purchase by entering some details.<br><br>
	By Michael James (b00019330)
	
	
	</p></div>
	
		
		

</body>
</html>

		
		<?php
include ('Include/footer.html'); // Include the HTML footer.
?>


