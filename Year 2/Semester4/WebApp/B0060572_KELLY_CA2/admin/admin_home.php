<?php
	require_once("../include/db_connect.php");
?>

<html>

	 <head>
	  <title>Home</title>
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
		You are Logged In to the Administration Area
		</p>
	</div>
</body>
</html>

<?php
include ('../include/footer.html'); // Include the HTML footer.
?>
