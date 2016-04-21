<?php
//
// Program asks the user to enter 2 pieces of data - firstname and email address
// It accepts the input and searches a database for matching records
// It displays the matching records in a table, if they exist
// Otherwise, it displays an error message

// This program could be modified to ask a user to enter their username & password
// and search a user table to see if they were registered

require_once("inc/db_connect.php");
?>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
		<title>Search the customer table</title>
			<style type="text/css">
				.error { color: #ff0000 }
			</style>
</head>
<body>

<h1>Search the customer table using PHP</h1>


<?php

// Connect to server and select a database --- Call the function db_connect() in db_connect(External File)

    $db_link = db_connect("web_db");
    $self = $_SERVER['PHP_SELF'];
	if (isset($_POST['Submit']))
	{
		$first = trim(isset($_REQUEST['first'])) ? $_REQUEST['first'] : '';
	    $email = trim(isset($_REQUEST['email'])) ? $_REQUEST['email'] : '';

		$query = "SELECT * FROM customers WHERE firstname = '$first'"
		         ." AND email = '$email'";
		// echo $query. "<p>";

		$result = mysql_query($query);



// If a match exists (my_sql_num rows function > 0,
	if (mysql_num_rows($result) > 0)
		{
		echo "<table align = 'left' border = '1' cellpadding = '3'>";

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
// Else -- State there are no records

		else
		{
			echo 'No matching record found for the details entered';
		}
		mysql_close();
	}
else // if have not clicked on submit button
	{
?>
Please enter an email address

<form action= "<?php echo $self ?>"method="post" >
First Name :	<input name = "first" type="text"><br>
Email Address: <input  name = "email" type="text"><br>
<input type="submit" name="Submit" value="Submit">

</form>

<?php
	}
?>
