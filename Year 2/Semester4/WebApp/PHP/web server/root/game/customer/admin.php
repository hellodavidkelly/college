<?php
require_once("Include/db_connect.php");
?>

<head>
	<link rel="stylesheet" type="text/css" href="Css/admin_style.css">
</head>
<body>

<h1>Administration Login </h1>


<?php



    $db_link = db_connect("games");
    $self = $_SERVER['PHP_SELF'];
	if (isset($_POST['Submit']))
	{
		$username = trim(isset($_REQUEST['username'])) ? $_REQUEST['username'] : '';
	    $password = trim(isset($_REQUEST['password'])) ? $_REQUEST['password'] : '';

		$query = "SELECT * FROM users WHERE username = '$username'"
		         ." AND password = '$password'";
		

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
				$page = $_SERVER['PHP_SELF'];
				$sec = "2.0";
				header("Refresh: $sec;$page");
		}
		mysql_close();
	}
else
	{
?>
<div id = "login">


<form action= "<?php echo $self ?>"method="post" >
Please enter username and password
&nbsp;&nbsp;&nbsp;
UserName :	<input name = "username" type="text">&nbsp;
Password: <input  name = "password" type="text">&nbsp;
<input type="submit" name="Submit" value="Submit">
</div>
</form>

<?php
	}
?>
