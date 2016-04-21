

<html>

 <head>
  <title>Search Database</title>
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
<h1>Home</h1>
	
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
    <form action="" method="get">
  
			Search By A String: 
			<input type = "text" name = "publisher"> For
			<input type = "submit" name = "Game" value = "Title">
			<input type = "submit" name = "Maker" value = "Publisher">
			<input type = "submit" name = "Year" value = "Year">
			<input type = "submit" name = "id" value = "Game ID">
			
   </form>
   </div>
	
</body>
</html>

	


<?php
    require_once("Include/db_connect.php");

if (isset($_REQUEST['Game'])) // submit was clicked
{

  search_title();
}

if (isset($_REQUEST['Maker'])) // submit was clicked
{

  search_publisher();
}
if (isset($_REQUEST['Year'])) // submit was clicked
{

  search_year();
}

if (isset($_REQUEST['id'])) // submit was clicked
{

  search_id();
}



else // display form for first time
{
  // process_form();
}
?>

<?php
function search_publisher()
{
?>
   <html>
     <head><title>Search for a Publisher</title></head>
     <body>
   

   
  <?php

		$db_link = db_connect("games");
		$publisher= $_REQUEST['publisher'];
	
		$publisher = "%".$publisher."%";
   
   
   
   
   
   
		$query = "SELECT * from inventory WHERE pub LIKE ". " '$publisher'";
  		$result = mysql_query($query);

		

		if (mysql_num_rows($result) > 0)
		{
				echo '<table border="1">';
				echo "<tr>";
				echo "<th> Title </th>";
				echo "<th> Price </th>";
				echo "<th> Publisher</th>";
				echo "<th> Image</th>";
				echo "</tr>";
		
		
				while ($row = mysql_fetch_assoc($result))
				{
					$title = $row['title'];
					echo "<td>".$row['title']."</td>";
					$price=$row['price'];
					echo "<td>$".$row['price']."</td>";
					$pub=$row['pub'];
					echo "<td>".$row['pub']."</td>";
					echo "<td><img src='images/".$row['image']."'></td>";
					
					echo "</tr>";				
				}
   }
		else
        {
		
					echo '<table border="0">';
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
     <head><title>Search for a Title</title></head>
     <body>
   

   
  <?php

		$db_link = db_connect("games");
		$publisher= $_REQUEST['publisher'];
		
		$publisher = "%".$publisher."%";
   
   
   
   
	
   
   
		$query = "SELECT * from inventory WHERE title LIKE ". " '$publisher'";
  		$result = mysql_query($query);

		

		if (mysql_num_rows($result) > 0)
		{
					echo '<table border="1">';
					echo "<tr>";
					echo "<th> Title </th>";
					echo "<th> Price </th>";
					echo "<th> Publisher</th>";
					echo "<th> Image</th>";
					echo "</tr>";
   
		
		
				while ($row = mysql_fetch_assoc($result))
				{
					$title = $row['title'];
					echo "<td>".$row['title']."</td>";
					$price=$row['price'];
					echo "<td>$".$row['price']."</td>";
					$pub=$row['pub'];
					echo "<td>".$row['pub']."</td>";
					echo "<td><img src='images/".$row['image']."'></td>";
					
					echo "</tr>";				
				}
   }
		else
        {
				
				
					echo '<table border="0">';
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
     <head><title>Search for a Game By Year</title></head>
     <body>
   

   
  <?php

		$db_link = db_connect("games");
		$publisher= $_REQUEST['publisher'];
		
		//$publisher = "%".$publisher."%";
   $publisher =$_REQUEST['publisher'];


   
		$query = "SELECT * from inventory WHERE year =  ".$publisher.";";
  		$result = mysql_query($query);

		

		if (mysql_num_rows($result) > 0)
		{
				
				echo '<table border="6" cellpadding = "6" >';
				echo "<th>Title</th>";
				echo "<th>Price</th>";
				echo "<th>Publisher</th>";
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
					$pub=$row['pub'];
					echo "<td>".$row['pub']."</td>";
					echo "<td><img src='images/".$row['image']."'></td>";
					
								
				
			echo "</tr>";
			}
   }
   
   
		else
        {
				
					echo '<table border="0">';
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
     <head><title>Search for a Game By ID</title></head>
     <body>
   

   
  <?php

		$db_link = db_connect("games");
		$publisher= $_REQUEST['publisher'];
		
		$publisher = "%".$publisher."%";
   

	
   
		$query = "SELECT * from inventory WHERE gameID LIKE ". " '$publisher'";
  		$result = mysql_query($query);

		

		if (mysql_num_rows($result) > 0)
		{
				
				echo '<table border="6" cellpadding = "6" >';
				echo "<th>Title</th>";
				echo "<th>Price</th>";
				echo "<th>Publisher</th>";
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
					$pub=$row['pub'];
					echo "<td>".$row['pub']."</td>";
					echo "<td><img src='images/".$row['image']."'></td>";
					
								
				
			echo "</tr>";
			}
			
   }
   
   
		else
        {
				
					echo '<table border="0">';
					echo "<tr>";
					
					echo "<th> No Search Results Found</th>";
					echo "</tr>";
 	    }
   }  // end process
   
   
   
 ?>
 		<?php
include ('Include/footer.html'); // Include the HTML footer.
?>


  