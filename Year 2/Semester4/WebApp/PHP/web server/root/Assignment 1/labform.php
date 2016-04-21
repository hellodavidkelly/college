<?php


	if (isset($_REQUEST['button']))
	{
  		 process_form();


	}
		else
			{
  				 display_form_page('');
			}
?>

<?php

		function display_form_page($error)
		{
 			 $self = $_SERVER['PHP_SELF'];
  			 $first_name = isset($_REQUEST['firstname']) ? $_REQUEST['firstname'] : '';
			 $last_name = isset($_REQUEST['surname']) ? $_REQUEST['surname'] : '';
   			 $breed = isset($_REQUEST['breed']) ? $_REQUEST['breed'] : '';
   			 $horsename = isset($_REQUEST['horsename']) ? $_REQUEST['horsename'] : '';
   			 $recorded = isset($_REQUEST['recorded']) ? $_REQUEST['recorded'] : '';
   			 $performance = isset($_REQUEST['performance']) ? $_REQUEST['performance'] : '';
  			 $colour = isset($_REQUEST['colour']) ? $_REQUEST['colour'] : '';
  			 $age = isset($_REQUEST['age']) ? $_REQUEST['age'] : '';
  			 $horse_height = isset($_REQUEST['height']) ? $_REQUEST['height'] : '';
  			 $phone = isset($_REQUEST['phone']) ? $_REQUEST['phone'] : '';
  			 $email = isset($_REQUEST['email']) ? $_REQUEST['email'] : '';
  			 $address = isset($_REQUEST['address']) ? $_REQUEST['address'] : '';
			 $additionalInfo = isset($_REQUEST['extrainfo']) ? $_REQUEST['extrainfo'] : '';
			 $fileName = isset($_REQUEST['myfile']) ? $_REQUEST['myfile'] : '';

?>

<?php
		if ($error)
		{
 		  echo "<p>$error</p>\n";
		}
?>

<form action="<?php echo $self ?>" method="POST">

<html>

<head>

<link rel="stylesheet" type="text/css" href="style.css">


<title>Entry Registrations</title>
<meta http-equiv="content-type" content="text/html;charset=utf-8"/>


</head>

<h1> Horse Sale - Entry Form</h1>

<body>


<form>

<fieldset>
<legend> Owner Details </legend>
<p>
<label>First  name: </label>
<input type ="text"  value="<?php echo $first_name?>" name = "firstname"/>
</p>
<p>
<label>Second  name: </label>
<input type = "text" value="<?php echo $last_name?>"  name = "surname"/>
</p>

<p>
<label>Email Address: </label>
<input type = "text" value="<?php echo $email?>" name = "email"/>
</p>
<p>
<label>Phone Number: </label>
<input type = "text" value="<?php echo $phone?>"  name = "phone"/><span>Eg: (123-4567899)</span>
</p>
<p>
<label>Address: </label>
<input type = "text" value="<?php echo $address?>" style="width: 300px;" name = "address"/>
</p>
				</fieldset>

<fieldset>

<legend> Tick Selection </legend>
<p>
<label>Breed: </label>
Gelding <input type="radio" name="breed" value="gelding" <?php checkBreed($breed,"gelding")?>>
Filly <input type="radio" name="breed" value="filly" <?php checkBreed($breed,"filly")?>>
Mare <input type="radio" name="breed" value="mare" <?php checkBreed($breed,"mare")?>>
Colt <input type="radio" name="breed" value="colt" <?php checkBreed($breed,"colt")?>>
</p>
</fieldset>



<fieldset>

<legend> Performance - Check All That Apply </legend>
<p>
<label>Performance: </label>
Broken <input type="checkbox" name="performance[]" value="Broken" <?php checkPerformance($performance,"broken")?>>
Clubbed <input type="checkbox" name="performance[]" value="clubbed" <?php checkPerformance($performance,"clubbed")?>>
Lunging <input type="checkbox" name="performance[]" value="lunging" <?php checkPerformance($performance,"lunging")?>>
Unbroken <input type="checkbox" name="performance[]" value="unbroken" <?php checkPerformance($performance,"unbroken")?>>
</p>
</fieldset>



	<fieldset>

		<legend> Details Of Horse </legend>
		<p>
		<label>Horse Name: </label>
		<input type ="text" value="<?php echo $horsename?>" name = "horsename"/>
</p>


		<p>
		<label>Horse Colour: </label>
		<select name="colour">
			<label>Horse Name: </label>
		   <option <?php check($colour,"")?>> </option>
		   <option <?php check($colour,"Bay")?>>Bay </option>
		   <option <?php check($colour,"Chestnut")?>>Chestnut</option>
		   <option <?php check($colour,"Piebald")?>>Piebald</option>
		   <option <?php check($colour,"White")?>>White</option>
		</select>
</p>

&nbsp;&nbsp;&nbsp;&nbsp;Age: <input type="text" value="<?php echo $age?>" style=width:50px; name="age">


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Height: <input type="text" value="<?php echo $horse_height?>" style=width:70px; name="height">


<p>
		<label>Breeding Recorded: </label>
Yes<input type="radio" name="recorded" value="yes" <?php checkRecorded($recorded,"yes")?>>
No <input type="radio" name="recorded" value="no" <?php checkRecorded($recorded,"no")?>>
</p>





	</fieldset>


<fieldset>



		<legend> Additional Info </legend>
		<p>
		<label>Additional Comments: </label>

		<textarea name="extrainfo" cols="29" rows="4"><?php if(isset($_POST['extrainfo'])) { echo $_POST['extrainfo']; } ?></textarea>

		</p>

		<p>
		<label>Optional Media Upload: </label>

		 <input id="file" type="file" name="myfile" value="<?php echo isset($fileName) ? $fileName : ''?>"/>

		</p>


</fieldset>

	<div id = "buttons">

		<input type = "submit" name = "button"value = "Enter Details">
		<input type = "reset" value = "Clear Fields">

	</div>

		</form>

	</body>

</html>



<?php
}
?>
<?php

			function check($group, $val)
			{
  				 if ($group === $val)
  				 {
    				  echo 'selected = "selected"';
  				 }


			}
?>
<?php

			function checkRecorded($group, $val)
			{
  				 if ($group === $val)
  				 {
    				  echo 'checked = "checked"';
  				 }


			}
?>

<?php

			function checkBreed($group, $val)
			{
  				 if ($group === $val)
  				 {
    				  echo 'checked = "checked"';
  				 }


			}
?>
<?php

			function checkPerformance($performance, $val)
			{
  				 if (is_array($performance) and in_array($val, $performance))
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

function validate_form()
{




   $first_name = trim($_REQUEST['firstname']);
   $last_name = trim($_REQUEST['surname']);
   $breed = isset($_REQUEST['breed']) ? $_REQUEST['breed'] : '';
   $recorded = isset($_REQUEST['recorded']) ? $_REQUEST['recorded'] : '';
   $horse_name = trim($_REQUEST['horsename']);
   $performance = isset($_REQUEST['performance']) ? $_REQUEST['performance'] : '';
   $colour = isset($_REQUEST['colour']) ? $_REQUEST['colour'] : '';
   $age = isset($_REQUEST['age']) ? $_REQUEST['age'] : '';
   $horse_height = isset($_REQUEST['height']) ? $_REQUEST['height'] : '';
   $phone = isset($_REQUEST['phone']) ? $_REQUEST['phone'] : '';
   $email = isset($_REQUEST['email']) ? $_REQUEST['email'] : '';
   $address = isset($_REQUEST['address']) ? $_REQUEST['address'] : '';
   $additionalInfo = isset($_REQUEST['extrainfo']) ? $_REQUEST['extrainfo'] : '';


   $error = '';

   $reg_exp = '/^[a-zA-Z]+$/';
   $reg_exp_surname = '/^[a-zA-Z]+$/';
   $reg_exp_horsename = '/^[a-zA-Z\-\']+$/';
   $regexp_phone =  '^[0-9]{3}-[0-9]{7}$^';
   $reg_exp_email = "#[a-z0-9_\+-]+(\.[a-z0-9_\+-]+)*@[a-z0-9-]+(\.[a-z0-9-]+)*\.([a-z]{2,4})$#";
   $reg_exp_address ="#[a-z0-9']i#";
   $count =0;



   	   if (! preg_match($reg_exp, $first_name))
        {
        	 $count++;
             $error .= "<span class=\"error\"> $count First Name is invalid (letters, hyphens, ', only)</span><br>";
        }

   		if (! preg_match($reg_exp_surname, $last_name))
   		{
   			  $count++;
     		  $error .= "<span class=\"error\">$count Last name is invalid (letters, hyphens, ', only)</span><br>";
   		}

		if (!preg_match($reg_exp_email, $email))
		{
			   $count++;
		       $error .= "<span class=\"error\">$count Email is invalid (Must Be in the form example@gmail.com)</span><br>";
   		}

		if (!preg_match($regexp_phone, $phone))
	 	{
	 			$count++;
	 		    $error .= "<span class=\"error\">$count Phone Number invalid (Format must be 111-1111111)</span><br>";
     	}




   		if (! preg_match($reg_exp_address, $address))
		{
				$count++;
		  		$error .= "<span class=\"error\">$count Address is invalid (Invalid Address)</span><br>";
		}


      	if (strlen($breed) == 0)
     	{
     		   $count++;
     	 	   $error .= "<span class=\"error\">$count Please select the sex of the horse</span><br>";
  		}

		if (! is_array($performance))
		{
			   $count++;
			   $error .= "<span class=\"error\">$count Tick a box in the Performance section </span></br>";
		}

		if (! preg_match($reg_exp_horsename, $horse_name))
		{
				$count++;
    		    $error .= "<span class=\"error\">$count Horse Name is invalid (letters, hyphens, ', only)</span><br>";
		}

		if (strlen($colour) == 0)
		{
				 $count++;
    		     $error .="<span class=\"error\">$count Select a Colour for the horse</span><br>";
		}

		if (!is_numeric($age))
		 {
		 		$count++;
			 	$error .="<span class=\"error\">$count Enter age correctly</span><br>";
		 }

		if (!is_numeric($horse_height))
		{
				$count++;
			   	$error .="<span class=\"error\">$count 	Enter Height correctly</span><br>";
		}

		if (strlen($recorded) == 0)
	     {
	     		  $count++;
    		      $error .="<span class=\"error\">$count State whether the Breeding is recorded</span><br>";
		 }

		if( $additionalInfo == null )
		{
		    	  $count++;
    		      $error .="<span class=\"error\">$count Enter additional Performance Details  </span><br>";
		}


			return $error;
}
?>


<?php
	function display_output_page()
	{




  		 $first_name = trim($_REQUEST['firstname']);
  		 $last_name = trim($_REQUEST['surname']);
  		 $horse_name = trim($_REQUEST['horsename']);
  		 $breed = isset($_REQUEST['breed']) ? $_REQUEST['breed'] : '';
  		 $recorded = isset($_REQUEST['recorded']) ? $_REQUEST['recorded'] : '';
   		 $performance = isset($_REQUEST['performance']) ? $_REQUEST['performance'] : '';
   		 $age = isset($_REQUEST['age']) ? $_REQUEST['age'] : '';
   		 $horse_height = isset($_REQUEST['height']) ? $_REQUEST['height'] : '';
     	 $colour = isset($_REQUEST['colour']) ? $_REQUEST['colour'] : '';
         $phone = isset($_REQUEST['phone']) ? $_REQUEST['phone'] : '';
         $email = isset($_REQUEST['email']) ? $_REQUEST['email'] : '';
		 $address = isset($_REQUEST['address']) ? $_REQUEST['address'] : '';
		 $self = $_SERVER['PHP_SELF'];
		 $additionalInfo = isset($_REQUEST['extrainfo']) ? $_REQUEST['extrainfo'] : '';
		 $fileName = isset($_REQUEST['myfile']) ? $_REQUEST['myfile'] : '';




?>

	 <form action="MAILTO:<?php echo $email;?>" method="post" enctype="text/plain">
  	 <html>

   	 <head>

   	 	<link rel="stylesheet" type="text/css" href="style2.css">
   			 <title>Form Results</title>
   			 <h1>Form Results</h1>

<textarea name="output" cols="70" rows="33">
<?php echo date("D M d, Y G:i a\n\n"); ?>
<?php echo "First Name:\t\t\t\t$first_name\n\n" ?>
<?php echo "Last Name:\t\t\t\t$last_name\n\n" ?>
<?php echo "Address:\t\t\t\t$address\n\n" ?>
<?php echo "Phone Num:\t\t\t\t$phone\n\n" ?>
<?php echo "E Mail:\t\t\t\t\t$email\n\n"  ?>
<?php echo "Recorded:\t\t\t\t$recorded\n\n" ?>
<?php echo "Breed:\t\t\t\t\t$breed\n\n" ?>
<?php echo "Horse Name:\t\t\t\t$horse_name\n\n" ?>
<?php echo "Colour:\t\t\t\t\t$colour\n\n" ?>
<?php echo "Horse Age:\t\t\t\t$age\n\n" ?>
<?php echo "Horse Height:\t\t\t\t$horse_height\n\n" ?>
<?php echo "Recorded:\t\t\t\t$recorded\n\n" ?>
<?php   if (is_array($performance))
	   {
	   		echo "Performance(s):\n\n";

	 		foreach ($performance as $key)
	        {

	               echo "($key)";
	        }


	   } ?>
			<?php echo "\n\nAdditional Info:\t\t\t$additionalInfo\n\n" ?>
<?php if(isset($fileName))
			 {
			 	echo "File Uploaded:\t\t\t\tYes\n";
			 	echo "File Name:\t\t\t\t$fileName\n";
			 }

			 ?>

</textarea>
   	 </head>
   	 		<body>

<fieldset>
 <?php
		echo  '<a href= " '. $self . ' " >Back To Form</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';

?>

						<input class="button" type="submit" value="Send to your email"/>
			</fieldset>



	    </body>




		<br>


   </html>



<?php



}

?>









