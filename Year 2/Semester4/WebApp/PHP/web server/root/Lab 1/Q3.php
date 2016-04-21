<?php

$tablets = 15;
$price = 350;
$vat = 0.2;


$total = $tablets * $price;
$afterVat = $total + $total*$vat;

echo "<br>You purchased $tablets at a cost of $price each</br>";
echo "<br>With tax, the total comes to $afterVat <br>";
?>