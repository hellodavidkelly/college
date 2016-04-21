<?php
require_once("../include/db_connect.php");
?>

<head>
<link rel="stylesheet" type="text/css" href="../css/admin_style.css">
</head>
<body>

<?php

	$db_link = db_connect("project");
	$self = $_SERVER['PHP_SELF'];
	
	if (isset($_POST['Submit']))
	{
		$username = trim(isset($_REQUEST['username'])) ? $_REQUEST['username'] : '';
		$password = trim(isset($_REQUEST['password'])) ? $_REQUEST['password'] : '';

		$query = "SELECT * FROM users WHERE username = '$username'"." AND password = '$password'";

		$result = mysql_query($query);

		if (mysql_num_rows($result) > 0)
		{
			print "<script>";
			print " self.location='admin_home.php';"; 
			print "</script>";
			echo "You Are Now Logged In $username";
		}

		else
		{
			echo 'You Are Not Logged In';
		}
		mysql_close();
	}
	
	else
	{
?>
		<div id = "login">
			<form action= "<?php echo $self ?>"method="post" >
			<label>Please enter username and password</label>
			<label>UserName:</label><input name = "username" type="text">
			<label>Password:</label><input  name = "password" type="password">
			<input type="submit" name="Submit" value="Submit">
		</div>
		</form>

<?php
	}
?>
