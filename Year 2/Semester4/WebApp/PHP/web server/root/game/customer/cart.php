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

 <body> <hr>
 <h1>My Cart</h1>






<html>
<head>
<title>Count Visits</title>
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




		update_table();

		exit;
	}

	if (isset($_POST['cancel']))
	{




		cancel_order();

		exit;
	}


	$db_link = db_connect("games");
    $self = $_SERVER['PHP_SELF'];


	$session = (int)session_id();
	

	

	foreach($_REQUEST as $key=>$value)
	echo("<tr><td>$key</td><td>$value</td></tr>");
	$fields = mysql_list_fields("games", "cart");
	$num_columns = mysql_num_fields($fields);
	
	$query = "SELECT * FROM cart WHERE session_id = ".$session.";";

	$result = mysql_query($query) or die("SQL failed");
	echo '<table border="1">';
	echo "<tr>";
	echo "<th> Title </th>";
    echo "<th> Price </th>";
	echo "<th> Quantity </th>";
	echo "<th> Update Quantity </th>";
	echo "<th> Confirm Order </th>";
	echo "<th> Cancel Order </th>";

	echo "</tr>";

	while ($row = mysql_fetch_assoc($result))
	{
       echo "<tr>";


	echo "<td>".$row['title']. "</td>";
		echo "<td>$".$row['price']."</td>";
	   echo "<td>".$row['quantity']."</td>";
	


		$title=$row['title'];
		$price=$row['price'];
		$quantity = $row['quantity'];
		$gameID = $row['gameID'];
		
		
?>

		<form action="" method="post">
			<input type="hidden" name="price" value="<?php echo $price ?>">
			<td><input type="text" name="quantity"</td>
			<td><input type="submit" name="button" value="Confirm"></td>
			<td><input type="submit" name="cancel" value="Cancel"></td>
			<input type="hidden" name="gameID" value="<?php echo $gameID ?>">
			
			<input type="hidden" name="title" value="<?php echo $title ?>">


		</form>
	</body>
</html>



<?php
		echo "</tr>";
	}



		mysql_free_result($result);
		mysql_close($db_link);

	
		

	
			function cancel_order()
			{
		

					$db_link = db_connect("games");
					$sessionID = session_id();



					$gameID = $_REQUEST['gameID'];
					$price = $_REQUEST['price'];
					$quantity =$_REQUEST['quantity'];
					$title =$_REQUEST['title'];

		
				 
					$sql2 = "DELETE from cart WHERE title = '$title'";
					
					$result2 = mysql_query($sql2); 


			if(!$result2) die('Could not insert data because ' . mysql_error());

		 		mysql_close($db_link);
				$page = $_SERVER['PHP_SELF'];
				$sec = ".01";
				header("Refresh: $sec;$page");
				
				}

			function	update_table()
			{
		

					$db_link = db_connect("games");
					$sessionID = session_id();



					$gameID = $_REQUEST['gameID'];
					$price = $_REQUEST['price'];
					$quantity =$_REQUEST['quantity'];
					$title =$_REQUEST['title'];

							
		if($quantity !=0)
		{
				 
					$sql2 = "UPDATE cart SET quantity = '$quantity' WHERE title = '$title'";
					$result2 = mysql_query($sql2); 


			if(!$result2) die('Could not insert data because ' . mysql_error());
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


	
	
	
	
	