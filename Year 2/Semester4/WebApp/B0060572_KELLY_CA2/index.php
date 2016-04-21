<?php
	require_once("Include/db_connect.php");
?>

<html>

	 <head>
	  <title>Home</title>
	 </head>

<body>
<?php
include ('Include/header.html'); // Include the HTML footer.
?>
<br>

	<div id="side">
		<a href="search.php">SEARCH</a></br></br></br>	
		<a href="admin/admin.php">ADMIN</a><br></br></br>
	</div>
	
	<p>
	Check out this weeks offers
	</p>
<?php

    $db_link = db_connect("project");
    $self = $_SERVER['PHP_SELF'];

	$title = trim(isset($_REQUEST['title'])) ? $_REQUEST['title'] : '';
    $price = trim(isset($_REQUEST['price'])) ? $_REQUEST['price'] : '';
	$image = trim(isset($_REQUEST['image'])) ? $_REQUEST['image'] : '';
	$movieID = trim(isset($_REQUEST['movieID'])) ? $_REQUEST['movieID'] : '';

	$count;

	$query = "SELECT movieID,title,price,image FROM product ORDER BY rand() limit 3";
	$result = mysql_query($query);

	if (mysql_num_rows($result) > 0)
	{
		echo "<table id='indexTable'>";

		// Fetch and print all the records in HTML table format, if records exist
			while ($row = mysql_fetch_assoc($result))
			{
				echo "<tr>";
				echo "<td>".$row['movieID']."</td>";
				echo "<td>".$row['title']."</td>";
				echo "<td><a href='detailMovie.php?   movieID=".$row['movieID']."'><img src='images/".$row['image']."'></a></td>";	
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
