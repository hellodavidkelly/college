<?php

require_once("include/db_connect.php");

if (isset($_REQUEST['sbutton'])) // submit was clicked
{
   $error = validate_form();
   if($error)
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
function validate_form()
{
	$error = '';
	$name = trim($_REQUEST['name']);
	$email = trim($_REQUEST['email']);
	$comments = trim($_REQUEST['comments']);
    $reg_exp = '/^[a-zA-Z\-\ \']+$/';
	
	if(! preg_match($reg_exp, $name))
	{
		$error .= "Please complete the name correctly <br>";
	}

	if (! filter_var($email, FILTER_VALIDATE_EMAIL))
   	{
		$error .= "Please complete the email correctly <br>";
   	}
	if (strlen($comments) == 0)
   {
       	$error .= "Enter additional comments<br>";
   }
   	
   	return $error;
}
?>

<?php
// Display the form page and the error message
// An empty error message indicates valid data
function display_form_page($error)
{
   $self = $_SERVER['PHP_SELF'];
   $name = isset($_REQUEST['name']) ? $_REQUEST['name'] : '';
   $email = isset($_REQUEST['email']) ? $_REQUEST['email'] : '';
   $comments = isset($_REQUEST['comments']) ? $_REQUEST['comments'] : '';
?>

<!DOCTYPE html>
<hmtl lang="en">
<head>
	<meta charset="utf-8">
	<title>Guestbook</title>
	<style>
	@import "style/style.css";
	</style>
</head>

<body>
	<?php
	if($error)
	{
		echo"<p class='error'>$error</p>";
	}
	?>

	<form action="<?php echo $self ?>" method="post">
	<h1> The Guest Book</h1>
	<h2> Please complete the following form</h2>
	<label>Name:</label><input type="text" name="name" size="40" value="<?php echo $name?>"><br>
	<label>Email:</label><input type="text" name="email" size="40" value="<?php echo $email?>"><br>
	<label>Comments:</label><textarea name="comments" cols="40" rows="4" value="<?php echo $comments?>"><?php
			if(isset($comments))
			{
			echo "$comments";
			}
		?>
	</textarea><br>
	<div id="buttons">
	<input type="submit" name="sbutton" value="Sign In">
	<input type="reset" name="rbutton" value="Reset">
	</div>
	</form>

</body>
</html>
<?php
}
?>

<?php
function display_output_page()
{
   $name = isset($_REQUEST['name']) ? $_REQUEST['name'] : '';
   $email = isset($_REQUEST['email']) ? $_REQUEST['email'] : '';
   $comments = isset($_REQUEST['comments']) ? $_REQUEST['comments'] : '';
   
   $db_link = db_connect("web_db");
   $sql = "INSERT INTO guestbook(name,email,comments,time)
   							VALUES('$name','$email','$comments',now())";
   $result = mysql_query($sql) or die ("<br> Could not execute SQL query");
?>
   <html>
   <head><title>Form Results</title>
   <link href="style.css" rel="stylesheet" type="text/css">
   </head>
   <body>
   <h1>Form Entries Submitted</h1>
	
<?php
	if($result)
	{
		echo"<h3>Thank you". $name .".Your entry has been saved</h3>";
		echo"<h3><a href='guestbook-view.php'>View My Guestbook</h3>";
	}
}
?>
	</body>
	</html>