<?php

	session_start();
	require_once("Include/db_connect.php");





?>


<html>

 <head>
  <title>Session running</title>
 </head>

 <body>
 <hr>
 PHPSESSID = <?php echo session_id(); ?>
 <br>
 
 <hr>

<html>
<head><title>Game Inventory</title>
<link rel="stylesheet" type="text/css" href="Css/style.css">
<h1>Inventory</h1>
</head>
<body>
	<form action="<?php echo $_SERVER['PHP_SELF']; ?>" method="post">
		<p><a href="home.php"><img src="Images/home.png"  width="258" height="75"></a>
		<a href="catalog.php"><img src="Images/catalogue.png" alt="HTML tutorial" width="258" height="75"></a>
		<a href="cart.php"><img src="Images/cart.png"  width="258" height="75"></a>
		<a href="checkout.php"><img src="Images/checkout.png"  width="258" height="75"></a>
		<a href="about.php"><img src="Images/about.png"  width="258" height="75"></a></p>
		<a href="search.php"><img src="Images/search.png"  width="258" height="75"></a></br></br></br>
		<a href="admin.php"><img src="Images/admin.png"  width="258" height="75"></a><br></br></br>
		<a href="enter.php"><img src="Images/enter.png"  width="258" height="75"></a>
		</form>


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
  echo "<th> Quantity </th>";
    echo "<th> Add </th>";
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
	

			<form action="catalog.php" method="post">
			
			<td><input type="text" name="quantity" value = "1"></td>
			<td><input type="submit" name="button"  value="Add"></td>
			<input type="hidden" name="gameID" value="<?php echo $gameID ?>">
			<input type="hidden" name="price" value="<?php echo $price ?>">
			<input type="hidden" name="title" value="<?php echo $title ?>">
		</form>
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

		if($quantity !=0)
{
		

$sql2 = "INSERT INTO CART (session_id,gameID,title,quantity,price) 
			VALUES ('$sessionID','$gameID','$title','$quantity','$price')
			ON DUPLICATE KEY UPDATE
			quantity =quantity +".$quantity.";";
		
		
		
		 $result2 = mysql_query($sql2); 

}
		
		mysql_close($db_link);
		$page = $_SERVER['PHP_SELF'];
		$sec = ".01";
		header("Refresh: $sec;$page");
	
	}
	
?>
		<?php
include ('Include/footer.html'); // Include the HTML footer.
?>
