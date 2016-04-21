<html>
<head><title>Fahrenhiet to Celsius Conversion</title></head>
<body>

<!-- 
   This version of the temperature conversion program uses the existence
   of the button name to determine whether to display the form or do the
   calculations. If the button name is set then the form was just submitted
   and the conversion can be done and displayed. Otherwise the form should
   be displayed
-->

<h1>Fahrenheit to Celsius Conversion</h1>

<?php
   $self = $_SERVER['PHP_SELF'];

   if (isset($_REQUEST['convert'])) // button was clicked
   {
      // Form was submitted so do the conversion

      $fahr = $_REQUEST['fahrenheit'];
      $celsius = ($fahr - 32) * (5.0 / 9.0);

      printf("%.2fF is %.2fC", $fahr, $celsius);
      echo " <a href=\"$self\">Another conversion</a>";
   }
   else
   {
     // Form not submitted so display the form
?>
      <form action="<?php echo $self ?>" method="POST">
      Fahrenheit temperature:
      <input type="text" name="fahrenheit" />
      <p><input type="submit" name="convert" value="Convert to Celsius" /></p>
      </form>
<?php
   }
?>
</body>
</html>