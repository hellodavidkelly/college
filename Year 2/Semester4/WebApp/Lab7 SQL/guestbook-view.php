<?php
require_once("include/db_connect.php");
?>

<!DOCTYPE html> <html lang="en"> 
<head>
	<meta charset="utf-8"> <title>View Guestbook</title>
		<style>
		@import "style/style.css";
		</style> 
</head>
<body>
	<h3>Entries in Guestbook...</h3> 
	<?php
	$db_link = db_connect("web_db");
	// create the SQL query
	$query = "select * from guestbook order by time desc"; // execute the query
	$result = @mysql_query( $query )
	or die( "Could not execute SQL query" ); // loop through all records & display in a HTML table
	// display the email address as a hyperlink 
	while ($row = mysql_fetch_array( $result) ) {
	?>
	<table>
		<tr>
			<td id="name"><strong>Name:</strong> 
					<?php echo $row["name"]; ?> 
			</td>
			<td><strong>Email:</strong>
					<a href="mailto:<?php echo $row["email"]; ?>"> 
					<?php echo $row["email"]; ?>
					</a>
			</td> 
		<tr>
			<td colspan="2">
			<strong> Date: </strong> \
			<?php echo $row["time"]; ?> 
			</td>

		</tr>
		<tr>
			<td colspan="3"> <strong>Comments:</strong>
				<?php echo $row["comments"]; ?> 
			</td>
		</tr> 
	</table>
<br> <?php
}
?> 
</body> 
</html>