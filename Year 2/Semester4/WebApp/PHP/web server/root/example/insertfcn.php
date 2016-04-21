<?php
  require_once("inc/db_connect.php");
?>


<?php

////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//   The program allows a user to insert a new record in the customer table, using a FORM
//
//   The program performs limited validation of user input & ouputs error messages if data is incorrect
//
//   If the data entered is correct, the data is entered into the table in the database
//
//   Logic
//   If the submit button is pressed
//			Check each field is valid
//      		If there are errors
//         			 Print an error messages and a provide a LINK back to the original form
//      		If there are no error
//					 Print display a message with the data being entered in the table
//			 		 & Update the customer
//    Else if the submit button has not been pressed
//			Display the blank form to allow users enter data on a new record
//
//
///////////////////////////////////////////////////////////////////////////////////////////////////////


// Connect to server and select a database --- Call the function db_connect() in db_connect(External File)

    $db_link = db_connect("web_db");

// Find the path of the current file & use it when calling the file if user must resubmit data

	$self = $_SERVER['PHP_SELF'];

// If the Submit button has been pressed -- Do limited validation of entries
// Check the first name, last name, email address are not blank
// Check weight entered is numberic & is a positive number greater than zero
// Print error messages -- if there are errors & display a link to return to the original form

// Set a flag to true if the user has an error

if (isset($_REQUEST['Submit'])) // submit was clicked
{
   $error = validate_form();
   if ($error)
   {
      display_form_page($error);
   }
   else
   {
      display_output_page();
   }
}
else // display form for first time
{
   display_form_page('');
}
?>

<?php
function display_form_page($error)
{
   $first = isset($_REQUEST['first']) ? $_REQUEST['first'] : '';
   $last = isset($_REQUEST['last']) ? $_REQUEST['last'] : '';
   $email = isset($_REQUEST['email']) ? $_REQUEST['email'] : '';
   $weight = isset($_REQUEST['weight']) ? $_REQUEST['weight'] : '';

   $self = $_SERVER['PHP_SELF'];

  ?>

 <!DOCTYPE html>
 <html lang="en">
 <head>
 	<meta charset="utf-8">
 		<title>Inserting into the customer table</title>
 		<style> @import "input.css"; </style>
 			<style type="text/css">
 				.error { color: #ff0000 }
 			</style>
 </head>
 <body>

<h1>Inserting a NEW CUSTOMER RECORD into a table using a FORM </h1>

<?php
if ($error)
{
   echo "<p>$error</p>";
}
?>


<form action= "<?php echo $self ?>" method="post">
	First Name <input name="first" type="text"><br>
	Last Name  <input name="last" type="text"><br>
	Email 	    <input name="email" type="text" ><br>
	Weight 		<input name="weight" type="text" ><br>
	<input type="submit" name="Submit" value="Submit" >
</form>
</body>
</html>
<?php
}
?>


<?php
function validate_form()
{
   $first =  $_REQUEST['first'];
   $last =  $_REQUEST['last'];
   $email =  $_REQUEST['email'];
   $weight =  $_REQUEST['weight'];

   $error = '';

   	if (empty($_REQUEST['first']))
   	{
   		$error .=
          "<span class= 'error'>You must enter your first name </span><br>";
   	}

   	if (empty($_REQUEST['last']))
   	{
   		$error .=
           "<span class= 'error'>You must enter your last name </span><br>";
   	}

   	if (empty($_REQUEST['email']))
   	{
   		$error .=
           "<span class= 'error'>You must enter your email address </span><br>";
   	}

   	if ((empty($_REQUEST['weight'])) || (!is_numeric($_REQUEST['weight'])))
   	{
   		$error .=
           "<span class= 'error'>You must enter a numeric weight. </span><br>";
   	}

   return $error;
}
?>


<?php
// -----------------------------------------------------------------------------
function display_output_page()
{
   $first =  $_REQUEST['first'];
   $last =  $_REQUEST['last'];
   $email =  $_REQUEST['email'];
   $weight =  $_REQUEST['weight'];

   // INSERT command enters a new row in the customers table

   		$query = "INSERT INTO customers(FirstName, LastName, Email, Weight) VALUES ('$first', '$last', '$email ', '$weight')";

           echo "<p>". $query;

   // Run the query

   		$result = mysql_query($query) or die("<br>Insertion failed");

   // If the query ran OK - Print a message
          if ($result)
           {
           echo "<p>Thank you ". $first . " ". $last . " for submitting your information <br>";
   		echo "<p>You are now registered in the database";
   		}
   		else
   		{
   		 $error .=
          "<span class= 'error'><br>You could not be registered due to a system error </span></br>";
   		 echo $error;
   		 }

   // Close the database connection
		mysql_close();

}
?>




