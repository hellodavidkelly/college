<?php

	session_start();
	require_once("Include/db_connect.php");

 session_regenerate_id();
 ($_SESSION['count']) ? $_SESSION['count']++ : $_SESSION['count'] = 1;



?>

<!-- example for PHP 5.0.0 final release -->

<html>

 <head>
  <title>Session running</title>
 </head>

 <body>
 <h1> Book Details</h1>
 <a href="catalog.php?<?php echo( SID ); ?>">Go Back To Inventory</a>
 <hr>
 PHPSESSID = <?php echo session_id(); ?>
 <br>
 You have been here <?php echo( $_SESSION['count'] ); ?> times in this session
 <hr>


<html>
<head>
<title>Count Visits</title>
</head>

<body>

<?php


	if (isset($_POST['button']))
	{

	
	
	
		display_output_page();

		exit;
	}



	$db_link = db_connect("project");
    $self = $_SERVER['PHP_SELF'];
    $isbn = $_REQUEST['isbn'];

	foreach($_REQUEST as $key=>$value)
	echo("<tr><td>$key</td><td>$value</td></tr>");
	$fields = mysql_list_fields("project", "books");
	$num_columns = mysql_num_fields($fields);


	$query = "SELECT * FROM books WHERE isbn=".$isbn.";";
	$result = mysql_query($query) or die("SQL failed");
	echo '<table border="1">';
	echo "<tr>";
	for ($i = 0; $i < $num_columns; $i++)
	{
		echo "<th>", mysql_field_name($fields, $i), "</th>";
	}
	echo "<th> Quantity </th>";
    echo "<th> Add </th>";
	echo "</tr>";

	while ($row = mysql_fetch_assoc($result))
	{
       echo "<tr>";
		echo "<td>".$row['isbn']."</td>";
		echo "<td>".$row['title']."</td>";
		echo "<td>".$row['author']. "</td>";
		echo "<td>".$row['pub']."</td>";
		echo "<td>".$row['year']."</td>";
		echo "<td>".$row['price']."</td>";
		echo "<td><img src='images/".$row['image']."'></td>";


		$price=$row['price'];

?>

		<form action="<?php echo $_SERVER['PHP_SELF']; ?>" method="post">
			<td>Quantity: </td>
			<td><input type="text" name="quantity"></td>
			<td><input type="submit" name="button" value="Add"></td>
			<input type="hidden" name="isbn" value="<?php echo $isbn ?>">
			<input type="hidden" name="price" value="<?php echo $price ?>">
		</form>
	</body>
</html>
<?php
		echo "</tr>";
	}
		mysql_free_result($result);
		mysql_close($db_link);



	function display_output_page()
	{


		$db_link = db_connect("project");
		$sessionID = session_id();



		$isbn = $_REQUEST['isbn'];
		$price = $_REQUEST['price'];
		$quantity =$_REQUEST['quantity'];

		foreach($_REQUEST as $key=>$value)
		echo("<tr><td>$key</td><td>$value</td></tr>");

		 $sql2 = "INSERT INTO cart(session_id,isbn,quantity,price) VALUES('$sessionID','$isbn','$quantity','$price')";
		 $result2 = mysql_query($sql2); 


		 if(!$result2) die('Could not insert data because ' . mysql_error());



		 if($result2)
		{
			echo "You Have Added The Item To The Cart";
		}
		mysql_close($db_link);
	}
?>