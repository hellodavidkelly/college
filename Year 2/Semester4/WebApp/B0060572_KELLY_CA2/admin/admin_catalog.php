<?php
	require_once("../include/db_connect.php");
?>

<html>

	 <head>
	  <title>Products</title>
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

<?php

	if (isset($_POST['button']))
	{
		add_item();
		exit;
	}

	$db_link = db_connect("project");
	$self = $_SERVER['PHP_SELF'];
	
	$fields = mysql_list_fields("project", "product");
	$num_columns = mysql_num_fields($fields);

	$query = "SELECT * FROM product";
	$result = mysql_query($query) or die("SQL query failed");

	echo '<table>';
	echo "<tr>";
	for ($i = 0; $i < $num_columns; $i++)
	{
	   echo "<th>", mysql_field_name($fields, $i), "</th>";
	}
  	echo "</tr>";


	while ($row = mysql_fetch_assoc($result))
	{
		echo "<tr>";
		echo "<td>".$row['movieID']."</td>";
		echo "<td>".$row['title']."</td>";
		echo "<td>".$row['studio']."</td>";
		echo "<td>".$row['year']."</td>";
		echo "<td>$".$row['price']."</td>";
		echo "<td><img src='../images/".$row['image']."'></td>";

		$price=$row['price'];
		$movieID = $row['movieID'];
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
		$db_link = db_connect("project");
		$sessionID = session_id();
		$movieID = $_REQUEST['movieID'];
		$price = $_REQUEST['price'];
		$quantity =$_REQUEST['quantity'];
		$title =$_REQUEST['title'];

		foreach($_REQUEST as $key=>$value)
		echo("<tr><td>$key</td><td>$value</td></tr>");

		if($quantity >0)
		{
			$sql2 = "INSERT INTO CART (session_id,movieID,title,quantity,price) 
			VALUES ('$sessionID','$movieID','$title','$quantity','$price')
			ON DUPLICATE KEY UPDATE
			quantity =quantity +".$quantity.";";
		}	

		$result2 = mysql_query($sql2); 
		mysql_close($db_link);
		$page = $_SERVER['PHP_SELF'];
		$sec = ".01";
		//header("Refresh: $sec;$page");

	}	
?>

<?php
include ('../include/footer.html'); // Include the HTML footer.
?>
