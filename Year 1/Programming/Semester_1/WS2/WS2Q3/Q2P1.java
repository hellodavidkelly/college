/********************************************************/
/*			Name: David Kelly							*/
/*			Date: 4/10/12								*/
/*			Program Name: WS2Q3							*/
/*														*/
/*			Description: This is Question 3	from		*/
/*						 worksheet 2: reverse 	    	*/
/********************************************************/


class Q2P1 {



  public static void main(String[] args) {

	int num1;
	System.out.println("Enter first number");
	num1 = Keyboard.readInt();

	int num2;
	System.out.println("Enter second number");
	num2 = Keyboard.readInt();

	int num3;
	System.out.println("Enter third number");
	num3 = Keyboard.readInt();

	int temp;

	   temp = num1;
	   num1 = num3;
       num2 = num2;
	   num3 = temp;

	System.out.println("Your Result is:");

	System.out.println(num1);


	System.out.println(num2);


	System.out.println(num3);


  }


}