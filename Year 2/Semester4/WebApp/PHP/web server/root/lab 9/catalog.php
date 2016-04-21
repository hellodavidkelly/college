<?php
   	session_start();	#start a session

	# initially set the value to 1 or increment on next visits
    	if ( !isset( $_SESSION['count'] ) )
	$_SESSION['count'] = 1; else $_SESSION['count']++;
?>




<?php require_once("include/db_connect.php"); ?>
<html>
<head><title>Displaying the book database table using PHP</title>
<link rel="stylesheet" type="text/css" href="Css/style.css">
</head>
<body>
<h1>Book Depository Inventory</h1>

<?php




$db_link = db_connect("project");



$fields = mysql_list_fields("project", "books");
$num_columns = mysql_num_fields($fields);


$query = "SELECT * FROM books";
$result = mysql_query($query) or die("SQL query failed");



echo '<table border="1">';



echo "<tr>";
for ($i = 0; $i < $num_columns; $i++)
{
   echo "<th>", mysql_field_name($fields, $i), "</th>";


}

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
    	echo "<td><a href='detailbook.php? isbn=".$row['isbn']."'><img src='images/".$row['image']."'></a></td>";




    	echo "</tr>";








}
echo "</table>";





mysql_free_result($result);
mysql_close($db_link);
?>



</body>


</html>