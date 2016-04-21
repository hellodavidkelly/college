<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<?php
	include_once "php/functions.php";
	debug_to_stdout($_POST);
	if (isset($_POST['button']))
	{
		$error=validate_form();
		if ($error)
		{
			echo "<ol>";
			echo $error;
			echo "</ol>";
		}
 		else {
			display_output_page();
			exit;
		}
		extract($_POST);
	}
?>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
	<head>
		<title>Assignment1: Horse Sale Web Form</title>
		<meta http-equiv="Content-type" content="text/html;charset=UTF-8" />
		<meta name="description" content="Web Applications Assignment 1: Horse Sale Form"/>
		<meta name="keywords" content="learning,web,form,html,xhtml,css"/>
		<link rel="stylesheet" type="text/css" media="screen" href="css/styles.css"/>
	</head>
	<body>
		<form action="<?php echo $_SERVER['PHP_SELF'] ?>" method="post">
			<fieldset id="header_fieldset" class="centered">
				<h3>Horse Sale - Entry Form</h3>
				<img src="images/brown_and_white_horse.jpg" alt="horse_image_is_missing!"/>
			</fieldset>
			<fieldset>
				<legend>Personal Details</legend>
				<div class="personal">
					<label class="personal" for="first_name">First  name</label>
					<input id="first_name" class="input" type="text" name="first_name" size="12" value="<?php echo isset($first_name) ? $first_name : '';?>"/>
				</div>
				<div class="personal">
					<label class="personal" for="last_name">Last name</label>
					<input id="last_name" class="input" type="text" name="last_name" size="12" value="<?php echo isset($last_name) ? $last_name: '';?>"/>
				</div>
				<div class="personal">
					<label class="personal" for="email">Email</label>
					<input id="email" class="input" type="text" name="email" size="30" value="<?php echo isset($email) ? $email : '';?>"/>
				</div>
				<div class="personal">
					<label class="personal" for="phone">Phone</label>
					<input id="phone" class="input" type="text" name="phone" size="12" value="<?php echo isset($phone) ? $phone : '';?>"/>
				</div>
				<div class="personal">
					<label class="personal" for="address">Address</label>
					<input id="address" class="input" type="text" name="address" size="70" value="<?php echo isset($address) ? $address : '';?>"/>
				</div>
			</fieldset>
			<fieldset>
				<legend>Tick selection</legend>
				<div class="tick">
					<label for="gelding">Gelding</label>
					<input id="gelding" type="radio" name="tick" value="Gelding" <?php if(isset($tick)) echo $tick==='Gelding' ? 'checked="checked"' : '';?>/>
				</div>
				<div class="tick">
					<label for="colt">Colt</label>
					<input id="colt" type="radio" name="tick" value="Colt" <?php if(isset($tick)) echo $tick==='Colt' ? 'checked="checked"' : '';?>/>
				</div>
				<div class="tick">
					<label for="filly">Filly</label>
					<input id="filly" type="radio" name="tick" value="Filly" <?php if(isset($tick)) echo $tick==='Filly' ? 'checked="checked"' : '';?>/>
				</div>
				<div class="tick">
					<label for="mare">Mare</label>
					<input id="mare" type="radio" name="tick" value="Mare"  <?php if(isset($tick)) echo $tick==='Mare' ? 'checked="checked"' : '';?>/>
				</div>
			</fieldset>
			<fieldset>
				<legend>Performance - check all that apply</legend>
				<div class="performance">
					<label for="broken">Broken and Riding</label>
					<input id="broken" type="checkbox" name="performance[]" value="Broken and Riding" <?php if(isset($performance)) echo in_array('Broken and Riding',$performance) ? 'checked="checked"': ''?>/>
				</div>
				<div class="performance">
					<label for="clubbed">Pony Clubbed</label>
					<input id="clubbed" type="checkbox" name="performance[]" value="Pony Clubbed" <?php if(isset($performance)) echo in_array('Pony Clubbed',$performance) ? 'checked="checked"' : ''?>/>
				</div>
				<div class="performance">
					<label for="lunging">Lunging</label>
					<input id="lunging" type="checkbox" name="performance[]" value="Lunging" <?php if(isset($performance)) echo in_array('Lunging',$performance) ? 'checked="checked"' : ''?>/>
				</div>
				<div class="performance">
					<label for="unbroken">Unbroken</label>
					<input id="unbroken" type="checkbox" name="performance[]" value="Unbroken" <?php if(isset($performance)) echo in_array('Unbroken',$performance) ? 'checked="checked"' : ''?>/>
				</div>
			</fieldset>
			<fieldset>
				<legend>Details of the Horse</legend>
				<div class="horse_details">
					<label class="horse_details" for="horse_name">Name</label>
					<input id="horse_name" type="text" name="horse_name" size="12" value="<?php echo isset($horse_name) ? $horse_name : '';?>"/>
				</div>
				<div class="horse_details">
					<label class="horse_details" for="horse_color">Color</label>
					<select id="horse_color" name="horse_color">
						<option value="">Select color</option>
						<option value="Bay" <?php if(isset($horse_color)) echo $horse_color==='Bay' ? 'selected="selected"' : ''?>>Bay</option>
						<option value="Chestnut" <?php if(isset($horse_color)) echo $horse_color==='Chestnut' ? 'selected="selected"' : ''?>>Chestnut</option>
						<option value="Piebald" <?php if(isset($horse_color)) echo $horse_color==='Piebald' ? 'selected="selected"' : ''?>>Piebald</option>
						<option value="White" <?php if(isset($horse_color)) echo $horse_color==='White' ? 'selected="selected"' : ''?>>White</option>
					</select>
				</div>
				<div class="horse_details">
					<label class="horse_details" for="horse_age">Age</label>
					<input id="horse_age" type="text" name="horse_age" size="3" value="<?php echo isset($horse_age) ? $horse_age : '';?>"/>
				</div>
				<div class="horse_details">
					<label class="horse_details" for="horse_height">Height</label>
					<input id="horse_height" type="text" name="horse_height" size="3" value="<?php echo isset($horse_height) ? $horse_height : '';?>"/>
				</div>
				<div class="horse_details">
					<label>Breeding Recorded</label>
					<label for="yes">Yes</label>
					<input id="yes" type="radio" name="breeding" value="Yes" <?php if(isset($breeding)) echo $breeding==='Yes' ? 'checked="checked"' : '';?>/>
					<label for="no">No</label>
					<input id="no" type="radio" name="breeding" value="No" <?php if(isset($breeding)) echo $breeding==='No' ? 'checked="checked"' : '';?>/>
				</div>
			</fieldset>
			<fieldset>
				<legend>Addtional Information</legend>
				<div class="additional">
					<label class="additional" for="additional_info">Additional Performance Details</label>
					<textarea id="additional_info" name="additional_info" rows="4" cols="50">
						<?php echo (isset($additional_info))? $additional_info : '';?>
					</textarea>
				</div>
				<div class="additional">
					<label class="additional" for="file">Upload video or images (optional)</label>
					<input id="file" type="file" name="file" value="<?php echo isset($file) ? $file : ''?>"/>
				</div>
			</fieldset>
			<fieldset class="centered">
				<input class="button" type="submit" name="button" value="Submit"/>
				<input class="button" type="reset" value="Clear"/>
			</fieldset>
		</form>
	</body>
</html>