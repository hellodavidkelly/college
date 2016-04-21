<?php
if (isset($_REQUEST['button']))
{
 $self =  $_SERVER['PHP_SELF'];
 $band = $_REQUEST['band'];

 // band, using a foreach loop
 echo "<b>The Band(s) selected is/are:</b>";
 echo "<ul>";
 if (isset($band)){
   foreach($band as $value){
     echo "<li> $value </li>";
   }
 }
 else{
   echo "No band was selected.";
 }
 echo "</ul>";
 }

 ?>

