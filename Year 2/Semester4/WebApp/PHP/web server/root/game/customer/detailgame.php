<?php

	session_start();
	require_once("Include/db_connect.php");






?>

<!-- example for PHP 5.0.0 final release -->

<html>

 <head>
  <title>Session running</title>

 </head>
 <hr>
 PHPSESSID = <?php echo session_id(); ?>
 <br>


 <body>
 <h1> Game Details</h1>






<html>
<head><title>Game Details</title>
<link rel="stylesheet" type="text/css" href="Css/style.css">

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

	
	
	
		display_output_page();

		exit;
	}



	$db_link = db_connect("games");
    $self = $_SERVER['PHP_SELF'];
    $gameID = $_REQUEST['gameID'];

	foreach($_REQUEST as $key=>$value)

	$fields = mysql_list_fields("games", "inventory");
	$num_columns = mysql_num_fields($fields);


	$query = "SELECT * FROM inventory WHERE gameID=".$gameID.";";
	$result = mysql_query($query) or die("SQL failed");
	echo '<table border="1">';
	echo "<tr>";

		
		echo "<th> Game Details </th>";
		

	while ($row = mysql_fetch_assoc($result))
	{
		echo "<tr>";
		echo "<td><img src='images/".$row['image']."'></td>";
		echo "</tr>";echo "<tr>";
		echo "<td>".$row['title']."</td>";echo "</tr>";echo "<tr>";
		echo "<td>$".$row['price']."  </td>"; echo "</tr>";
		echo "</tr>";
		
			$gameID=$row['gameID'];
			$price=$row['price'];
			$title=$row['title'];
			$pub=$row['pub'];
			$year=$row['year'];

?>

		<form action="<?php echo $_SERVER['PHP_SELF']; ?>" method="post">
			
			<td>Quantity<input type="text" name="quantity"</td>
			<input type="submit" name="button" value="Add">
			<input type="hidden" name="gameID" value="<?php echo $gameID ?>">
			<input type="hidden" name="price" value="<?php echo $price ?>">
			<input type="hidden" name="title" value="<?php echo $title ?>">
		</form>
	</body>
</html>
<?php
	
	}
		mysql_free_result($result);
		mysql_close($db_link);



	function display_output_page()
	{


		$db_link = db_connect("games");
		$sessionID = session_id();



		$gameID = $_REQUEST['gameID'];
		$price = $_REQUEST['price'];
		$quantity =$_REQUEST['quantity'];
		$title =$_REQUEST['title'];

		
		if($quantity !=0)
{
$sql2 = "INSERT INTO CART (session_id,gameID,title,quantity,price) 
			VALUES ('$sessionID','$gameID','$title','$quantity','$price')
			ON DUPLICATE KEY UPDATE
			quantity =quantity +".$quantity."; ";
		

		 $result2 = mysql_query($sql2); 


		 if(!$result2) die('Could not insert data because ');



		 if($result2)
		{
	
			echo "You Have Added The Item To The Cart";
		}
		

		} 
		
		mysql_close($db_link);
		
		
	}
?>


