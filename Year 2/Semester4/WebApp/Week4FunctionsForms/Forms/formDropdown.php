<?php // Using a drop down list

if (isset($_REQUEST['button'])) // submit was clicked
{
   display_output_page();
}
else // display form for first time
{
   display_form_page();
}
?>

<?php
function display_form_page()
{
   $self = $_SERVER['PHP_SELF'];
?>
<html>
<head>
<link rel="stylesheet" type="text/css" href="input.css"/>
<title>Forms, version 6 (drop down list)</title>
</head>
<body>
<h1>Forms, version 6 (drop down list)</h1>
<form action="<?php echo $self ?>" method="POST">
<p>First name: <input class="input" type="text" name="firstname"></p>
<p>Last name: <input class="input" type="text" name="lastname"></p>
<p>
Select your favourite wine from the list:
<select name="wine">
   <option selected="selected">Shiraz</option>
   <option>Merlot</option>
   <option>Chianti</option>
   <option>Other</option>
</select>
<p><input type="submit" name="button" value="Submit"></p>
</form>
</body>
</html>
<?php
}
?>


<?php
function display_output_page()
{
   $first_name = $_REQUEST['firstname'];
   $last_name = $_REQUEST['lastname'];
   $wine = $_REQUEST['wine'];
?>
   <html><head><title>Form Results</title></head><body>
   <h1>Form Results</h1>
   <?php
      echo "Hello $first_name $last_name<br/>\n";
      echo "Wine selected was $wine";
   ?>
</body></html>
<?php
} // end display_output_page
?>
