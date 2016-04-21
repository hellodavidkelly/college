<html>
 <head>
  <title>Your submission</title>
 </head>
 <body>
 <img src="foodbanner.png" width="368" height="54">
 <br>
<hr />
 <?php
	$username = $_POST['user'];
	$crustchoice = $_POST ['crust'];
	$toppingschoice =$_POST ['toppings'];
	$commentbox =$_POST ['comments'];


	if( $username != null )
	{
	  echo( "Thanks for your selection $username <hr>" );
	}
	if( $crustchoice != null )
	{
		  echo( "Crust:  $crustchoice <hr>" );
	}
	if( $toppingschoice != null )
	{
		  echo( "Topping/Toppings: $toppingschoice <hr>" );
	}

	if( $commentbox != null )
	{
		  echo( "Comment:  $commentbox <hr>" );
	}



 ?>

 </body>
</html>