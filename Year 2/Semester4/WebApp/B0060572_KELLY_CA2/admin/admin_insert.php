<?php
	require_once("../include/db_connect.php");
?>

<html>

	 <head>
	  <title>Insert</title>
	  <link rel="stylesheet" type="text/css" href="admin_style.css">
	 </head>
	 
<body>
<?php
include ('../include/adminHeader.html'); // Include the HTML footer.
?>
<br>

	<div id="side">
		<a href="../index.php">Home</a><br>
		<a href="admin_search.php">Admin Search</a>
	</div>

<?php
	$db_link = db_connect("project");
	$self = $_SERVER['PHP_SELF'];
	$movieID = isset($_REQUEST['movieID']) ? $_REQUEST['movieID'] : '';
	$title = isset($_REQUEST['title']) ? $_REQUEST['title'] : '';
	$studio = isset($_REQUEST['studio']) ? $_REQUEST['studio'] : '';
	$year = isset($_REQUEST['year']) ? $_REQUEST['year'] : '';
	$price = isset($_REQUEST['price']) ? $_REQUEST['price'] : '';
	$image = isset($_REQUEST['image']) ? $_REQUEST['image'] : '';
	$session = (int)session_id();	
?>

	<form action="" method="post">
	
	<fieldset>
	<legend>Enter Details</legend>
	<label class="movieLabel">Enter Movie ID:</label><input class="input" type ="text"  value="<?php echo $movieID?>" name = "movieID">
	<label class="movieLabel">Enter Title:</label><input class="input" type = "text" value="<?php echo $title?>" name = "title"/>
	<label class="movieLabel">Enter Studio Name:</label><input class="input" type = "text" value="<?php echo $studio?>" name = "studio"/>
	<label class="movieLabel">Enter Year:</label><input class="input" type = "text" value="<?php echo $year?>" name = "year"/>
	<label class="movieLabel">Enter Price:</label><input class="input" type = "text" value="<?php echo $price?>" name = "price"/>	
	<label class="movieLabel">Enter Image:</label><input class="input" type = "text" value="<?php echo $image?>" name = "image"/>
	</fieldset>
<br>
	<div id = "buttons">
		<input type = "submit" name = "button"value = "Enter Details">
		<input type = "reset" value = "Reset">
	</div>
	
	</form>
<br>
		
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
		$db_link = db_connect("project");
		$sessionID = session_id();
		$movieID = $_REQUEST['movieID'];
		$title = $_REQUEST['title'];
		$studio = $_REQUEST['studio'];
		$year = $_REQUEST['year'];
		$price = $_REQUEST['price'];
		$image = $_REQUEST['image'];

		$sql2 = "INSERT INTO product(movieID,title,studio,year,price,image)
		VALUES('$movieID','$title','$studio','$year','$price','$image')";
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
   $movieID = trim($_REQUEST['movieID']);
   $title = trim($_REQUEST['title']);
   $studio = isset($_REQUEST['studio']) ? $_REQUEST['studio'] : '';
   $year = isset($_REQUEST['year']) ? $_REQUEST['year'] : '';
   $price = isset($_REQUEST['price']) ? $_REQUEST['price'] : '';
   $image = isset($_REQUEST['image']) ? $_REQUEST['image'] : '';

   $error = '';
   $reg_exp_title = '/^[a-zA-Z\-\']+$/';
   $reg_exp = '/^[a-zA-Z]+$/';
   
   $count =0;


	if (!is_numeric($movieID))
	{
		$count++;
		$error .="<span class=\"error\">$count: Enter Movie ID Details correctly</span><br>";
	}
	
	if (empty($title))
	{
		$count++;
		$error .= "<span class=\"error\">$count: Title is invalid (letters, hyphens, ', only)</span><br>";
	}
	
	if (empty($studio))
	{
		$count++;
		$error .= "<span class=\"error\">$count: Studio is invalid (Invalid studio)</span><br>";
	}

	if (!is_numeric($year))
	{
		$count++;
		$error .="<span class=\"error\">$count: Enter Year Details correctly</span><br>";
	}

	if (!is_numeric($price))
	{
		$count++;
		$error .="<span class=\"error\">$count: Enter Price Details correctly</span><br>";
	}

	if (empty($image))
	{
		$count++;
		$error .= "<span class=\"error\">$count: Image is invalid (letters, hyphens, ', only)</span><br>";
	}
	return $error;
}
?>


<?php
function display_output_page()
{

	$movieID = trim($_REQUEST['movieID']);
	$title = trim($_REQUEST['title']);
	$year = isset($_REQUEST['year']) ? $_REQUEST['year'] : '';
	$studio = isset($_REQUEST['studio']) ? $_REQUEST['studio'] : '';
	$self = $_SERVER['PHP_SELF'];
	$price = isset($_REQUEST['price']) ? $_REQUEST['price'] : '';
	$image = isset($_REQUEST['image']) ? $_REQUEST['image'] : '';

	echo "New Title $title has been added to the database " ;

	$db_link = db_connect("project");
	$self = $_SERVER['PHP_SELF'];
	$movieID = $_REQUEST['movieID'];

	foreach($_REQUEST as $key=>$value)

	$fields = mysql_list_fields("project", "product");
	$num_columns = mysql_num_fields($fields);

	$query = "SELECT * FROM product WHERE movieID=".$movieID.";";
	$result = mysql_query($query) or die("SQL failed");
	echo '<table border="1">';
	echo "<tr>";
	echo "<th> Movie ID</th>";
	echo "<th> Title</th>";
	echo "<th> Studio</th>";
	echo "<th> Year </th>";
	echo "<th> Price </th>";
	echo "<th> Image </th>";
	echo "</tr>";

	while ($row = mysql_fetch_assoc($result))
	{
		echo "<tr>";
		echo "<td>".$row['movieID']."</td>";
		echo "<td>".$row['title']."</td>";
		echo "<td>".$row['studio']."</td>";
		echo "<td>".$row['year']."</td>";
		echo "<td>$".$row['price']."</td>";
		echo "<td><img src='../images/".$row['image']."'></td>";
	}

	$page = $_SERVER['PHP_SELF'];
	$sec = "5.0";
	//header("Refresh: $sec;$page");

?>
	

<?php
}
?>

<?php
include ('../include/footer.html'); // Include the HTML footer.
?>