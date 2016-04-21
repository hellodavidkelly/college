<?php


if (isset($_REQUEST["button"]))
{

 $self =  $_SERVER['PHP_SELF'];
 if ((empty($_REQUEST["username"])) || (empty($_REQUEST["dish"]))|| (empty($_REQUEST["color"])))
	{
	header("Location:$self");
	exit;
	}

echo "<img src='foodbanner.jpg' width='368' height='54'>";
$username = $_REQUEST['username'];
$color =    $_REQUEST['color'];
$dish =     $_REQUEST['dish'];
echo  "<br/>Thanks for your selection $username <hr>" ;
$msg = "You really enjoy $dish <br>";
$msg .= "- especially with a nice $color wine";
echo $msg;
echo "<hr>";
echo '<a href= " '. $self . ' " > Back to Form  </a>';
}

else
{
?>


<html>
<head>
<title>Your Favorites</title>
</head><body>
  <form action= "<?php echo $_SERVER['PHP_SELF']; ?>" method="post">
   <strong>Please enter your first name:</strong>
   <input type="text" size="45" name="username">  <br>
   <strong>Please select your favorite color wine:</strong> <br>
   <input type="radio" name="color" value="white">  White
   <input type="radio" name="color" value="rosé">   Rosé
   <input type="radio" name="color" value="red">    Red <br>
   <b>Please enter your favorite dish:</b>
   <input type="text" size="45" name="dish"><br><br>
   <input type="submit" name = "button" value="Submit">
   <input type="reset">
 </form>
 </body>
 </html>


 <?php
 }
?>
