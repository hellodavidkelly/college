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
    	echo "<td><a href='http://www.google.ie/'><img src='images/".$row['image']."'></a></td>";
		echo '<form action = "formscript.php" method = "post">
		             <td><input type = "text" value=1 style="width: 30px;" name = "value"/></td>
		          <td><input type = "submit" name = "button"value = "Add"></td>
		        </form>
    ';



    	echo "</tr>";








}
echo "</table>";





mysql_free_result($result);
mysql_close($db_link);
?>



</body>


</html>