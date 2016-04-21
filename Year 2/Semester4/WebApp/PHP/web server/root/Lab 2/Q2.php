<?php



$spices = array ('Apples'=>2.50 ,'Pears'=>3.50, 'Oranges'=>4.50, 'Strawberries'=>5.50);

print_r($spices);
echo'<br>';
echo'<br>';


$spices['Pears']= number_format($spices['Pears'], 2, '.', '');
echo 'Pears Cost:'; echo $spices['Pears'];

echo'<br>';

$spices['Oranges']= number_format($spices['Oranges'], 2, '.', '');
echo 'Oranges Cost:'; echo $spices['Oranges'];

echo'<br>';
echo'<br>';

echo "<table width='600' cellpadding='5' cellspacing='5' border='1'>";

echo "<tr>  <th>Fruit</th> <th>Price</th></tr>";






foreach ($spices as $element => $value)
{

	echo "<tr>  <td>$element</td> <td> $value</td> </tr>";

}
	echo'</table>';


?>


