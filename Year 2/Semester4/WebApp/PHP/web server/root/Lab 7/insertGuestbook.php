<?php require_once("db_connect.php");
if (isset($_REQUEST['button'])) // submit was clicked
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
function validate_form()
{
$name = trim($_REQUEST['name']);
$email = trim($_REQUEST['email']);
$comments = trim($_REQUEST['comments']);
$error = '';
$reg_exp = '/^[a-zA-Z]+$/';
$regEmail = "#[a-z0-9_\+-]+(\.[a-z0-9_\+-]+)*@[a-z0-9-]+(\.[a-z0-9-]+)*\.([a-z]{2,4})$#";

if (! preg_match($reg_exp, $name))
{

$error .="<span class=\"error\">Enter name correctly </span><br>";
}

if (! preg_match($regEmail,$email))
{

$error .="<span class=\"error\">Enter email Correcly </span><br>";
}

if( $comments == null )
{
    $error .="<span class=\"error\">Enter Comments Propery </span><br>";
}



return $error;
}
?>
<?php
function display_form_page($error)
{
$self = $_SERVER['PHP_SELF'];
$name = isset($_REQUEST['name']) ? $_REQUEST['name'] : '';
$email = isset($_REQUEST['email']) ? $_REQUEST['email'] : '';
$comments = isset($_REQUEST['comments']) ? $_REQUEST['comments'] : '';
?>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Guestbook</title>
<style>
<link rel="stylesheet" type="text/css" href="style.css">
</style>
<body>
<?php




if ($error)
{
echo "<p class = 'error'>$error</p>";
}
?>

<form action="<?php echo $self ?>" method="POST">

<link rel="stylesheet" type="text/css" href="style.css">

<h1> The Guest Book </h1>
<h2> Please complete the following form </h2>

Name<input type ="text"  value="<?php echo $name?>" name = "name"/>
<br>
Email<input type = "text" value="<?php echo $email?>" name = "email"/>
<br>
<br>
<br>


Comments <textarea name="comments" cols="40" rows="4">

<?php if(isset($_POST['comments'])) { echo $_POST['comments']; } ?></textarea>
<br>
<input type="submit" name="button" value="Sign In">
<input type="reset" value="Start Again">
</form>
</body>
</html>
<?php
}
?>
<?php
function display_output_page()
{


 $name = trim($_REQUEST['name']);
 $email = isset($_REQUEST['email']) ? $_REQUEST['email'] : '';
 $comments = isset($_REQUEST['comments']) ? $_REQUEST['comments'] : '';


$db_link = db_connect("web_db");
$sql = "INSERT INTO guestbook (name, email, comments, time)
VALUES ('$name','$email','$comments', now())";
$result = mysql_query($sql) or die ("<br> Could not execute SQL query");
?>
<html>
<head><title>Form Results</title></head>
<body>
<h1>Form Results</h1>
<?php
// If the data has been inserted correctly, print out the following message
if($result)
{
echo "<h3>Thank you ". $name . ". Your entry has been saved.</h3>";
echo "<h3><a href = 'guestbookView.php'> View My Guestbook</a></h3>";
}
}
?>
</body>
</html>