<?php
	session_start();
	require_once("include/db_connect.php");
?>

<html>

	 <head>
	  <title>Cart</title>
	 </head>

 <body>
 <?php
 include ('include/header.html'); // Include the HTML footer.
 ?>
 <br>

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


	$db_link = db_connect("project");
    $self = $_SERVER['PHP_SELF'];

	$session = (int)session_id();
	
	foreach($_REQUEST as $key=>$value)
	echo("<tr><td>$key</td><td>$value</td></tr>");
	$fields = mysql_list_fields("project", "cart");
	$num_columns = mysql_num_fields($fields);
	
	$query = "SELECT * FROM cart WHERE session_id = ".$session.";";

	$result = mysql_query($query) or die("SQL failed");
	echo '<table border="1">';
	echo "<tr>";
	echo "<th> Title </th>";
    echo "<th> Price </th>";
	echo "<th> Quantity </th>";
	echo "<th> Update Quantity </th>";
	echo "<th> Confirm Update </th>";
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
	$movieID = $row['movieID'];		
?>
	<form action="" method="post">
		<input type="hidden" name="price" value="<?php echo $price ?>">
		<td><input type="text" name="quantity"</td>
		<td><input type="submit" name="button" value="Confirm"></td>
		<td><input type="submit" name="cancel" value="Cancel"></td>
		<input type="hidden" name="movieID" value="<?php echo $movieID ?>">
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

		$db_link = db_connect("project");
		$sessionID = session_id();

		$movieID = $_REQUEST['movieID'];
		$price = $_REQUEST['price'];
		$quantity =$_REQUEST['quantity'];
		$title =$_REQUEST['title'];

		$sql2 = "DELETE from cart WHERE title = '$title'";				
		$result2 = mysql_query($sql2); 

		if(!$result2) die('Could not insert data because ' . mysql_error());

		mysql_close($db_link);
		$page = $_SERVER['PHP_SELF'];
		$sec = ".01";
		//header("Refresh: $sec;$page");
	
	}

	function update_table()
	{

		$db_link = db_connect("project");
		$sessionID = session_id();
		
		$movieID = $_REQUEST['movieID'];
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
		//header("Refresh: $sec;$page");
	}
	
?>

<?php
include ('include/footer.html'); // Include the HTML footer.
?>