<?php
// -----------------------------------------------------------------------------
// This version generates the form and prcessess the form.
// If the submit button is undefined then the form is displayed
// else the form is processed.
// Error checking is also performed on the names
// The form is also sticky: previous values are shown for error correction
// -----------------------------------------------------------------------------

if (isset($_REQUEST['sbutton'])) // submit was clicked
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
   $email = isset($_REQUEST['email']) ? $_REQUEST['email'] : '';
   $phone = isset($_REQUEST['phone']) ? $_REQUEST['phone'] : '';
   $address = isset($_REQUEST['address']) ? $_REQUEST['address'] : '';   
   $breed = isset($_REQUEST['breed']) ? $_REQUEST['breed'] : '';
   $performance = isset($_REQUEST['performance']) ? $_REQUEST['performance'] : '';
   $horse_name = isset($_REQUEST['horsename']) ? $_REQUEST['horsename'] : '';
   $color = isset($_REQUEST['color']) ? $_REQUEST['color'] : '';
   $age = isset($_REQUEST['age']) ? $_REQUEST['age'] : '';
   $height = isset($_REQUEST['height']) ? $_REQUEST['height'] : '';
   $record = isset($_REQUEST['record']) ? $_REQUEST['record'] : '';
   $details = isset($_REQUEST['details']) ? $_REQUEST['details'] : '';
   $file =  isset($_REQUEST['file']) ? $_REQUEST['file'] : '';


?>
<html>
<head>
<link href="assignment1Style.css" rel="stylesheet" type="text/css">
<title>Forms, version 4</title>
<style type="text/css">
  .error { color: #ff0000 }
</style>
</head>
<body>

<?php
if ($error)
{
   echo "<p>$error</p>\n";
}
?>

<form action="<?php echo $self ?>" method="post">
<div id=head><h1 id="horseTitle">Horse Sale - Entry Form</h1><img src='images/horse.png' alt='horsehead'></div>
	<fieldset><legend>Owner Details</legend>
		<label>First Name:</label> <input class="input" type="text" name="firstname" value="<?php echo $first_name?>">
		<label>Last Name:</label> <input class="input" type="text" name="lastname" value="<?php echo $last_name?>">
		<br>
		<label>Email Address:</label> <input class="input" type="email" name="email" value="<?php echo $email?>">
		<label>Phone Number:</label> <input class="input" type="tel" name="phone" value="<?php echo $phone?>">(e.g 123-1234567)
		<br>
		<label>Address:</label> <input class="input"  size="40" type="text" name="address" value="<?php echo $address?>">
	</fieldset>

	<fieldset><legend>Tick selection</legend>
		<input class="input" type="radio" name="breed" value="Gelding" <?php check($breed,"Gelding")?>><span class="radio">Gelding</span>
		<input class="input" type="radio" name="breed" value="Colt" <?php check($breed,"Colt")?>><span class="radio">Colt</span>
		<input class="input" type="radio" name="breed" value="Filly" <?php check($breed,"Filly")?>><span class="radio">Filly</span>
		<input class="input" type="radio" name="breed" value="Mare" <?php check($breed,"Mare")?>><span class="radio">Mare</span>
	</fieldset>	

	<fieldset><legend>Performance - check all that apply</legend> 	
		<input class="input" type="checkbox" name="performance[]" value="broken" <?php check2($performance,"broken")?>><span class="check">Broken and Riding</span>
		<input class="input" type="checkbox" name="performance[]" value="clubbed" <?php check2($performance,"clubbed")?>><span class="check">Pony Clubbed</span>
		<input class="input" type="checkbox" name="performance[]" value="lunging" <?php check2($performance,"lunging")?>><span class="check">Lunging</span>
		<input class="input" type="checkbox" name="performance[]" value="unbroken" <?php check2($performance,"unbroken")?>><span class="check">Unbroken</span>
	</fieldset>

	<fieldset><legend>Details of horse</legend>
	<table>
		<tr>
		<td>
		<span class="details">Name:</span> <input class="details" type="text" name="horsename" value="<?php echo $horse_name?>">
		</td>
		<td>
		<span class="details">Color:</span> 	
				<select class="details" name="color">
				<option <?php check3($color,"empty")?>></option>
				<option <?php check3($color,"Bay")?>>Bay</option>
				<option <?php check3($color,"Chestnut")?>>Chestnut</option>			
				<option <?php check3($color,"Piebald")?>>Piebald</option>			
				<option <?php check3($color,"White")?>>White</option>			
				</select>
		</td>
		<td>
		<span class="details">Age:</span> <input class="details" size="5" type="number" name="age" value="<?php echo $age?>">
		</td>
		<td>
		<span class="details">Height:</span> <input class="details" size="5" type="number" name="height" value="<?php echo $height?>">
		</td>
		<td>
		<span class="details">Breeding Record?</span>
		<br> 
		<span class="option">No</span><input type="radio" name="record" value="No" <?php check4($record,"No")?>>
		<span class="option">Yes</span><input type="radio" name="record" value="Yes" <?php check4($record,"Yes")?>>
		</td>
		</tr>
	</table>
	</fieldset>

	<fieldset><legend>Additional information</legend>
	<table>
		<td>
		<span class="info">Additional performance details:</span>
		<textarea class="info" rows="4" cols="50"
		name="details" value="<?php echo $details?>">
		<?php
			if(isset($details))
			{
			echo "$details";
			}
		?>
		</textarea>
		</td>
		<td>
		<span class="info">Upload images or video (optional)</span>
		<input  class="info"  type="file" value="Browse" name="file" id="browse">
		</td>
	</table>
	</fieldset>
	<br> 

	<div id="buttons">
	<input type="submit" name="sbutton" value="Enter Details">
	<input type="reset" name="rbutton" value="Reset">
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
// If $val is in the $food array then check this checkbox
function check2($performance, $val)
{
   if (is_array($performance) and in_array($val, $performance))
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
// If $group has the value $val then check this radio button
function check4($group, $val)
{
   if ($group === $val)
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
   $email = trim($_REQUEST['email']);
   $phone = trim($_REQUEST['phone']);
   $address = trim($_REQUEST['address']);
   $breed = trim($_REQUEST['breed']);
   $performance = isset($_REQUEST['performance']) ? $_REQUEST['performance'] : '';
   $horse_name = isset($_REQUEST['horsename']) ? $_REQUEST['horsename'] : '';
   $color = isset($_REQUEST['color']) ? $_REQUEST['color'] : '';
   $age = trim($_REQUEST['age']);
   $height = trim($_REQUEST['height']);
   $record = trim($_REQUEST['record']);
   $details = trim($_REQUEST['details']);



   $error = '';

   // Our definition of a valid name is one containing letters, hyphens,
   // and apostrophe's

   $reg_exp = '/^[a-zA-Z\-\']+$/';
   $phone_exp = '/^[0-9]{3}\-[0-9]{7}$/';
   $num_exp = '/^[0-9]+$/';
   $varcount = 0;

   if (! preg_match($reg_exp, $first_name))
   {
      	$varcount++;
      	$error .= "<span class=\"error\">$varcount. First name is invalid (letters, hyphens, ', only)</span><br>";     	
   }
   if (! preg_match($reg_exp, $last_name))
   {
      	$varcount++;
		$error .= "<span class=\"error\">$varcount. Last name is invalid (letters, hyphens, ', only)</span><br>";
   }
   if (! filter_var($email, FILTER_VALIDATE_EMAIL))
   {
      	$varcount++;
       	$error .= "<span class=\"error\">$varcount. Email entry is invalid (Entry must be a valid email)</span><br>";
   }
   if (! preg_match($phone_exp, $phone))
   {
      	$varcount++;
       	$error .= "<span class=\"error\">$varcount. Phone Number entry is invalid (Entry must be a valid Phone Number)</span><br>";
   } 
   if (strlen($address) == 0)
   {
      	$varcount++;
       	$error .= "<span class=\"error\">$varcount. Address entry is empty (Please enter a valid Address)</span><br>";
   } 
   if (strlen($breed) == 0)
   {
      	$varcount++;
        $error .= "<span class=\"error\">$varcount. Select a horse type</span><br>";
   }
   if (! is_array($performance))
   {
      	$varcount++;
        $error .= "<span class=\"error\">$varcount. You must select at least one performance type</span></br>";
   }
   if (strlen($color) == 0)
   {
      	$varcount++;
        $error .=
      "<span class=\"error\">$varcount. Select a color</span><br>";
   }
   if (! preg_match($reg_exp, $horse_name))
   {
      	$varcount++;
      	$error .= "<span class=\"error\">$varcount. Horse name is invalid (letters, hyphens, ', only)</span><br>";
   }
   if (! preg_match($num_exp, $age))
   {
      	$varcount++;
       	$error .= "<span class=\"error\">$varcount. Age entry is invalid (Entry must be Integer)</span><br>";
   }   
   if (! preg_match($num_exp, $height))
   {
      	$varcount++;
       	$error .= "<span class=\"error\">$varcount. Height entry is invalid (Entry must be Integer)</span><br>";
   }
   if (strlen($record) == 0)
   {
      	$varcount++;
        $error .=
      "<span class=\"error\">$varcount. Select a record history</span><br>";
   }
   if (strlen($details) == 0)
   {
      	$varcount++;
       	$error .= "<span class=\"error\">$varcount. Enter additional performance details</span><br>";
   }
   return $error;
}
?>


<?php
function display_output_page()
{
   $first_name = trim($_REQUEST['firstname']);
   $last_name = trim($_REQUEST['lastname']);
   $email = trim($_REQUEST['email']);
   $phone = trim($_REQUEST['phone']);
   $address = trim($_REQUEST['address']);
   $breed = trim($_REQUEST['breed']);
   $performance = isset($_REQUEST['performance']) ? $_REQUEST['performance'] : '';
   $color = trim($_REQUEST['color']);
   $horse_name = trim($_REQUEST['horsename']);
   $age = trim($_REQUEST['age']);
   $height = trim($_REQUEST['height']);
   $record = trim($_REQUEST['record']);
   $details = trim($_REQUEST['details']);
   $file = trim($_REQUEST['file']);


?>
   <html>
   <head><title>Form Results</title>
   <link href="style.css" rel="stylesheet" type="text/css">
   </head>
   <body>
   <h1>Form Entries Submitted</h1>
   <?php
   		echo "Please review the details you entered on ". date("l F d, y H:i:s")
   		."<br/>\n";
   ?>
   <form name="resultsForm" method="post" action="mailto:<?php echo $email ?>">
   
   <textarea rows="25" cols="50">
      <?php 
   		echo "Name:\t\t\t\t$first_name $last_name\n"; 
    	echo "Address:\t\t\t\t$address\n";
  		echo "Email:\t\t\t\t$email\n";
   		echo "Phone:\t\t\t\t$phone\n";
   		echo "Name of horse: \t\t$horse_name\n";
   		echo "Breeding record:\t\t$record\n";
   		echo "Type of horse:\t\t\t$breed\n";
   		echo "Color:\t\t\t\t$color\n";
   		if (is_array($performance))
      	{
        	 echo "$horse_name performance details are:";
         	 foreach ($performance as $performance)
         	{
            	echo "\n\t\t\t\t\t$performance";
         	}
      	}
   		echo "\n";      	
   		echo "Age of horse:\t\t\t$age\n";
   		echo "Height of horse:\t\t$height\n";
   		echo "Comment:\t\t\t\t$details\n";
   		echo "File:\t\t\t\t\t$file"
   		
   ?>
   </textarea>
   <br>

   <input type="submit" name="email" value="send thru email" >
   <a href="?php echo $self ?">Return</a>
   </form>
   
   </body>
   </html>
<?php
}
?>

