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
<link rel="stylesheet" type="text/css" href="Css/admin_style.css">
</head>
<body>
<h1>About</h1>

	<form action="<?php echo $_SERVER['PHP_SELF']; ?>" method="post">
		<p><a href="admin_home.php"><img src="Images/admin_home.jpg"  width="258" height="75"></a>
		<a href="admin_catalog.php"><img src="Images/admin_catalogue.png" alt="HTML tutorial" width="258" height="75"></a>
		<a href="admin_delete.php"><img src="Images/delete.jpg"  width="258" height="75"></a>
		<a href="admin_insert.php"><img src="Images/insert.png"  width="258" height="75"></a>
		<a href="admin_about.php"><img src="Images/admin_about.png"  width="258" height="75"></a></p>
	
		
		</form>
		<a href="home.php"><img src="Images/logout.png"  width="258" height="75"></a></p>
<a href="admin_search.php"><img src="Images/admin_search.png"  width="258" height="75"></a>
<div id = "about">
	<p> This part of the PHP project is an admin home site for a games company with database behind it.<br>
	In the admin section the admin can update or remove records
	as well as search the database. .<br><br>
	By Michael James (b00019330)
	
	
	</p></div>
	
		
		

</body>
</html>

		
		<?php
include ('Include/footer.html'); // Include the HTML footer.
?>


