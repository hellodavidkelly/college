<?php


	require_once("Include/db_connect.php");


	


?>


<html>

 <head>
  <title>Admin Home</title>
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
<h1>Admin Home</h1>

	<form action="<?php echo $_SERVER['PHP_SELF']; ?>" method="post">
		<p><a href="admin_home.php"><img src="Images/admin_home.jpg"  width="258" height="75"></a>
		<a href="admin_catalog.php"><img src="Images/admin_catalogue.png" alt="HTML tutorial" width="258" height="75"></a>
		<a href="admin_delete.php"><img src="Images/delete.jpg"  width="258" height="75"></a>
		<a href="admin_insert.php"><img src="Images/insert.png"  width="258" height="75"></a>
		<a href="admin_about.php"><img src="Images/admin_about.png"  width="258" height="75"></a></p>
	
		
		</form>
<a href="home.php"><img src="Images/logout.png"  width="258" height="75"></a></p>
<a href="admin_search.php"><img src="Images/admin_search.png"  width="258" height="75">
<div id = "notice">
			You are Logged In to the Administration Area
		</div>
		


	
</body>
</html>

		


		<?php
include ('Include/footer.html'); // Include the HTML footer.
?>
