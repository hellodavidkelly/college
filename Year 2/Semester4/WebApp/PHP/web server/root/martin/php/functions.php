<?php
/*validate superglobal $_POST and returns $error string*/
function validate_form() 
{
	//debug_to_stdout($_POST);
	extract($_POST);
	$error=false;

	if(!preg_match('#^[a-z\-\']+$#i', $first_name))
		$error.="<li>First name is invalid (letters, hyphens, ', only)</li>";
	if(!preg_match('#^[a-z\-\']+$#i', $last_name))
		$error.="<li>Last name is invalid (letters, hyphens, ', only)</li>";
	if(!preg_match('#^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]+$#i', $email))
		$error.="<li>Use valid email format: user@domain.something</li>";
	if(!preg_match('#^[\d]{3}[-][\d]{7}$#i', $phone))
		$error.="<li>Use valid phone format: 123-1234567</li>";
	if(!preg_match('#^[a-z\d]+[ a-z\d\']*$#i', $address))
		$error.="<li>Use valid address</li>";
	if(!isset($tick)) $error.="<li>Choose a tick</li>";
	if(!isset($performance)) $error.="<li>Tick a box in the Performance section</li>";
	if(!preg_match('#^[a-z\-\']+$#i', $horse_name))
		$error.="<li>Horse name is invalid (letters, hyphens, ', only)</li>";
	if(!isset($horse_color) or $horse_color=="") $error.="<li>Select horse color</li>";
	if(!is_numeric($horse_age)) $error.="<li>Write horse age as numeric</li>";
	if(!is_numeric($horse_height)) $error.="<li>Write horse height as numeric</li>";
	if(!isset($breeding)) $error.="<li>State whether the Breeding is recorded</li>";
	if(!isset($additional_info)) $error.="<li>Enter additional Performance Details</li>";
	else $additional_info=trim($additional_info,"\t\n\r\0\x0B");
	return $error;
}
/*displays html output*/
function display_output_page() 
{
	extract($_POST);
	$output="";
	
	$output.="Name: $first_name $last_name"
			."\nAddress: $address"
			."\nEmail: $email"
			."\nPhone: $phone"
			."\nName of the horse: $horse_name"
			."\nBreeding recorded: $breeding"
			."\nSex of the horse: $tick"
			."\nColor: $horse_color"
			."\nPerformance: ";
			for($i=0;$i<count($performance);$i++)
				$output.="\n\t".$performance[$i];
	$additional_info=trim($additional_info,"\t\n\r\0\x0B");
	$output.="\nComment: \n$additional_info";
	if(isset($file)) $output.="\nFile uploaded: $file";
	?>
	<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
	<head>
		<title>Assignment1: Horse Sale Web Form</title>
		<meta http-equiv="Content-type" content="text/html;charset=UTF-8" />
		<link rel="stylesheet" type="text/css" media="screen" href="css/styles.css"/>
	</head>
	<body>
		<form action="MAILTO:<?php echo $email;?>" method="post" enctype="text/plain">
			<fieldset>
				<legend>Please review entries <?php echo date('m/d/y');?></legend>
				<textarea rows="15" cols="100"><?php echo $output;?></textarea><br>
				<input class="button" type="submit" value="Send to your email"/>
			</fieldset>
		</form>
	</body>
<?php	
}
 /*dumps $data to stdout*/
function debug_to_stdout($data="") 
{
	echo "<pre>";
	print_r($data);
	echo "</pre>";
}
?>