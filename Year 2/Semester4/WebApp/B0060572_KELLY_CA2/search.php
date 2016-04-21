<?php
	require_once("include/db_connect.php");
?>

<html>

	 <head>
	  <title>Home</title>
	 </head>

<body>
<?php
include ('include/header.html'); // Include the HTML footer.
?>
<br>

	<div id = "search">
		<form action="" method="get">
			<input type = "text" name = "studio"> 
			<input type = "submit" name = "product" value = "Title">
			<input type = "submit" name = "Maker" value = "studio">
			<input type = "submit" name = "Year" value = "Year">
			<input type = "submit" name = "id" value = "product ID">	
	   </form>
   </div>
<br>
<br>
</body>
</html>

	


<?php
	if (isset($_REQUEST['product'])) // submit was clicked
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
			echo '<table border="1">';
			echo "<tr>";
			echo "<th> Title </th>";
			echo "<th> Price </th>";
			echo "<th> studio</th>";
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
			echo "<td><img src='images/".$row['image']."'></td>";
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
			echo "<th> studio</th>";
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
				echo "<td><img src='images/".$row['image']."'></td>";
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
			echo "<th>studio</th>";
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
				echo "<td><img src='images/".$row['image']."'></td>";
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
			echo "<th>studio</th>";
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
				echo "<td><img src='images/".$row['image']."'></td>";
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
include ('Include/footer.html'); // Include the HTML footer.
?>
