<?php


	require_once("Include/db_connect.php");





?>


<html>

 <head>
  <title></title>
 </head>

 <body>
 <hr>
 
 <br>
 
 <hr>

<html>
<head><title>Admin Inventory</title>
<link rel="stylesheet" type="text/css" href="Css/admin_style.css">
<h1>Admin Inventory</h1>
</head>
<body>
	<form action="<?php echo $_SERVER['PHP_SELF']; ?>" method="post">
		<p><a href="admin_home.php"><img src="Images/admin_home.jpg"  width="258" height="75"></a>
		<a href="admin_catalog.php"><img src="Images/admin_catalogue.png" alt="HTML tutorial" width="258" height="75"></a>
		<a href="admin_delete.php"><img src="Images/delete.jpg"  width="258" height="75"></a>
		<a href="admin_insert.php"><img src="Images/insert.png"  width="258" height="75"></a>
		<a href="admin_about.php"><img src="Images/admin_about.png"  width="258" height="75"></a></p>
	
		
		</form>
<a href="home.php"><img src="Images/logout.png"  width="258" height="75"></a></p>
<a href="admin_search.php"><img src="Images/admin_search.png"  width="258" height="75"></a>
<?php



	if (isset($_POST['button']))
	{
	
		add_item();
	

		exit;
	}

$db_link = db_connect("games");
 $self = $_SERVER['PHP_SELF'];


$fields = mysql_list_fields("games", "inventory");
$num_columns = mysql_num_fields($fields);


$query = "SELECT * FROM inventory";
$result = mysql_query($query) or die("SQL query failed");



echo '<table border="6" cellpadding = "6" >';



echo "<tr>";
for ($i = 0; $i < $num_columns; $i++)
{
   echo "<th>", mysql_field_name($fields, $i), "</th>";


}
  
echo "</tr>";
echo "</tr>";



while ($row = mysql_fetch_assoc($result))
{
  		echo "<tr>";
  		echo "<td>".$row['gameID']."</td>";
 		echo "<td>".$row['title']."</td>";
	 	echo "<td>".$row['pub']."</td>";
   		echo "<td>".$row['year']."</td>";
    	echo "<td>$".$row['price']."</td>";
    	echo "<td><img src='images/".$row['image']."'></td>";
		
		$price=$row['price'];
		$gameID = $row['gameID'];
		$title=$row['title'];
		
	?>
	
	</body>
</html>
		


<?php
		echo "</tr>";
		
	}
		mysql_free_result($result);
		mysql_close($db_link);

	function add_item()
	{


		$db_link = db_connect("games");
		$sessionID = session_id();



		$gameID = $_REQUEST['gameID'];
		$price = $_REQUEST['price'];
		$quantity =$_REQUEST['quantity'];
		$title =$_REQUEST['title'];

		foreach($_REQUEST as $key=>$value)
		echo("<tr><td>$key</td><td>$value</td></tr>");

		
		
if($quantity >0)
{
$sql2 = "INSERT INTO CART (session_id,gameID,title,quantity,price) 
			VALUES ('$sessionID','$gameID','$title','$quantity','$price')
			ON DUPLICATE KEY UPDATE
			quantity =quantity +".$quantity.";";
	}	
		
		 $result2 = mysql_query($sql2); 

		
		mysql_close($db_link);
		$page = $_SERVER['PHP_SELF'];
		$sec = ".01";
		header("Refresh: $sec;$page");
	
	}
	
?>
		<?php
include ('Include/footer.html'); // Include the HTML footer.
?>
