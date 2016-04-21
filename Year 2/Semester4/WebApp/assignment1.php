<?php
// -----------------------------------------------------------------------------
// This version generates the form and prcessess the form.
// If the submit button is undefined then the form is displayed
// else the form is processed.
// Error checking is also performed on the names
// The form is also sticky: previous values are shown for error correction
// -----------------------------------------------------------------------------

echo "<u>Forms with ERROR CHECKING & STICKY INPUT on TEXT BOXES </u> <p>";

if (isset($_REQUEST['button'])) // submit was clicked
{
   process_form();
}
else // display form for first time
{
   display_form_page('');
}
?>

<?php
// Display the form page and the error message
// An empty error message indicates valid data
function display_form_page($error)
{
   $self = $_SERVER['PHP_SELF'];
   $first_name = isset($_REQUEST['firstname']) ? $_REQUEST['firstname'] : '';
   $last_name = isset($_REQUEST['lastname']) ? $_REQUEST['lastname'] : '';
   $age = isset($_REQUEST['age']) ? $_REQUEST['age'] : '';
   $sex = isset($_REQUEST['sex']) ? $_REQUEST['sex'] : '';
   $food = isset($_REQUEST['food']) ? $_REQUEST['food'] : '';
   $color = isset($_REQUEST['color']) ? $_REQUEST['color'] : '';

?>
<html>
<head>
<link href="style.css" rel="stylesheet" type="text/css">
<title>Forms, version 4</title>
<style type="text/css">
  .error { color: #ff0000 }
</style>
</head>
<body>
<h1>Horse Sale - Entry Form</h1><img src='images/horse.jpg'>

<?php
if ($error)
{
   echo "<p>$error</p>\n";
}
?>

<form action="<?php echo $self ?>" method="POST">
<p>
	First  name: <input class="input" type="text" name="firstname" value="<?php echo $first_name?>">
</p>
<p>
	Last name: <input class="input" type="text" name="lastname" value="<?php echo $last_name?>">
</p>
<p>
	Age: <input class="input" type="number" name="age" value="<?php echo $age?>">
</p>
<p>
	Sex: 
	<input class="input" type="radio" name="sex" value="male" <?php check($sex,"male")?>>Male
	<input class="input" type="radio" name="sex" value="female" <?php check($sex,"female")?>>Female
	
<p>
	Food: 	
	<input class="input" type="checkbox" name="food[]" value="pizza" <?php check2($food,"pizza")?>>Pizza
	<input class="input" type="checkbox" name="food[]" value="burger" <?php check2($food,"burger")?>>Burger
	<input class="input" type="checkbox" name="food[]" value="fries" <?php check2($food,"fries")?>>Fries
</p>
<p>
	Color: 	<select class="input" name="color">
			<option <?php check3($color,"Red")?>>Red</option>
			<option <?php check3($color,"Blue")?>>Blue</option>			
			<option <?php check3($color,"Green")?>>Green</option>			
			<option <?php check3($color,"Orange")?>>Orange</option>			
			</select>
</p>
<br> 
<p><input type="submit" name="button" value="Submit Name"></p>
</form>

</body>
</html>
<?php
}
?>

<?php
// If $group has the value $val then check this radio button
function check($group, $val)
{
   if ($group === $val)
   {
      echo 'checked = "checked"';
   }
}
?>

<?php
// If $val is in the $food array then check this checkbox
function check2($food, $val)
{
   if (is_array($food) and in_array($val, $food))
   {
      echo 'checked = "checked"';
   }
}
?>

<?php
// If $group has the value $val then select this list item
function check3($group, $val)
{
   if ($group === $val)
   {
      echo 'selected = "selected"';
   }
}
?>

<?php
function process_form()
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
?>


<?php
// Return an error string that is empty if there were no errors.
// Otherwise it contains an error message.
function validate_form()
{
   $first_name = trim($_REQUEST['firstname']);
   $last_name = trim($_REQUEST['lastname']);
   $age = trim($_REQUEST['age']);
   $sex = trim($_REQUEST['sex']);
   $food = isset($_REQUEST['food']) ? $_REQUEST['food'] : '';
   $color = isset($_REQUEST['color']) ? $_REQUEST['color'] : '';

   $error = '';

   // Our definition of a valid name is one containing letters, hyphens,
   // and apostrophe's

   $reg_exp = '/^[a-zA-Z\-\']+$/';
   $num_exp = '/^[0-9]+$/';

   if (! preg_match($reg_exp, $first_name))
   {
      	$error .= "<span class=\"error\">First name is invalid (letters, hyphens, ', only)</span><br>";
   }
   if (! preg_match($reg_exp, $last_name))
   {
      	 $error .= "<span class=\"error\">Last name is invalid (letters, hyphens, ', only)</span><br>";
   }
   if (! preg_match($num_exp, $age))
   {
       	$error .= "<span class=\"error\">Age entry is invalid (Entry must be Integer)</span><br>";
   }
   if (strlen($sex) == 0)
   {
      $error .=
      "<span class=\"error\">Select a gender</span><br>";
   }
      if (! is_array($food))
   {
      $error .= "<span class=\"error\">You must select at least one food item</span></br>";
   }
      if (strlen($color) == 0)
   {
      $error .=
      "<span class=\"error\">Select a color</span><br>";
   }
   return $error;
}
?>


<?php
function display_output_page()
{
   $first_name = trim($_REQUEST['firstname']);
   $last_name = trim($_REQUEST['lastname']);
   $age = trim($_REQUEST['age']);
   $sex = trim($_REQUEST['sex']);
   $food = isset($_REQUEST['food']) ? $_REQUEST['food'] : '';
   $color = trim($_REQUEST['color']);
?>
   <html>
   <head><title>Form Results</title>
   <link href="style.css" rel="stylesheet" type="text/css">
   </head>
   <body>
   <h1>Form Results</h1>
   <?php 
   		echo "Hello $first_name $last_name<br/>\n"; 
   		echo "You are $age years old, correct?<br/>\n";
   		echo "You are $sex<br/>\n";
 		echo "<ul>";
   		if (is_array($food))
      	{
        	 echo "Favorite foods are ";
         	 foreach ($food as $food)
         	{
            	echo "<li>$food</li>";
         	}
      	}
      	echo "</ul>";
      	echo "</br>";
   		echo "You like the color $color<br/>\n";
   ?>
   </body>
   </html>
<?php
}
?>

