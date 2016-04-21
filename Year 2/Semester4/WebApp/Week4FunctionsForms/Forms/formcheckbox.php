<?php // Using a group of checkboxes

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
// Note how a checkbox group is specified in HTML:
// A single name is used for each group and [] is appended
// to indicate that the group is an array
function display_form_page()
{
   $self = $_SERVER['PHP_SELF'];
?>
<html>
<head>
<title>Forms, version 5 (checkboxes)</title>
<link rel="stylesheet" type="text/css" href="input.css"/>
</head>
<body>
<h1>Forms, version 5 (checkboxes)</h1>
<form action="<?php echo $self ?>" method="POST">
<p>First  name: <input class="input" type="text" name="firstname"></p>
<p>Last name: <input class="input" type="text" name="lastname"></p>
<p>Which wines do you like?
Shiraz <input type="checkbox" name="wines[]" value="shiraz">
Merlot <input type="checkbox" name="wines[]" value="merlot">
Chianti <input type="checkbox" name="wines[]" value="chianti">
</p>
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
   // $wines is an indexed array that is empty if no wines were checked
   // size of $wines is the number of wines checked (0,1,2,3)
   $wines = isset($_REQUEST['wines']) ? $_REQUEST['wines'] : array();
?>
   <html><head><title>Form Results</title></head><body>
   <h1>Form Results</h1>
   <?php
      echo "Hello $first_name $last_name<br/>\n";
      if (! empty($wines) )
      {  echo "Wines selected were ";
         foreach ($wines as $wine)
         {  echo "$wine ";
         }
      }
      else
         echo "No wines were selected";
   ?>
</body>
</html>
<?php
} // end display_output_page
?>

