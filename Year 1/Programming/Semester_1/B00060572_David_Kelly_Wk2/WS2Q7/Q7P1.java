/********************************************************/
/*			Name: David Kelly							*/
/*			Date: 4/10/12								*/
/*			Program Name: WS2Q7							*/
/*														*/
/*			Description: This is Question 7	from		*/
/*						 worksheet 2: Average    	   	*/
/********************************************************/

class Q7P1{

	public static void main (String[] args){

		//Declared variables
		double num1,num2,num3,result;

		System.out.println("please enter the first number:");
		num1 = Keyboard.readDouble();
		System.out.println("please enter the second number:");
		num2 = Keyboard.readDouble();
		System.out.println("please enter the third number:");
		num3 = Keyboard.readDouble();

		result = (num1 + num2 + num3) / 3 ;
		System.out.println("The average of these thre numbers is:");
		System.out.println(result);


		}

	}