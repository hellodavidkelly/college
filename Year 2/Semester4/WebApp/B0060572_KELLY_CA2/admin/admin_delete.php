<?php
	require_once("../include/db_connect.php");
?>

<html>

	 <head>
	  <title>Delete</title>
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

	<div id = "search">
		<form action="" method="post">
			<form action = "" method = "post">
			<label>Enter Title</label><input type = "text" name = "login"> 
			<input type = "submit" name = "submit" value = "Delete">
		</form>
   </div>

</body>

		
<?php

	if (isset($_REQUEST['submit']))
	{
		$db_link = db_connect("project");
		$login = $_REQUEST['login'];
		$query = "DELETE from product WHERE title = '$login'";

		mysql_query($query);

		if (mysql_affected_rows()==1)
		{	
			echo "<p>You have Deleted The Title From The Database</p>";	
		}
		else
		{ 
			echo "<p>No Matches</p>";
		}
	}

?>

<?php
include ('../include/footer.html'); // Include the HTML footer.
?>
