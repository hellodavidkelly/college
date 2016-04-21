<?php
if (isset($_REQUEST["button"]))
{
   $self =  $_SERVER['PHP_SELF'];
   if ((empty($_REQUEST["val1"])) || (empty($_REQUEST["val2"])) || (empty($_REQUEST["calc"])))
	{
	header("Location:$self");
	exit;
	}
	$val1 = $_REQUEST['val1'];
    $val2 = $_REQUEST['val2'];
	$calc = $_REQUEST['calc'];
	if(is_numeric( $val1 ) && is_numeric( $val2 ))
	   {
	   if( $calc != null )
	   		{
	    	switch($calc )
	    		{
	      		case "add" : $result = $val1 + $val2; break;
	      		case "sub" : $result = $val1 - $val2; break;
	      		case "mult" : $result = $val1 * $val2; break;
	      		case "div" : $result = $val1 / $val2; break;
	    		}

	    		echo "<title> Calculation Result </title>";
	    		echo  "<h2> Calculation Result </h2><hr/>";
	  			echo  "The result of $calc sum of $val1 and $val2 is: <b>$result </b> <br/><br/>" ;
	  		    echo  '<a href= " '. $self . ' " > Do another calculation</a>';
	  		}
	  	}    // is_numeric
		else
		    {
			echo "Invalid entry - please retry <br/><br/>" ;
			echo '<a href= " '. $self . ' " > Back to Form  </a>';
		}
}
else
{
?>
<html>
<head>
<title>Calculation Form</title> </head><body>
  <form action = "<?php echo $_SERVER['PHP_SELF']; ?>" method = "post">
   Value 1: <input type = "text" name = "val1" size = "10">
   Value 2: <input type = "text" name = "val2" size = "10">
  <br>
  Calculation: <br>
  <input type = "radio" name = "calc" value = "add"> Add
  <input type = "radio" name = "calc" value = "sub"> Subtract
  <input type = "radio" name = "calc" value = "mult"> Multiply
  <input type = "radio" name = "calc" value = "div"> Divide
  <hr>
  <input type = "submit" name = "button" value = "Calculate">
  <input type = "reset" value = "Clear">
  </form>
 </body>
</html>
 <?php
 }
?>

