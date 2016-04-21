<?php

$companies = array('ibm','oracle','ryanair','sybase','airlingus','channel4','fox','sky');


echo "<h2><b> My Company Listing</b></h2>";


foreach ($companies as $element )
{


	echo "<li><a href= 'http://www.".$element.".com'>" . $element.  "</a> </li>";

}



?>