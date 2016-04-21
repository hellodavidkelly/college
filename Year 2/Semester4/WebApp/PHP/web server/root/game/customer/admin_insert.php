<?php

	//session_start();
	require_once("Include/db_connect.php");




?>

<!-- example for PHP 5.0.0 final release -->

<html>

 <head>
  <title>Session running</title>
 </head>
 <hr>
 

 <br>

 <body> <hr>
 <h1>Admin Game Insert</h1>






<html>
<head>
<title>Count Visits</title>
<link rel="stylesheet" type="text/css" href="Css/admin_style.css">
</head>
<body>
<div id = "notice">
			Enter Details For A New Title And Submit
		</div>

	<form action="<?php echo $_SERVER['PHP_SELF']; ?>" method="post">
		<p><a href="admin_home.php"><img src="Images/admin_home.jpg"  width="258" height="75"></a>
		<a href="admin_catalog.php"><img src="Images/admin_catalogue.png" alt="HTML tutorial" width="258" height="75"></a>
		<a href="admin_delete.php"><img src="Images/delete.jpg"  width="258" height="75"></a>
		<a href="admin_insert.php"><img src="Images/insert.png"  width="258" height="75"></a>
		<a href="admin_about.php"><img src="Images/admin_about.png"  width="258" height="75"></a></p>
	
		
		</form>
<a href="home.php"><img src="Images/logout.png"  width="258" height="75"></a></p>
<a href="admin_search.php"><img src="Images/admin_search.png"  width="258" height="75"></a>


<?php




			 $db_link = db_connect("games");
			 $self = $_SERVER['PHP_SELF'];
			 $gameID = isset($_REQUEST['gameID']) ? $_REQUEST['gameID'] : '';
			 $title = isset($_REQUEST['title']) ? $_REQUEST['title'] : '';
   			 $pub = isset($_REQUEST['pub']) ? $_REQUEST['pub'] : '';
			 $year = isset($_REQUEST['year']) ? $_REQUEST['year'] : '';
			 $price = isset($_REQUEST['price']) ? $_REQUEST['price'] : '';
			 $image = isset($_REQUEST['image']) ? $_REQUEST['image'] : '';
			 $session = (int)session_id();
	       

	
	
?>

			<form action="" method="post">
			
<br>

					<head>
								<link rel="stylesheet" type="text/css" href="admin_style.css">
								
					</head>
					
				<fieldset>	
					
					<p>	<label>Enter A Game ID: </label>
						<input type ="text"  value="<?php echo $gameID?>" name = "gameID"/></p>
					
					<p><label>Enter A Title</label>
						<input type = "text" value="<?php echo $title?>"  name = "title"/></p>

						

					<p><label>Enter A Publisher Name: </label>
						<input type = "text" value="<?php echo $pub?>" style="width: 300px;" name = "pub"/></p>

						<label>Enter A Year: </label>
						<input type = "text" value="<?php echo $year?>" style="width: 300px;" name = "year"/></p>
						
					<p><label>Enter A Price: </label>
						<input type = "text" value="<?php echo $price?>" style="width: 300px;" name = "price"/></p>	
						<p><label>Enter An Image Name: </label>
						<input type = "text" value="<?php echo $image?>" style="width: 300px;" name = "image"/>
				</fieldset>


				



<div id = "buttons">
		<input type = "submit" name = "button"value = "Enter Details">
		<input type = "reset" value = "Clear Fields"></p>
</div>
	
		</form>
		
		
		
		
		
		
		
	</body>
</html>



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



						$gameID = $_REQUEST['gameID'];
						$title = $_REQUEST['title'];
						$pub = $_REQUEST['pub'];
						$year = $_REQUEST['year'];
						$price = $_REQUEST['price'];
					    $image = $_REQUEST['image'];

				
			

					$sql2 = "INSERT INTO inventory(gameID,title,pub,year,price,image)
					VALUES('$gameID','$title','$pub','$year','$price','$image')";
					$result2 = mysql_query($sql2); 
					

					if(!$result2) die('Could not insert data because ' . mysql_error());
							
	
					display_output_page();
					mysql_close($db_link);
					
				
					
   					 }
			 }
?>





<?php

function validate_form()
{




   $gameID = trim($_REQUEST['gameID']);
   $title = trim($_REQUEST['title']);
   $pub = isset($_REQUEST['pub']) ? $_REQUEST['pub'] : '';
   $year = isset($_REQUEST['year']) ? $_REQUEST['year'] : '';
   $price = isset($_REQUEST['price']) ? $_REQUEST['price'] : '';
   $image = isset($_REQUEST['image']) ? $_REQUEST['image'] : '';

   $error = '';
   $reg_exp_title = '/^[a-zA-Z\-\']+$/';
   $reg_exp = '/^[a-zA-Z]+$/';
   
 
   
   $count =0;



   		if (empty($title))
   		{
   			  $count++;
     		  $error .= "<span class=\"error\">$count Title is invalid (letters, hyphens, ', only)</span><br>";
   		}

		if (!is_numeric($year))
		 {
		 		$count++;
			 	$error .="<span class=\"error\">$count Enter year Details correctly</span><br>";
		 }


   		if (empty($pub))
		{
				$count++;
		  		$error .= "<span class=\"error\">$count pub is invalid (Invalid pub)</span><br>";
		}

		
		  if (!is_numeric($gameID))
		 {
		 		$count++;
			 	$error .="<span class=\"error\">$count Enter Game ID Details correctly</span><br>";
		 }

		 
		 if (empty($image))
   		{
   			  $count++;
     		  $error .= "<span class=\"error\">$count Image is invalid (letters, hyphens, ', only)</span><br>";
   		}
		
			  if (!is_numeric($price))
		 {
		 		$count++;
			 	$error .="<span class=\"error\">$count Enter Game ID Details correctly</span><br>";
		 }
			return $error;
}
?>


<?php
	function display_output_page()
	{




  		 $gameID = trim($_REQUEST['gameID']);
  		 $title = trim($_REQUEST['title']);
		 $year = isset($_REQUEST['year']) ? $_REQUEST['year'] : '';
		 $pub = isset($_REQUEST['pub']) ? $_REQUEST['pub'] : '';
		 $self = $_SERVER['PHP_SELF'];
		 $price = isset($_REQUEST['price']) ? $_REQUEST['price'] : '';
		 $image = isset($_REQUEST['image']) ? $_REQUEST['image'] : '';


		echo "New Title $title has been added to the database " ;
		 
		 
		 
	$db_link = db_connect("games");
    $self = $_SERVER['PHP_SELF'];
    $gameID = $_REQUEST['gameID'];

	foreach($_REQUEST as $key=>$value)

	$fields = mysql_list_fields("games", "inventory");
	$num_columns = mysql_num_fields($fields);


	$query = "SELECT * FROM inventory WHERE gameID=".$gameID.";";
	$result = mysql_query($query) or die("SQL failed");
	echo '<table border="1">';
	echo "<tr>";
	
		echo "<th> Game ID</th>";
		echo "<th> Title</th>";
		echo "<th> Maker</th>";
		echo "<th> Year </th>";
		echo "<th> Price </th>";
		echo "<th> Image </th>";
	
		
		echo "</tr>";

		while ($row = mysql_fetch_assoc($result))
		{
		echo "<tr>";
		echo "<td>".$row['gameID']."</td>";
		echo "<td>".$row['title']."</td>";
		echo "<td>".$row['pub']."</td>";
		echo "<td>".$row['year']."</td>";
		echo "<td>$".$row['price']."</td>";
		echo "<td><img src='images/".$row['image']."'></td>";

}
		 
		 
		 
		 $page = $_SERVER['PHP_SELF'];
		$sec = "5.0";
		header("Refresh: $sec;$page");

?>
	

<?php



}

?>
		<?php
include ('Include/footer.html'); // Include the HTML footer.
?>









