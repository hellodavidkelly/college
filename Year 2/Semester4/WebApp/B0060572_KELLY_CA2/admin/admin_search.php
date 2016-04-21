<html>

	<head>
		<title>Search</title>
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
		<form action="" method="get">
			<input type = "text" name = "studio">
			<input type = "submit" name = "Title" value = "Title">
			<input type = "submit" name = "Maker" value = "Studio">
			<input type = "submit" name = "Year" value = "Year">
			<input type = "submit" name = "id" value = "Movie ID">
		</form>
	</div>
	<br>
	</body>
</html>

	


<?php
require_once("../include/db_connect.php");

	if (isset($_REQUEST['title'])) // submit was clicked
	{

	  search_title();
	}

	if (isset($_REQUEST['Maker'])) // submit was clicked
	{

	  search_studio();
	}
	if (isset($_REQUEST['Year'])) // submit was clicked
	{

	  search_year();
	}

	if (isset($_REQUEST['id'])) // submit was clicked
	{

	  search_id();
	}

?>

<?php
function search_studio()
{
?>
   <html>
     <body>
   
<?php

	$db_link = db_connect("project");
	$studio= $_REQUEST['studio'];

	$studio = "%".$studio."%";

	$query = "SELECT * from product WHERE studio LIKE ". " '$studio'";
	$result = mysql_query($query);

	if (mysql_num_rows($result) > 0)
	{
		echo '<table>';
		echo "<tr>";
		echo "<th> Title </th>";
		echo "<th> Price </th>";
		echo "<th> Studio</th>";
		echo "<th> Image</th>";
		echo "</tr>";

		while ($row = mysql_fetch_assoc($result))
		{
		$title = $row['title'];
		echo "<td>".$row['title']."</td>";
		$price=$row['price'];
		echo "<td>$".$row['price']."</td>";
		$studio=$row['studio'];
		echo "<td>".$row['studio']."</td>";
		echo "<td><img src='../images/".$row['image']."'></td>";

		echo "</tr>";				
		}
	}

	else
	{
		echo '<table>';
		echo "<tr>";
		echo "<th> No Search Results Found</th>";
		echo "</tr>";
	}

}  // end process
?>
   
<?php
function search_title()
{
?>
	<html>
		<body>
<?php

	$db_link = db_connect("project");
	$studio= $_REQUEST['studio'];

	$studio = "%".$studio."%";

	$query = "SELECT * from product WHERE title LIKE ". " '$studio'";
	$result = mysql_query($query);


	if (mysql_num_rows($result) > 0)
	{
		echo '<table>';
		echo "<tr>";
		echo "<th> Title </th>";
		echo "<th> Price </th>";
		echo "<th> Studio</th>";
		echo "<th> Image</th>";
		echo "</tr>";

		while ($row = mysql_fetch_assoc($result))
		{
		$title = $row['title'];
		echo "<td>".$row['title']."</td>";
		$price=$row['price'];
		echo "<td>$".$row['price']."</td>";
		$studio=$row['studio'];
		echo "<td>".$row['studio']."</td>";
		echo "<td><img src='../images/".$row['image']."'></td>";
		echo "</tr>";				
		}
	}
	
	else
	{
		echo '<table>';
		echo "<tr>";
		echo "<th> No Search Results Found</th>";
		echo "</tr>";
	}
	
}  // end process
?>
   
  
<?php
function search_year()
{
?>
	<html>
		<body>

<?php

	$db_link = db_connect("project");
	$studio= $_REQUEST['studio'];
	$studio = "%".$studio."%";

	$query = "SELECT * from product WHERE year LIKE ". " '$studio'";
	$result = mysql_query($query);

	if (mysql_num_rows($result) > 0)
	{
		echo '<table>';
		echo "<th>Title</th>";
		echo "<th>Price</th>";
		echo "<th>Studio</th>";
		echo "<th>Image</th>";
		echo "<tr>";
		echo "</tr>";
		echo "</tr>";

		while ($row = mysql_fetch_assoc($result))
		{
		$title = $row['title'];
		echo "<td>".$row['title']."</td>";
		$price=$row['price'];
		echo "<td>$".$row['price']."</td>";
		$studio=$row['studio'];
		echo "<td>".$row['studio']."</td>";
		echo "<td><img src='../images/".$row['image']."'></td>";
		echo "</tr>";
		}
	}

	else
	{
		echo '<table>';
		echo "<tr>";
		echo "<th> No Search Results Found</th>";
		echo "</tr>";
	}
	
}  // end process
 ?>
 
 
 
<?php
function search_id()
{
?>
   <html>
     <body>
 
<?php

	$db_link = db_connect("project");
	$studio= $_REQUEST['studio'];
	$studio = "%".$studio."%";

	$query = "SELECT * from product WHERE movieID LIKE ". " '$studio'";
	$result = mysql_query($query);

		

	if (mysql_num_rows($result) > 0)
	{
		echo '<table>';
		echo "<th>Title</th>";
		echo "<th>Price</th>";
		echo "<th>Studio</th>";
		echo "<th>Image</th>";
		echo "<tr>";
		echo "</tr>";
		echo "</tr>";

		while ($row = mysql_fetch_assoc($result))
		{
		$title = $row['title'];
		echo "<td>".$row['title']."</td>";
		$price=$row['price'];
		echo "<td>".$row['price']."</td>";
		$studio=$row['studio'];
		echo "<td>".$row['studio']."</td>";
		echo "<td><img src='../images/".$row['image']."'></td>";
		echo "</tr>";
		}
	}

	else
	{
		echo '<table>';
		echo "<tr>";
		echo "<th> No Search Results Found</th>";
		echo "</tr>";
	}

}  // end process
   
   
   
 ?>
 
<?php
include ('../include/footer.html'); // Include the HTML footer.
?>
