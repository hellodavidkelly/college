<?php
//
// Program asks the user to enter 2 pieces of data - firstname and email address
// It accepts the input and searches a database for matching records
// It displays the matching records in a table, if they exist
// Otherwise, it displays an error message

// This program could be modified to ask a user to enter their username & password
// and search a user table to see if they were registered

require_once("include/db_connect.php");
?>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
		<title>Search the customer table</title>
			<link rel="stylesheet" type="text/css" href="Css/style.css">
</head>
<body>

<h1>Search the Books</h1>


<?php

// Connect to server and select a database --- Call the function db_connect() in db_connect(External File)

    $db_link = db_connect("project");
    $self = $_SERVER['PHP_SELF'];

		$isbn = trim(isset($_REQUEST['isbn'])) ? $_REQUEST['isbn'] : '';

	    $author = trim(isset($_REQUEST['author'])) ? $_REQUEST['author'] : '';
	    $price = trim(isset($_REQUEST['price'])) ? $_REQUEST['price'] : '';
	    $image = trim(isset($_REQUEST['image'])) ? $_REQUEST['image'] : '';

		$query = "SELECT * FROM books ORDER BY rand() limit 3";

		// echo $query. "<p>";

		$result = mysql_query($query);



// If a match exists (my_sql_num rows function > 0,
	if (mysql_num_rows($result) > 0)
		{
		echo "<table align = 'left' border = '1' cellpadding = '13'>";

// Fetch and print all the records in HTML table format, if records exist

		while ($row = mysql_fetch_assoc($result))
			{
			echo "<tr>";
   			foreach ($row as $col_value)
   				{
      			echo "<td>$col_value</td>";
  		 		}
   			echo "</tr>";
			}
	  echo "</table>";
		}

		mysql_close();


?>
</body>
</html>