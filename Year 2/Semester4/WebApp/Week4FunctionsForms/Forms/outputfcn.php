<?php
// ------------------------------------------------------------
// This version generates the form and prcessess the form.
// If the submit button is undefined then the form is displayed
// else the form is processed
// ------------------------------------------------------------



echo "<u>Script displays form or output, depending on whether SUBMIT button pressed </u> <p>";

if (isset($_REQUEST['button'])) // submit was clicked
{
   display_output_page();
}
else // display form for first time
{
   display_form_page();
}
?>

<?php
function display_form_page()
{
   $self = $_SERVER['PHP_SELF'];
?>

<html>
<head><title>Forms, version 2</title></head>
<body>
<h1>Forms, version 2</h1>
<form action="<?php echo $self ?>" method="POST">
First  name: <input type="text" name="firstname"><br>
Last name: <input type="text" name="lastname">
<p>
<input type="submit" name="button" value="Submit Name">
</form>

</body>
</html>
<?php
}
?>


<?php
function display_output_page()
{
   $first_name = $_REQUEST['firstname'];
   $last_name = $_REQUEST['lastname'];
?>

   <html>
   <head><title>Form Results</title></head>
   <body>
   <h1>Form Results</h1>
   <?php echo "Hello $first_name $last_name<br/>\n"; ?>
   </body>
   </html>
<?php
}
?>
