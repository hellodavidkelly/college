<?php
	require_once("../include/db_connect.php");
?>

<html>
	 <head>
	  <title>About</title>
	 </head>

<body>
<?php
include ('../include/adminHeader.html'); // Include the HTML footer.
?>
<br>

	<div id="side">
		<a href="../index.php">Home</a><br>
		<a href="admin_search.php">Admin Search</a>
	</div>

	<div id = "about">
		<p> 
		You are in the ADMIN section of an online DVD store.<br>
		You have permissions to insert and delete items from the database.<br>
		When you leave the admin section you will be required to log back in.<br>
		</p>
		<br>
		<p>
		This Website was created by David Kelly B00060572
		</p>
	</div>
		
</body>
</html>
	
<?php
include ('../include/footer.html'); // Include the HTML footer.
?>


