<?php


	require_once("Include/db_connect.php");


	


?>


<hr>

 <br>
 
 <hr>

<head><title>Manage Records</title>
<link rel="stylesheet" type="text/css" href="Css/admin_style.css">
</head>
<body>
<h1>Admin Delete Records</h1>

<form action="<?php echo $_SERVER['PHP_SELF']; ?>" method="post">
		<p><a href="admin_home.php"><img src="Images/admin_home.jpg"  width="258" height="75"></a>
		<a href="admin_catalog.php"><img src="Images/admin_catalogue.png" alt="HTML tutorial" width="258" height="75"></a>
		<a href="admin_delete.php"><img src="Images/delete.jpg"  width="258" height="75"></a>
		<a href="admin_insert.php"><img src="Images/insert.png"  width="258" height="75"></a>
		<a href="admin_about.php"><img src="Images/admin_about.png"  width="258" height="75"></a></p>
	
		
		</form>
	<a href="home.php"><img src="Images/logout.png"  width="258" height="75"></a></p>
<a href="admin_search.php"><img src="Images/admin_search.png"  width="258" height="75"></a>
	

	<div id = "search">
    <form action="" method="post">
  
			
		 <form action = "" method = "post">
		Enter A Title To Delete <input type = "text" name = "login"> 
		 <input type = "submit" name = "submit" value = "Delete">
   </form>
			
   
   </div>

</body>

		
<?php

if (isset($_REQUEST['submit']))
   {

			$db_link = db_connect("games");
			$login = $_REQUEST['login'];
			$query = "DELETE from inventory WHERE title = '$login'";

			mysql_query($query);

	if (mysql_affected_rows()==1)
    {	
		echo "<p>You have Deleted The Title From The Database</p>";
		
	}else
	
	 
   echo "<p>No Matches</p>";
  
  
   }
   
   
   
   
   else
   { ?>
   <html>
   <body>
   
  
	<div id = "search">
    <form action="" method="post">
  
			 
		 <form action = "admin_delete.php" method = "post">
		Enter A Title To Delete <input type = "text" name = "login"> 
		 <input type = "submit" name = "submit" value = "Delete">
   </form>
   </body>
   </html>
   <?php
   }
   ?>

		<?php
include ('Include/footer.html'); // Include the HTML footer.
?>
