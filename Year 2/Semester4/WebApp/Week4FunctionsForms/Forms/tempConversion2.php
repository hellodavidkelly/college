<?php

   // This version uses one page for input and output
   
   $self = $_SERVER['PHP_SELF'];
   $fahr = isset($_REQUEST['fahrenheit']) ? $_REQUEST['fahrenheit'] : '';
?>
<html>
<head><title>Fahrenheit to Celsius Conversion</title>
</head>

<body>

<h1>Fahrenheit to Celsius Conversion</h1>

<form action="<?php echo $self ?>" method="POST">
Fahrenheit temperature:
<input type="text" name = "fahrenheit" value = "<?php echo $fahr ?>" />
<p><input type="submit" name="test" value="Convert to Celsius" /></p>
</form>
<p><?php result($fahr)?></p>
</body>
</html>

<?php 
   // function to do the conversion and print result

   function result($fahr)
   {
      if ( ! ($fahr === '') )
      {
         $fahr = $_REQUEST['fahrenheit'];
         $celsius = ($fahr - 32)*(5.0/9.0);
         printf("%.2fF is %.2fC", $fahr, $celsius);
      }      
   }
?>