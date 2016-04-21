<?php
	require_once("Include/db_connect.php");
?>

<html>

	 <head>
	  <title>Home</title>
	 </head>

 	<body>
 <hr>
 <?php
 include ('Include/header.html'); // Include the HTML footer.
 ?>
 <br>

<?php

// Connect to server and select a database --- Call the function db_connect() in db_connect(External File)



    $db_link = db_connect("games");
    $self = $_SERVER['PHP_SELF'];

		$title = trim(isset($_REQUEST['title'])) ? $_REQUEST['title'] : '';
	    $price = trim(isset($_REQUEST['price'])) ? $_REQUEST['price'] : '';
	    $image = trim(isset($_REQUEST['image'])) ? $_REQUEST['image'] : '';
		$gameID = trim(isset($_REQUEST['gameID'])) ? $_REQUEST['gameID'] : '';

		
		$count;

		

		// echo $query. "<p>";



$query = "SELECT gameID,title,price,image FROM inventory ORDER BY rand() limit 3";

		// echo $query. "<p>";

		$result = mysql_query($query);



// If a match exists (my_sql_num rows function > 0,
	if (mysql_num_rows($result) > 0)
		{
		echo "<table align = 'left' border = '10' cellpadding = '10'>";
		
// Fetch and print all the records in HTML table format, if records exist
		
		while ($row = mysql_fetch_assoc($result))
			{
			echo "<tr>";
				//echo "<td>".$row['gameID']."</td>";
				echo "<td>".$row['title']."</td>";
				echo "<td>$".$row['price']."</td>";
				echo "<td><a href='detailgame.php?   gameID=".$row['gameID']."'><img src='images/".$row['image']."'></a></td>";
				
				
   			echo "</tr>";
			}
	  echo "</table>";
	  
		}

		mysql_close();


?>

	
</body>
</html>

		<?php
include ('Include/footer.html'); // Include the HTML footer.
?>
