<?php

$extraToppings = array('Mushrooms','Anchovies','Chocolate');

print_r ($extraToppings);
echo'<br>';


asort($extraToppings);

print_r ($extraToppings);
echo'<br>';
echo'<br>';

	for ($count=0; $count<3; $count++)
	{

		echo "<ul>";

		echo "<li> $extraToppings[$count] </li>";
		echo'<br>';

		echo "</ul>";
	}

?>