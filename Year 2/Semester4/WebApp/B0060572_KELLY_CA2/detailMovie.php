<?php
	session_start();
	require_once("Include/db_connect.php");
?>

<html>

	 <head>
	  <title>Product Details</title>
	 </head>

<body>
<?php
include ('Include/header.html'); // Include the HTML footer.
?>
<br>
PHPSESSID = <?php echo session_id(); ?>

<?php

	if (isset($_POST['button']))
	{
		display_output_page();
		exit;
	}

	$db_link = db_connect("project");
    $self = $_SERVER['PHP_SELF'];
    $movieID = $_REQUEST['movieID'];

	foreach($_REQUEST as $key=>$value)

	$fields = mysql_list_fields("project", "product");
	$num_columns = mysql_num_fields($fields);

	$query = "SELECT * FROM product WHERE movieID=".$movieID.";";
	$result = mysql_query($query) or die("SQL failed");
	
	echo '<table>';
	echo "<tr>";
	echo "<th> product Details </th>";
		
	while ($row = mysql_fetch_assoc($result))
	{
		echo "<tr>";
		echo "<td><img src='images/".$row['image']."'></td>";
		echo "</tr>";
		echo "<tr>";
		echo "<td>".$row['title']."</td>";
		echo "</tr>";
		echo "<tr>";
		echo "<td>".$row['studio']."</td>";
		echo "</tr>";
		echo "<tr>";
		echo "<td>$".$row['price']."  </td>"; 
		echo "</tr>";
	echo "</tr>";
		
		$movieID=$row['movieID'];
		$price=$row['price'];
		$title=$row['title'];
		$studio=$row['studio'];
		$year=$row['year'];

?>
		<form action="<?php echo $_SERVER['PHP_SELF']; ?>" method="post">
			<td>Quantity<input type="text" name="quantity"</td>
			<input type="submit" name="button" value="Add">
			<input type="hidden" name="movieID" value="<?php echo $movieID ?>">
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
		$db_link = db_connect("project");
		$sessionID = session_id();

		$movieID = $_REQUEST['movieID'];
		$price = $_REQUEST['price'];
		$quantity =$_REQUEST['quantity'];
		$title =$_REQUEST['title'];

		if($quantity !=0)
		{
			$sql2 = "INSERT INTO CART (session_id,movieID,title,quantity,price) 
			VALUES ('$sessionID','$movieID','$title','$quantity','$price')
			ON DUPLICATE KEY UPDATE
			quantity = quantity +".$quantity."; ";


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


