<?php



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

function display_form_page($error)
{
   $self = $_SERVER['PHP_SELF'];
   $first_name = isset($_REQUEST['firstname']) ? $_REQUEST['firstname'] : '';
   $last_name = isset($_REQUEST['lastname']) ? $_REQUEST['lastname'] : '';
    $sex = isset($_REQUEST['sex']) ? $_REQUEST['sex'] : '';
    $colour = isset($_REQUEST['colour']) ? $_REQUEST['colour'] : '';
     $food = isset($_REQUEST['food']) ? $_REQUEST['food'] : '';
     $age = isset($_REQUEST['age']) ? $_REQUEST['age'] : '';


?>
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css"/>
<title>Stick Input Form</title>
<style type="text/css">
  .error { color: #ff0000 }
</style>
</head>
<body>
<h1>Forms, Version 4</h1>


<?php
if ($error)
{
   echo "<p>$error</p>\n";
}
?>

<form action="<?php echo $self ?>" method="POST">
<p>First  name: <input class="input" type="text" name="firstname"
   value="<?php echo $first_name?>"></p>
<p>Last name: <input class="input" type="text" name="lastname"
   value="<?php echo $last_name?>"></p>


<p>Age: <input class="input" type="text" name="age"
   value="<?php echo $age?>"></p>


Man<input type="radio" name="sex" value="man" <?php check($sex,"man")?>>
Woman<input type="radio" name="sex" value="woman" <?php check($sex,"woman")?>>


<br>
<br>
<fieldset>
<label for="colour">Select Favourite Colour:</label>

<select name="colour">
   <option <?php check($colour,"Red")?>>Red</option>
   <option <?php check($colour,"Black")?>>Black</option>
   <option <?php check($colour,"Yellow")?>>Yellow</option>
   <option <?php check($colour,"Greed")?>>Green</option>
</select>


</fieldset>


<fieldset>


<label for="food[]">Choose Your Food :</label>

Beans <input type="checkbox" name="food[]" value="beans" <?php checkFood($food,"beans")?>>
Chips <input type="checkbox" name="food[]" value="chips" <?php checkFood($food,"chips")?>>
Pizza <input type="checkbox" name="food[]" value="pizza" <?php checkFood($food,"pizza")?>>


</fieldset>

<div id = "buttons">

	<input type = "submit" name = "button"value = "Submit">
	<input type = "reset" value = "Reset">

</div>


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
// If $val is in the $wines array then check this checkbox
function checkFood($food, $val)
{
   if (is_array($food) and in_array($val, $food))
   {
      echo 'checked = "checked"';
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
      $sex = isset($_REQUEST['sex']) ? $_REQUEST['sex'] : '';
       $colour = isset($_REQUEST['colour']) ? $_REQUEST['colour'] : '';
        $food = isset($_REQUEST['food']) ? $_REQUEST['food'] : '';
   $age = isset($_REQUEST['age']) ? $_REQUEST['age'] : '';

   $error = '';



   $reg_exp = '/^[a-zA-Z\-\']+$/';

   if (! preg_match($reg_exp, $first_name))
   {
      $error .= "<span class=\"error\">First name is invalid (letters, hyphens, ', only)</span><br>";
   }
   if (! preg_match($reg_exp, $last_name))
   {
       $error .= "<span class=\"error\">Last name is invalid (letters, hyphens, ', only)</span><br>";
   }

    if (strlen($sex) == 0)
            {
               $error .=
               "<span class=\"error\">Specify Gender</span><br>";
   }
      if (strlen($colour) == 0)
        {
           $error .=
           "<span class=\"error\">Select a Colour</span><br>";
   }

   if (! is_array($food))
      {
       $error .=
           "<span class=\"error\">Select a Food</span><br>";

   }

    if (!is_numeric($age))
   	 	{
   		$error .="<span class=\"error\">Select an age</span><br>";


		}



   return $error;
}
?>


<?php
function display_output_page()
{
   $first_name = trim($_REQUEST['firstname']);
   $last_name = trim($_REQUEST['lastname']);
     $sex = isset($_REQUEST['sex']) ? $_REQUEST['sex'] : '';
       $colour = isset($_REQUEST['colour']) ? $_REQUEST['colour'] : '';
        $food = isset($_REQUEST['food']) ? $_REQUEST['food'] : '';
 $age = isset($_REQUEST['age']) ? $_REQUEST['age'] : '';

?>
   <html>
   <head><title>Form Results</title></head>
   <body>
   <h1>Form Results</h1>
   <?php echo "Hello $first_name $last_name<br/>\n";
 	  echo "Gender:$sex <br/>\n";
	 echo "Colour:$colour <br/>\n";
echo "Age:$age<br/>\n";
	 if (is_array($food))
	        {
	           echo "Foods are: ";
	           foreach ($food as $wine)
	           {
	              echo $wine, " ";
	           }
      }
   ?>
   </body>
   </html>
<?php
}
?>

