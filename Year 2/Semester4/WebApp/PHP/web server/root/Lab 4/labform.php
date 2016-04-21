<?php



if (isset($_REQUEST["button"]))
{

 $self =  $_SERVER['PHP_SELF'];
 if (empty($_REQUEST["pword"]))
	{
	header("Location:$self");
	exit;
	}





$firstname = $_REQUEST['firstname'];
$secondname =    $_REQUEST['surname'];
$password =    $_REQUEST['pword'];
$gender = $_REQUEST['sex'];
$homecountry = $_REQUEST['birthplace'];
$countrymul= $_REQUEST['country'];
$comment= $_REQUEST['workexp'];


echo "Thank You For Your Submission!";
echo  "<br/>Name:$firstname $secondname<hr>" ;
echo  "<br/>Password: $password<hr>" ;
echo  "<br/>Sex: $gender<hr>" ;
echo  "<br/>Country Of Origon: $homecountry<hr>" ;

echo "<br>";
echo "<ul>";
echo "Country/Countries of Residence";
echo "<br>";
echo "<br>";

foreach($countrymul as $key)
{

	echo "<li> $key </li>";

}
echo "</ul>";

echo "<ul>";
echo "Hobby/Hobbies";
echo "<br>";
echo "<br>";



if (!empty($_REQUEST['hobbies']))
{
	$hobby= $_REQUEST['hobbies'];

   		 foreach($hobby as $key)
		{

				echo "<li> $key </li>";
		}
}

	else
	{
   		echo "Hobby Not Selected";
	}

echo "<br>";
echo "<br>";


	echo  "<br/>Comments:$comment<hr>" ;





echo '<a href= " '. $self . ' " > Back to Form  </a>';
}







else
{



?>












<html>

<head>

<link rel="stylesheet" type="text/css" href="style.css">


<title>Registrations</title>
<meta http-equiv="content-type" content="text/html;charset=utf-8"/>


</head>



<body>
<form action= "<?php echo $_SERVER['PHP_SELF']; ?>" method="post">

<h1> EmployMent Registration Form </h1>
<fieldset>

<div id = "bluetext"><label for="name">First Name :</label></div id>
<input type ="text" name = "firstname"/>
<br>
 <div id = "bluetext"><label for="secondname">Surname :</label></div id>
 <input type = "text" name = "surname"/>
<br/>
 <div id = "bluetext"><label for="pass">Password :</label></div id>
 <input type ="password" name = "pword"/> <span>(mandatory)</span>
<br/>

</fieldset>

</br>
<fieldset>


</br>
<div id = "bluetext"><label for="sex">Sex :</label></div id>
Male: <input type = "radio" name = "sex" value ="man">
Female: <input type = "radio" name = "sex" value ="woman">


</fieldset>

</br>


<fieldset>
<div id = "bluetext"><label for="country">Country Of Origon:</label></div id>
<select name= "birthplace">

  <option value="uk">UK</option>
  <option value="usa">USA</option>
  <option value="irl">IRL</option>
  <option value= "other">OTHER</option>

</select>

</fieldset>

<fieldset>
<div id = "bluetext"><label for="country">Country(ies) Of Residence :</label></div id>


<select name="country[]" multiple>
  <option value="uk" >UK</option>
  <option value="usa">USA</option>
  <option value="irl">IRL</option>
  <option value="other">OTHER</option>
</select>


</fieldset>

<fieldset>


<div id = "bluetext"><label for="hobby">Hobbies :</label></div id>
Sailing <input type = "checkbox" name = "hobbies[]" value ="sailing">
PHP <input type = "checkbox" name = "hobbies[]" value ="php">
Painting <input type = "checkbox" name = "hobbies[]" value ="painting">


</fieldset>
<fieldset>



<div id = "bluetext"><label for="workex">Work Experience :</label></div id>
<br>
<textarea name = "workexp" rows ="10" cols = "47"></textarea>
</fieldset>

<fieldset>

<div id = "buttons">

	<input type = "submit" name = "button"value = "Submit">
	<input type = "reset" value = "Reset">

</div>

			</fieldset>

		</form>

	</body>


</html>



 <?php


	}

 ?>









