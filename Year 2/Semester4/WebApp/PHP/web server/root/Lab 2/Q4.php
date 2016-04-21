<?php

echo "<h2><b> Tip of the Day</b></h2>";


$extraToppings = array('Learn Shortcut Keys','An apple a day','One in the hand is worth two in the bush','No point crying over spilled Milk',
'A Wacthed Pot never boils','Too many cooks spoil the broth','Let sleeping dogs lie');


$myNumber = rand(0, 6);


echo "$extraToppings[$myNumber]";





?>