/********************************************************/
/*			Name: David Kelly							*/
/*			Date: 4/10/12								*/
/*			Program Name: WS2Q2.java					*/
/*														*/
/*			Description: This is Question 1 from		*/
/*						 worksheet 2 : part 5			*/
/********************************************************/


class Q1P5{

	public static void main(String[] args)

	{
	int tom = 1200;
	int alice = 2100;
	int temp;

	temp = tom;
	tom = alice;
	alice = temp;

	System.out.println(tom);
	System.out.println(alice);
	}


}