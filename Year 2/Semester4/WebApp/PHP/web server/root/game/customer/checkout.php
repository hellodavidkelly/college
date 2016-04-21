<?php

	session_start();
	require_once("Include/db_connect.php");




?>

<!-- example for PHP 5.0.0 final release -->

<html>

 <head>
  <title>Session running</title>
 </head>
 <hr>
 PHPSESSID = <?php echo session_id(); ?>

 <br>

 <body> <hr>
 <h1>Checkout</h1>






<html>
<head>
<title>Count Visits</title>
<link rel="stylesheet" type="text/css" href="Css/style.css">
</head>
<body>


	<form action="<?php echo $_SERVER['PHP_SELF']; ?>" method="post">
		<p><a href="home.php"><img src="Images/home.png"  width="258" height="75"></a>
		<a href="catalog.php"><img src="Images/catalogue.png" alt="HTML tutorial" width="258" height="75"></a>
		<a href="cart.php"><img src="Images/cart.png"  width="258" height="75"></a>
		<a href="checkout.php"><img src="Images/checkout.png"  width="258" height="75"></a>
		<a href="about.php"><img src="Images/about.png"  width="258" height="75"></a></p>
		<a href="search.php"><img src="Images/search.png"  width="258" height="75"></a></br></br></br>
		<a href="admin.php"><img src="Images/admin.png"  width="258" height="75"></a><br></br></br>
		<a href="enter.php"><img src="Images/enter.png"  width="258" height="75"></a>
		</form>

<h1> Please Fill Out The Order Form</h1>
<?php




			 $db_link = db_connect("games");
			 $self = $_SERVER['PHP_SELF'];
			 $first_name = isset($_REQUEST['firstname']) ? $_REQUEST['firstname'] : '';
			 $last_name = isset($_REQUEST['surname']) ? $_REQUEST['surname'] : '';
   			 $address = isset($_REQUEST['address']) ? $_REQUEST['address'] : '';
			 $delivery = isset($_REQUEST['delivery']) ? $_REQUEST['delivery'] : '';
			 $credit_card = isset($_REQUEST['card']) ? $_REQUEST['card'] : '';
			 $session = (int)session_id();
	         $total=0;
	         $final_total=0;

	

	
	$fields = mysql_list_fields("games", "cart");
	$num_columns = mysql_num_fields($fields);
	
	$query = "SELECT * FROM cart WHERE session_id = ".$session.";";

	$result = mysql_query($query) or die("SQL failed");
	echo '<table border="1">';
	echo "<tr>";
	echo "<th> Title </th>";
    echo "<th> Price </th>";
	echo "<th> Quantity </th>";
	echo "<th> Price </th>";
	echo "<th> Subtotal </th>";

	echo "</tr>";

	while ($row = mysql_fetch_assoc($result))
	{
       echo "<tr>";


		echo "<td>".$row['title']. "</td>";
		echo "<td>$".$row['price']."</td>";
		echo "<td>".$row['quantity']."</td>";
	

		$quantity = $row['quantity'];
		$title=$row['title'];
		$price=$row['price'];
		$total = $quantity*$price;
		echo "<td>$$total</td>";
		$final_total += $total;
		$gameID = $row['gameID'];
		
			
		
	
?>

			<form action="" method="post">
			<input type="hidden" name="price" value="<?php echo $price ?>">
			<input type="hidden" name="gameID" valus="<?php echo $gameID ?>">
			<input type="hidden"="subtotal" value="<?php echo $final_total?> ">
			<input type="hidden" name="title" value="<?php echo $title ?>">
<br>

					<head>
								<link rel="stylesheet" type="text/css" href="style.css">
								
					</head>
					
				<fieldset>	
					
					<p>	<label>First  name: </label>
						<input type ="text"  value="<?php echo $first_name?>" name = "firstname"/></p>
					
					<p><label>Second  name: </label>
						<input type = "text" value="<?php echo $last_name?>"  name = "surname"/></p>

						<input type="hidden" name="subtotal" value="<?php echo $final_total?> ">

					<p><label>Address: </label>
						<input type = "text" value="<?php echo $address?>" style="width: 300px;" name = "address"/></p>

						<label>Delivery Address: </label>
						<input type = "text" value="<?php echo $delivery?>" style="width: 300px;" name = "delivery"/></p>
						
					<p><label>Credit Card Number: </label>
						<input type = "text" value="<?php echo $credit_card?>" style="width: 300px;" name = "card"/></p>	
				</fieldset>


				



<div id = "buttons">
		<input type = "submit" name = "button"value = "Enter Details">
		<input type = "reset" value = "Clear Fields"></p>
</div>
	
		</form>
		
		
		
		
		
		
		
	</body>
</html>


<?php
		
		echo "</tr>";
		
		
	}

		
		
		echo "<th>";
		echo "<td>-</td>";
		echo "<td>-</td>";
		echo "<td>-</td>";
		
		echo "<td>$$final_total</td>";
		echo "</th>";

		mysql_free_result($result);
		mysql_close($db_link);

	

?>

	<?php


	if (isset($_REQUEST['button']))
	{
  		 process_form();


	}
		else
			{
  				 display_form_page('');
			}
?>

<?php

		function display_form_page($error)
		{
 			

?>

<?php
		if ($error)
		{
 		  echo "<p>$error</p>\n";
		}
?>


<?php
}
?>



		<?php
			function process_form()
			{
 				  $error = validate_form();

				  
				  
				  
				  
				  
				  
 				if ($error)
  				 {
    				  display_form_page($error);
   				 }
  					 else
  					 {
     					 
						$db_link = db_connect("games");
						$sessionID = session_id();



						$first_name = $_REQUEST['firstname'];
						$surname = $_REQUEST['surname'];
						$address = $_REQUEST['address'];
						$delivery = $_REQUEST['delivery'];
						$total = $_REQUEST['subtotal'];
					    $credit_card = $_REQUEST['card'];
						$customer_id = uniqid();
						$order_id = uniqid("ORD");

				
					
					
					$sql2= "DELETE from cart WHERE session_id = '$sessionID' ";
					$result2 = mysql_query($sql2); 

					
							
					$sql2 = "INSERT INTO customer(customer_id,first_name,surname,address,delivery_address)
					VALUES('$customer_id','$first_name','$surname','$address','$delivery')";
					$result2 = mysql_query($sql2); 
					

					$sql2 = "INSERT INTO orders(order_id,customer_id,session_id,first_name,surname,address,delivery_address,subtotal,credit_card)
					VALUES('$order_id','$customer_id','$sessionID','$first_name','$surname','$address','$delivery','$total','$credit_card')";
					$result2 = mysql_query($sql2); 
					

					if(!$result2) die('Could not insert data because ' . mysql_error());
							
	
					display_output_page();
					mysql_close($db_link);
					
					session_regenerate_id();
					
   					 }
			 }
?>





<?php

function validate_form()
{




   $first_name = trim($_REQUEST['firstname']);
   $last_name = trim($_REQUEST['surname']);
   $total = isset($_REQUEST['subtotal']) ? $_REQUEST['subtotal'] : '';
   $address = isset($_REQUEST['address']) ? $_REQUEST['address'] : '';
   $delivery = isset($_REQUEST['delivery']) ? $_REQUEST['delivery'] : '';
   $credit_card = isset($_REQUEST['card']) ? $_REQUEST['card'] : '';
  
 
   $error = '';

   $reg_exp = '/^[a-zA-Z]+$/';
   $reg_exp_surname = '/^[a-zA-Z]+$/';
 
   $reg_exp_address ="#[a-z0-9']i#";
   $count =0;



   	   if (! preg_match($reg_exp, $first_name))
        {
        	 $count++;
             $error .= "<span class=\"error\"> $count First Name is invalid (letters, hyphens, ', only)</span><br>";
        }

   		if (! preg_match($reg_exp_surname, $last_name))
   		{
   			  $count++;
     		  $error .= "<span class=\"error\">$count Last name is invalid (letters, hyphens, ', only)</span><br>";
   		}

		if (! preg_match($reg_exp_address, $delivery))
		{
				$count++;
		  		$error .= "<span class=\"error\">$count Delivery Address is invalid (Invalid Address)</span><br>";
		}



   		if (! preg_match($reg_exp_address, $address))
		{
				$count++;
		  		$error .= "<span class=\"error\">$count Address is invalid (Invalid Address)</span><br>";
		}

		 if (!is_numeric($credit_card))
		 {
		 		$count++;
			 	$error .="<span class=\"error\">$count Enter Card Details correctly</span><br>";
		 }


			return $error;
}
?>


<?php
	function display_output_page()
	{




  		 $first_name = trim($_REQUEST['firstname']);
  		 $last_name = trim($_REQUEST['surname']);
		 $delivery = isset($_REQUEST['delivery']) ? $_REQUEST['delivery'] : '';
		 $address = isset($_REQUEST['address']) ? $_REQUEST['address'] : '';
		 $self = $_SERVER['PHP_SELF'];
		 $total = isset($_REQUEST['subtotal']) ? $_REQUEST['subtotal'] : '';
		 $credit_card = isset($_REQUEST['card']) ? $_REQUEST['card'] : '';
		 


?>

	 <form action="MAILTO:<?php echo $email;?>" method="post" enctype="text/plain">
  	 <html>

   	 <head>

   	 
   			
   			

<textarea name="output"  cols="70" rows="20" readonly>
Your Order Is Complete


<?php echo date("D M d, Y G:i a\n\n"); ?>
<?php echo "Thank You $first_name Your Order has been processed and Will Be delivered to $delivery Within 14 Days\n\n\n" ?>
<?php echo "First Name:\t\t\t\t$first_name\n\n" ?>
<?php echo "Last Name:\t\t\t\t$last_name\n\n" ?>
<?php echo "Address:\t\t\t\t$address\n\n" ?>
<?php echo "Delivery Address:\t\t\t$delivery\n\n" ?>
<?php echo "Subtotal:\t\t\t\t$$total\n\n" ?>
<?php echo "Card Number:\t\t\t\t$credit_card\n\n" ?>

</textarea>

 <?php
		

?>

			



	    </body>




		<br>


   </html>



<?php



}

?>





		<?php
include ('Include/footer.html'); // Include the HTML footer.
?>




