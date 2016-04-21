<?php require_once("inc/db_connect.php"); ?>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
		<title>Displaying the book database table using PHP</title>
			<style type="text/css">
				.error { color: #ff0000 }
			</style>
</head>
<body>

<h1>Displaying the book database table using PHP</h1>

<?php



// Connect to server and select a database

$db_link = db_connect("web_db");

// Retrieve table properties

$fields = mysql_list_fields("web_db", "customers");
$num_columns = mysql_num_fields($fields);

// Make a simple database query to select all columns and rows

$query = "SELECT * FROM customers";
$result = mysql_query($query) or die("SQL query failed");

// Display results as an HTML table. Note how mysql_field name
// uses the $fields object to extract the column names

echo '<table border="1">';

// Display the column names

echo "<tr>";
for ($i = 0; $i < $num_columns; $i++)
{
   echo "<th>", mysql_field_name($fields, $i), "</th>";
}
echo "</tr>";

// Loop over the rows of the table.
// $row contains  the information for each row

while ($row = mysql_fetch_assoc($result))
{

   // Now loop through the entries in each row

   echo "<tr>";
   foreach ($row as $col_value)
   {
      echo "<td>$col_value</td>";
   }
   echo "</tr>";
}
echo "</table>";

// Free the resources and close the connection

mysql_free_result($result);
mysql_close($db_link);
?>
</body>
</html>
